package com.cmz_one.easyweather.adapter;

import android.support.v4.app.FragmentManager;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * Created by cmz_o on 2016/9/29.
 */

public class FragmentAdapter extends FragmentPagerItemAdapter {

    public FragmentAdapter(FragmentManager fm, FragmentPagerItems pages) {
        super(fm, pages);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
