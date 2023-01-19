package pcru.phattara.campson_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OtopFragment extends Fragment {
    public OtopFragment() {
        // Required empty public constructor
    }
    public static OtopFragment newInstance() {
        OtopFragment fragment = new OtopFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_bn_gMap = view.findViewById(R.id.btn_bn_gMap);
        Button btn_makahm_gMap = view.findViewById(R.id.btn_makahm_gMap);
        Button btn_coldProduct_gMap = view.findViewById(R.id.btn_coldProduct_gMap);
        btn_bn_gMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.GMapLocate(getActivity(), GMaps.class, 16.741613169316746, 101.0160315057619);
            }
        });
        btn_makahm_gMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.GMapLocate(getActivity(), GMaps.class, 16.770104396901054, 101.0533211248949);
            }
        });
        btn_coldProduct_gMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.GMapLocate(getActivity(), GMaps.class, 16.821790527024618, 100.26220871258688);
            }
        });
    }
}