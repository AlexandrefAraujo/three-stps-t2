
package test.three.stripes.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Sys {

    private Integer type;
    private Integer id;
    private Double message;
    private String country;
    private Integer sunrise;
    private Integer sunset;

    public Integer getType() {
        return type;
    }

    public Sys setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Sys setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getMessage() {
        return message;
    }

    public Sys setMessage(Double message) {
        this.message = message;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Sys setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public Sys setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public Integer getSunset() {
        return sunset;
    }

    public Sys setSunset(Integer sunset) {
        this.sunset = sunset;
        return this;
    }
}
