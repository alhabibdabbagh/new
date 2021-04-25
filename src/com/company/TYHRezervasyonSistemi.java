package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class TYHRezervasyonSistemi extends UcakRezervasyonSistemi {

    public TYHRezervasyonSistemi() {

    }

    private int businessOrEkonomik;
    private int businessKoltukNumber;
    private int EkonomikKoltukNumber;
    private boolean[] thyListBoolean;
    private Scanner input = new Scanner(System.in);

    public TYHRezervasyonSistemi(int koltuSayisi) {
        if (koltuSayisi < 10) {
            System.out.println("10'dan az olamaz 10 atamıştır ");
            koltuSayisi = 10;
        }
        thyListBoolean = new boolean[koltuSayisi];
        for (int i = 0; i < koltuSayisi; i++) {
            thyListBoolean[i] = false;
        }

    }




    public boolean bosMu() {

        for (int i = 0; i < getThyListBoolean().length; i++) {
            if (thyListBoolean[i] == false) return true;

        }

        return false;
    }

    public void yazdir() {
        for (int i = 0; i < getThyListBoolean().length; i++) {
            if (thyListBoolean[i] == false)
                System.out.print((i + 1) + " ");
        }
    }

    public void yazdirBusiness() {
        for (int i = 0; i < 5; i++) {
            if (thyListBoolean[i] == false)
                System.out.print((i + 1) + " ");
        }
    }

    public void yazdirEkonomik() {
        for (int i = 5; i < getThyListBoolean().length; i++) {
            if (thyListBoolean[i] == false)
                System.out.print((i + 1) + " ");
        }


    }

    public boolean cikar(int silenecekSayi) {
        boolean isFull = false;
        if (silenecekSayi < getThyListBoolean().length + 1) {
            if (thyListBoolean[silenecekSayi - 1] == false) {
                System.out.println("rezervasyon alındı");
                thyListBoolean[silenecekSayi - 1] = true;
                isFull = true;
                return isFull;
            } else {
                System.out.println("Hatalı seçim");
                return isFull;
            }
        } else {
            System.out.println("Öyle bir koltuk yok 0");
            return isFull;
        }
    }

    public boolean ekonomiDoluMu() {
        boolean isFull = true;
        for (int i = 6; i < getThyListBoolean().length; i++) {
            if (thyListBoolean[i] == false) {

                isFull = false;
            }
        }
        return isFull;

    }

    public boolean businessDoluMu() {
        boolean isFull = true;
        for (int i = 0; i < 5; i++) {
            if (thyListBoolean[i] == false) {
                isFull = false;
            }
        }
        return isFull;
    }

    @Override
    public void rezervasyonAl() {
        System.out.println("THY REZERVASYON Sistemine hoş geldiniz ! ");
        System.out.println("Business class uçmak için 0'a basınız , ekonomik class uçmak için 1'a basınız ");
        boolean isNumberRong = true;
        String inputCheck = "";
        while (isNumberRong) {//TODO names must be more clean
      try {
          inputCheck = input.next();
          if (Integer.class.isInstance(Integer.parseInt(inputCheck))) {
              setBusinessOrEkonomik(Integer.parseInt(inputCheck));
              if (getBusinessOrEkonomik() < 2) {
                  isNumberRong = false;
              } else {
                  System.out.println("1 yada 0 seçiniz lütfen");
              }
          }

      }catch (Exception e){
          System.out.println("girdiğinz sayı doğru değil bir daha giriniz");

      }
        }
    /*    if(!Integer.class.isInstance(businessOrEkonomik)){
            System.out.println("girdiğinz sayı doğru değil bir daha giriniz");
        }*/
        //TODO control the value is it integer
        if (getBusinessOrEkonomik() == 0) {
            if (businessDoluMu()) {
                System.out.println("business kalmadı ");
            } else {
                System.out.println("aşağıdaki koltuklarından seçin ");
                yazdirBusiness();
                setBusinessKoltukNumber(input.nextInt());
                if (getBusinessKoltukNumber() > 0 && getBusinessKoltukNumber() < 6) {
                    cikar(getBusinessKoltukNumber());
                } else {
                    System.out.println("yanlış");
                }

            }

        } else if (getBusinessOrEkonomik() == 1) {
            if (ekonomiDoluMu()) {
                System.out.println("ekommik Dolu");
            } else {
                System.out.println("aşağıdaki koltuklarından seçin ");
                yazdirEkonomik();
                setEkonomikKoltukNumber(input.nextInt());
                if (getEkonomikKoltukNumber() > 5 && getEkonomikKoltukNumber() < getThyListBoolean().length + 1) {
                    cikar(getEkonomikKoltukNumber());
                } else {
                    System.out.println("yanlış");
                }

            }

        } else {//TODO change to while loops
            System.out.println("hata seçim");
        }

    }

    public int getBusinessOrEkonomik() {
        return businessOrEkonomik;
    }

    public void setBusinessOrEkonomik(int businessOrEkonomik) {
        this.businessOrEkonomik = businessOrEkonomik;
    }

    public int getBusinessKoltukNumber() {
        return businessKoltukNumber;
    }

    public void setBusinessKoltukNumber(int businessKoltukNumber) {
        this.businessKoltukNumber = businessKoltukNumber;
    }

    public int getEkonomikKoltukNumber() {
        return EkonomikKoltukNumber;
    }

    public void setEkonomikKoltukNumber(int ekonomikKoltukNumber) {
        EkonomikKoltukNumber = ekonomikKoltukNumber;
    }

    public boolean[] getThyListBoolean() {
        return thyListBoolean;
    }

    public void setThyListBoolean(boolean[] thyListBoolean) {
        this.thyListBoolean = thyListBoolean;
    }
}
