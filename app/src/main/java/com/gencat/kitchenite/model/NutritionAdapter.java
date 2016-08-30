package com.gencat.kitchenite.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gencat.kitchenite.R;

import java.util.ArrayList;

/**
 * Created by Tifani on 8/31/2016.
 */
public class NutritionAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Nutrition> nutritions;
    private static LayoutInflater inflater = null;

    public NutritionAdapter(Context context, ArrayList<Nutrition> nutritions) {
        this.context = context;
        this.nutritions = nutritions;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return nutritions.size();
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
        if (nutritions != null) {
            Nutrition nutrition = nutritions.get(position);
            v = inflater.inflate(R.layout.nutrition_item, null);
            LinearLayout background = (LinearLayout) v.findViewById(R.id.background);
            View divider = v.findViewById(R.id.divider);
            TextView name = (TextView) v.findViewById(R.id.nutrition_name);
            TextView count = (TextView) v.findViewById(R.id.nutrition_count);

            if(position%2 == 0) {
                background.setBackgroundColor(context.getResources().getColor(R.color.dark_pink));
                divider.setBackgroundColor(context.getResources().getColor(R.color.dark_pink_divider));
            } else {
                background.setBackgroundColor(context.getResources().getColor(R.color.light_pink));
                divider.setBackgroundColor(context.getResources().getColor(R.color.light_pink_divider));
            }

            name.setText(nutrition.getName());
            count.setText(nutrition.getCount());
        }
        return v;
    }
}
