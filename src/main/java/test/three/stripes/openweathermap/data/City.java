package test.three.stripes.openweathermap.data;

public enum City {

    RIO_DE_JANEIRO(3451190, "Rio de Janeiro", -22.91, -43.21),
    WROCLAW(3081368, "Wroclaw", 51.1, 17.03),
    ZARAGOZA(3104324, "Zaragoza", -0.88, 41.65),
    MONTAIN_VIEW(420006353, "Mountain View", -122.08, 37.39);

    private Integer id;
    private String name;
    private Double lat;
    private Double lon;

    City(Integer id, String name, Double lat, Double lon) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
