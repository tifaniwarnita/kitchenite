package com.gencat.kitchenite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gencat.kitchenite.model.Feed;
import com.gencat.kitchenite.model.FeedAdapter;
import com.gencat.kitchenite.model.RecipeFeed;
import com.gencat.kitchenite.view.RecipeFeedFragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private static final int CONTENT_VIEW_ID = 10101010;
    private static final int CONTENT_VIEW_ID1 = 10101011;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,null);
        ListView feedList = (ListView) v.findViewById(R.id.feed_list);

        ArrayList<Feed> feeds = new ArrayList<>();
        feeds.add(new RecipeFeed("1",
                "Swedish Meatballs",
                "http://tastyfoodsnacks.com/wp-content/uploads/2013/12/Swedish-Meatballs-Holiday-Appetizer-Recipes.png",
                'A',
                22,
                4.5f,
                33,
                false,
                "1",
                "Tifani",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAVmAAAAJGE4ZDYzOTFmLWU5NDQtNGMxYi1hNGJiLWM3MjQwYjI3N2EzOA.jpg"));

        feeds.add(new RecipeFeed("2",
                "Ayam Saus Pedas",
                "http://weneedfun.com/wp-content/uploads/2015/10/Beautiful-Food-Photos-8.jpg",
                'M',
                20,
                3.0f,
                5,
                true,
                "1",
                "Tifani",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAVmAAAAJGE4ZDYzOTFmLWU5NDQtNGMxYi1hNGJiLWM3MjQwYjI3N2EzOA.jpg"));

        feeds.add(new RecipeFeed("2",
                "Pudding Stroberi",
                "https://images6.alphacoders.com/434/434430.jpg",
                'D',
                2,
                4.0f,
                34,
                false,
                "1",
                "William",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAUWAAAAJGUxODViNGRjLTNhNDctNDVlYy05NjJmLTQ4YTMxMGY2MDI3Mg.jpg"));


        feedList.setAdapter(new FeedAdapter(getContext(), feeds));

        return v;
    }
}
