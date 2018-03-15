/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka.logika;
import java.util.*;

/*******************************************************************************
 * Instance třídy Kabelka představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Kabelka 
{
    
    //== Datové atributy (statické i instancí)======================================
    public Set<Vec> seznamVeci;
    public static final int KAPACITA = 4;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor, který vytvoří HashMap pro obsah batohu
     */
    public Kabelka()
    {
        this.seznamVeci = new HashSet<Vec>();
    }
     /**
     *  Metoda zjistí, zda se věc vejde do batohu.
     *
     *  return   Vrátí true, pokud se vejde do batohu.
     */
    public boolean jeMistoVKabelce()
    {
        return (seznamVeci.size() < KAPACITA);
    }
    
    /**
     * Metoda přidá věc do kabelky, pokud v ní je místo.
     * 
     * @param vec věc, která se má přidat do kabelky.
     * 
     * return true, pokud se věc podaří přidat do kabelky.
     */

    public boolean vlozVec (Vec v)
    {
        if(jeMistoVKabelce() && (v.jePrenositelna())) {
            seznamVeci.add(v);
            return true;
        }
        return false;
    }
   
     /**
     * Odebere vec z kabelky
     * 
     */
    public Vec odeberVec(String jmeno) {
        for(Vec v:seznamVeci)
        if(v.getNazev().equals(jmeno)) {
            Vec vybranaVec = v;
            seznamVeci.remove(v);//smaže věc
            return vybranaVec;
        }
        return null;
    }
    /**
     * Vybere konkretni vec z kabelky
     * 
     */
     public Vec vemVec(String jmeno){
        for ( Vec v : seznamVeci ){
            if (v.getNazev().equals(jmeno)) {
                
                return v;
            }}
        return null;
    }
    /**
     * Vypíše obsah kabelky
     * 
     */
    
    public String veciVKabelce(){
        String result = "";
        if(seznamVeci.isEmpty()){
            result += "Kabelka je prázdná";
        }
        else{
            for (Vec vec : seznamVeci){
            result += "\n -" + vec.getNazev();
        }
        }

        
        return result;
    }
    /**
     * Metoda, která zjistí, zda se konkrétní věc nachází v kabelce
     */
    public boolean obsahujeVec(String nazev){
        for (Vec v : seznamVeci){
            if (v.getNazev().equals(nazev)){
                return true;
            }
        }
        return false;
    }
    /**
     * Vypíše kapacitu kabelky
     */
    public int getKapacitaKabelky(){
        return KAPACITA; 
    }
}
