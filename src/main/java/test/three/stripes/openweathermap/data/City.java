package test.three.stripes.openweathermap.data;

public enum City {

    RIO_DE_JANEIRO(3451190, "Rio de Janeiro", -22.91, -43.21),
    WROCLAW(3081368, "Wroclaw", 51.1, 17.03),
    ZARAGOZA(6362983, "Zaragoza",41.65, -0.88),
    MONTAIN_VIEW(420006353, "Mountain View", 37.39, -122.08),
    BIRKIRKARA(2563191, "Birkirkara", 35.54, 14.27),
    MODICA(2524119, "Modica", 36.8499, 14.76976),
    BACHURINO(578680, "Bachurino", 55.58, 37.52),
    KOMUNARKA(545782, "Kommunarka", 55.5695, 37.4893);

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
