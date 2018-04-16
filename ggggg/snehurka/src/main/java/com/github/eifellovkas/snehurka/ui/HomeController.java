package com.github.eifellovkas.snehurka.ui;

import com.github.eifellovkas.snehurka.logika.Hra;
import java.util.Observable;
import java.util.Observer;

import com.github.eifellovkas.snehurka.logika.IHra;
import com.github.eifellovkas.snehurka.logika.Prostor;
import com.github.eifellovkas.snehurka.logika.Vec;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HomeController extends AnchorPane implements Observer, Initializable{
	@FXML private TextField vstupniText;
	@FXML private TextArea vystup;
	@FXML private ListView<Object> seznamVeciMistnost = new ListView<>();
    @FXML private ListView<Object> seznamVeciKabelka = new ListView<>();
	@FXML private ListView<Object> seznamVychodu = new ListView<>();
	@FXML private ImageView uzivatel;
	
	
	private IHra hra;
		private ObservableList<Object> veciMistnost = FXCollections.observableArrayList();
		private ObservableList<Object> veciKabelka = FXCollections.observableArrayList();
		private ObservableList<Object> vychody = FXCollections.observableArrayList();
		

		/**
		 * metoda čte příkaz ze vstupního textového pole
		 * a zpracuje ho
		 */
		@FXML public void odesliPrikaz() 
	        {
			String vystupPrikazu = hra.zpracujPrikaz(vstupniText.getText());
			vystup.appendText("\n----------\n"+vstupniText.getText()+"\n----------\n");
			vystup.appendText(vystupPrikazu);
			vstupniText.setText("");
			if(hra.konecHry()) 
	                {
				vystup.appendText("\n----------\nKonec hry\n----------\n");
				vstupniText.setDisable(true);
			}
	                hra.getHerniPlan().notifyObservers();
		}
		
		/**
		 * Metoda bude soužit pro předání objektu se spuštěnou hrou
		 * kontroleru a zobrazí stav hry v grafice.
		 * @param objekt spuštěné hry
		 */
		@Override
	        public void initialize(URL url, ResourceBundle rb)  
	        {
	                hra = new Hra();
			vystup.setText(hra.vratUvitani());
			vystup.setEditable(false);
	                
	                
	                seznamVeciMistnost.setItems(veciMistnost);
	                seznamVeciKabelka.setItems(veciKabelka);
	                seznamVychodu.setItems(vychody);
	                
			hra.getHerniPlan().addObserver(this);
	                hra.getHerniPlan().notifyObservers();
		}
		@FXML public void novaHra() 
        {
        hra = new Hra();
		vystup.setText(hra.vratUvitani());
		vstupniText.setDisable(false);
        hra.getHerniPlan().addObserver(this);
        hra.getHerniPlan().notifyObservers();
        }
        
        @FXML public void konecHry() 
        {
            vstupniText.setText("konec");
            odesliPrikaz();
        }
        @FXML public void Napoveda() 
        {
            Stage stage = new Stage();
            stage.setTitle("Nápověda");
            
            WebView webView = new WebView();               
            webView.getEngine().load(com.github.eifellovkas.snehurka.ui.Application.class.getResource("/zdroje/napoveda.html").toExternalForm());
            
            stage.setScene(new Scene(webView, 1200, 650));
            stage.show();
        }
        @Override
    	public void update(Observable arg0, Object arg1) 
            {
    		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
    		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
                
                    veciMistnost.clear();
                    veciKabelka.clear();
                    vychody.clear();
    		String sVychody = hra.getHerniPlan().getAktualniProstor().seznamVychodu();
                    String[] oddeleneVychody = sVychody.split(" ");
                    for (int i = 1; i < oddeleneVychody.length; i++) 
                    {
                        vychody.add(oddeleneVychody[i]);
                    }
                    
                    Map<String, Vec> sKabelka = hra.getHerniPlan().getKabelka().veciVKabelce2();
                    for (String x : sKabelka.keySet()) 
                    {
                        Vec pomocna = sKabelka.get(x);
                        ImageView obrazek = new ImageView(new Image(com.github.eifellovkas.snehurka.ui.Application.class.getResourceAsStream("/zdroje/"+pomocna.getObrazek()), 100, 100, false, false));
                        veciKabelka.add(img);
                    }
     //              for (String nazevPredmetu : plan.getBatoh().getPredmety().keySet()) {
     //              	String URL = plan.getBatoh().getPredmet(nazevPredmetu).getObr();
     //              	Image obr = new Image(getClass().getResourceAsStream(URL));
     //              	ImageView image = new ImageView(obr);
     //              	image.setId(nazevPredmetu);
     //              	observableList.add(image);
            		}
                    
                    Map<String, Vec> sVeci = hra.getHerniPlan().getAktualniProstor().getSeznamVeci();
                    for (String x : sVeci.keySet()) 
                    {
                        Vec pomocna = sVeci.get(x);
                        ImageView img = new ImageView(new Image(com.github.eifellovkas.snehurka.ui.Application.class.getResourceAsStream("/zdroje/"+pomocna.getImg()), 100, 100, false, false));
                        veciMistnost.add(img);
                    }
    	}
		}

