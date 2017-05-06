package com.younggan.intermediate1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.younggan.intermediate1.adapter.Adapter;
import com.younggan.intermediate1.app.AppController;
import com.younggan.intermediate1.data.Data;
/**
 * Created by ihsan on 26/03/2016.
 */
public class DaftarWOActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    Adapter adapter;
    ListView list;
    List<Data> itemList = new ArrayList<Data>();
    private static String url_select = "https://ihsanab31.000webhostapp.com/select.php";
    String tag_json_obj = "json_obj_req";
    private static final String TAG = DaftarWOActivity.class.getSimpleName();
    public static final String TAG_ID       = "id";
    public static final String TAG_IDPELANGGAN= "idpelanggan";
    public static final String TAG_NAMA     = "nama";
    public static final String TAG_ALAMAT   = "alamat";
    public static final String TAG_TARIF   = "tarif";
    public static final String TAG_GRADU   = "gradu";
    public static final String TAG_PIUTANG   = "piutang";
    public static final String TAG_BK   = "bk";
    public static final String TAG_PETUGAS  = "petugas";
    public  static  final String TAG_STATUS = "status";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_wo);
        list = (ListView)findViewById(R.id.list);
        swipe   = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        adapter = new Adapter(DaftarWOActivity.this, itemList);
        list.setAdapter(adapter);
        swipe.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) DaftarWOActivity.this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           itemList.clear();
                           adapter.notifyDataSetChanged();
                           callVolley();
                       }
                   }
        );
//        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                final String idx = itemList.get(position).getId();
//                Intent intent = new Intent(getApplicationContext(), InputActivity.class);
//                intent.putExtra("id",idx);
//                startActivity(intent);
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate dari menu; disini akan menambahkan item menu pada Actionbar
        getMenuInflater().inflate(R.menu.main_menu, menu);//Memanggil file bernama menu di folder menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRefresh() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        callVolley();
    }
    private void callVolley(){
        itemList.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        // membuat request JSON
        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Data item = new Data();

                        item.setId(obj.getString(TAG_ID));
                        item.setIdpelanggan(obj.getString(TAG_IDPELANGGAN));
                        item.setNama(obj.getString(TAG_NAMA));
                        item.setAlamat(obj.getString(TAG_ALAMAT));
                        item.setTarif(obj.getString(TAG_TARIF));
                        item.setGradu(obj.getString(TAG_GRADU));
                        item.setPiutang(obj.getString(TAG_PIUTANG));
                        item.setBk(obj.getString(TAG_BK));
                        item.setPetugas(obj.getString(TAG_PETUGAS));
                        // menambah item ke array
                        itemList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                // notifikasi adanya perubahan data pada adapter
                adapter.notifyDataSetChanged();

                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                swipe.setRefreshing(false);
            }
        });

        // menambah request ke request queue
        AppController.getInstance().addToRequestQueue(jArr);
    }
}
