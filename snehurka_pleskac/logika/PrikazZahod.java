/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazZahod představují odhození vybrané věci z batohu
 *
 * @author    Václav Pleskač
 * @version   1.00.000
 */
public class PrikazZahod implements IPrikaz
{
    private static final String NAZEV = "zahod";
    private HerniPlan plan;
    private Kabelka kabelka;
    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazZahod(HerniPlan plan, Kabelka kabelka)
    {
        this.plan = plan;
        this.kabelka = kabelka;
    }

    /**
     * Metoda provadejici prikaz "zahod", odebere vec z kabelky a vrati do
     * aktualniho prostoru
     * 
     * @param parametry     ve, kterou zahazujeme
     * @return zprava vypsana hraci
     */
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nezadal jsi nazev veci";
        }
        String nazevVeci = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        
        Vec v = kabelka.vemVec(nazevVeci);
        if (v==null){
            return "Tohle v kabelkce nemám.";
        }
        else {kabelka.odeberVec(nazevVeci);
            aktualniProstor.vlozVec(v);
            return "Věc "+nazevVeci+" byla odebrána z kabelky.";
        }
    }

    /**
     * Metoda vracející název příkazu
     * @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }

}
