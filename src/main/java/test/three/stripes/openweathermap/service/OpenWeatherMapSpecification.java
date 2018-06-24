package test.three.stripes.openweathermap.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

class OpenWeatherMapSpecification{

    private static APIProperties properties;


    RequestSpecification requestSpecification() {

        if(properties == null) properties = new APIProperties().loadContext();

        return new RequestSpecBuilder()
                .setUrlEncodingEnabled(true)
                .setContentType(ContentType.JSON)
                .setBaseUri(properties.baseUri)
                .setBasePath(properties.basePath)
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
                .build()
                .queryParam("APPID", properties.apiKey);
    }



}
