package com.gencat.kitchenite.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gencat.kitchenite.R;
import com.gencat.kitchenite.model.Ingredient;
import com.gencat.kitchenite.model.IngredientAdapter;
import com.gencat.kitchenite.model.Procedure;
import com.gencat.kitchenite.model.ProcedureAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProceduresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProceduresFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ProceduresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProceduresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProceduresFragment newInstance(String param1, String param2) {
        ProceduresFragment fragment = new ProceduresFragment();
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
        View v = inflater.inflate(R.layout.fragment_procedures, container, false);
        ListView listView = (ListView) v.findViewById(R.id.procedure_list);
        ArrayList<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList("1", "Bersihkan ayam, buang lemak dan"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "kulitnya. Kucuri perasan air"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "jeruk nipis, dan beri garam."))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "Remas-remas ayam. Tunggu"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "sekitar 15-30 menit"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList("2", "Ungkep ayam menggunakan"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "air secukupnya, tuang ayam."))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "Beri jahe dan bawang putih"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "halus. Ungkap ayam sampai"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "empuk."))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList("3", "Panaskan margarine dan minyak"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "kulitnya. Kucuri perasan air"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "jeruk nipis, dan beri garam."))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "Remas-remas ayam. Tunggu"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList("4", "Masak sampai harum."))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "Beri jahe dan bawang putih"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "halus. Ungkap ayam sampai"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList("5", "Masukkan sisa air tadi"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "air secukupnya, tuang ayam."))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "Beri jahe dan bawang putih"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList("6", "Masukkan sisa air ungkepan"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "Beri jahe dan bawang putih"))));
        procedures.add(new Procedure(new ArrayList<>(Arrays.asList(null, "halus. Ungkap ayam sampai"))));

        listView.setAdapter(new ProcedureAdapter(getContext(), procedures));

        return v;
    }

}
