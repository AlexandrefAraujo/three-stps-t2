
package test.three.stripes.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CurrentWeatherResponse {

    private Coord coord;
    private List<Weather> weather = null;
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Integer dt;
    private Sys sys;
    private Integer id;
    private String name;
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public CurrentWeatherResponse setCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public CurrentWeatherResponse setWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public String getBase() {
        return base;
    }

    public CurrentWeatherResponse setBase(String base) {
        this.base = base;
        return this;
    }

    public Main getMain() {
        return main;
    }

    public CurrentWeatherResponse setMain(Main main) {
        this.main = main;
        return this;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public CurrentWeatherResponse setVisibility(Integer visibility) {
        this.visibility = visibility;
        return this;
    }

    public Wind getWind() {
        return wind;
    }

    public CurrentWeatherResponse setWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public CurrentWeatherResponse setClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

    public Integer getDt() {
        return dt;
    }

    public CurrentWeatherResponse setDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Sys getSys() {
        return sys;
    }

    public CurrentWeatherResponse setSys(Sys sys) {
        this.sys = sys;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public CurrentWeatherResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CurrentWeatherResponse setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCod() {
        return cod;
    }

    public CurrentWeatherResponse setCod(Integer cod) {
        this.cod = cod;
        return this;
    }
}
