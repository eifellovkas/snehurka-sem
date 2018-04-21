/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka.main;



<<<<<<< HEAD
import com.github.eifellovkas.snehurka.logika.*;
import com.github.eifellovkas.snehurka.ui.TextoveRozhrani;
=======
import com.github.eifellovkas.snehurka.logika.Hra;
import com.github.eifellovkas.snehurka.logika.IHra;
import com.github.eifellovkas.snehurka.uiText.TextoveRozhrani;
>>>>>>> branch 'almostt' of https://github.com/eifellovkas/snehurka-sem.git

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 * @author    Jarmila Pavlíčková
 * @version   ZS 2016/2017
 */
public class Start extends Application
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
  //  public static void main(String[] args)
  //  {
  //      
  //      IHra hra = new Hra();
  //      TextoveRozhrani ui = new TextoveRozhrani(hra);
  //      ui.hraj();
  //  }
    
    public static void main(String[] args) {
    	if (args.length == 0) {
            launch(args);
        } else {
            if (args[0].equals("-text")) {
                IHra hra = new Hra();
                TextoveRozhrani ui = new TextoveRozhrani(hra);
                ui.hraj();
            } else {
                System.out.println("Neplatný parametr");
            }
        }
    }
    
  //  private Start(){}
    
    @Override
	public void start(Stage primaryStage) throws Exception 
    {
    	Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    	
	}
}
