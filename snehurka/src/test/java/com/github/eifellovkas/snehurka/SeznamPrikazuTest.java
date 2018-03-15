/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.snehurka.logika.Hra;
import com.github.eifellovkas.snehurka.logika.PrikazJdi;
import com.github.eifellovkas.snehurka.logika.PrikazKonec;
import com.github.eifellovkas.snehurka.logika.SeznamPrikazu;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class SeznamPrikazuTest
{
       private PrikazKonec prikazKonec;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        Hra hra = new Hra();
        prikazKonec = new PrikazKonec(hra);
        
    }
    @Test
    public void testVlozeni() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prikazKonec);
        assertEquals(prikazKonec, seznPrikazu.vratPrikaz("konec"));
        assertEquals(null, seznPrikazu.vratPrikaz("nápověda"));
    }
    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prikazKonec);

        assertEquals(true, seznPrikazu.jePlatnyPrikaz("konec"));

        assertEquals(false, seznPrikazu.jePlatnyPrikaz("nápověda"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }
     @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prikazKonec);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(false, nazvy.contains("KONEC"));
    }
    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
        //nothing
    }

    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }
}
