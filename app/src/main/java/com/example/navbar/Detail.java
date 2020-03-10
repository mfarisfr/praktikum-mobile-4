package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    private ImageView gambar;
    private TextView nama,deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        nama = findViewById(R.id.detailNama);
        deskripsi = findViewById(R.id.detailDeskripsi);

        Bundle bundle = getIntent().getExtras();
        String nameHero = bundle.getString("nama");
        String deskripsiHero = bundle.getString("deskripsi");

        nama.setText(nameHero);
        deskripsi.setText(deskripsiHero);


    }
}
