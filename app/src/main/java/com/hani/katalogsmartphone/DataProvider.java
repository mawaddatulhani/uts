package com.hani.katalogsmartphone;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.hani.katalogsmartphone.model.Hp;
import com.hani.katalogsmartphone.model.Vivo;
import com.hani.katalogsmartphone.model.Oppo;
import com.hani.katalogsmartphone.model.Samsung;

public class DataProvider {
    private static List<Hp> hps = new ArrayList<>();

    private static List<Vivo> initDataVivo(Context ctx) {
        List<Vivo> vivos = new ArrayList<>();
        vivos.add(new Vivo("VIVO V20 GARANSI RESMI VIVO ", "Rp3.950.000",
                "OS Android 10, Funtouch 11\n" +
                        "Chipset Qualcomm SDM720 Snapdragon 720G (7 nm)\n" +
                        "CPU Octa-core (1x2.4 GHz Kryo 475 Prime & 1x2.2 GHz Kryo 475 Gold & 6x1.8 GHz Kryo 475 Silver)\n" +
                        "GPU Adreno 620\n", R.drawable.vivo1));
        vivos.add(new Vivo("VIVO Y50 RAM 8/128 GB", "Rp3.000.000",
                "Prosesor\n" +
                        "Qualcomm Snapdragon 665\n" +
                        "Octa Core\n" +
                        "\n" +
                        "Sistem Operasi\n" +
                        "Android 10\n" +
                        "\n" +
                        "Ram : 8GB\n" +
                        "Internal : 128GB\n", R.drawable.vivo2));
        vivos.add(new Vivo("Vivo V20 [8/128] RAM 8GB ROM 128GB", "Rp3.000.000",
                "CPU : Qualcomm Snapdragon 720G\n" +
                        "RAM&ROM : 8GB+128GB\n" +
                        "Battery : 4000mAh (TYP)\n" +
                        "Fast Charging : 33W (11V/3A)\n" +
                        "Color: Midnight Jazz & Sunset Melody\n" +
                        "Operating System: Funtouch OS 11 (Based on Android 11)", R.drawable.vivo3));
        return vivos;
    }

    private static List<Samsung> initDataSamsung(Context ctx) {
        List<Samsung> samsungs = new ArrayList<>();
        samsungs.add(new Samsung("Samsung A71", "Rp5.000.000",
                "- Konfirmasi warna sebelum order ( CANTUMKAN WARNA DI NOTED )\n" +
                        "- BNIB , Brand New In Box ( Segel No Repact )\n" +
                        "- Ada toko Offline di Depok (bisa COD)\n" +
                        "- Garansi resmi Samsung Elecktronic Indonesia SEIN 1 tahun\n" +
                        "- Proses hari ini max 19:30 , kirim hari ini\n", R.drawable.samsung1));
        samsungs.add(new Samsung("Samsung Galaxy A51 [6/128] GB", "Rp3.899.000 ",
                "SIM Single SIM (Nano-SIM) or Dual SIM (Nano-SIM, dual stand-by)\n" +
                        "Size 6.5 inches, 102.0 cm2 (~87.4% screen-to-body ratio)\n" +
                        "Protection Corning Gorilla Glass 3\n" +
                        "PLATFORM OS Android 10.0; One UI 2\n" +
                        "Chipset Exynos 9611 (10nm)", R.drawable.samsung2));
        samsungs.add(new Samsung("Samsung Galaxy A11 3/32Gb", "Rp1.784.000",
                "Samsung Galaxy A11 3/32Gb\n" +
                        "Garansi resmi Samsung Indonesia 1thn\n" +
                        "Ready Hitam dan Putih\n" +
                        "Kartu Garansi Nyatu di buku panduan", R.drawable.samsung3));
        return samsungs;
    }
    private static List<Oppo> initDataOppo(Context ctx) {
        List<Oppo> oppos = new ArrayList<>();
        oppos.add(new Oppo("OPPO A52 Smartphone Special Online Edition 6GB/128GB", "Rp3.000.000",
                "Basic Parameters\n" +
                        "Operating System : ColorOS 7, based on Android 10\n" +
                        "Processor : Qualcomm Snapdragon 665 (SM6125)\n" +
                        "CPU frequency : 4*2.0Hz + 4*1.8GHz\n" +
                        "GPU Model: Adreno 610\n" +
                        "Battery : 4880/5000 mAh (min/typ)\n" +
                        "Charge Speed: 9V 2A，18W", R.drawable.oppo1));
        oppos.add(new Oppo("OPPO A91 Smartphone 8GB/128GB", "Rp3.000.000 ",
                "Basic Parameters\n" +
                        "Color: Lightening Black, Unicorn White\n" +
                        "Operating System: ColorOS 6.1.2, based on Android 9\n" +
                        "CPU: Helio P70\n" +
                        "GPU: ARM Mali G72 MP3 900MHz\n" +
                        "Battery: 4025mAh (Standard Value)\n" +
                        "RAM: 8GB", R.drawable.oppo2));
        oppos.add(new Oppo("OPPO A52 Smartphone Special Online Edition 6GB/128GB", "Rp3.000.000",
                "Basic Parameters\n" +
                        "Operating System : ColorOS 7, based on Android 10\n" +
                        "Processor : Qualcomm Snapdragon 665 (SM6125)\n" +
                        "CPU frequency : 4*2.0Hz + 4*1.8GHz\n" +
                        "GPU Model: Adreno 610\n" +
                        "Battery : 4880/5000 mAh (min/typ) ", R.drawable.opp3));
        return oppos;
    }

    private static void initAllHps(Context ctx) {
        hps.addAll(initDataSamsung(ctx));
        hps.addAll(initDataVivo(ctx));
        hps.addAll(initDataOppo(ctx));
    }

    public static List<Hp> getAllHp(Context ctx) {
        if (hps.size() == 0) {
            initAllHps(ctx);
        }
        return  hps;
    }

    public static List<Hp> getHpsByTipe(Context ctx, String merek) {
        List<Hp> hpsByType = new ArrayList<>();
        if (hps.size() == 0) {
            initAllHps(ctx);
        }
        for (Hp h : hps) {
            if (h.getMerek().equals(merek)) {
                hpsByType.add(h);
            }
        }
        return hpsByType;
    }

}
