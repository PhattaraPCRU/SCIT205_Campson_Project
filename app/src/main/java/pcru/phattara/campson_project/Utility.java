package pcru.phattara.campson_project;

public class Utility {
    public static String get_ts() {
        long tsLong = System.currentTimeMillis()/1000;
        return Long.toString(tsLong);
    }
}
