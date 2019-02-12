package application;
	
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class NoppaGUI extends Application implements NoppaGUI_IF {
	
	//Kontrollerin esittely
	private NoppaKontrolleri_IF kontrolleri;
	private Text silmaluku;
	private Text heitot;
	private Text viisi;
	private Text summa;
	private Text kolikko;
	private Text selite;
	private Text teksti;
	
	private Image dice1 = new Image("https://www.wpclipart.com/recreation/games/dice/die_face_1.png");
	private Image dice2 = new Image("https://www.wpclipart.com/recreation/games/dice/die_face_2.png");
	private Image dice3 = new Image("https://www.wpclipart.com/recreation/games/dice/die_face_3.png");
	private Image dice4 = new Image("https://www.wpclipart.com/recreation/games/dice/die_face_4.png");
	private Image dice5 = new Image("https://www.wpclipart.com/recreation/games/dice/die_face_5.png");
	private Image dice6 = new Image("https://www.wpclipart.com/recreation/games/dice/die_face_6.png");
	private ImageView iv1;
	
	//Käyttöliittymäkomponenttien esittelyt
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		kontrolleri = new NoppaKontrolleri(this);
	}
	
	@Override
	public void start(Stage primaryStage) {
        
		try {
			primaryStage.setTitle("Noppa - MVC");
			silmaluku = new Text();
			heitot = new Text();
			viisi = new Text();
			summa = new Text();
			kolikko = new Text();
			selite = new Text("Napsauta painiketta");
			teksti = new Text();
			iv1 = new ImageView();
			iv1.setFitWidth(96);
			iv1.setFitHeight(96);
	        
			Button heitaNoppa = new Button("Heitä noppaa!");			//t1,t2,t3,t6
			//Button heitaKolikko = new Button("Heitä kolikkoa!");		//t4
			//Button aamu = new Button("Aamu");		//t5
			//Button paiva = new Button("Päivä");	//t5
			//Button ilta = new Button("Ilta");		//t5
			//Button yo = new Button("Yö");			//t5
			heitaNoppa.setOnAction(new EventHandler<ActionEvent>() {		//t1,t2,t3,t6
			//heitaKolikko.setOnAction(new EventHandler<ActionEvent>() {	//t4
				
				@Override
				public void handle(ActionEvent event) {
					kontrolleri.arvoSilmaluku();		//t1,t6
					//kontrolleri.annaHeitot();			//t2
					//kontrolleri.annaViisiNoppaa();	//t3
					//kontrolleri.annaSumma();			//t3
					//kontrolleri.arvoKolikko();		//t4
				}
			});	
			/*
			final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>() {	//t5
				@Override
				public void handle(final ActionEvent event) {
					if (event.getSource() == aamu) {
						kontrolleri.annaTeksti("aamu");
					}
					else if (event.getSource() == paiva) {
						kontrolleri.annaTeksti("paiva");
					}
					else if (event.getSource() == ilta) {
						kontrolleri.annaTeksti("ilta");
					}
					else if (event.getSource() == yo) {
						kontrolleri.annaTeksti("yo");
					}
				}
			};*/
			
			//aamu.setOnAction(myHandler);	//t5
			//paiva.setOnAction(myHandler);	//t5
			//ilta.setOnAction(myHandler);	//t5
			//yo.setOnAction(myHandler);	//t5
				
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(20);
			grid.add(heitaNoppa,0,0);		//t1,t2,t3,t6
			//grid.add(heitaKolikko, 0, 0);	//t4
			//grid.add(selite, 0, 0);		//t5
			
			//grid.add(silmaluku,0,1);		//t1
			//grid.add(heitot, 1, 1);		//t2
			//grid.add(viisi,0,1);			//t3
			//grid.add(summa, 1, 1);		//t3
			//grid.add(kolikko, 0, 1);		//t4
			//grid.add(aamu, 0, 1);			//t5
			//grid.add(paiva, 0, 2);		//t5
			//grid.add(ilta, 0, 3);			//t5
			//grid.add(yo, 0, 4);			//t5
			//grid.add(teksti, 0, 5);		//t5
			grid.add(iv1, 0, 1);			//t6
			
	        primaryStage.setScene(new Scene(grid, 300, 250));
	        primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setSilmaluku(int silmaluku) {
		//String arvo = Integer.toString(silmaluku);	//t1
		//this.silmaluku.setText(arvo);					//t1
		
		//t6
		if (silmaluku == 1) {
			this.iv1.setImage(dice1);
		}
		else if (silmaluku == 2) {
			this.iv1.setImage(dice2);
		}
		else if (silmaluku == 3) {
			this.iv1.setImage(dice3);
		}
		else if (silmaluku == 4) {
			this.iv1.setImage(dice4);
		}
		else if (silmaluku == 5) {
			this.iv1.setImage(dice5);
		}
		else if (silmaluku == 6){
			this.iv1.setImage(dice6);
		}	
	}
	@Override
	public void setHeitot(int kerrat) {
		String kerta = Integer.toString(kerrat);
		this.heitot.setText(kerta);
	}
	@Override
	public void setViisiNoppaa(String viisiNoppaa) {	
		this.viisi.setText(viisiNoppaa);
	}
	@Override
	public void setSumma(int summa) {
		String sum = Integer.toString(summa);
		this.summa.setText(sum);
	}
	@Override
	public void setKolikko(String kolikko) {
		this.kolikko.setText(kolikko);
	}
	@Override
	public void setTeksti(String teksti) {
		this.teksti.setText(teksti);
	}
}
