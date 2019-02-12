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
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Synttarit {

    //kapseloidut muuttujat
    protected int synttaritPaiva;
    protected String synttaritKuukausi;
    protected String synttaritVuosi;
    protected String synttaritKirjain;
    protected int pelPaiva;
    protected String pelKuukausi;
    protected String pelVuosi;
    protected String pelKirjain;

    //Esitellään Synttärit-peli
    public String getSynttaritOtsikko() {
        return ("Synttärit" + "\n" + "Pääpotti 150 000 €");
    }

    public String getSynttaritInfo() {
        return ("Valitse päivä, kuukausi, vuosi ja kirjain.");
    }

    //Arpoo int Päivän
    public void arvoSynttaritPaiva() {
        synttaritPaiva = (int) (1 + 31 * Math.random());
    }

    //Arpoo String Kuukauden
    public void arvoSynttaritKuukausi() {
        ArrayList<String> kuukaudet = new ArrayList<>();
        kuukaudet.add("Tammikuu");
        kuukaudet.add("Helmikuu");
        kuukaudet.add("Maaliskuu");
        kuukaudet.add("Huhtikuu");
        kuukaudet.add("Toukokuu");
        kuukaudet.add("Kesäkuu");
        kuukaudet.add("Heinäkuu");
        kuukaudet.add("Elokuu");
        kuukaudet.add("Syyskuu");
        kuukaudet.add("Lokakuu");
        kuukaudet.add("Marraskuu");
        kuukaudet.add("Joulukuu");
        Collections.shuffle(kuukaudet);
        this.synttaritKuukausi = kuukaudet.get(0);
    }

    //Arpoo String Vuoden
    public void arvoSynttaritVuosi() {
        int vuosi = (int) (10 + 99 * Math.random());
        String vuosi2 = Integer.toString(vuosi);
        ArrayList<String> vuodet = new ArrayList<>();
        vuodet.add("00");
        vuodet.add("01");
        vuodet.add("02");
        vuodet.add("03");
        vuodet.add("04");
        vuodet.add("05");
        vuodet.add("06");
        vuodet.add("07");
        vuodet.add("08");
        vuodet.add("09");
        Collections.shuffle(vuodet);

        ArrayList<String> vuodet2 = new ArrayList<>();
        vuodet2.add(vuosi2);
        vuodet2.add(vuodet.get(0));
        Collections.shuffle(vuodet2);

        this.synttaritVuosi = vuodet2.get(0);
    }

    //Arpoo String Kirjaimen
    public void arvoSynttaritKirjain() {
        ArrayList<String> kirjain = new ArrayList<>();
        kirjain.add("A");
        kirjain.add("B");
        kirjain.add("C");
        kirjain.add("D");
        kirjain.add("E");
        kirjain.add("F");
        kirjain.add("G");
        kirjain.add("H");
        kirjain.add("I");
        kirjain.add("J");
        kirjain.add("K");
        kirjain.add("L");
        kirjain.add("M");
        kirjain.add("N");
        kirjain.add("O");
        kirjain.add("P");
        kirjain.add("Q");
        kirjain.add("R");
        kirjain.add("S");
        kirjain.add("T");
        kirjain.add("U");
        kirjain.add("V");
        kirjain.add("W");
        kirjain.add("X");
        kirjain.add("Y");
        kirjain.add("Z");
        kirjain.add("Å");
        kirjain.add("Ä");
        kirjain.add("Ö");
        Collections.shuffle(kirjain);
        this.synttaritKirjain = kirjain.get(0);
    }

    //Tulostetaan Synttärit oikearivi
    public String getSynttarit() {
        return synttaritPaiva + ", " + synttaritKuukausi + ", " + synttaritVuosi + ", " + synttaritKirjain;
    }

    //Kysytään pelaajalta Päivä
    public int pelaajanPaiva() {
        String paiva;
        String kirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
        paiva = JOptionPane.showInputDialog(null, "Anna Päivä 1-31: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
        if (paiva == null) {
            JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        while (paiva.equals("")) {
            paiva = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna uusi päivä", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            if (paiva == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        while (kirjaimet.contains(paiva)) {
            paiva = JOptionPane.showInputDialog(null, "Annoit kirjaimen.\nAnna uusi päivä", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
            if (paiva == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        
        this.pelPaiva = Integer.parseInt(paiva);
        while(pelPaiva < 1 || pelPaiva > 31){
                paiva = JOptionPane.showInputDialog(null,"Annoit numeron, joka on 1-40 lukujen ulkopuolelta.\nAnna uusi lottonumero","Veikkaus",JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.
                if (paiva == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                this.pelPaiva = Integer.parseInt(paiva);  
            }
        return pelPaiva;
    }
    
    //Kysytään pelaajalta Kuukausi
    public String pelaajanKuukausi() {
        String[] kaupungit = new String[]{"Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"};
        int kuukausiValinta = JOptionPane.showOptionDialog(null, "Valitse kuukausi: ", "", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, kaupungit, kaupungit[0]);
        switch (kuukausiValinta) {
            case 0:
                this.pelKuukausi = "Tammikuu";
                return pelKuukausi;
            case 1:
                this.pelKuukausi = "Helmikuu";
                return pelKuukausi;
            case 2:
                this.pelKuukausi = "Maaliskuu";
                return pelKuukausi;
            case 3:
                this.pelKuukausi = "Huhtikuu";
                return pelKuukausi;
            case 4:
                this.pelKuukausi = "Toukokuu";
                return pelKuukausi;
            case 5:
                this.pelKuukausi = "Kesäkuu";
                return pelKuukausi;
            case 6:
                this.pelKuukausi = "Heinäkuu";
                return pelKuukausi;
            case 7:
                this.pelKuukausi = "Elokuu";
                return pelKuukausi;
            case 8:
                this.pelKuukausi = "Syyskuu";
                return pelKuukausi;
            case 9:
                this.pelKuukausi = "Lokakuu";
                return pelKuukausi;
            case 10:
                this.pelKuukausi = "Marraskuu";
                return pelKuukausi;
            case 11:
                this.pelKuukausi = "Joulukuu";
                return pelKuukausi;
            default:
                return pelKuukausi;
        }
    }

    //Kysytään pelaajalta Vuosi
    public String pelaajanVuosi() {
        String vuosi;
        String kirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
        vuosi = JOptionPane.showInputDialog(null, "Anna vuosi väliltä 00-99: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
        if (vuosi == null) {
            JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        while (vuosi.equals("")) {
            vuosi = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna uusi vuosi", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            if (vuosi == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        while (kirjaimet.contains(vuosi)) {
            vuosi = JOptionPane.showInputDialog(null, "Annoit kirjaimen.\nAnna uusi vuosi", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
            if (vuosi == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        while(Integer.parseInt(vuosi) < 0 || Integer.parseInt(vuosi) > 99){
            vuosi = JOptionPane.showInputDialog(null, "Annoit numeron, joka on 00-99 lukujen ulkopuolelta.\nAnna uusi vuosi", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
            if (vuosi == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        //Jos pelaaja antaa vain yhden numeron, peli automaattisesti lisää 0 pelaajan antaman numeron eteen
        if(vuosi.equals("0") || vuosi.equals("1") || vuosi.equals("2") || vuosi.equals("3") || vuosi.equals("4") || vuosi.equals("5") || vuosi.equals("6") || vuosi.equals("7") || vuosi.equals("8") || vuosi.equals("9")){
            vuosi = "0" + vuosi;
        }
        this.pelVuosi = vuosi;
        
        return pelVuosi;
    }

    //Kysytään pelaajalta Kirjain
    public String pelaajanKirjain() {
        String pkirjain;
        String numerot = "1234567890";
        pkirjain = JOptionPane.showInputDialog(null, "Anna kirjain A-Ö: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
        if (pkirjain == null) {
            JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        while (pkirjain.equals("")) {
            pkirjain = JOptionPane.showInputDialog(null, "Annoit tyhjän.\nAnna uusi kirjain", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
            if (pkirjain == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }

        //Tarkistaa onko vastaus=kirjain ja pyytää pelaajaa antamaan numeron
        while (numerot.contains(pkirjain)) {
            pkirjain = JOptionPane.showInputDialog(null, "Annoit numeron.\nAnna uusi kirjain", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
            if (pkirjain == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Veikkaus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        
        pkirjain = pkirjain.substring(0, 1).toUpperCase();
        this.pelKirjain = pkirjain;
        return pelKirjain;
    }

    //Tulostetaan pelaajan rivi
    public String getPelaajanSynttarit() {
        return pelPaiva + ", " + pelKuukausi + ", " + pelVuosi + ", " + pelKirjain;
    }

    //Tulostetaan Synttärit oikearivi ja pelaajan rivi
    public String getSynttaritRivit() {
        return ("Synttarit oikea rivi on:\n" + getSynttarit() + "\n\nSinun rivisi on:\n" + getPelaajanSynttarit());
    }

    //Vertaillaan String tulos
    public String vertaaSynttaritTulostus() {
        if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi) && synttaritKirjain.equals(pelKirjain)) {
            return ("Päivä, Kuukausi, Vuosi, Kirjain oikein\n\n Onneksi olkoon! Voitit Synttärit pääpotin 150 000€! :)");

        } else if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi)) {
            return ("Päivä, Kuukausi, Vuosi oikein\n\n Onneksi olkoon! Voitit 5 000€ euroa!");

        } else if (synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi) && synttaritKirjain.equals(pelKirjain)) {
            return ("Kuukausi, Vuosi, Kirjain oikein\n\n Onneksi olkoon! Voitit 500€ euroa!");

        } else if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi) && synttaritKirjain.equals(pelKirjain)) {
            return ("Päivä, Kuukausi, Kirjain oikein\n\n Onneksi olkoon! Voitit 250€ euroa!");

        } else if (synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi)) {
            return ("Kuukausi, Vuosi oikein\n\n Onneksi olkoon! Voitit 50€ euroa!");

        } else if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi)) {
            return ("Päivä, Kuukausi oikein\n\n Onneksi olkoon! Voitit 15€ euroa!");

        } else if (synttaritKuukausi.equals(pelKuukausi) && synttaritKirjain.equals(pelKirjain)) {
            return ("Päivä, Kuukausi oikein\n\n Onneksi olkoon! Voitit 10€ euroa!");

        } else if (synttaritKuukausi.equals(pelKuukausi)) {
            return ("Kuukausi oikein\n\n Onneksi olkoon! Voitit 2€ euroa!");

        } else {
            return ("Et voittanut mitään! :(");

        }
    }

    //Vertaillaan double voittosumma
    public double vertaaSynttaritVoitto() {
        if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi) && synttaritKirjain.equals(pelKirjain)) {
            return (150000);
        } else if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi)) {
            return (5000);
        } else if (synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi) && synttaritKirjain.equals(pelKirjain)) {
            return (500);
        } else if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi) && synttaritKirjain.equals(pelKirjain)) {
            return (250);
        } else if (synttaritKuukausi.equals(pelKuukausi) && synttaritVuosi.equals(pelVuosi)) {
            return (50);
        } else if (synttaritPaiva == pelPaiva && synttaritKuukausi.equals(pelKuukausi)) {
            return (15);
        } else if (synttaritKuukausi.equals(pelKuukausi) && synttaritKirjain.equals(pelKirjain)) {
            return (10);
        } else if (synttaritKuukausi.equals(pelKuukausi)) {
            return (2);
        } else {
            return (0);
        }
    }
}
