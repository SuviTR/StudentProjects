
package ay_projekti;

/**
 *
 * @strann
 */
import javax.swing.JOptionPane;

public class Naytto {

    private Kontrolleri kontrolleri;

    public void rekisteriOhjain(Kontrolleri ohjain) {
        this.kontrolleri = ohjain;
    }

    //Aloitus, joka näkyy, kun pelaaja alkaa pelaamaan Hirsipuuta ensimmäisen kerran
    public void tervetuloa() {

        Pelaaja pelaaja = new Pelaaja();

        //Kysytään pelaajan nimeä ja toivotetaan tervetulleeksi pelaamaan
        String nimi = JOptionPane.showInputDialog(null, "Anna pelaajanimesi:", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
        //Tarkistaa, valitseeko pelaaja cancel
        if (nimi == null) {
            JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        //Tarkistaa, antaako pelaaja tyhjän
        while (nimi.equals("")) {
            nimi = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna pelaajanimesi:", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE); //parentComponent, message, title, messageType)
            if (nimi == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        //Muutetaan nimen ensimmäinen kirjain isoksi ja loput pieniksi kirjaimiksi
        nimi = nimi.substring(0, 1).toUpperCase() + nimi.substring(1).toLowerCase();
        pelaaja.asetaPelaajanNimi(nimi);

        JOptionPane.showMessageDialog(null, pelaaja.annaPelaajanNimi() + ", \nTervetuloa pelaamaan Hirsipuuta!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
        hirsipuuAlku();
    }

    //Päävalikko, josta pelaaja pystyy valitsemaan haluamansa pelin
    //Näkyy aina myös pelin loputtua 
    public void aloitusNaytto() {

        //Esitellään peli-valikko
        String[] pelit = new String[]{"Hirsipuu", "Lopeta pelaaminen"};

        int valinta = JOptionPane.showOptionDialog(null, "Pelatut pelit: " + kontrolleri.annaPelatut()+ "", "Hirsipuu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pelit, pelit[0]);

        switch (valinta) {
            case 0: //Uusi Hirsipuu käyntiin
                hirsipuu();
                kontrolleri.loppu();
            case 1: //Lopetetaan peli
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen. Tervetuloa pelaamaan uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }
    }

    //Näyttö kutsuu Kontrollerilta hirsipuu-peliä
    public void hirsipuu() {
        kontrolleri.hirsipuu();
    }
    
    //Näyttö kutsuu Kontrollerilta hirsipuun sääntöjä
    public void hirsipuuAlku() {
        kontrolleri.hirsipuuAlku();
    }

    //Näytetään JOptionPane-muodossa palautettu merkkijono
    public void naytaTieto(String tieto) {
        JOptionPane.showMessageDialog(null, tieto, "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
    }

    public String kysyTieto(String kysymys) {
        // Metodi kysyy käyttäjältä jotakin tietoa.
        // Käyttäjälle esitetään kysymys, joka tulee parametrina.
        // Metodi palauttaa käyttäjän antaman vastauksen
        return JOptionPane.showInputDialog(kysymys);
    }

}
