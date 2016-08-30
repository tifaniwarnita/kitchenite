package com.gencat.kitchenite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gencat.kitchenite.model.Fixtures;
import com.gencat.kitchenite.view.ProfileFragment;

public class TabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 4;

    public static String HOME = "home";
    public static String RECENT = "recent";
    public static String PROFILE = "profile";
    public static String NOTIFICATION = "notification";

    private Integer[] tabIcons = {
            R.drawable.ic_tab_home,
            R.drawable.ic_tab_recent,
            R.drawable.ic_tab_profile,
            R.drawable.ic_tab_notification
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                for (int i = 0; i < int_items; i++) {
                    tabLayout.getTabAt(i).setIcon(tabIcons[i]);
                }
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {

            switch (position){
                case 0 : return HomeFragment.newInstance(HOME, Fixtures.getHomeFeeds()); //TODO:
                case 1 : return HomeFragment.newInstance(RECENT, Fixtures.getUpdateFeeds()); //TODO:
                case 2 : return new ProfileFragment();
                case 3 : return HomeFragment.newInstance(NOTIFICATION, null);
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

//            switch (position){
//                case 0 :
//                    return "Home";
//                case 1 :
//                    return "Recent";
//                case 2 :
//                    return "Profile";
//                case 3:
//                    return "Notification";
//            }
            return null;
        }
    }
}
