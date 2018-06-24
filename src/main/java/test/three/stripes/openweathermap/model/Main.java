
package test.three.stripes.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Main {

    private Double temp;
    private Integer pressure;
    private Integer humidity;
    private Double tempMin;
    private Double tempMax;

    public Double getTemp() {
        return temp;
    }

    public Main setTemp(Double temp) {
        this.temp = temp;
        return this;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Main setPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Main setHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Main setTempMin(Double tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Main setTempMax(Double tempMax) {
        this.tempMax = tempMax;
        return this;
    }
}
