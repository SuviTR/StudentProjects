/*
 * Laskee kuinka monta peliä pelaaja voittaa
 */
package ay_projekti;

/**
 *
 * @author Käyttäjä
 */
public class Voitot {
    private int voitot;
    
    
    public Voitot(){
        this.voitot = 0;
    }
    
    /** 
     * Muuttaa tyhjää sanaa, lisäämällä kirjaimia
     * @param uusiVoitto lisätään yksi voitto lisää
     * AE: uusiVoitto != kirjain
     * LE: this.voitot = voitot + uusiVoitto
     */ 
    public void asetaVoitot() {
        this.voitot = voitot + 1;
    }
    
    /** 
     * Palauttaa tiedon voitettujen pelien lukumäärän 
     */ 
    public int voitot() {
        this.voitot = voitot;
        return voitot;
    }
}
