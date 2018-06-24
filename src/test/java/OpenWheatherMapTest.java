import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import test.three.stripes.openweathermap.data.City;
import test.three.stripes.openweathermap.data.GeographicCoordinates;
import test.three.stripes.openweathermap.model.CurrentWeatherResponse;
import test.three.stripes.openweathermap.service.OpenWeatherMapService;

import java.lang.reflect.Method;
import java.util.List;

import static test.three.stripes.openweathermap.log.ExtentReportLog.*;

public class OpenWheatherMapTest {

    OpenWeatherMapService openWeatherMapService = new OpenWeatherMapService();

    @BeforeSuite
    public void setUp0(){
        initReport();

    }

    @AfterSuite
    public void tearDown0(){
        flushReport();
    }

    @BeforeMethod
    public void setUp(Method method){
        initTestMethod(method);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        setStatus(result);
    }

    @Test
    public void testWeatherByCityName(){

        CurrentWeatherResponse weather = openWeatherMapService.getWeatherByCityName(City.RIO_DE_JANEIRO);

        validateWeather(weather, City.RIO_DE_JANEIRO);

    }

    @Test
    public void testWeatherByCityId(){

        CurrentWeatherResponse weather = openWeatherMapService.getWeatherByCityId(City.WROCLAW.getId());

        validateWeather(weather, City.WROCLAW);

    }

    @Test
    public void testWeatherByCityCoordinates(){

        CurrentWeatherResponse weather = openWeatherMapService
                .getWeatherByGeographicCoordinates(new GeographicCoordinates(City.ZARAGOZA.getLat(), City.ZARAGOZA.getLon()));

        validateWeather(weather, City.ZARAGOZA);

    }

    @Test
    public void testWeatherByZipCode(){

        CurrentWeatherResponse weather = openWeatherMapService.getWeatherByZipCode(94040, "us");

        validateWeather(weather, City.MONTAIN_VIEW);
    }

    @Test
    public void testWeatherFromCitiesInARectangleZone() throws Exception {
        //this test is validating just two cities from rectangle.
        List<CurrentWeatherResponse> weather = openWeatherMapService
                .getWeatherFromCitiesInARectangleZone(new GeographicCoordinates(12,32,15,37,10));


        Assert.assertTrue(weather.size() > 0);

        CurrentWeatherResponse birkirkara = weather.
                stream()
                .filter(w -> w.getName().equals(City.BIRKIRKARA.getName()))
                .findFirst()
                .orElseThrow(Exception::new);

        CurrentWeatherResponse modica = weather.
                stream()
                .filter(w -> w.getName().equals(City.MODICA.getName()))
                .findFirst()
                .orElseThrow(Exception::new);

        validateWeather(birkirkara, City.BIRKIRKARA);
        validateWeather(modica, City.MODICA);
    }

    @Test
    public void testWeatherFromCitiesInACycleZone() throws Exception {
        //this test is validating just two cities from rectangle.
        int numberOfCities = 10;
        List<CurrentWeatherResponse> weather = openWeatherMapService
                .getWeatherFromCitiesInACycleZone(new GeographicCoordinates(55.5,37.5),numberOfCities);


        Assert.assertTrue(weather.size() > 0 && weather.size() == numberOfCities);

        CurrentWeatherResponse bachurino = weather.
                stream()
                .filter(w -> w.getName().equals(City.BACHURINO.getName()))
                .findFirst()
                .orElseThrow(Exception::new);

        CurrentWeatherResponse komunarca = weather.
                stream()
                .filter(w -> w.getName().equals(City.KOMUNARKA.getName()))
                .findFirst()
                .orElseThrow(Exception::new);

        validateWeather(bachurino, City.BACHURINO);
        validateWeather(komunarca, City.KOMUNARKA);
    }


    @Test
    public void testWeatherFromCitiesCityIds() throws Exception {

        List<CurrentWeatherResponse> weather = openWeatherMapService
                .getWeatherFromCitiesByIds("3081368,578680,6362983");

        CurrentWeatherResponse wroclaw = weather.
                stream()
                .filter(w -> w.getName().equals(City.WROCLAW.getName()))
                .findFirst()
                .orElseThrow(Exception::new);

        CurrentWeatherResponse bachurino = weather.
                stream()
                .filter(w -> w.getName().equals(City.BACHURINO.getName()))
                .findFirst()
                .orElseThrow(Exception::new);

        CurrentWeatherResponse zaragoza = weather.
                stream()
                .filter(w -> w.getName().equals(City.ZARAGOZA.getName()))
                .findFirst()
                .orElseThrow(Exception::new);


        validateWeather(wroclaw, City.WROCLAW);
        validateWeather(bachurino, City.BACHURINO);
        validateWeather(zaragoza, City.ZARAGOZA);

    }



    private void validateWeather(CurrentWeatherResponse weather, City city) {


        Assert.assertEquals(weather.getId(), city.getId(), "Wrong city id returned. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("City id correct", ExtentColor.GREEN));

        Assert.assertEquals(weather.getName(), city.getName(), "Wrong city name returned. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("City name is correct", ExtentColor.GREEN));

        Assert.assertNotNull(weather.getMain().getTemp(), "temperature value is missing. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("temperature is not null", ExtentColor.GREEN));

        Assert.assertNotNull(weather.getMain().getPressure(), "pressure value is missing. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("pressure is not null", ExtentColor.GREEN));

        Assert.assertNotNull(weather.getMain().getHumidity(), "humidity value is missing. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("humidity is not null", ExtentColor.GREEN));

        Assert.assertNotNull(weather.getMain().getTempMin(), "minimum temperature value is missing. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("minimum temperature is not null", ExtentColor.GREEN));

        Assert.assertNotNull(weather.getMain().getTempMax(), "maximum temperature value is missing. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("maximum temperature is not null", ExtentColor.GREEN));

        Assert.assertNotNull(weather.getWeather().get(0).getMain(), "weather is missing. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("weather status is not null", ExtentColor.GREEN));

        Assert.assertNotNull(weather.getWeather().get(0).getDescription(), "weather description is missing. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("weather description is not null", ExtentColor.GREEN));

        Assert.assertEquals(weather.getCoord().getLat(), city.getLat(), "Wrong latitude returned. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("latitude is correct", ExtentColor.GREEN));

        Assert.assertEquals(weather.getCoord().getLon(), city.getLon(), "Wrong longitude returned. ");
        logger.log(Status.PASS, MarkupHelper.createLabel("longitude is correct", ExtentColor.GREEN));
    }

}
