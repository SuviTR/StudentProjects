/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veikkaus_projekti;

/**
 *
 * @author Käyttäjä
 */
import javax.swing.JOptionPane;

public class Veikkaus_Naytto {

    private Veikkaus_Kontrolleri kontrolleri;
    private Pelaaja pelaaja;
    private Pelitili tili;
    private Lotto lotto;
    private Ktem ktem;
    private Lomatonni lomatonni;
    private Synttarit synttarit;

    public void rekisteriOhjain(Veikkaus_Kontrolleri ohjain) {
        this.kontrolleri = ohjain;
    }

    //Aloitus, joka näkyy, kun pelaaja alkaa pelaamaan Veikkausta ensimmäisen kerran
    public void tervetuloa() {
        Pelaaja pelaaja = new Pelaaja();
        Pelitili tili = new Pelitili();

        //Kysytään pelaajan nimeä ja toivotetaan tervetulleeksi pelaamaan
        String nimi = JOptionPane.showInputDialog(null, "Anna pelaajanimesi:", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
        //Tarkistaa, valitseeko pelaaja cancel
        if (nimi == null) {
            JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        //Tarkistaa, antaako pelaaja tyhjän
        while (nimi.equals("")) {
            nimi = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna pelaajanimesi:", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); //parentComponent, message, title, messageType)
            if (nimi == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        nimi = nimi.substring(0, 1).toUpperCase() + nimi.substring(1).toLowerCase();
        pelaaja.setPelaajanNimi(nimi);

        JOptionPane.showMessageDialog(null, pelaaja.getPelaajanNimi() + ", \nTervetuloa pelaamaan Veikkauksen rahapelejä!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);

        //Kysytään kuinka paljon pelaaja haluaa tallettaa rahaa tyhjälle pelitilille, jotta hän voi pelata
        String sraha = JOptionPane.showInputDialog(null, "Pelit maksavat 1€/kpl. \n\nKuinka paljon haluat tallettaa pelitilillesi rahaa?", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
        //Tarkistaa, antaako pelaaja tyhjän
        if (sraha == null) {
            JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        while (sraha.equals("")) {
            sraha = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nKuinka paljon haluat tallettaa pelitilillesi rahaa?", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            if (sraha == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        //Tarkistaa, antaako pelaaja kirjaimen
        String kirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
        while (kirjaimet.contains(sraha)) {
            sraha = JOptionPane.showInputDialog(null, "Annoit kirjaimen.\nKuinka paljon haluat tallettaa pelitilillesi rahaa?", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
            if (sraha == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        /*-merkkinen summa ja sana tunnistaminen
        while (sraha.equals("-"+sraha)) {
            sraha = JOptionPane.showInputDialog(null, "Annoit miinus merkkisen summan.\nKuinka paljon haluat tallettaa pelitilillesi rahaa?", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
            if (sraha == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }*/
        //Tallettaa pelaajan antaman rahamäärän pelitilille
        double raha = Double.parseDouble(sraha);
        kontrolleri.setTili(raha);
    }

    //Päävalikko, josta pelaaja pystyy valitsemaan haluamansa pelin
    //Näkyy aina myös pelin loputtua 
    public void aloitusNaytto() {
        String terve;

        Pelaaja pelaaja = new Pelaaja();
        Pelitili tili = new Pelitili();
        Pelatutpelit pelatutpelit = new Pelatutpelit();
        Voitetut voitetutrahat = new Voitetut();

        //Esitellään pelit
        String[] pelit = new String[]{"Lotto", "Kaikki tai Ei mitään", "Lomatonni", "Synttärit", "Lopeta pelaaminen"};

        int valinta = JOptionPane.showOptionDialog(null, "\nPelitilisi: " + kontrolleri.getSaldo() + " €\n" + "Pelatut pelit: " + kontrolleri.getPelatut() + "\nOlet voittanut: " + kontrolleri.getVoitetut() + " €\n\nMitä peliä haluaisit pelata?", "Veikkaus", //nullVeikkaus
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pelit, pelit[0]);

        switch (valinta) {
            case 0:
                if (kontrolleri.getSaldo() != 0) {
                    kontrolleri.ottoAlku(1.00);
                    lotto();
                    kontrolleri.getSaldo();
                    kontrolleri.loppu();
                } //Jos pelitili on 0.0€, ei pysty enää pelaamaan
                else {
                    JOptionPane.showMessageDialog(null, "Pelitilisi on tyhjä.\nValitettavasti pelisi päättyvät tähän.", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            case 1:
                if (kontrolleri.getSaldo() != 0) {
                    kontrolleri.ottoAlku(1.00);
                    ktem();
                    kontrolleri.getSaldo();
                    kontrolleri.loppu();
                } else {
                    JOptionPane.showMessageDialog(null, "Pelitilisi on tyhjä.\nValitettavasti pelisi päättyvät tähän.", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            case 2:
                if (kontrolleri.getSaldo() != 0) {
                    kontrolleri.ottoAlku(1.00);
                    lomatonni();
                    kontrolleri.getSaldo();
                    kontrolleri.loppu();
                } else {
                    JOptionPane.showMessageDialog(null, "Pelitilisi on tyhjä.\nValitettavasti pelisi päättyvät tähän.", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            case 3:
                if (kontrolleri.getSaldo() != 0) {
                    kontrolleri.ottoAlku(1.00);
                    synttarit();
                    kontrolleri.getSaldo();
                    kontrolleri.loppu();
                } else {
                    JOptionPane.showMessageDialog(null, "Pelitilisi on tyhjä.\nValitettavasti pelisi päättyvät tähän.", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            case 4:
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }
    }

    public void lotto() {
        kontrolleri.lotto();
    }

    public void ktem() {
        kontrolleri.ktem();
    }

    public void lomatonni() {
        kontrolleri.lomatonni();
    }

    public void synttarit() {
        kontrolleri.synttarit();
    }

    public void naytaTieto(String tieto) {
        JOptionPane.showMessageDialog(null, tieto, "Veikkaus", JOptionPane.INFORMATION_MESSAGE); //null, "You", "my title", JOptionPane.INFORMATION_MESSAGE);
    }

    public String kysyTieto(String kysymys) {
        // Metodi kysyy käyttäjältä jotakin tietoa.
        // Käyttäjälle esitetään kysymys, joka tulee parametrina.
        // Metodi palauttaa käyttäjän antaman vastauksen
        return JOptionPane.showInputDialog(kysymys);
    }
}
