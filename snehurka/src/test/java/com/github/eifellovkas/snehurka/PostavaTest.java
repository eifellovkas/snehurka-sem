/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.github.eifellovkas.snehurka.logika.*;

/*******************************************************************************
 * Testovací třída PostavaTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PostavaTest
{
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        //nothing
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
        //nothing
    }
    @Test
    /***************************************************************************
     * Testuje existenci osoby a odkazuje na jeji jmeno
     */
    public void testOsoby()
    {
       Postava test = new Postava("jmeno");        
       assertEquals("jmeno", test.getJmeno());
     
    }
}
