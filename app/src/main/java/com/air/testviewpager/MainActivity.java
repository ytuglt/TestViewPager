package com.air.testviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mViewPager;
    private FragmentAdapter mFragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.btn4);
        button4.setOnClickListener(this);


        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), this);
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(mFragmentAdapter);

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAccessibilityDelegate(null);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((BaseFragment)mFragmentAdapter.getItem(position)).onSelected();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.btn2:
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.btn3:
                mViewPager.setCurrentItem(2,false);
                break;
            case R.id.btn4:
                mViewPager.setCurrentItem(3, false);
                break;
        }
    }
}
