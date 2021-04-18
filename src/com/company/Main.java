package com.company;

import java.util.Scanner;

/**
 * @author habib
 * @on 18.04.2021 01:50
 */
public class Main {
    private  static UcakRezervasyonSistemi thyRezervasyonSistemi;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("bizim sistemiz hoş geldiniz, hangi şirket tercih edersiniz 0 THY ise 1 PEGASUS ise  ");
         int x =input.nextInt();//TODO clean code and check if integer
        while (x>1){
            System.out.println("yanlış girdiniz bir daha girin");
            x =input.nextInt();
        }
        if(x==0){
             thyRezervasyonSistemi = new TYHRezervasyonSistemi(5);
        }else {
             thyRezervasyonSistemi = new PegasusRezervasyonSistemi(5);
        }



        String inputKey = "c";

        while (inputKey.equals("c") || inputKey.equals("C")) {
            thyRezervasyonSistemi.rezervasyonAl();
            System.out.println("\nDevam etmek için c'ye, çıkmak için herhangi başka bir tuşa basınız ");
            inputKey = input.next();

        }
    }
}
