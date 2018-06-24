package test.three.stripes.openweathermap.service;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import test.three.stripes.openweathermap.data.City;
import test.three.stripes.openweathermap.data.GeographicCoordinates;
import test.three.stripes.openweathermap.model.CurrentWeatherResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static test.three.stripes.openweathermap.log.ExtentReportLog.logger;

public class OpenWeatherMapService extends OpenWeatherMapSpecification{

    private CurrentWeatherResponse getCurrentWeather(Map<String, String> queryParams) {
        return given()
                .spec(this.requestSpecification())
                .queryParams(queryParams)
                .when()
                .get("weather")
                .then()
                .statusCode(200)
                .extract().body().as(CurrentWeatherResponse.class);
    }


    public CurrentWeatherResponse getWeatherByCityName(City city) {
        logger.log(Status.INFO, MarkupHelper.createLabel("Calling getWeatherByCityName using city: "+city.getName(),
                ExtentColor.GREY));

        Map<String, String> params = new HashMap<>();
        params.put("q", city.getName());
        return getCurrentWeather(params);
    }

    public CurrentWeatherResponse getWeatherByCityId(int cityId) {
        logger.log(Status.INFO, MarkupHelper.createLabel("Calling getWeatherByCityId using id:"+cityId,
                ExtentColor.GREY));

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(cityId));
        return getCurrentWeather(params);
    }

    public CurrentWeatherResponse getWeatherByGeographicCoordinates(GeographicCoordinates latLon) {
        logger.log(Status.INFO, MarkupHelper.createLabel("Calling getWeatherByGeographicCoordinates using " +
                        "coordinates:"+latLon, ExtentColor.GREY));

        Map<String, String> params = new HashMap<>();
        params.put("lat", latLon.getLat());
        params.put("lon", latLon.getLon());
        return getCurrentWeather(params);
    }

    public CurrentWeatherResponse getWeatherByZipCode(int zipCode, String countryCode) {
        logger.log(Status.INFO, MarkupHelper.createLabel("Calling getWeatherByZipCode using zipcode:"+zipCode+
                " and country code: "+countryCode, ExtentColor.GREY));

        Map<String, String> params = new HashMap<>();
        params.put("zip", zipCode+","+countryCode);
        return getCurrentWeather(params);
    }

    public List<CurrentWeatherResponse> getWeatherFromCitiesInARectangleZone(GeographicCoordinates coordinates) {
        logger.log(Status.INFO, MarkupHelper.createLabel("Calling getWeatherFromCitiesInARectangleZone using " +
                        "coordinates:"+coordinates, ExtentColor.GREY));

        Map<String, String> params = new HashMap<>();
        params.put("bbox", coordinates.toString());

        return Arrays.asList(given()
                .spec(this.requestSpecification())
                .queryParams(params)
                .when()
                .get("box/city")
                .then()
                .statusCode(200)
                .extract().body()
                .jsonPath()
                .getObject("list", CurrentWeatherResponse[].class));
    }

    public List<CurrentWeatherResponse> getWeatherFromCitiesInACycleZone(GeographicCoordinates latLon, int numberOfCities) {
        logger.log(Status.INFO, MarkupHelper.createLabel("Calling getWeatherFromCitiesInACycleZone using " +
                "coordinates:"+latLon+" and number of cities: "+numberOfCities, ExtentColor.GREY));

        Map<String, String> params = new HashMap<>();
        params.put("lat", latLon.getLat());
        params.put("lon", latLon.getLon());
        params.put("cnt", String.valueOf(numberOfCities));
        params.put("lang", "en");

        return Arrays.asList(given()
                .spec(this.requestSpecification())
                .queryParams(params)
                .when()
                .get("find")
                .then()
                .statusCode(200)
                .extract().body()
                .jsonPath()
                .getObject("list", CurrentWeatherResponse[].class));
    }


    public List<CurrentWeatherResponse> getWeatherFromCitiesByIds(String idsWithComma) {
        logger.log(Status.INFO, MarkupHelper.createLabel("Calling getWeatherFromCitiesByIds using" +
                " city ids: "+idsWithComma, ExtentColor.GREY));

        Map<String, String> params = new HashMap<>();
        params.put("id", idsWithComma);
        params.put("units", "metric");

        return Arrays.asList(given()
                .spec(this.requestSpecification())
                .queryParams(params)
                .when()
                .get("group")
                .then()
                .statusCode(200)
                .extract().body()
                .jsonPath()
                .getObject("list", CurrentWeatherResponse[].class));
    }

}
