package pcru.phattara.campson_project;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Utility {
    public static String get_ts() {
        long tsLong = System.currentTimeMillis()/1000;
        return Long.toString(tsLong);
    }
    public static String getDateTimeHM() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Timestamp(date.getTime()).toString().substring(11, 16);
    }
    public static String getDateTime() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Timestamp(date.getTime()).toString();
    }
    public static String getDateTimeThailandF() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Timestamp(date.getTime()).toString().substring(8, 10) + "/" +
                new java.sql.Timestamp(date.getTime()).toString().substring(5, 7) + "/" +
                new java.sql.Timestamp(date.getTime()).toString().substring(0, 4) + " " +
                new java.sql.Timestamp(date.getTime()).toString().substring(11, 16);
    }
    public static void page(Context context, Class<?> target) {
        Intent intent = new Intent(context, target);
        context.startActivity(intent);
    }
    public static void GMapLocate(Context source, Class<?> target, double lat, double lng) {
        if (googleServiceCheck(source)) {
            Intent intent = new Intent(source, target);
            intent.putExtra("lat", lat);
            intent.putExtra("long", lng);
            source.startActivity(intent);
        }
    }
    public static boolean googleServiceCheck(Context context) {
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (available == ConnectionResult.SUCCESS) {
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog((Activity) context, available, 9001);
            assert dialog != null;
            dialog.show();
        } else {
            Toast.makeText(context, "You can't make map requests without google services.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public static void scrollUp(Activity activity, int id) {
        ScrollView scrollView = activity.findViewById(id);
        scrollView.fullScroll(ScrollView.FOCUS_UP);
    }
    public static void scrollDown(Activity activity, int id) {
        ScrollView scrollView = activity.findViewById(id);
        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
    }
    public static void url(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse(url));
        context.startActivity(intent);
    }
}
