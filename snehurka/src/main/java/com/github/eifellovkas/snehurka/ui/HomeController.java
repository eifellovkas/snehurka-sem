package com.github.eifellovkas.snehurka.ui;

import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.Set;

import com.github.eifellovkas.snehurka.logika.Hra;
import com.github.eifellovkas.snehurka.logika.IHra;
import com.github.eifellovkas.snehurka.logika.IPrikaz;
import com.github.eifellovkas.snehurka.logika.Vec;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
	@FXML private ComboBox boxPrikaz;
	
	
		private IHra hra;
		private ObservableList<Object> veciMistnost = FXCollections.observableArrayList();
		private ObservableList<Object> veciKabelka = FXCollections.observableArrayList();
		private ObservableList<Object> vychody = FXCollections.observableArrayList();
	    private ObservableList<String> seznamPrikazu = FXCollections.observableArrayList();

		

	    /**
		 * metoda čte příkaz ze vstupního textového pole
		 * a zpracuje ho
		 */
		@FXML public void odesliPrikaz() 
	        {
			String vypis = "";
			String pomocna = "" + boxPrikaz.getSelectionModel().getSelectedItem();
			if(pomocna.equals("null"))
		    {
		        vypis = hra.zpracujPrikaz(vstupniText.getText());
		        vystup.appendText("\n--------\n"+vstupniText.getText()+"\n--------\n");
		    }
			else
			 {
		        vypis = hra.zpracujPrikaz(pomocna + " " + vstupniText.getText());
		        vystup.appendText("\n--------\n"+ pomocna + " " + vstupniText.getText()+"\n--------\n");
		    }
			
			vystup.appendText(vypis);
			vstupniText.setText("");
			
			if(hra.konecHry()) 
	                {
				vystup.appendText("\n----------\nKonec hry\n----------\n");
				vstupniText.setDisable(true);
			}
	                hra.getHerniPlan().notifyObservers();
	                boxPrikaz.setValue(null);
		}
		

	@Override
	      public void initialize(URL url, ResourceBundle rb)  
	      {
	                hra = new Hra();
			vystup.setText(hra.vratUvitani());
			vystup.setEditable(false);
	                
			Map<String, IPrikaz> sPrikazu = hra.getPlatnePrikazy().getMapaSPrikazy();
		 
			for(String prikaz : sPrikazu.keySet())
		    {
		        seznamPrikazu.add(prikaz);
		    }
	                seznamVeciMistnost.setItems(veciMistnost);
	                seznamVeciKabelka.setItems(veciKabelka);
	                seznamVychodu.setItems(vychody);
	                boxPrikaz.setItems(seznamPrikazu);
	                
	        
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
              
              Set <Vec> sKabelka = hra.getKabelka().getSeznamVeci();
              for (Vec pomocna : sKabelka) 
              {
              	ImageView img = new ImageView(new Image(com.github.eifellovkas.snehurka.ui.Application.class.getResourceAsStream("/resources/"+pomocna.getImg()), 100, 100, false, false));
                  veciKabelka.add(img);
              }
         	}
               
        @FXML public void Mistnost() 
        {
       String nazev = seznamVychodu.getSelectionModel().getSelectedItem().toString();
       if(!hra.konecHry())
       		{
    	   vystup.setText("jdi " + nazev);
    	   odesliPrikaz();
       		}
   		}
                    
 }


