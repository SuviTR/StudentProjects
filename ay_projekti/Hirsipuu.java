
/*
 * Pelataan Hirsipuuta
 */
package ay_projekti;

/**
 * @strann
 */
import javax.swing.JOptionPane;

public class Hirsipuu {

    Sana sana = new Sana();
    Sana kirjaimet = new Sana();
    Yritykset yritys = new Yritykset(1);
    TikkuUkko tikku = new TikkuUkko();

    /*
    Do-while -silmukka kysyy pelaajalta kirjaimia, vertaa niitä oikeaan sanaan ja 
    //lisää kirjaimet, jos ne esiintyvät sanassa.
    //Jos kirjain on väärä, yritykset vähenevät
     */
    public void hirsipuupeli() {

        StringBuilder oikeasana = sana.annaSana();
        tikku = new TikkuUkko();
        yritys = new Yritykset(1);
        tikku = new TikkuUkko();
        kirjaimet = new Sana();

        do {
            String k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                    + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nAnna kirjain:", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
            if (k == null) {
                JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            //Pelaaja antaa numeron kirjaimen sijasta
            while (k.matches("[0-9]")) {
                k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                        + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nAnnoit numeron.\nAnna uusi kirjain: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
                //Pelaaja painaa cancel
                if (k == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                while (kirjaimet.annaArvatutKirjaimet().contains(k)) {
                    k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                            + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nOlet jo antanut tämän kirjaimen.\nAnna uusi kirjain: ", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.
                    if (k == null) {
                        JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
            }
            //Pelaaja paina enteriä, vaikka ei ole kirjoittanut mitään
            while (k.equals("")) {
                k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                        + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nAnnoit tyhjän.\nAnna uusi kirjain: ", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                if (k == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelaamisen kesken. Tervetuloa pelaamaan uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            //Muuttaa kirjaimen pieneksi varmuuden vuoksi
            k = k.substring(0, 1).toLowerCase();

            //Tarkistaa onko kirjain jo annettu
            while (kirjaimet.annaArvatutKirjaimet().contains(k)) {
                k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                        + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nOlet jo antanut tämän kirjaimen.\nAnna uusi kirjain: ", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.
                if (k == null) {
                    JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                while (k.matches("[0-9]")) {
                    k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                            + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nAnnoit numeron.\nAnna uusi kirjain: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
                    if (k == null) {
                        JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
            }
            //Tarkistaa onko erikoismerkki
            while (k.matches("[,.;:-_+!%&/()=?><']")) {
                k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                            + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nAnnoit erikoismerkin.\nAnna uusi kirjain: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
                if (k == null) {
                        JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                }
                while (k.matches("[0-9]")) {
                    k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                            + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nAnnoit numeron.\nAnna uusi kirjain: ", "Veikkaus", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.   
                    if (k == null) {
                        JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
                while (kirjaimet.annaArvatutKirjaimet().contains(k)) {
                    k = JOptionPane.showInputDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                        + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nOlet jo antanut tämän kirjaimen.\nAnna uusi kirjain: ", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE); // "Olet jo syöttänyt tämän numeron.
                    if (k == null) {
                        JOptionPane.showMessageDialog(null, "Lopetit pelin kesken. Tervetuloa pelaamaan taas uudestaan!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
            }
            
            kirjaimet.asetaArvatutKirjaimet(k);
            char kirjain = k.charAt(0);

            //Korvaa oikean kirjaimen tyhjässä sanassa
            //Jos tyhjästä sanasta ei puutu enää kirjaimia, pelaaja on voittanut pelin
            oikeasana = sana.korvaa(kirjain);
            
            if (oikeasana.toString().contains(k)) {
                yritys.yrityksiaJaljella();
                if (!oikeasana.toString().contains("-")) {
                    JOptionPane.showMessageDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                            + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + oikeasana
                            + "\n\nOnneksi olkoon!\nOlet voittanut pelin!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                
                //Jos kirjain on väärä, yritysten lukumäärä vähenee
                //Piirretään hirsipuuta
                //Jos yrityksiä on jäljellä 0, eikä sana ole valmis, pelaaja häviää pelin
            } else {
                yritys.asetaYritykset();
                yritys.yrityksiaJaljella();

                JOptionPane.showMessageDialog(null, "Arvatut kirjaimet: " + kirjaimet.annaArvatutKirjaimet() + "\n"
                        + "Yrityksiä jäljellä: " + yritys.annaYrityksiaJaljella() + "\n\n" + tikku.piirra(yritys.annaYrityksiaJaljella()) + "\n\n" + oikeasana + "\n\nArvauksesi on väärin!", "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                if (yritys.annaYrityksiaJaljella() == 0) {
                    JOptionPane.showMessageDialog(null, "Game over!\n\nOikea sana olisi ollut: " + sana.sana(), "Hirsipuu", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            //Lisätään pelaajan arvaamat merkit merkkijonoon
        } while (oikeasana.toString().contains("-"));
    }

}
