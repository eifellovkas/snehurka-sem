/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class ProstorTest
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
        //prostě prázdné
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
        //prostě prázdné
    }

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry.
     * 
     */
    @Test
    public  void testLzeProjit() {		
        Prostor prostor1 = new Prostor("komnata_Sněhurky","Komnata, kde bydlím já, Sněhurka", false);
        Prostor prostor2 = new Prostor("tajná_chodba", "Tajná chodba...hmm!", false);
        Prostor prostor3 = new Prostor("tajemná_komnata","Tady jsem nikdy nebyla! Je to tajemná komnata!", true);
        Prostor prostor4 = new Prostor("hlavni_chodba","Tohle je hlavní chodba, vede všude!", false);
        Prostor prostor5 = new Prostor("prázdná_komnata1","Nikdo tu už dlouho nebydlí", false);
        Prostor prostor6 = new Prostor("prázdná_komnata2","Tadý také už dlouho nikdo nebydlí", false);
        Prostor prostor7 = new Prostor("komnata_prince","Princ je na cestách a zbyla po něm prázdná komnata", true);

        prostor1.setVychod(prostor2);
        prostor1.setVychod(prostor3);
        prostor2.setVychod(prostor4);
        prostor4.setVychod(prostor5);
        prostor5.setVychod(prostor6);
        prostor6.setVychod(prostor7);
        assertEquals(prostor4, prostor2.vratSousedniProstor("hlavni_chodba"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }
}
