package com.younggan.intermediate1;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iihsa on 4/28/2017.
 */

public class CuacaAdapter extends ArrayAdapter<String> {
    private final AppCompatActivity context;
    private final String[] cuaca;


    public CuacaAdapter(AppCompatActivity context, String[] cuaca) {
        super(context, R.layout.mylist, cuaca);
        this.context=context;
        this.cuaca = cuaca;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        txtTitle.setText(cuaca[position]);
        return rowView;

    };
}
