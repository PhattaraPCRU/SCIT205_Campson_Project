package pcru.phattara.campson_project;

import android.content.Context;
import android.content.Intent;

public class Utility {
    public static String get_ts() {
        long tsLong = System.currentTimeMillis()/1000;
        return Long.toString(tsLong);
    }
    public static void page(Context context, Class<?> target) {
        Intent intent = new Intent(context, target);
        context.startActivity(intent);
    }
}
