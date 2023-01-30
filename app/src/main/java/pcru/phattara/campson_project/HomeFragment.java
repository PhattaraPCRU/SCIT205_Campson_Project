package pcru.phattara.campson_project;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.concurrent.ThreadLocalRandom;

public class HomeFragment extends Fragment {
    int[] temple_sonkaew = {R.drawable.temple_sonkaew1, R.drawable.temple_sonkaew2, R.drawable.temple_sonkaew3, R.drawable.temple_sonkaew4, R.drawable.temple_sonkaew5};
    int[] waterfall_sridith = {R.drawable.waterfall_sridith1, R.drawable.waterfall_sridith2, R.drawable.waterfall_sridith3, R.drawable.waterfall_sridith4};
    int[] royal_pratumnak = {R.drawable.royal_pratumnak1, R.drawable.royal_pratumnak2, R.drawable.royal_pratumnak3, R.drawable.royal_pratumnak4, R.drawable.royal_pratumnak5};
    int[] jadee = {R.drawable.jadee1, R.drawable.jadee2, R.drawable.jadee3, R.drawable.jadee4, R.drawable.jadee5, R.drawable.jadee6, R.drawable.jadee7};
    int[] khaokho_sacment = {R.drawable.khaokho_sacment1, R.drawable.khaokho_sacment2, R.drawable.khaokho_sacment3, R.drawable.khaokho_sacment4, R.drawable.khaokho_sacment5, R.drawable.khaokho_sacment6, R.drawable.khaokho_sacment7};
    Context ThisActivity = getActivity();
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        SliderView sv1 = view.findViewById(R.id.imgS1);
//        SliderView sv2 = view.findViewById(R.id.imgS2);
//        SliderView sv3 = view.findViewById(R.id.imgS3);
//        SliderView sv4 = view.findViewById(R.id.imgS4);
//        SliderView sv5 = view.findViewById(R.id.imgS5);
//        SliderAdapter sa1 = new SliderAdapter(temple_sonkaew);
//        SliderAdapter sa2 = new SliderAdapter(waterfall_sridith);
//        SliderAdapter sa3 = new SliderAdapter(royal_pratumnak);
//        SliderAdapter sa4 = new SliderAdapter(jadee);
//        SliderAdapter sa5 = new SliderAdapter(khaokho_sacment);
//        SliderView[] sliderViews = {sv1,sv2,sv3,sv4,sv5};
//        SliderAdapter[] sliderAdapters = {sa1,sa2,sa3,sa4,sa5};
        SliderView[] sliderViews = {
                view.findViewById(R.id.imgS1),
                view.findViewById(R.id.imgS2),
                view.findViewById(R.id.imgS3),
                view.findViewById(R.id.imgS4),
                view.findViewById(R.id.imgS5)
        };
        SliderAdapter[] sliderAdapters = {
                new SliderAdapter(temple_sonkaew),
                new SliderAdapter(waterfall_sridith),
                new SliderAdapter(royal_pratumnak),
                new SliderAdapter(jadee),
                new SliderAdapter(khaokho_sacment)
        };
        int randMin = 3000;
        int randMax = randMin + 6000;
        for (int i = 0; i < sliderViews.length; i++) {
            sliderViews[i].setScrollTimeInMillis(ThreadLocalRandom.current().nextInt(randMin, randMax));
            sliderViews[i].setSliderAdapter(sliderAdapters[i]);
            sliderViews[i].setIndicatorAnimation(IndicatorAnimationType.WORM);
            sliderViews[i].setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
            sliderViews[i].startAutoCycle();
        }
        view.findViewById(R.id.tv1).setOnClickListener(v -> Utility.page(ThisActivity, info_temple_sonkaew.class));
        view.findViewById(R.id.tv2).setOnClickListener(v -> Utility.page(ThisActivity, info_waterfall_sridith.class));
        view.findViewById(R.id.tv3).setOnClickListener(v -> Utility.page(ThisActivity, info_royal_pratumnak.class));
        view.findViewById(R.id.tv4).setOnClickListener(v -> Utility.page(ThisActivity, info_jadee.class));
        view.findViewById(R.id.tv5).setOnClickListener(v -> Utility.page(ThisActivity, info_khaokho_sacment.class));

    }
}