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
public class Veikkaus_Kontrolleri {

    private Lotto lotto;
    private Ktem ktem;
    private Lomatonni lomatonni;
    private Synttarit synttarit;
    private Pelitili tili;
    private Pelatutpelit pelatut;
    private Voitetut voitetut;
    private Veikkaus_Naytto veikkaus;

    //Luodaan peli-oliot, pelitili-olio ja naytto-olio
    public Veikkaus_Kontrolleri() {
        lotto = new Lotto();
        ktem = new Ktem();
        lomatonni = new Lomatonni();
        synttarit = new Synttarit();
        tili = new Pelitili();
        pelatut = new Pelatutpelit();
        voitetut = new Voitetut();

        veikkaus = new Veikkaus_Naytto();
        veikkaus.rekisteriOhjain(this);
        

        veikkaus.tervetuloa();
        veikkaus.aloitusNaytto();
    }

    public void setPelatut() {
        pelatut.setPelatut(0);
    }

    public int getPelatut() {
        int pelatutPelit = pelatut.getPelatut();
        return pelatutPelit;
    }

    public void setVoitettu() {
        voitetut.setVoitettu(0);
    }

    public double getVoitetut() {
        double voitetutRahat = voitetut.getVoitetut();
        return voitetutRahat;
    }

    //Pyydetään tämän hetkinen pelitilin saldo Pelitililtä
    public double getSaldo() {
        double tilinSaldo = tili.getTili();
        return tilinSaldo;
    }

    //Talletetaan rahaa Pelitilille
    public void setTili(double lisaaRahaa) {
        tili.setTili(lisaaRahaa);
        veikkaus.aloitusNaytto();
    }

    //Nostetaan rahaa Pelitililtä ja palataan aloitusNaytto()n
    public void otto(double uusiRaha) {
        tili.vahenna(uusiRaha);
        veikkaus.aloitusNaytto();
    }

    //Nostetaan rahaa Pelitililtä
    public void ottoAlku(double uusiRaha) {
        tili.vahenna(uusiRaha);
    }

    //Pelataan Lottoa
    public void lotto() {

        //Info tekstit
        String lottoOtsikko = lotto.getLottoOtsikko();
        veikkaus.naytaTieto(lottoOtsikko);

        String lottoInfo = lotto.getLottoInfo();
        veikkaus.naytaTieto(lottoInfo);

        //Arvotaan lotto-numerot
        lotto.lottoNumerot();
        lotto.getLottoNumerot();

        //Pyydetään pelaajalta omat lotto-numerot
        lotto.annaNumerot();

        //Näytetään loton oikea rivi ja pelaajan numerot
        String pRivi = lotto.getRivit();
        veikkaus.naytaTieto(pRivi);

        //Vertaillaan numerot keskenään ja tulostetaan näytölle tulos
        String vertaa = lotto.vertaaTulostus();
        veikkaus.naytaTieto(vertaa);

        //Jos tuli voittoja, talletetaan rahat pelaajan Pelitilille
        double voitto = lotto.vertaaVoitto();
        tili.lisaa(voitto);

        pelatut.lisaaPelatut(0);
        voitetut.lisaaVoitetut(voitto);
    }

    public void ktem() {
        String ktemOtsikko = ktem.getKtremOtsikko();
        veikkaus.naytaTieto(ktemOtsikko);

        String ktemInfo = ktem.getKtemInfo();
        veikkaus.naytaTieto(ktemInfo);

        ktem.ktemNumerot();
        ktem.getKtemNumerot();

        ktem.annaKtemnumerot();
        String ktemprivi = ktem.getKtemRivit();
        veikkaus.naytaTieto(ktemprivi);

        String vertaa = ktem.vertaile();
        veikkaus.naytaTieto(vertaa);

        double voitto = ktem.vertaaVoitto();
        tili.lisaa(voitto);

        pelatut.lisaaPelatut(0);
        voitetut.lisaaVoitetut(voitto);
    }

    public void lomatonni() {
        String lomaOtsikko = lomatonni.getLomatonniotsikko();
        veikkaus.naytaTieto(lomaOtsikko);

        String lomaInfo = lomatonni.getLomatonniinfo();
        veikkaus.naytaTieto(lomaInfo);

        lomatonni.arvoKaupunki();
        lomatonni.kysyPelaajankaupunkia();

        lomatonni.pelaajanNumerooo();
        lomatonni.arvoLomatonninNumero();

        String lomarivi = lomatonni.getLomatonnirivit();
        veikkaus.naytaTieto(lomarivi);

        String tulosta = lomatonni.tulostuksia();
        veikkaus.naytaTieto(tulosta);

        double voitto = lomatonni.vertaaKaupunki();
        tili.lisaa(voitto);

        pelatut.lisaaPelatut(0);
        voitetut.lisaaVoitetut(voitto);
    }

    public void synttarit() {
        String synttaritOtsikko = synttarit.getSynttaritOtsikko();
        veikkaus.naytaTieto(synttaritOtsikko);

        String synttaritInfo = synttarit.getSynttaritInfo();
        veikkaus.naytaTieto(synttaritInfo);

        synttarit.arvoSynttaritPaiva();
        synttarit.pelaajanPaiva();

        synttarit.arvoSynttaritKuukausi();
        synttarit.pelaajanKuukausi();

        synttarit.arvoSynttaritVuosi();
        synttarit.pelaajanVuosi();

        synttarit.arvoSynttaritKirjain();
        synttarit.pelaajanKirjain();

        String synttaritRivi = synttarit.getSynttaritRivit();
        veikkaus.naytaTieto(synttaritRivi);

        String tulosta = synttarit.vertaaSynttaritTulostus();
        veikkaus.naytaTieto(tulosta);

        double voitto = synttarit.vertaaSynttaritVoitto();
        tili.lisaa(voitto);

        pelatut.lisaaPelatut(0);
        voitetut.lisaaVoitetut(voitto);
    }

    //Pelin jälkeen palataan aloitusNaytto()n
    public void loppu() {
        veikkaus.aloitusNaytto();
    }

    public static void main(String[] args) {
        new Veikkaus_Kontrolleri();  // Peli käyntiin
    }
}
