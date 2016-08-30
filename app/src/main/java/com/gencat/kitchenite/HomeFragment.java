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
import com.gencat.kitchenite.model.Fixtures;
import com.gencat.kitchenite.model.RecipeFeed;
import com.gencat.kitchenite.view.RecipeFeedFragment;

import java.io.Serializable;
import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private static final String ARG_TYPE = "type";
    private static final String ARG_PARAM = "param";

    private String type;
    private Serializable param;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String type, Serializable param) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TYPE, type);
        args.putSerializable(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if(getArguments().getString(ARG_TYPE) != null) {
                type = getArguments().getString(ARG_TYPE, null);
            }
            if(getArguments().getSerializable(ARG_PARAM) != null) {
                param = getArguments().getSerializable(ARG_PARAM);
            } else {
                param = null;
            }
        } else {
            type = null;
            param = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,null);
        ListView listView = (ListView) v.findViewById(R.id.feed_list);
        if (type != null) {
            if (type.equals(TabFragment.HOME)) {
                listView.setAdapter(new FeedAdapter(getContext(), Fixtures.getHomeFeeds())); //TODO
            } else if (type.equals(TabFragment.RECENT)) {
                listView.setAdapter(new FeedAdapter(getContext(), Fixtures.getUpdateFeeds())); //TODO
            }
        }

        return v;
    }
}
