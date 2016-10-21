/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amobaoop;

import java.util.Scanner;

/**
 *
 * @author Pisti
 */
public class AmobaOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jatekos p1 = new Jatekos("Józsi", "X");
        Jatekos p2 = new Jatekos("Gazsi", "O");
        
        int[] aktlepes;
        boolean jatekvege = false;
        Jatekos aktualis = p1;

        Tabla t = new Tabla();
        String[][] palya = new String[3][3];

        t.tablaInit(palya);
        System.out.println("Üdv a 3-mas amőba játékban. A koordináták szerint léphet (pl. A1)");
        t.tablaKiir(palya);
        do {
            System.out.println("Kérem: " + aktualis.getNev() + " (" + aktualis.getJel() + ") lépését.");
            aktlepes = t.lepesKer();
            while (!t.lepesEll(aktlepes, palya, aktualis)) {
                aktlepes = t.lepesKer();
            }
            t.tablaKiir(palya);
            if (t.nyertes(palya).equals(aktualis.getJel())) {
                System.out.println(aktualis.getNev() + " győzött!");
                jatekvege = true;
            } else if (t.nyertes(palya).equals("dontetlen")) {
                System.out.println("Döntetlen!");
                jatekvege = true;
            }
            if (aktualis == p1) {
                aktualis = p2;
            } else {
                aktualis = p1;
            }
        } while (!jatekvege);
    }

}
