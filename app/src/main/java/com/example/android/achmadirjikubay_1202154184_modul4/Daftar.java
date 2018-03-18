package com.example.android.achmadirjikubay_1202154184_modul4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class Daftar extends AppCompatActivity {
    public ListView lList;
    private Button bButton;
    private ProgressBar bBar;
    private ItemList itemList;
    private String[] mahasiswa = {
            "LoYou", "L'on", "Musk", "Osas", "Elon", "Xander", "Thanos", "Iron","You","Know","What","I","Mean"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        lList = findViewById(R.id.listView);
        bButton = findViewById(R.id.btnAsync);
        bBar = findViewById(R.id.bar);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());

        lList.setAdapter(adapter);
    }

    public void startAsync(View view) {
        itemList = new ItemList();
        itemList.execute();
    }

    private class ItemList extends AsyncTask<Void, String, Void> {
        private ArrayAdapter<String> mAdapter;
        private int mCounter = 1;
        ProgressDialog mDialog = new ProgressDialog(Daftar.this);

        @Override
        protected void onPreExecute() {
            //memasukkan data ke list view
            mAdapter = (ArrayAdapter<String>) lList.getAdapter();
            //membuat progress bar
            mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mDialog.setTitle("Tunggu Sebentar");

            mDialog.setProgress(0);
            mDialog.show();
        }



        @Override
        protected Void doInBackground(Void... voids) {
            for (String data : mahasiswa){
                publishProgress(data);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            mAdapter.add(values[0]);

            //menghitung persen pada dialog
            Integer status = (int) ((mCounter / (float) mahasiswa.length) * 100);
            bBar.setProgress(status);

            //set status pada ProgressDialog
            mDialog.setProgress(status);

            //set message will not working when using horizontal loading
            mDialog.setMessage(String.valueOf(status + "%"));
            mCounter++;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            //hide progreebar
            bBar.setVisibility(View.GONE);

            //remove progress dialog
            mDialog.dismiss();
            lList.setVisibility(View.VISIBLE);
        }

    }
    }

