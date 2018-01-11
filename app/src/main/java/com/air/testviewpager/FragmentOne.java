package com.air.testviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonglt1 on 18-1-11.
 */

public class FragmentOne extends BaseFragment {
    private static final String TAG = "FragmentOne";
    private RecyclerView mRecycleView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        mRecycleView = view.findViewById(R.id.recycle_view);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> data = new ArrayList<>();
        for(int i=0;i <10; i++) {
            data.add("text " + i);
        }
        MyRecycleAdapter adapter = new MyRecycleAdapter(data);
        mRecycleView.setAdapter(adapter);
        return view;
    }

    private void doRycleViewEnterAnimation() {
        Log.d(TAG, "doRycleViewEnterAnimation: ");
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(alphaAnimation);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f
        );

        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(80);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animationSet, 0.5f);
        layoutAnimationController.setInterpolator(new LinearInterpolator());
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        mRecycleView.setLayoutAnimation(layoutAnimationController);
        mRecycleView.startLayoutAnimation();
    }

    @Override
    public void onSelected() {
        doRycleViewEnterAnimation();
    }
}
