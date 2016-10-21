/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amobaoop;

/**
 *
 * @author Pisti
 */
public class Jatekos {

    protected String nev;
    protected String jel;

    public Jatekos() {
    }

    public Jatekos(String nev, String jel) {
        this.nev = nev;
        this.jel = jel;
    }

    public String getJel() {
        return jel;
    }

    public void setJel(String jel) {
        this.jel = jel;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

}
