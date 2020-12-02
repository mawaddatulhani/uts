package com.hani.katalogsmartphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnSamsung,btnOppo,btnVivo;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnOppo = findViewById(R.id.btn_buka_oppo);
        btnSamsung = findViewById(R.id.btn_buka_samsung);
        btnVivo = findViewById(R.id.btn_buka_vivo);
        btnOppo.setOnClickListener(view -> bukaGaleri("Oppo"));
        btnSamsung.setOnClickListener(view -> bukaGaleri("Samsung"));
        btnVivo.setOnClickListener(view -> bukaGaleri("Vivo"));
    }

    private void bukaGaleri(String merekHp) {
        Log.d("MAIN","Buka activity samsung");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, merekHp);
        startActivity(intent);
    }

}