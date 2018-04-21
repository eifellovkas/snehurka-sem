/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.snehurka.logika.Hra;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class HraTest
{
    private Hra hra1;

    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        hra1 = new Hra();

    }

    @After
    public void tearDown()
    {
        //prostě prázdný
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @Test
    public void testPrubehHry()
    {
        assertEquals("komnata_snehurky", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi tajna_chodba");
        assertEquals(false, hra1.konecHry());
        assertEquals("tajna_chodba", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi komnata_snehurky");
        assertEquals(false, hra1.konecHry());
        assertEquals("komnata_snehurky", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
    }

    @Test
    public void testKonec(){
        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
    }
}
