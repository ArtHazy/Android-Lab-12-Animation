package com.example.lab12_.ui.home;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lab12_.R;
import com.example.lab12_.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ImageView squareI,circleI;
    AnimatorSet animatorSet;
    Button playButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        playButton = root.findViewById(R.id.playB);
        animatorSet = new AnimatorSet();

        playButton.setOnClickListener((v)->{
            Drawable square = getResources().getDrawable(R.drawable.square);
            Drawable circle = getResources().getDrawable(R.drawable.circle);

            squareI = root.findViewById(R.id.imageView);
            squareI.setImageDrawable(square);

            circleI = root.findViewById(R.id.circleI);
            circleI.setImageDrawable(circle);

            ObjectAnimator transYcircle = ObjectAnimator.ofFloat(circleI, "translationY", -200f, 0f,-200f);
            ObjectAnimator scaleYsquare = ObjectAnimator.ofFloat(squareI, "scaleY", 1,0,1);
            ObjectAnimator transYsquare = ObjectAnimator.ofFloat(squareI, "translationY", 0, 50,0);

            transYcircle.setRepeatCount(ObjectAnimator.INFINITE);
            scaleYsquare.setRepeatCount(ObjectAnimator.INFINITE);
            transYsquare.setRepeatCount(ObjectAnimator.INFINITE);

            animatorSet.setDuration(850);
            animatorSet.playTogether(transYcircle,scaleYsquare,transYsquare);
            animatorSet.start();
        });
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


