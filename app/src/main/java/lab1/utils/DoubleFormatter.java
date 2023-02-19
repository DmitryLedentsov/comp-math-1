package lab1.utils;

public class DoubleFormatter {
    static final int DECIMAL_PLACES = 2;
    static final double k = Math.pow(10, DECIMAL_PLACES);
    public static boolean isInt(double d){
        return d == (int) d;
    }
    public static String format(double d) {
        if(isInt(d)){
            return String.format("%.0f",d);
        }
        d = Math.round(d*k)/k;
        return String.format("%."+DECIMAL_PLACES+"f",d);
    }
    /*
    public static String format(double d, int len) {
        if(isInt(d)){
            return String.format("%.0f",d);
        }
        return String.format("%."+len+"f",d);
    }*/
}
