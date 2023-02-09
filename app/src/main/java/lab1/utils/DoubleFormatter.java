package lab1.utils;

public class DoubleFormatter {
    public static boolean isInt(double d){
        return d == (int) d;
    }
    public static String format(double d) {
        if(isInt(d)){
            return String.format("%.0f",d);
        }
        return String.format("%.2f",d);
    }
    public static String format(double d, int len) {
        if(isInt(d)){
            return String.format("%.0f",d);
        }
        return String.format("%."+len+"f",d);
    }
}
