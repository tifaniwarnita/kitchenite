package com.gencat.kitchenite.model;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gencat.kitchenite.R;

import java.util.ArrayList;

/**
 * Created by Tifani on 8/31/2016.
 */
public class ProcedureAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Procedure> procedures;
    private static LayoutInflater inflater = null;

    public ProcedureAdapter(Context context, ArrayList<Procedure> procedures) {
        this.context = context;
        this.procedures = procedures;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return procedures.size();
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
        if (procedures != null) {
            Procedure procedure = procedures.get(position);
            v = inflater.inflate(R.layout.procedure_item, null);
            TextView stepNumber = (TextView) v.findViewById(R.id.step_number);
            TextView stepDetail = (TextView) v.findViewById(R.id.step_detail);

            if (procedure.getStepNumber() != null)
                stepNumber.setText("Langkah " + procedure.getStepNumber());
            stepDetail.setText(procedure.getStepDetail());
        }
        return v;
    }
}
