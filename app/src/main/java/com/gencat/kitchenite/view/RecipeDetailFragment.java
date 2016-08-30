package com.gencat.kitchenite.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gencat.kitchenite.R;
import com.gencat.kitchenite.model.Fixtures;
import com.gencat.kitchenite.model.RecipeFeed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public RecipeDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeDetailFragment newInstance(String param1, String param2) {
        RecipeDetailFragment fragment = new RecipeDetailFragment();
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
        View v = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Ayam Goreng Mentega");

        CircleImageView userPicture = (CircleImageView) v.findViewById(R.id.user_picture);
        TextView userName = (TextView) v.findViewById(R.id.user_name);
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

        Context context = getContext();
        RecipeFeed recipe = (RecipeFeed) Fixtures.getHomeFeeds().get(0);
        Picasso.with(context)
                .load(recipe.getUserPictureURL())
                .placeholder(R.drawable.placeholder_user)
                .error(R.drawable.placeholder_user)
                .into(userPicture);
        userName.setText(recipe.getUserName());
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

        return v;
    }

}
