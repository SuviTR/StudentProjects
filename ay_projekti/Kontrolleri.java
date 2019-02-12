/*
 * Kommunikoi näytön ja muiden luokkien välissä
 */
package ay_projekti;

/**
 * @strann
 */
public class Kontrolleri {
    private HirsipuuSaannot hirsipuuAlku;
    private Hirsipuu hirsipuu;
    private Pelatutpelit pelatut;
    private Naytto naytto;

    //Luodaan peli-oliot, pelitili-olio ja naytto-olio
    public Kontrolleri() {
        hirsipuu = new Hirsipuu();
        hirsipuuAlku = new HirsipuuSaannot();
        pelatut = new Pelatutpelit();
      
        naytto = new Naytto();
        naytto.rekisteriOhjain(this);

        naytto.tervetuloa();
        naytto.aloitusNaytto();
    }

    //Palautettaan pelattujen pelien lukumäärä
    //Kontrolleri kutsuu Pelatutpelit-luokasta
    public int annaPelatut() {
        int pelatutPelit = pelatut.annaPelatut();
        return pelatutPelit;
    }

    
    //Hirsipuun säännöt
    //Kontrolleri kutsuu HirsipuuSaannot-luokasta
    public void hirsipuuAlku() {
        String hirsipuuOtsikko = hirsipuuAlku.annaHirsipuuOtsikko();
        naytto.naytaTieto(hirsipuuOtsikko);
    }

    //Pelataan Hirsipuuta
    public void hirsipuu() {

        hirsipuu.hirsipuupeli();
        //Lisätään yksi lisää pelattuihin pelien lukumäärään
        pelatut.lisaaPelatut();
    }

    //Pelin jälkeen palataan aloitusNaytto()n
    public void loppu() {
        naytto.aloitusNaytto();
    }

    public static void main(String[] args) {
        new Kontrolleri();  // Peli käyntiin
    }
}

