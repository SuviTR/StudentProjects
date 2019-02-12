package application;

import java.util.Random;

public class NoppaModel implements NoppaModel_IF {
	
	private int kerrat = 1;
	private int[] taulu;
	
	@Override
	public int getSilmaluku() {
		int rnd = new Random().nextInt(6)+1;
		System.out.println(rnd);
		return rnd;	
	}
	@Override
	public int getHeitot() {
		return kerrat++;
	}
	@Override
	public String getViisiNoppaa() {
		taulu = new int[5];
		
		taulu[0] = new Random().nextInt(6)+1;
		taulu[1] = new Random().nextInt(6)+1;
		taulu[2] = new Random().nextInt(6)+1;
		taulu[3] = new Random().nextInt(6)+1;
		taulu[4] = new Random().nextInt(6)+1;

		return taulu[0] + "," + taulu[1] + "," + taulu[2] + "," + taulu[3] + "," + taulu[4];
	}
	@Override
	public int getSumma() {
		int summa = 0;
		for(int arvo : taulu) {
			summa += arvo;
		}
		return summa;
	}
	public String getKolikko() {
		int arvo = new Random().nextInt(2)+1;
		if (arvo == 1) {
			return "Kruunu";
		}
		else {
			return "Klaava";
		}
	}
	public String getTeksti(String teksti) {
		if (teksti.equals("aamu")) {
			return "Hyvää huomenta!";
		}
		else if (teksti.equals("paiva")) {
			return "Hyvää päivää!";
		}
		else if (teksti.equals("ilta")) {
			return "Hyvää iltaa!";
		}
		else if (teksti.equals("yo")) {
			return "Hyvää yötä!";
		}
		else {
			return "Virhe";
		}
	}
}
