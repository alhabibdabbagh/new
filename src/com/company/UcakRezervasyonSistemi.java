package com.company;

public abstract class UcakRezervasyonSistemi {

    public UcakRezervasyonSistemi(){

    }

    public UcakRezervasyonSistemi(int koltukSayisi){

    }
    private int koltukSayisi;
    private boolean[] koltuklar;

    public int getKoltukSayisi() {
        return koltukSayisi;
    }

    public void setKoltukSayisi(int koltukSayisi) {
        this.koltukSayisi = koltukSayisi;
    }

    public boolean[] getKoltuklar() {
        return koltuklar;
    }

    public void setKoltuklar(boolean[] koltuklar) {
        this.koltuklar = koltuklar;
    }

    public boolean ekonomiDoluMu() {
        return false;
    }
    public boolean businessDoluMu() {
        return false;
    }
    public boolean ucakDoluMu() {
        return false;
    }

    public  abstract void rezervasyonAl();
}
