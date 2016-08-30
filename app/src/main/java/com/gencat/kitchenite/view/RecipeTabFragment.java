package com.gencat.kitchenite.view;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gencat.kitchenite.HomeFragment;
import com.gencat.kitchenite.R;
import com.gencat.kitchenite.TabFragment;
import com.gencat.kitchenite.model.Fixtures;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeTabFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    public static String INGREDIENTS = "BAHAN";
    public static String PROCEDURE = "PROSEDUR";
    public static String NUTRITION = "NUTRISI";

    public RecipeTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeTabFragment newInstance(String param1, String param2) {
        RecipeTabFragment fragment = new RecipeTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recipe_tab, null);


        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);

        viewPager.setAdapter(new RecipeTabAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                for (int i = 0; i < int_items; i++) {
                    tabLayout.getTabAt(i).setText(viewPager.getAdapter().getPageTitle(i));
                }
            }
        });

        return v;
    }

    class RecipeTabAdapter extends FragmentPagerAdapter {

        public RecipeTabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new IngredientsFragment();
                case 1 : return new ProceduresFragment();
                case 2 : return new NutritionFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return INGREDIENTS;
                case 1 :
                    return PROCEDURE;
                case 2 :
                    return NUTRITION;
            }
            return null;
        }
    }

}
