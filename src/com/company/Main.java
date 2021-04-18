package com.company;

import java.util.Scanner;

/**
 * @author habib
 * @on 18.04.2021 01:50
 */
public class Main {
    public static void main(String[] args) {

        UcakRezervasyonSistemi thyRezervasyonSistemi = new TYHRezervasyonSistemi(5);

        Scanner input = new Scanner(System.in);

        String inputKey = "c";

        while (inputKey.equals("c") || inputKey.equals("C")) {
            thyRezervasyonSistemi.rezervasyonAl();
            System.out.println("\nDevam etmek için c'ye, çıkmak için herhangi başka bir tuşa basınız ");
            inputKey = input.next();

        }
    }
}
