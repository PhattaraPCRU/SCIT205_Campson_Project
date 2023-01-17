package pcru.phattara.campson_project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        try (DBHelper db = new DBHelper(this)) {
            Button btn_submit_data = findViewById(R.id.btn_submit_data);
            Button btn_submit_ano = findViewById(R.id.btn_submit_ano);
            EditText data_name = findViewById(R.id.data_name);
            EditText data_age = findViewById(R.id.data_age);

            btn_submit_data.setOnClickListener(v -> {
                String data_name_str = data_name.getText().toString();
                String data_age_str = data_age.getText().toString();
                if (data_name_str.equalsIgnoreCase("")) {
                    data_name.setError("Please enter a name");
                } else if (data_age_str.equalsIgnoreCase("")) {
                    data_age.setError("Please enter a age");
                } else {
                    db.addVisitor(new Visitor(data_name_str, Integer.parseInt(data_age_str), Utility.get_ts()));
                    data_name.setText("");
                    data_age.setText("");
                    Utility.page(this, Home.class);
                }
            });
            btn_submit_ano.setOnClickListener(v -> {
                    db.addVisitor(new Visitor("Anonymous", 0, Utility.get_ts()));
                    data_name.setText("");
                    data_age.setText("");
            });
        }
    }
}