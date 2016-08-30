package com.gencat.kitchenite.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gencat.kitchenite.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Tifani on 8/29/2016.
 */
public class FeedAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Feed> feeds;
    private static LayoutInflater inflater = null;

    public FeedAdapter(Context context, ArrayList<Feed> feeds) {
        this.context = context;
        this.feeds = feeds;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return feeds.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if (feeds != null) {
            Feed feed = feeds.get(position);
            if (feed.getType().equals(Feed.RECIPE)) {
                v = inflater.inflate(R.layout.fragment_recipe_feed, null);

                CircleImageView userPicture = (CircleImageView) v.findViewById(R.id.user_picture);
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

                RecipeFeed recipe = (RecipeFeed) feed;
                Picasso.with(context)
                        .load(recipe.getUserPictureURL())
                        .placeholder(R.drawable.placeholder_user)
                        .error(R.drawable.placeholder_user)
                        .into(userPicture);
                userName.setText(recipe.getUserName());
                recipeEntree.setText(String.valueOf(recipe.getEntree()));
                if (recipe.getEntree()=='A') {
                    recipeEntree.setBackgroundColor(context.getResources().getColor(R.color.appetizer));
                } else if (recipe.getEntree()=='M') {
                    recipeEntree.setBackgroundColor(context.getResources().getColor(R.color.main_course));
                } else if (recipe.getEntree()=='D') {
                    recipeEntree.setBackgroundColor(context.getResources().getColor(R.color.dessert));
                }
                recipeName.setText(recipe.getRecipeName());
                Picasso.with(context)
                        .load(recipe.getRecipePhotoURL())
                        .placeholder(R.drawable.circle_animation)
                        .error(R.drawable.placeholder_recipe_photo)
                        .into(recipePhoto);
                made.setText(String.valueOf(recipe.getMade()));
                int roundStars = (int) Math.floor(recipe.getStars());
                for(int i=0; i<roundStars; i++) {
                    stars.get(i).setImageResource(R.drawable.ic_full_star);
                }
                if (recipe.getStars() > roundStars) {
                    stars.get(roundStars).setImageResource(R.drawable.ic_half_star);
                }
                comments.setText(String.valueOf(recipe.getComments()));
                if (recipe.isBookmarked()) {
                    bookmark.setImageResource(R.drawable.ic_bookmarked);
                } else {
                    bookmark.setImageResource(R.drawable.ic_not_bookmarked);
                }
            } else {
                assert((feed.getType().equals(Feed.UPDATE)));
                v = inflater.inflate(R.layout.fragment_update_feed, null);

                CircleImageView userPicture = (CircleImageView) v.findViewById(R.id.user_picture);
                TextView userName = (TextView) v.findViewById(R.id.user_name);
                TextView content = (TextView) v.findViewById(R.id.feed_content);
                TextView detail = (TextView) v.findViewById(R.id.feed_detail);

                UpdateFeed update = (UpdateFeed) feed;
                Picasso.with(context)
                        .load(update.getUserPictureURL())
                        .placeholder(R.drawable.placeholder_user)
                        .error(R.drawable.placeholder_user)
                        .into(userPicture);
                userName.setText(update.getUserName());
                content.setText(update.getContent());
                detail.setText(update.getRecipeName()); //TODO: follow atau made

            }
        }

        return v;
    }
}
