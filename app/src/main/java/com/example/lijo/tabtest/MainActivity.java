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
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;


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
        imageView.setImageResource(R.drawable.kitchen);



         collapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.collapse_toolbar);

        collapsingToolbar.setTitleEnabled(false);




        setupToolbar();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("Position : ", String.valueOf(position));
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("Position1 : ", String.valueOf(position));
                Fade fade = new Fade();
                /*TransitionManager.go(imageView, fade);*/
              /*  ImageView newImage = new ImageView(getApplicationContext());*/


                switch(position) {

                    case 0:  imageView.setImageResource(R.drawable.kitchen);
                        break;
                    case 1:   imageView.setImageResource(R.drawable.beds);
                        break;

                    case 2:  imageView.setImageResource(R.drawable.bed1);
                        break;

                    case 3:   imageView.setImageResource(R.drawable.bed2);
                        break;

                    case 4:  imageView.setImageResource(R.drawable.top);
                        break;
                }
              /*  Scene newScene = new Scene((ViewGroup)newImage.getParent(),(ViewGroup)imageView.getParent() );
                TransitionManager.go(newScene, fade);*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });









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

        adapter.addFrag(new fragtwo(new OnFragmentSelectedListener() {
            @Override
            public void onFragmentSelected(int position) {
               /* imageView.setImageResource(R.drawable.top);*/

            }
        }), "Kitchen");
        adapter.addFrag(new fragthree(new OnFragmentSelectedListener() {
            @Override
            public void onFragmentSelected(int position) {
                /*imageView.setImageResource(R.drawable.bed);*/
            }
        }), "Bedroom");
        adapter.addFrag(new fragfour(new OnFragmentSelectedListener() {
            @Override
            public void onFragmentSelected(int position) {
              /*  imageView.setImageResource(R.drawable.top);*/
            }
        }), "Bedroom1");
        adapter.addFrag(new fragfive(new OnFragmentSelectedListener() {
            @Override
            public void onFragmentSelected(int position) {


                  /*  imageView.setImageResource(R.drawable.bed);*/

            }
        }), "Livingroom");
        adapter.addFrag(new fragone(new OnFragmentSelectedListener(){

            @Override
            public void onFragmentSelected(int position) {

//if(position==1) {
                    /*collapsingToolbar.setBackgroundResource(R.drawable.eveback);*/
   /* imageView.setImageResource(R.drawable.top);*/
}
//            }
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
