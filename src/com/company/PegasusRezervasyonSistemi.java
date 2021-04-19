package com.company;


import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class PegasusRezervasyonSistemi extends UcakRezervasyonSistemi {

    public PegasusRezervasyonSistemi() {

    }

    private int businessOrEkonomik;
    private int businessKoltukNumber;
    private int EkonomikKoltukNumber;
    private boolean[] thyListBoolean;
    private Scanner input = new Scanner(System.in);

    public PegasusRezervasyonSistemi(int koltukSayisi) {
        if (koltukSayisi < 10) {
            System.out.println("10'dan az olamaz 10 atamıştır ");
            koltukSayisi = 10;
        }
        thyListBoolean = new boolean[koltukSayisi];
        for (int i = 0; i < koltukSayisi; i++) {
            thyListBoolean[i] = false;
        }

    }

    public boolean bosMu() {

        for (int i = 0; i < thyListBoolean.length; i++) {
            if (thyListBoolean[i] == false) return true;

        }

        return false;
    }

    public void yazdir() {
        for (int i = 0; i < thyListBoolean.length; i++) {
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
        for (int i = 5; i < thyListBoolean.length; i++) {
            if (thyListBoolean[i] == false)
                System.out.print((i + 1) + " ");
        }


    }

    public boolean cikar(int silenecekSayi) {
        boolean isFull = false;
        if (silenecekSayi < thyListBoolean.length + 1) {
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
            System.out.println("Oyle bi koltuk yok 0");
            return isFull;
        }
    }

    public boolean ekonomiDoluMu() {
        boolean isFull = true;
        for (int i = 6; i < thyListBoolean.length; i++) {
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
        System.out.println("Pegasus REZERVASYON Sistemine hoş geldiniz ! ");
        System.out.println("Business class uçmak için 0'a basınız , ekonomik class uçmak için 1'a basınız ");
        /*      setBusinessOrEkonomik(Optional.ofNullable(input.nextInt()).map(integer -> integer::se)); */
        boolean c = true;
        String ss = "";
        while (c) {//TODO names must be more clean
            try {
                ss = input.next();
                if (Integer.class.isInstance(Integer.parseInt(ss))) {
                    setBusinessOrEkonomik(Integer.parseInt(ss));
                    if (getBusinessOrEkonomik() < 2) {
                        c = false;
                    } else {
                        System.out.println("1 yada 0 seçiniz lütfen");
                    }
                }
            } catch (Exception e) {
                System.out.println("düzgün gir sayıyı");
            }
        }

   /* Optional.ofNullable(input.nextInt()).ifPresentOrElse(this::setBusinessKoltukNumber,() -> System.out.println(" yanlış girdiniz"));
    if(Integer.class.isInstance(getBusinessOrEkonomik())){
        c=false;
    }else {

    }*/
    /* try{
         if(input.hasNextInt()) {
             setBusinessKoltukNumber(input.nextInt());
             c=false;
         }*//*else{
             System.out.println("yanliş ");
             //
         }*//*
     }catch (Exception e){
         System.out.println("yanliş1 ");
     }
*//*        if(input.hasNextInt()) {
            setBusinessKoltukNumber(input.nextInt());
            c=false;
        }else{
            System.out.println("yanliş ");
            //
        }*//*

         *//* setBusinessKoltukNumber(input.nextInt());*//*
         *//*        c=false;*//*
         */


        if (!Integer.class.isInstance(businessOrEkonomik)) {
            System.out.println("girdiğinz sayı doğru değil bir daha giriniz");
        }
        //TODO control the value is it integer
        if (businessOrEkonomik == 0) {
            if (businessDoluMu()) {
                System.out.println("business kalmadı ");
            } else {
                System.out.println("aşağıdaki koltuklarından seçin ");
                yazdirBusiness();
                businessKoltukNumber = input.nextInt();
                if (businessKoltukNumber > 0 && businessKoltukNumber < 6) {
                    cikar(businessKoltukNumber);
                } else {
                    System.out.println("yanlış");
                }

            }

        } else if (businessOrEkonomik == 1) {
            if (ekonomiDoluMu()) {
                System.out.println("ekommik Dolu");
            } else {
                System.out.println("aşağıdaki koltuklarından seçin ");
                yazdirEkonomik();
                EkonomikKoltukNumber = input.nextInt();
                if (EkonomikKoltukNumber > 5 && EkonomikKoltukNumber < thyListBoolean.length + 1) {
                    cikar(EkonomikKoltukNumber);
                } else {
                    System.out.println("yanlış");
                }

            }

        } else {
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
