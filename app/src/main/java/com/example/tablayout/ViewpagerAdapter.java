package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewpagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragmentArraylist = new ArrayList<>();
//    private ArrayList<String> listS = new ArrayList<>();

    public ViewpagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return fragmentArraylist.get(position);
    }
    //new method to set position
//    public CharSequence getPageTitle(int position){
//        return listS.get(position);
//    }

    @Override
    public int getItemCount() {
        return fragmentArraylist.size();
    }


    public void addFragment(Fragment fragment){
        fragmentArraylist.add(fragment);


    }

}
