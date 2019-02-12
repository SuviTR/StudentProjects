/*
* Arvotaan arvattava sana
*/
package ay_projekti;

/**
 *
 * @strann
 */
public class Sana {
    private StringBuilder tyhja;
    private String sana;
    private String arvatutK;
    
    public Sana(){
        this.arvatutK = "";
    }
    //Palautetaan sana, jos pelaaja ei ole tiennyt sanaa
    public String sana(){
        this.sana = sana;
        return sana;
    }
    /** 
     * Arpoo arvattavan sanan
     * @return tyhja Palauttaa arvotun sanan pituisen tyhjän sanan
     */ 
    public StringBuilder annaSana(){
        String[] sanat = {"raparperipiirakka","suomenajokoira","virtahepo","hissikuilu","uraputki","nyhtökaurapyörykät","avokadopasta","kasvihuone","löytöretkeily","tietokonenäppäimistö","kinuskijäätelö","myymälävarkaus","amiraaliperhoset","sotilasparaati","flamingo","tietokonepeli","sanaristikko","omakotitalo","pilvipouta","lumisade","myrskyluoto","iltahämärä"};
        this.sana = sanat[(int) (Math.random() * sanat.length)];  

        tyhja = new StringBuilder();
        for (int i = 0; i < sana.length(); i++) {
            tyhja = tyhja.append("-");
        }
        return tyhja;
    }
    
    /** 
     * Muuttaa tyhjää sanaa, lisäämällä kirjaimia
     * @param kirjain joka asetetaan arvattavan sanan oikean kirjaimen kohdalle
     * AE: kirjain != numero
     * @return tyhja Palauttaa arvotun sanan pituisen tyhjän sanan, jossa korvatut kirjaimet
     */ 
    public StringBuilder korvaa(char kirjain){
        
        for(int i = 0; i < tyhja.length(); i++){
            if(sana.charAt(i) == (kirjain)){
                tyhja.setCharAt(i,kirjain);
            }
        }
        return tyhja;
    }
    /** 
     * Lisää merkkijonoon käyttäjän arvaamia merkkejä
     * @param uusiKirjain joka lisätään merkkijonoon
     * AE: uusiKirjain !=  numero
     * LE: this.arvatutK = arvatutK + uusiKirjain 
     */ 
    public void asetaArvatutKirjaimet(String uusiKirjain) {
        this.arvatutK = arvatutK + uusiKirjain;
    }  
     
    //Palauttaa arvatutK merkkijonon, jossa käyttäjän antamia merkkejä
    public String annaArvatutKirjaimet() {
        return arvatutK;
    }
    
    //Palauttaa tyhja+"" merkkijonon
    @Override
    public String toString(){
        return tyhja+"";
    }
}
