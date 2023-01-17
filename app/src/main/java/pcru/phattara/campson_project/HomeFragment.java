package pcru.phattara.campson_project;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    SliderView sv1,sv2,sv3,sv4,sv5;
    Random random = new Random();
    int[] temple_sonkaew = {R.drawable.temple_sonkaew1,R.drawable.temple_sonkaew2,R.drawable.temple_sonkaew3,R.drawable.temple_sonkaew4,R.drawable.temple_sonkaew5};
    int[] waterfall_sridith = {R.drawable.waterfall_sridith1,R.drawable.waterfall_sridith2,R.drawable.waterfall_sridith3,R.drawable.waterfall_sridith4};
    int[] royal_pratumnak = {R.drawable.royal_pratumnak1,R.drawable.royal_pratumnak2,R.drawable.royal_pratumnak3,R.drawable.royal_pratumnak4,R.drawable.royal_pratumnak5};
    int[] jadee = {R.drawable.jadee1,R.drawable.jadee2,R.drawable.jadee3,R.drawable.jadee4,R.drawable.jadee5,R.drawable.jadee6,R.drawable.jadee7};
    int[] khaokho_sacment = {R.drawable.khaokho_sacment1,R.drawable.khaokho_sacment2,R.drawable.khaokho_sacment3,R.drawable.khaokho_sacment4,R.drawable.khaokho_sacment5,R.drawable.khaokho_sacment6,R.drawable.khaokho_sacment7};


    public static HomeFragment newInstance(String param1, String param2) {
        return new HomeFragment();
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

//        sv1 = view.findViewById(R.id.imgS1);
//        SliderAdapter sa1 = new SliderAdapter(temple_sonkaew);
//        sv1.setSliderAdapter(sa1);
//        sv1.setIndicatorAnimation(IndicatorAnimationType.WORM);
//        sv1.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
//        sv1.startAutoCycle();

        sv1 = view.findViewById(R.id.imgS1);
        sv2 = view.findViewById(R.id.imgS2);
        sv3 = view.findViewById(R.id.imgS3);
        sv4 = view.findViewById(R.id.imgS4);
        sv5 = view.findViewById(R.id.imgS5);
        SliderAdapter sa1 = new SliderAdapter(temple_sonkaew);
        SliderAdapter sa2 = new SliderAdapter(waterfall_sridith);
        SliderAdapter sa3 = new SliderAdapter(royal_pratumnak);
        SliderAdapter sa4 = new SliderAdapter(jadee);
        SliderAdapter sa5 = new SliderAdapter(khaokho_sacment);
        SliderView[] sliderViews = {sv1,sv2,sv3,sv4,sv5};
        SliderAdapter[] sliderAdapters = {sa1,sa2,sa3,sa4,sa5};
        int randMin = 3000;
        int randMax = randMin + 6000;
        for (int i = 0; i < sliderViews.length; i++) {
            sliderViews[i].setScrollTimeInMillis(ThreadLocalRandom.current().nextInt(randMin,randMax));
            sliderViews[i].setSliderAdapter(sliderAdapters[i]);
            sliderViews[i].setIndicatorAnimation(IndicatorAnimationType.WORM);
            sliderViews[i].setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
            sliderViews[i].startAutoCycle();
        }
    }
}