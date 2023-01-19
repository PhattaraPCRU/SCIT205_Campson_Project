package pcru.phattara.campson_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TripleViewAdapter extends ArrayAdapter<Visitor> {
    private final LayoutInflater mInflater;
    private final ArrayList<Visitor> visitors;
    private final int mViewResourceId;

    public TripleViewAdapter(Context context, int textViewResourceId, ArrayList<Visitor> visitors) {
        super(context, textViewResourceId, visitors);
        this.visitors = visitors;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Visitor visitor = visitors.get(position);

        if (visitor != null) {
            TextView name = (TextView) convertView.findViewById(R.id.col_name);
            TextView age = (TextView) convertView.findViewById(R.id.col_age);
            TextView datetime = (TextView) convertView.findViewById(R.id.col_datetime);
            if (name != null) {
                name.setText(visitor.getName());
            }
            if (age != null) {
                age.setText((visitor.getAge()));
            }
            if (datetime != null) {
                datetime.setText((visitor.getDateTime()));
            }
        }

        return convertView;
    }
}