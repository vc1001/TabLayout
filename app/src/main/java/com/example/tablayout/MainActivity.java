package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    TabLayout tabLayout;
    ViewpagerAdapter viewpagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);

        viewPager2 = findViewById(R.id.viewpager);

        viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), getLifecycle());
        //add fragment to adapter
        viewpagerAdapter.addFragment(new Chat());
        viewpagerAdapter.addFragment(new Stories());
        viewpagerAdapter.addFragment(new Notifications());


        //orientation in viewpager

        viewPager2.setOrientation(viewPager2.ORIENTATION_HORIZONTAL);

        viewPager2.setAdapter(viewpagerAdapter);


        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0)
                    tab.setText("Chat");
                else {
                    if (position == 1)
                        tab.setText("Stories");
                    else
                        tab.setText("Notifications");
                }
            }

        }).attach();

    }
}