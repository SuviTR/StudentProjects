package veikkaus_projekti;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Lomatonni {

    protected int lomatonninnumero;
    protected String oikeakaupunki;
    protected String pelaajankaupunki;
    protected int pelaajannumero;

    public String getLomatonniotsikko() {
        return ("Lomatonni" + "\n" + "Pääpotti 1 000 €");
    }

    public String getLomatonniinfo() {
        return ("Anna kaupunki ja numero ");
    }

    public void arvoLomatonninNumero() {
        lomatonninnumero = (int) (1 + 100 * Math.random());
    }

    public void arvoKaupunki() {
        ArrayList<String> kaupungit = new ArrayList<String>();
        kaupungit.add("Helsinki");
        kaupungit.add("Kööpenhamina");
        kaupungit.add("Oslo");
        kaupungit.add("Reykjavik");
        kaupungit.add("Tukholma");
        Collections.shuffle(kaupungit);
        oikeakaupunki = kaupungit.get(0);
    }

    public String kysyPelaajankaupunkia() {
        String[] kaupungit = new String[]{"Helsinki", "Kööpenhamina", "Oslo", "Reykjavik", "Tukholma"};
        int kaupunginvalinta = JOptionPane.showOptionDialog(null, "Valitse kaupunki: ", "", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, kaupungit, kaupungit[0]);
        switch (kaupunginvalinta) {
            case 0:
                pelaajankaupunki = "Helsinki";
                return pelaajankaupunki;
            case 1:
                pelaajankaupunki = "Kööpenhamina";
                return pelaajankaupunki;
            case 2:
                pelaajankaupunki = "Oslo";
                return pelaajankaupunki;
            case 3:
                pelaajankaupunki = "Reykjavik";
                return pelaajankaupunki;
            case 4:
                pelaajankaupunki = "Tukholma";
                return pelaajankaupunki;
            default:
                // näytetään valikko uudestaan, jos ei kunnollinen valinta
                return pelaajankaupunki;
        }
    }

    
    public void pelaajanNumerooo() {
        String kirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
        String vastaus1 = JOptionPane.showInputDialog("Anna luku väliltä 1-100: ");
        //this.pelaajannumero = Integer.parseInt(vastaus1);
        if (vastaus1 == null) {
            JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        while (vastaus1.equals("")) {
            vastaus1 = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna uusi luku", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            if (vastaus1 == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }

        while (kirjaimet.contains(vastaus1)) {
            vastaus1 = JOptionPane.showInputDialog(null, "Annoit kirjaimen.\nAnna uusi luku", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            if (vastaus1 == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        this.pelaajannumero = Integer.parseInt(vastaus1);
        while (pelaajannumero < 1 || pelaajannumero > 100) {
            vastaus1 = JOptionPane.showInputDialog("Annoit liian pienen tai suuren luvun. Anna uusi luku");
            if (vastaus1 == null) {
                JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            while (vastaus1.equals("")) {
                vastaus1 = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna uusi luku", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                if (vastaus1 == null) {
                    JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
            while (kirjaimet.contains(vastaus1)) {
                vastaus1 = JOptionPane.showInputDialog(null, "Annoit kirjaimen.\nAnna uusi luku", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                if (vastaus1 == null) {
                    JOptionPane.showMessageDialog(null, "Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
            this.pelaajannumero = Integer.parseInt(vastaus1);

        }

    }

    public String getLomatonnirivit() {
        return ("Lomatonnin oikea rivi on; \n" + oikeakaupunki + " " + lomatonninnumero + "\n ja sinun vastauksesi ovat: \n" + pelaajankaupunki + " " + pelaajannumero);
    }

    //voi voittaa tonninet
    public String tulostuksia() {
        if (oikeakaupunki.equals(pelaajankaupunki) && lomatonninnumero == pelaajannumero) {
            return ("Voitit tonnin!");

        } else if (oikeakaupunki.equals(pelaajankaupunki)) {
            return ("Voitit viisi euroa!");

        } else {
            return ("Et voittanut mitään!");
        }
    }

    public double vertaaKaupunki() {
        if (oikeakaupunki.equals(pelaajankaupunki) && lomatonninnumero == pelaajannumero) {
            return 1000;
        } else if (oikeakaupunki.equals(pelaajankaupunki)) {
            return 5;
        } else {
            return 0;
        }
    }
}