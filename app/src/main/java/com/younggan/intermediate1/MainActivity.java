package com.younggan.intermediate1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button lihat;
    String[] cuaca = {
            "Mendung",
            "Hujan",
            "Panas",
            "Hujan",
            "Berawan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CuacaAdapter adapter= new CuacaAdapter(this, cuaca);
        list=(ListView)findViewById(R.id.list);
        lihat=(Button) findViewById(R.id.listparse);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("cuaca", cuaca[position]);
                startActivity(intent);
            }
        });
        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DaftarWOActivity.class);
                startActivity(intent);
            }
        });
    }
}
