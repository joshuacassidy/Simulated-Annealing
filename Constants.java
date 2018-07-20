public class Constants {

    private static final double MIN_COORDINATE = -1;
    private static final double MAX_COORDINATE = 2;
    private static final double MIN_TEMPERATURE= 1;
    private static final double MAX_TEMPERATURE= 100;
    private static final double COOLING_RATE= 0.02;


    private Constants() {

    }

    public static double getMinCoordinate() {
        return MIN_COORDINATE;
    }

    public static double getMaxCoordinate() {
        return MAX_COORDINATE;
    }

    public static double getMinTemperature() {
        return MIN_TEMPERATURE;
    }

    public static double getMaxTemperature() {
        return MAX_TEMPERATURE;
    }

    public static double getCoolingRate() {
        return COOLING_RATE;
    }
}
