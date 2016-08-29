package com.gencat.kitchenite.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gencat.kitchenite.R;
import com.gencat.kitchenite.model.RecipeFeed;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeFeedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String RECIPE_FEED = "recipe";

    // TODO: Rename and change types of parameters
    private RecipeFeed recipeFeed;


    public RecipeFeedFragment() {
        // Required empty public constructor
    }

    public static RecipeFeedFragment newInstance(RecipeFeed recipeFeed) {
        RecipeFeedFragment fragment = new RecipeFeedFragment();
        Bundle args = new Bundle();
        args.putSerializable(RECIPE_FEED, recipeFeed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recipeFeed = (RecipeFeed) getArguments().getSerializable(RECIPE_FEED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_feed, container, false);
    }

}
