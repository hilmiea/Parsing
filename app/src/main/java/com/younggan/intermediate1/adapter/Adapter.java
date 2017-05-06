package com.younggan.intermediate1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.younggan.intermediate1.R;
import com.younggan.intermediate1.data.Data;

/**
 * Created by ihsan on 26/03/2016.
 */
public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView idpelanggan = (TextView) convertView.findViewById(R.id.idpelanggan);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.alamat);
        TextView tarif = (TextView) convertView.findViewById(R.id.tarif);
        TextView gradu = (TextView) convertView.findViewById(R.id.gradu);
        TextView piutang = (TextView) convertView.findViewById(R.id.piutang);
        TextView bk = (TextView) convertView.findViewById(R.id.bk);
        TextView petugas = (TextView) convertView.findViewById(R.id.petugas);
        TextView status = (TextView)convertView.findViewById(R.id.status);
        Data data = items.get(position);
        id.setText(data.getId());
        idpelanggan.setText(data.getIdpelanggan());
        nama.setText(data.getNama());
        alamat.setText(data.getAlamat());
        tarif.setText(data.getTarif());
        gradu.setText(data.getGradu());
        piutang.setText(data.getPiutang());
        bk.setText(data.getBk());
        petugas.setText(data.getPetugas());
        status.setText(data.getStatus());
        return convertView;
    }

}