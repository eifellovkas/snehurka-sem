/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazKabelka představují implementaci příkazu "kabelka"
 * který vypíše obsah kabelky
 *
 * @author    Václav Pleskač
 * @version   1.00.000
 */
public class PrikazKabelka implements IPrikaz
{
    private static final String NAZEV = "kabelka";
    
    private Kabelka kabelka;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán a Kabelka kabelka
     */    
    public PrikazKabelka(Kabelka kabelka) {
        
        this.kabelka = kabelka;
    }

    /**
     *  Provádí příkaz "kabelka". Vypíše všechny věci, které jsou zrovna v kabelce.
     *
     *@param parametry - jako  parametr může být cokoliv
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        return kabelka.veciVKabelce();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
