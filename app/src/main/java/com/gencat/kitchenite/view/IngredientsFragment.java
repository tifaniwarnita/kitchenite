package com.gencat.kitchenite.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gencat.kitchenite.R;
import com.gencat.kitchenite.model.Fixtures;
import com.gencat.kitchenite.model.Ingredient;
import com.gencat.kitchenite.model.IngredientsAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IngredientsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IngredientsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public IngredientsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IngredientsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IngredientsFragment newInstance(String param1, String param2) {
        IngredientsFragment fragment = new IngredientsFragment();
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
        View v = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ListView listView = (ListView) v.findViewById(R.id.ingredient_list);

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("2 cangkir", "nasi"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("2.5 sendok makan", "kecap manis"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("1 sendok makan", "sambal"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("1/4 cangkir", "minyak kelapa"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("1", "bawang putih"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("300g", "udang"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("3", "bawang merah"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("1 potong", "ayam kampung"))));
        ingredients.add(new Ingredient(new ArrayList<>(Arrays.asList("3 sendok", "kecap asin"))));

        listView.setAdapter(new IngredientsAdapter(getContext(), ingredients));

        return v;
    }

}
