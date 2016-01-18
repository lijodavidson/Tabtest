package com.example.lijo.tabtest;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;



import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;


import com.example.lijo.tabtest.fragments.fragfive;
import com.example.lijo.tabtest.fragments.fragfour;
import com.example.lijo.tabtest.fragments.fragone;
import com.example.lijo.tabtest.fragments.fragthree;
import com.example.lijo.tabtest.fragments.fragtwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  CollapsingToolbarLayout collapsingToolbar;
    private ImageView imageView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         imageView=(ImageView) findViewById(R.id.header);
        imageView.setImageResource(R.drawable.top);



         collapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.collapse_toolbar);

        collapsingToolbar.setTitleEnabled(false);




        setupToolbar();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("HOME");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrag(new fragtwo(), "Kitchen");
        adapter.addFrag(new fragthree(), "Bedroom");
        adapter.addFrag(new fragfour(), "Bedroom1");
        adapter.addFrag(new fragfive(), "Livingroom");
        adapter.addFrag(new fragone(new OnFragmentSelectedListener(){

            @Override
            public void onFragmentSelected(int position) {

                if(position == 1){
                    /*collapsingToolbar.setBackgroundResource(R.drawable.eveback);*/
                    imageView.setImageResource(R.drawable.fans);
                }
            }
        }), "Hall");

        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager manager)
        {
            super(manager);
        }



        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
          public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }




    }


}
