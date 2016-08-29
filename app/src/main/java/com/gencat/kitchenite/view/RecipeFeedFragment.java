package com.gencat.kitchenite.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gencat.kitchenite.R;
import com.gencat.kitchenite.model.RecipeFeed;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeFeedFragment extends Fragment {
    private static final String ARG_RECIPE_FEED = "recipe";
    private RecipeFeed recipeFeed;


    public RecipeFeedFragment() {
        // Required empty public constructor
    }

    public static RecipeFeedFragment newInstance(RecipeFeed recipeFeed) {
        RecipeFeedFragment fragment = new RecipeFeedFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_RECIPE_FEED, recipeFeed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recipeFeed = (RecipeFeed) getArguments().getSerializable(ARG_RECIPE_FEED);
        } else {
            recipeFeed = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_recipe_feed, container, false);
        ImageView userPicture = (ImageView) v.findViewById(R.id.user_picture);
        TextView userName = (TextView) v.findViewById(R.id.user_name);
        TextView recipeEntree = (TextView) v.findViewById(R.id.recipe_entree);
        TextView recipeName = (TextView) v.findViewById(R.id.recipe_name);
        ImageView recipePhoto = (ImageView) v.findViewById(R.id.recipe_photo);
        Button made = (Button) v.findViewById(R.id.made);
        ImageButton star1 = (ImageButton) v.findViewById(R.id.star_1);
        ImageButton star2 = (ImageButton) v.findViewById(R.id.star_2);
        ImageButton star3 = (ImageButton) v.findViewById(R.id.star_3);
        ImageButton star4 = (ImageButton) v.findViewById(R.id.star_4);
        ImageButton star5 = (ImageButton) v.findViewById(R.id.star_5);
        ArrayList<ImageButton> stars = new ArrayList<>();
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);
        Button comments = (Button) v.findViewById(R.id.comments);
        ImageButton bookmark = (ImageButton) v.findViewById(R.id.bookmark);

        if (recipeFeed != null) {
            Picasso.with(getContext())
                    .load(recipeFeed.getUserPictureURL())
                    .placeholder(R.drawable.placeholder_user)
                    .error(R.drawable.placeholder_user)
                    .into(userPicture);
            userName.setText(recipeFeed.getUserName());
            recipeEntree.setText(recipeFeed.getEntree());
            if (recipeFeed.getEntree()=='E') {
                recipeEntree.setBackgroundColor(getResources().getColor(R.color.appetizer));
            } else if (recipeFeed.getEntree()=='M') {
                recipeEntree.setBackgroundColor(getResources().getColor(R.color.main_course));
            } else if (recipeFeed.getEntree()=='D') {
                recipeEntree.setText(recipeFeed.getRecipeName());
            }
            Picasso.with(getContext())
                    .load(recipeFeed.getRecipePhotoURL())
                    .placeholder(R.drawable.circle_animation)
                    .error(R.drawable.placeholder_recipe_photo)
                    .into(recipePhoto);
            made.setText(String.valueOf(recipeFeed.getMade()));
            int roundStars = (int) Math.floor(recipeFeed.getStars());
            for(int i=0; i<roundStars; i++) {
                stars.get(i).setImageResource(R.drawable.ic_full_star);
            }
            if (recipeFeed.getStars() > roundStars) {
                stars.get(roundStars+1).setImageResource(R.drawable.ic_half_star);
            }
            comments.setText(recipeFeed.getComments());
            if (recipeFeed.isBookmarked()) {
                bookmark.setImageResource(R.drawable.ic_bookmarked);
            } else {
                bookmark.setImageResource(R.drawable.ic_not_bookmarked);
            }
        }

        return v;
    }

}
