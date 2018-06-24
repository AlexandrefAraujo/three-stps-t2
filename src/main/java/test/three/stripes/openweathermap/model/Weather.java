
package test.three.stripes.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Weather {

    private Integer id;
    private String main;
    private String description;
    private String icon;

    public Integer getId() {
        return id;
    }

    public Weather setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMain() {
        return main;
    }

    public Weather setMain(String main) {
        this.main = main;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Weather setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Weather setIcon(String icon) {
        this.icon = icon;
        return this;
    }
}
