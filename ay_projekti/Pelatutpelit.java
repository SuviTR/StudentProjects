/*
 * Laskee kuinka monta kertaa yksi pelaaja pelaa hirsipuuta
 */
package ay_projekti;
/**
 *
 * @strann
 */
public class Pelatutpelit {
    
    private int pelatutpelit;

    /**
     * Asettaa pelattujen pelien lukumäärän
     * @param uusiPelatut lisää yhden uuden pelin pelattujen pelien lukumäärään 
     * AE: uusiPelatut != kirjain
     * LE: this.pelatutpelit = uusiPelatut
     */ 
    public void lisaaPelatut (){
        this.pelatutpelit = pelatutpelit + 1;
    }
    
    //Palauttaa pelattujen pelien lukumäärän
    public int annaPelatut(){
        return pelatutpelit;
    }
}
