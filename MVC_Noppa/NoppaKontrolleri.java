package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NoppaKontrolleri implements NoppaKontrolleri_IF {
	
	NoppaGUI_IF gui;
	NoppaModel_IF model;
	
	public NoppaKontrolleri(NoppaGUI_IF gui) {
		this.gui = gui;
		model = new NoppaModel();
	}

	@Override
	public void arvoSilmaluku() {
		int arvo = model.getSilmaluku();
		gui.setSilmaluku(arvo);
	}
	@Override
	public void annaHeitot() {
		int kerrat = model.getHeitot();
		gui.setHeitot(kerrat);
	}
	public void annaViisiNoppaa() {
		String viisi = model.getViisiNoppaa();
		gui.setViisiNoppaa(viisi);
	}
	public void annaSumma() {
		int summa = model.getSumma();
		gui.setSumma(summa);
	}
	public void arvoKolikko() {
		String arvo = model.getKolikko();
		gui.setKolikko(arvo);
	}
	public void annaTeksti(String teksti) {
		String tekst = model.getTeksti(teksti);
		gui.setTeksti(tekst);
	}
}
