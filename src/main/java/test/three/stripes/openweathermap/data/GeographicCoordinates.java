package test.three.stripes.openweathermap.data;

public class GeographicCoordinates {

    private String lonLeft;
    private String latBottom;
    private String lonRight;
    private String latTop;
    private String zoom;
//lonleft lat top
    public GeographicCoordinates(double lonLeft, double latBottom, double lonRight, double latTop, int zoom) {
        this.lonLeft = String.valueOf(lonLeft);
        this.latBottom = String.valueOf(latBottom);
        this.lonRight = String.valueOf(lonRight);
        this.latTop = String.valueOf(latTop);
        this.zoom = String.valueOf(zoom);
    }

    public GeographicCoordinates(double lat, double lon) {
        this.latTop = String.valueOf(lat);
        this.lonLeft = String.valueOf(lon);
    }

    @Override
    public String toString() {
        return lonLeft+","+
                latBottom+","+
                lonRight+","+
                latTop+","+
                zoom;
    }

    public String getLon() {
        return lonLeft;
    }

    public String getLat() {
        return latTop;
    }
}
