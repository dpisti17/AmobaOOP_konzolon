package amobaoop;

import java.util.Scanner;

/**
 *
 * @author Pisti
 */
public class Tabla {

    protected String[][] tabla;
    Scanner sc = new Scanner(System.in);

    public void tablaInit(String tabla[][]) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                tabla[i][j] = " ";
            }
        }
    }

    public void tablaKiir(String[][] tabla) {
        System.out.println("   1   2   3  ");
        System.out.println("A| " + tabla[0][0] + " | " + tabla[0][1] + " | " + tabla[0][2] + " | ");
        System.out.println("B| " + tabla[1][0] + " | " + tabla[1][1] + " | " + tabla[1][2] + " | ");
        System.out.println("C| " + tabla[2][0] + " | " + tabla[2][1] + " | " + tabla[2][2] + " | ");
    }

    public int[] lepesKer() {
        int[] lepeski = new int[2]; //kimenő adat: 0.index=sor, 1.index=oszlop      
        boolean sor = false;
        boolean oszlop = false;

        while (!sor || !oszlop) {
            String lepes = sc.next();
            if (lepes.length() == 2) {
                //sor konvertáció
                if (lepes.substring(0, 1).equalsIgnoreCase("A")) {
                    lepeski[0] = 0;
                    sor = true;
                } else if (lepes.substring(0, 1).equalsIgnoreCase("B")) {
                    lepeski[0] = 1;
                    sor = true;
                } else if (lepes.substring(0, 1).equalsIgnoreCase("C")) {
                    lepeski[0] = 2;
                    sor = true;
                } else {
                    System.out.println("Hibás sort adott meg");
                    System.out.println("Adjon megy egy új lépést");
                    sor = false;
                }
                //oszlop konvertáló
                if (lepes.substring(1, 2).equals("1")) {
                    lepeski[1] = 0;
                    oszlop = true;
                } else if (lepes.substring(1, 2).equals("2")) {
                    lepeski[1] = 1;
                    oszlop = true;
                } else if (lepes.substring(1, 2).equals("3")) {
                    lepeski[1] = 2;
                    oszlop = true;
                } else {
                    System.out.println("Hibás oszlopot adott meg.");
                    System.out.println("Adjon megy egy új lépést");
                    oszlop = false;
                }
            } else {
                System.out.println("Egy betű és egy szám kombinációját használhatja csak.");
                System.out.println("Adjon megy egy újat.");
            }
        }

        return lepeski;
    }

    public boolean lepesEll(int[] lepes, String[][] palya, Jatekos jatekos) {
        boolean jolepes = false;
        for (int i = 0; i < palya.length; i++) {
            for (int j = 0; j < palya[i].length; j++) {
                if ((lepes[0] == i && lepes[1] == j) && palya[i][j].equals(" ")) {
                    palya[i][j] = jatekos.getJel();
                    jolepes = true;
                }
            }
        }
        if (!jolepes) {
            System.out.println("A mező már foglalt. Adjon megy egy új lépést!");
        }
        return jolepes;
    }

    public String nyertes(String[][] tabla) {
        String nyertes = "";
        //oszlopokat vizsgálja és hogy nem üres-e
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[0][i].equals(tabla[1][i]) && tabla[0][i].equals(tabla[2][i]) && !tabla[0][i].equals(" ")) {
                nyertes = tabla[0][i];
            }
        }
        //sorokat vizsgálja
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i][0].equals(tabla[i][1]) && tabla[i][0].equals(tabla[i][2]) && !tabla[i][0].equals(" ")) {
                nyertes = tabla[i][0];
            }
        }
        //átlókat vizsgálja
        if (tabla[0][0].equals(tabla[1][1]) && tabla[0][0].equals(tabla[2][2]) && !tabla[1][1].equals(" ")) {
            nyertes = tabla[1][1];
        }
        if (tabla[2][0].equals(tabla[1][1]) && tabla[2][0].equals(tabla[0][2]) && !tabla[1][1].equals(" ")) {
            nyertes = tabla[1][1];
        }
        //megnézi, hogy döntetlen-e
        String vanszokoz = "";
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if (tabla[i][j].equals(" ")) {
                    vanszokoz = "jatek";
                }
            }
        }
        if (!vanszokoz.equals("jatek")) {
            nyertes = "dontetlen";
        }
        return nyertes;
    }

    public String[][] getTabla() {
        return tabla;
    }

    public void setTabla(String[][] tabla) {
        this.tabla = tabla;
    }
}
