package com.example.android.achmadirjikubay_1202154184_modul4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class Lihatgambar extends AppCompatActivity {
    private EditText uURL;
    private ImageView iImage;
    private String imageLink;
    private Button btnImage;
    //    private Uri link;
//    private ImageDownloader imageDownloader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatgambar);
        uURL = findViewById(R.id.linkImg);
        iImage = findViewById(R.id.imageResult);
        btnImage = findViewById(R.id.btnSearch);

    }

    public void cariGambar(View view) {
        imageLink = uURL.getText().toString();
        ImageDownloader  imageDownloader = new ImageDownloader();
        imageDownloader.execute(imageLink);
    }


    public class ImageDownloader extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
            return params[0];
        }
        @Override
        protected void onPostExecute(String imageLink) {
            super.onPostExecute(imageLink);

            Picasso.get().load(imageLink).into(iImage);

        }
    }
}
