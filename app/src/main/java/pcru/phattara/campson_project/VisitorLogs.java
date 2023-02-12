package pcru.phattara.campson_project;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class VisitorLogs extends AppCompatActivity {
    DBHelper db; ArrayList<Visitor> visitorList; ListView listView; Visitor visitor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_logs);
        updateListView();
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
        findViewById(R.id.btn_refresh).setOnClickListener(v -> {
            finish();
            startActivity(getIntent());
        });
        findViewById(R.id.btn_delete).setOnClickListener(v -> deleteListView());
    }
    private void updateListView(){
        db = new DBHelper(this);
        visitorList = new ArrayList<>();
        Cursor data = db.getAllData();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(VisitorLogs.this, "The Database is empty  :(.", Toast.LENGTH_SHORT).show();
        }else{
            int i = 0;
            while (data.moveToNext()){
                visitor = new Visitor(data.getString(1),data.getString(2),data.getString(3));
                visitorList.add(i,visitor);
                System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
                System.out.println(visitorList.get(i).getName());
                i++;
            }
            ListAdapter adapter = new TripleViewAdapter(this, R.layout.activity_triple_view, visitorList);
            listView = (ListView) findViewById(R.id.visitor_logs_list);
            listView.setAdapter(adapter);
        }
    }
    private void deleteListView(){
        if (db.deleteAll()) {
            Toast.makeText(VisitorLogs.this, "All data deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(VisitorLogs.this, "There is no data to delete", Toast.LENGTH_SHORT).show();
        }
    }
}