package com.example.android.achmadirjikubay_1202154184_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void daftarList(View view) {
        Intent x = new Intent(this, Daftar.class);
        startActivity(x);
    }

    public void lihatGambar(View view) {
        Intent x = new Intent(this, Lihatgambar.class);
        startActivity(x);
    }
}
