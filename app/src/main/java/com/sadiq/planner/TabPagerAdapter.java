package com.sadiq.planner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private static final int numTabs = 2;

    public TabPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    public String getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Schedule";
            case 1:
                return "Entry";
            default:
                return null;
        }
    }
}
