package pcru.phattara.campson_project;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {
    public SettingsFragment() {
        // Required empty public constructor
    }
    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
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
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context thisActivity = getActivity();
        view.findViewById(R.id.btn_logs).setOnClickListener(v -> Utility.page(thisActivity, VisitorLogs.class));
        view.findViewById(R.id.btn_endSession).setOnClickListener(v -> Utility.page(thisActivity, Login.class));
        view.findViewById(R.id.btn_sourceCode).setOnClickListener(v -> Utility.url(thisActivity, "https://github.com/PhattaraPCRU/SCIT205_Campson_Project"));
    }
}