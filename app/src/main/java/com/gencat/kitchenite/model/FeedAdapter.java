package com.gencat.kitchenite.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gencat.kitchenite.ChildActivity;
import com.gencat.kitchenite.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Tifani on 8/29/2016.
 */
public class FeedAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Feed> feeds;
    private static LayoutInflater inflater = null;
    private ImageButton bookmark;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = null;
        if (feeds != null) {
            Feed feed = feeds.get(position);
            if (feed.getType().equals(Feed.RECIPE)) {
                v = inflater.inflate(R.layout.fragment_recipe_feed, null);

                CircleImageView userPicture = (CircleImageView) v.findViewById(R.id.user_picture);
                TextView userName = (TextView) v.findViewById(R.id.user_name);
                LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.clickable_recipe);
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
                bookmark = (ImageButton) v.findViewById(R.id.bookmark);

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

                // Actions
                View.OnClickListener viewRecipe = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ChildActivity.class);
                        context.startActivity(intent);
                    }
                };
                linearLayout.setOnClickListener(viewRecipe);
                recipePhoto.setOnClickListener(viewRecipe);

                bookmark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeRecipeBookmark(position);
                    }
                });
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

    private void changeRecipeBookmark(int position) {
        RecipeFeed recipe = (RecipeFeed) feeds.get(position);
        recipe.changeBookmark();
        if (recipe.isBookmarked()) {
            bookmark.setImageResource(R.drawable.ic_bookmarked);
            Toast.makeText(context, "Resep berhasil ditandai", Toast.LENGTH_SHORT).show();
        } else {
            bookmark.setImageResource(R.drawable.ic_not_bookmarked);
            Toast.makeText(context, "Resep berhasil tidak ditandai", Toast.LENGTH_SHORT).show();
        }
    }

}
