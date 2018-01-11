package com.air.testviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;


/**
 * Created by gonglt1 on 18-1-10.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private SparseArray<Fragment> mFragments = new SparseArray<>();
    private Context mContext;

    private Class[] fragmentClass = new Class[]{
            FragmentOne.class, FragmentTwo.class, FragmentThree.class, FragmentFour.class
    };

    public FragmentAdapter(FragmentManager fragmentManager, MainActivity context) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragment(position);
    }

    @Override
    public int getCount() {
        return fragmentClass.length;
    }

    private Fragment getFragment(int position) {
        if (mFragments.get(position) != null) {
            return mFragments.get(position);
        }

       Fragment fragment = Fragment.instantiate(mContext, fragmentClass[position].getName());
        mFragments.put(position,fragment);
        return fragment;
    }
}
