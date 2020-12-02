package com.hani.katalogsmartphone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.hani.katalogsmartphone.model.Hp;

public class GaleriActivity extends AppCompatActivity {

    List<Hp> hps;
    int indeksTampil = 0;
    String merekHp;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txMerek,txTipe,txHarga,txDeskripsi,txJudul;
    ImageView ivFotoHp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_hp);
        Intent intent = getIntent();
        merekHp = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        hps = DataProvider.getHpsByTipe(this,merekHp);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> hpPertama());
        btnTerakhir.setOnClickListener(view -> hpTerakhir());
        btnSebelumnya.setOnClickListener(view -> hpSebelumnya());
        btnBerikutnya.setOnClickListener(view -> hpBerikutnya());

        txMerek = findViewById(R.id.txMerek);
        txTipe = findViewById(R.id.txTipe);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoHp = findViewById(R.id.gambarHp);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam Tipe "+merekHp);
    }


    private void tampilkanProfil() {
        Hp k = hps.get(indeksTampil);
        Log.d("SAMSUNG","Menampilkan samsung "+k.getMerek());
        txMerek.setText(k.getMerek());
        txTipe.setText(k.getTipe());
        txHarga.setText(k.getHarga());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoHp.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void hpPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void hpTerakhir() {
        int posAkhir = hps.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void hpBerikutnya() {
        if (indeksTampil == hps.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void hpSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}