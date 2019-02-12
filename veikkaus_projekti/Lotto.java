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
import java.util.Arrays;

public class Lotto {

    //kapseloidut muuttujat
    protected int[] lottoNumerot = new int[7];
    protected int[] pelNumerot = new int[7];

    //Esitellään Lotto-peli
    public String getLottoOtsikko() {
        return ("LOTTO" + "\n" + "Pääpotti 4 000 000 €");
    }

    public String getLottoInfo() {
        return ("Ole hyvä ja syötä lottonumerosi väliltä 1 - 40.");
    }

    //Arvotaan 7 lotto-numeroa Math.random()lla ja tallennetaan ne lottoNumerot-taulukkoon
    public void lottoNumerot() {

        for (int i = 0; i < 7; i++) {
            this.lottoNumerot[i] = (int) (Math.random() * ((40 - 1) + 1) + 1);

            for (int j = 0; j < i; j++) {
                if (lottoNumerot[j] == lottoNumerot[i]) {
                    this.lottoNumerot[i] = (int) (Math.random() * ((40 - 1) + 1) + 1);
                    j = -1;
                }
            }
        }
        //Järjestetään numerot pienimmästä suurimpaan
        for (int i = 0; i < this.lottoNumerot.length; i++) {
            Arrays.sort(this.lottoNumerot);
        }
    }

    //Tulostetaan lotto-numerot
    public String getLottoNumerot() {
        return lottoNumerot[0] + "," + lottoNumerot[1] + "," + lottoNumerot[2] + "," + lottoNumerot[3] + "," + lottoNumerot[4] + "," + lottoNumerot[5] + "," + lottoNumerot[6];
    }

    //Pyydetään pelaajaa antamaan omat lotto-numeronsa
    public void annaNumerot(){

        String vastaus;
        //String kirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";

        for (int i = 0; i < 7; i++) {
            vastaus = JOptionPane.showInputDialog(null, "Anna lottonumero " + (i + 1), "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            if (vastaus == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            while (vastaus.matches("[a-zA-Z]+")) {
                vastaus = JOptionPane.showInputDialog(null, "Annoit kirjaimen.\nAnna lottonumero: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
                if (vastaus == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            this.pelNumerot[i] = Integer.parseInt(vastaus);

            while (vastaus.equals("")) {
                vastaus = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna lottonumero", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                if (vastaus == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            //pyydetään numero uudestaan jos se ei ole pelialueella
            while (Integer.parseInt(vastaus) < 1 || Integer.parseInt(vastaus) > 40) {
                vastaus = JOptionPane.showInputDialog(null, "Annoit numeron, joka on 1-40 lukujen ulkopuolelta.\nAnna uusi lottonumero", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                if (vastaus == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                pelNumerot[i] = Integer.parseInt(vastaus);
            }

            //Jos pelaaja syöttää saman numeron kuin aikaisemmin, häntä pyydetään antamaan uusi numero
            for (int j = 0; j < i; j++) {
                if (pelNumerot[j] == pelNumerot[i]) {
                    vastaus = JOptionPane.showInputDialog("Olet jo antanut tämän numeron.\nAnna uusi lottonumero"); // "Olet jo syöttänyt tämän numeron.
                    if (vastaus == null) {
                        JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    pelNumerot[i] = Integer.parseInt(vastaus);
                    j = -1;
                }

            }

        }

        //Järjestää numerot pienimmästä suurimpaan
        for (int i = 0; i < this.pelNumerot.length; i++) {
            Arrays.sort(this.pelNumerot);
        }
    }

    //Tulostetaan pelaaja lotto-numerot
    public String getPelaajanNumerot() {
        return pelNumerot[0] + "," + pelNumerot[1] + "," + pelNumerot[2] + "," + pelNumerot[3] + "," + pelNumerot[4] + "," + pelNumerot[5] + "," + pelNumerot[6];
    }

    //Tulostetaan sekä lotto-numerot että pelaajan numerot
    public String getRivit() {
        return ("Loton oikea rivi on:\n" + getLottoNumerot() + "\n\nSinun numerosi ovat:\n" + getPelaajanNumerot());
    }

    //Vertaillaan lotto-numeroita pelaajan numeroihin ja palautetaan merkkijonona tulos
    public String vertaaTulostus() {
        int oikein = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (lottoNumerot[j] == pelNumerot[i]) {
                    oikein = oikein + 1;
                }
            }
        }
        switch (oikein) { //tulos
            case 7:
                return (oikein + " oikein\n\nOnneksi olkoon! Olet voittannut loton päävoiton! \n4 000 000 €!\n");
            case 6:
                return (oikein + " oikein\n\nOnneksi olkoon! Olet voittannut  200 000 €!\n");
            case 5:
                return (oikein + " oikein\n\nOnneksi olkoon! Olet voittannut  120 000 €!\n");
            case 4:
                return (oikein + " oikein\n\nOnneksi olkoon! Olet voittannut  2 000 €!\n");
            case 3:
                return (oikein + " oikein\n\nOnneksi olkoon! Olet voittannut  10 €!\n");
            case 2:
                return (oikein + " oikein\n\nOnneksi olkoon! Olet voittannut  2 €!\n");
            default:
                return (oikein + " oikein\n\nParempi onni seuraavalla kerralla!");
        }
    }

    //Vertaillaan lotto-numeroita pelaajan numeroihin ja palautetaan voittosumma, joka myöhemmin lisätään pelitilille
    public double vertaaVoitto() {

        int oikein = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (lottoNumerot[j] == pelNumerot[i]) {
                    oikein = oikein + 1;
                }
            }
        }
        switch (oikein) { //Pelitilille rahaa
            case 7:
                return (4000000);
            case 6:
                return (200000);
            case 5:
                return (120000);
            case 4:
                return (2000);
            case 3:
                return (10);
            case 2:
                return (2);
            default:
                return (0);
        }
    }
}
