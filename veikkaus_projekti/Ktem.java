package veikkaus_projekti;

import javax.swing.JOptionPane;

public class Ktem {

    //luodaan taulukot kayttajan antamista ja oikeista numeroista
    protected int[] kayttajan = new int[12];
    protected int[] oikeat = new int[12];

    public String getKtremOtsikko() {
        return ("Kaikki tai ei mitään" + "\n" + "Pääpotti 125 000€");
    }

    public String getKtemInfo() {
        return ("Anna 12 numeroa väliltä 1-24 (älä anna samaa lukua useaan kertaan) ");
    }

    //arvotaan oikeat voittonumerot
    public void ktemNumerot() {

        for (int i = 0; i < 12; i++) {
            this.oikeat[i] = (int) (Math.random() * ((24 - 1) + 1) + 1);

            for (int j = 0; j < i; j++) {
                if (oikeat[j] == oikeat[i]) {
                    this.oikeat[i] = (int) (Math.random() * ((24 - 1) + 1) + 1);
                    j = -1;
                }
            }
        }
    }

    private static void oikeatJarjesta(int[] oikeat) { //oikeiden numeroiden numerojärjestykseen laittaminen
        for (int i = 0; i < oikeat.length - 1; ++i) {
            for (int j = i + 1; j < oikeat.length; ++j) {
                if (oikeat[i] > oikeat[j]) {
                    int jarjesta = oikeat[i];
                    oikeat[i] = oikeat[j];
                    oikeat[j] = jarjesta;
                }
            }
        }
    }

    private static void kayttajanJarjesta(int[] kayttajan) { //kayttajan antamien lukujen numerojärjestykseen laittaminen
        for (int i = 0; i < kayttajan.length - 1; ++i) {
            for (int j = i + 1; j < kayttajan.length; ++j) {
                if (kayttajan[i] > kayttajan[j]) {
                    int jarjesta = kayttajan[i];
                    kayttajan[i] = kayttajan[j];
                    kayttajan[j] = jarjesta;
                }
            }
        }
    }

    public String getKtemNumerot() {
        oikeatJarjesta(oikeat);
        return oikeat[0] + "," + oikeat[1] + "," + oikeat[2] + "," + oikeat[3] + "," + oikeat[4] + "," + oikeat[5] + "," + oikeat[6] + "," + oikeat[7] + "," + oikeat[8] + "," + oikeat[9] + "," + oikeat[10] + "," + oikeat[11];
    }

    //pyydetään käyttäjältä käyttäjän numerot
    public void annaKtemnumerot() {

        String luku;
        String kirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";

        for (int i = 0; i < 12; i++) {
            luku = JOptionPane.showInputDialog("Anna " + (i + 1) + ". numero: ");
            if (luku == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            while (kirjaimet.contains(luku)) {
                luku = JOptionPane.showInputDialog(null, "Annoit kirjaimen.\nAnna numero: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
                if (luku == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            this.kayttajan[i] = Integer.parseInt(luku);

            while (luku.equals("")) {
                luku = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna uusi pelinumero", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                if (luku == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            //pyydetään numero uudestaan jos se ei ole pelialueella
            while (Integer.parseInt(luku) < 1 || Integer.parseInt(luku) > 24) {
                luku = JOptionPane.showInputDialog("Anna " + (i + 1) + ". numero uudestaan, antamasi luku ei ole pelialueella: ");
                if (luku == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            kayttajan[i] = Integer.parseInt(luku);
            for (int j = 0; j < i; j++) {
                if (kayttajan[j] == kayttajan[i]) {
                    luku = JOptionPane.showInputDialog("Anna uusi numero, tämä on jo annettu"); // "Olet jo syöttänyt tämän numeron.
                    kayttajan[i] = Integer.parseInt(luku);
                    j = -1;
                }
                if (luku == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

        }
    }

    public String getPelaajanKtemNum() {
        kayttajanJarjesta(kayttajan);
        return kayttajan[0] + "," + kayttajan[1] + "," + kayttajan[2] + "," + kayttajan[3] + "," + kayttajan[4] + "," + kayttajan[5] + "," + kayttajan[6] + "," + kayttajan[7] + "," + kayttajan[8] + "," + kayttajan[9] + "," + kayttajan[10] + "," + kayttajan[11];
    }

    public String getKtemRivit() {
        return ("Kaikki tai ei mitään- pelin oikea rivi on:\n" + getKtemNumerot() + "\n\nSinun numerosi ovat:\n" + getPelaajanKtemNum());
    }

    public String vertaile() {
        int oikein = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (oikeat[j] == kayttajan[i]) {
                    oikein = oikein + 1;
                }
            }
        }

        switch (oikein) { // Mitä pelaajalle näytetään pelin lopputuloksesta
            case 12:
                System.out.println(oikein + " oikein");
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut Kaikki tai ei mitään päävoiton! \n125 000 €!");
            case 11:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 250 €!");
            case 10:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 25 €!");
            case 9:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 5 €!");
            case 8:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 1 €!");
            case 4:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 1 €!");
            case 3:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 5 €!");
            case 2:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 25 €!");
            case 1:
                return (oikein + " oikein\nOnneksi olkoon! Olet voittanut 250 €!");
            case 0:
                return (oikein + " kaikki väärin!\nOnneksi olkoon! Olet voittanut Kaikki tai ei mitään päävoiton! \n125 000 €!");
            default:
                return (oikein + " oikein\nEi voittoa tällä kertaa :(");
        }
    }

    //vertaillaan kuinka monta pelaaja sai oikein
    public double vertaaVoitto() {

        int oikein = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (oikeat[j] == kayttajan[i]) {
                    oikein = oikein + 1;
                }
            }
        }
        switch (oikein) { // Pelitilille rahaa
            case 12:
                return (125000);
            case 11:
                return (250);
            case 10:
                return (25);
            case 9:
                return (5);
            case 8:
                return (1);
            case 4:
                return (1);
            case 3:
                return (5);
            case 2:
                return (25);
            case 1:
                return (250);
            case 0:
                return (125000);
            default:
                return (0);
        }
    }

}
