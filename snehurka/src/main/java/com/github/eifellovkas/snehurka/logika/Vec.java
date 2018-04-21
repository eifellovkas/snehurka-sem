/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka.logika;

/*******************************************************************************
 * Instance třídy Vec představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private boolean prenositelnost;
    private String img;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Vec(String nazev, boolean prenositelnost, String img)
    {
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
        this.img = img;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    public String getNazev(){
        return nazev;
    }

    public boolean jePrenositelna(){
        return prenositelnost;
    }

    public String getImg() {
    	return img;
   	}
    public void setImg(String img) {
    	this.img = img;
    	
    }
    //== Soukromé metody (instancí i třídy) ========================================

}
