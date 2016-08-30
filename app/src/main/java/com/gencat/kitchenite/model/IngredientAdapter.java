package com.gencat.kitchenite.model;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gencat.kitchenite.ChildActivity;
import com.gencat.kitchenite.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Tifani on 8/31/2016.
 */
public class IngredientAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Ingredient> ingredients;
    private static LayoutInflater inflater = null;

    public IngredientAdapter(Context context, ArrayList<Ingredient> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ingredients.size();
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
        if (ingredients != null) {
            Ingredient ingredient = ingredients.get(position);
            v = inflater.inflate(R.layout.ingredient_item, null);
            TextView ingredientText = (TextView) v.findViewById(R.id.ingredient);

            String s = "";
            if (ingredient.getCount() != null)
                s = s + "<b>" + ingredient.getCount() + "</b> ";
            s = s + ingredient.getMaterial();
            ingredientText.setText(Html.fromHtml(s));
        }
        return v;
    }
}
