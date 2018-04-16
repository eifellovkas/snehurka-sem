/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka.logika;

/*******************************************************************************
 * Instance třídy PrikazOdemkni představují implementaci příkazu pro odemknutí
 * prostoru za použití klíče
 *
 * @author    Václav Pleskač
 * @version   1.00.000
 */
public class PrikazOdemkni implements IPrikaz 
{
    private static final String NAZEV = "odemkni";
    private HerniPlan plan;
    private Kabelka kabelka;
    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazOdemkni(HerniPlan plan, Kabelka kabelka)
    {
        this.plan = plan;
        this.kabelka = kabelka;
    }

    /**
     * Provadi prikaz "odemkni". 
     * @param jmeno     jmeno odemykane mistnosti
     * @return  zprava vypsana pro hrace
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0){
            return "Zadejte jméno odemykané místnosti";      
        }
        String prostor = parametry [0];
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(prostor);
        if (sousedniProstor == null) {
            return "Tam se odtud jít nedá";
        }
        else
        { 
            if (sousedniProstor.jeZamcena()) {
                if (sousedniProstor.getNazev().equals("tajemna_komnata")||sousedniProstor.getNazev().equals("komnata_prince"))
                {
                    if (kabelka.obsahujeVec("rezavy_klic"))
                    {
                        sousedniProstor.odemknout(false);
                        kabelka.odeberVec("rezavy_klic");
                        return "Místnost "+prostor+" je odemčena. Kde jen může být?";
                    }
                    else
                    {
                        if(kabelka.obsahujeVec("leskly_klic")){
                            sousedniProstor.odemknout(false);
                            kabelka.odeberVec("leskly_klic");
                            return "Místnost "+prostor+" je odemčena. Kde jen může být?";
                        }
                        return "Pro odemknutí "+prostor+" potřebuješ správný klíč!";
                    }
                }
                return "Tato místnost není zamčená!";
            }
        }
        return "Chtělo by to najít klíč..."; 
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */

    public String getNazev() {
        return NAZEV;
    }

}
