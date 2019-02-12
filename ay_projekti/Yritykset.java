/*
 *Laskee pelaajan yritysten lukumäärän ja palauttaa tiedon pelaajalle
 */
package ay_projekti;

/**
 * @strann
 */


public class Yritykset {

    
    private int yritykset;
    private int jaljella;

    public Yritykset(int yritys) {
        this.jaljella = 5;
    }
    
    /** 
    * Laskee yritysten lukumäärän
    * LE: this.yritykset = yritykset + 1
    */ 
    public void asetaYritykset() {
        this.yritykset = yritykset + 1;
    }

    /** 
    * Laskee kuinka paljon yrityksiä on jäljellä viidestä
    * LE: this.jaljella = 5 - jaljella
    */ 
    public void yrityksiaJaljella() {
        this.jaljella = 5 - yritykset;
    }

    /** 
    * Palauttaa jäljellä olevien yritysten lukumäärän
    */ 
    public int annaYrityksiaJaljella() {
        return jaljella;
    }
    
}

