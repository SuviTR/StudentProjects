/*
 *Pelaaja-luokka, joka kysyy ja palauttaa pelaajan nimen
 */
package ay_projekti;

/**
 *
 * @strann
 */
public class Pelaaja {
    private String nimi;

    public Pelaaja() {
    }

    /** 
     * Muuttaa tyhjää sanaa, lisäämällä kirjaimia
     * @param uusiNimi asettaa uuden nimen, kun pelaaja ensimmäisen kerran alkaa pelaamaan peliä
     * AE: uusiNimi != numero
     * LE: this.nimi = uusiNimi
     */ 
    public void asetaPelaajanNimi(String uusiNimi) {
        this.nimi = uusiNimi;
    }

    /** 
     * Palauttaa pelaajan nimen
     */ 
    public String annaPelaajanNimi() {
        return nimi;
    }
}
