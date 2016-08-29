package com.gencat.kitchenite.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gencat.kitchenite.R;
import com.gencat.kitchenite.model.UpdateFeed;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateFeedFragment extends Fragment {
    private static final String ARG_UPDATE_FEED = "update";
    private UpdateFeed updateFeed;


    public UpdateFeedFragment() {
        // Required empty public constructor
    }

    public static UpdateFeedFragment newInstance(UpdateFeed updateFeed) {
        UpdateFeedFragment fragment = new UpdateFeedFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_UPDATE_FEED, updateFeed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            updateFeed = (UpdateFeed) getArguments().getSerializable(ARG_UPDATE_FEED);
        } else {
            updateFeed = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update_feed, container, false);
        ImageView userPicture = (ImageView) v.findViewById(R.id.user_picture);
        TextView userName = (TextView) v.findViewById(R.id.user_name);
        TextView content = (TextView) v.findViewById(R.id.feed_content);
        TextView detail = (TextView) v.findViewById(R.id.feed_detail);

        if (updateFeed != null) {
            Picasso.with(getContext())
                    .load(updateFeed.getUserPictureURL())
                    .placeholder(R.drawable.placeholder_user)
                    .error(R.drawable.placeholder_user)
                    .into(userPicture);
            userName.setText(updateFeed.getUserName());
            content.setText(updateFeed.getContent());
            //TODO: sama yg follow
            detail.setText(updateFeed.getRecipeName());
        }

        return v;
    }

}
