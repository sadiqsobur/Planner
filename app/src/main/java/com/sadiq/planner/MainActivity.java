package com.sadiq.planner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Schedule"));
        tabLayout.addTab(tabLayout.newTab().setText("Enter Event"));


        // Connect the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);

        // Set up onClickListener for the tabs
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, EventSheet.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Entry.class));
                        break;
                    // Add more cases for additional tabs
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                setContentView(R.layout.entry_layout);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                setContentView(R.layout.event_layout);
            }
        });
    }
}
