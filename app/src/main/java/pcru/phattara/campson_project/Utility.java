package pcru.phattara.campson_project;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Utility {
    public static String get_ts() {
        long tsLong = System.currentTimeMillis()/1000;
        return Long.toString(tsLong);
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
    public static String getDateTime() {
        long tsLong = System.currentTimeMillis()/1000;
        return Long.toString(tsLong);
    }
}
