package pcru.phattara.campson_project;

import android.os.Build;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicBoolean;

public class AppCompatActivity_info extends AppCompatActivity {
    //DO NOT TOUCH THIS CODE
    //IT UNSTABLE MIGHT BE BROKE BRUH
    protected void actionBarInit(){
        Button btn_control = findViewById(R.id.btn_control);
        btn_control.setText("");
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
//        findViewById(R.id.btn_control).setOnClickListener(v -> {
//            Utility.scrollUp(this, R.id.Scroll);
//        });
        //when scroll down to end of page, show button top
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AtomicBoolean isScrollDown = new AtomicBoolean(false);
            btn_control.setText(R.string.triangle_down);
            findViewById(R.id.Scroll).setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
                if (scrollY < oldScrollY) {
                    btn_control.setOnClickListener(view -> {
                        Utility.scrollUp(this, R.id.Scroll);
                        btn_control.setText(R.string.triangle_down);
                        isScrollDown.set(false);
                    });
                    isScrollDown.set(false);
                    btn_control.setText(R.string.triangle_up);
                } else {
                    btn_control.setOnClickListener(view -> {
                        Utility.scrollDown(this, R.id.Scroll);
                        btn_control.setText(R.string.triangle_up);
                        isScrollDown.set(true);
                    });
                    //set button string arrow down
                    isScrollDown.set(true);
                    btn_control.setText(R.string.triangle_down);
                }
//                findViewById(R.id.btn_control).setOnClickListener(v1 -> {
//                    if (isScrollDown.get()) {
//                        Utility.scrollUp(this, R.id.Scroll);
//                        btn_control.setText(R.string.triangle_down);
//                        isScrollDown.set(false);
//                    } else {
//                        Utility.scrollDown(this, R.id.Scroll);
//                        btn_control.setText(R.string.triangle_up);
//                        isScrollDown.set(true);
//                    }
//                });
            });
        }

    }
}
