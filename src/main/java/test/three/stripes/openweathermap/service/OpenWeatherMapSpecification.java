package test.three.stripes.openweathermap.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

class OpenWeatherMapSpecification {

    RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setUrlEncodingEnabled(true)
                .setContentType(ContentType.JSON)
                .setBaseUri("http://api.openweathermap.org")
                .setBasePath("/data/2.5/")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build()
                .queryParam("APPID", "e478b35334d99bcf5f47b8ea39d02958");
    }



}
