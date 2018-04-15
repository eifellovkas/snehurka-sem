/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída KabelkaTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class KabelkaTest
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

    
    /***************************************************************************
     * Test, který testuje vkládání věcí do batohu, vybrání věci, smazání věci a jestli batoh obsahuje věc.
     */
    @Test
    public void testKabelka()
    {
        logika.Kabelka kabelka1 = new logika.Kabelka();
        logika.Vec vec1 = new logika.Vec("věc1", true);
        logika.Vec vec2 = new logika.Vec("věc2", true);
        logika.Vec vec3 = new logika.Vec("věc3", true);
        logika.Vec vec4 = new logika.Vec("věc4", true);
        logika.Vec vec5 = new logika.Vec("věc5", true);
        assertEquals(true, kabelka1.vlozVec(vec1));
        assertEquals(true, kabelka1.vlozVec(vec2));
        assertEquals(true, kabelka1.vlozVec(vec3));
        assertEquals(true, kabelka1.vlozVec(vec4));
        assertEquals(false, kabelka1.vlozVec(vec5));
        kabelka1.vemVec("věc1");
        assertEquals(true, kabelka1.obsahujeVec("věc1"));
        assertEquals(true, kabelka1.obsahujeVec("věc2"));
        assertEquals(true, kabelka1.obsahujeVec("věc3"));
        assertEquals(true, kabelka1.obsahujeVec("věc4"));
        assertEquals(vec2, kabelka1.odeberVec("věc2"));
    }
}
