/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.eifellovkas.snehurka.logika;

/*******************************************************************************
 * Instance třídy PrikazSeber představují implementaci příkazu "seber"
 * který vyjme vybraný předmět z prostoru a vloží ho do kabelky
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PrikazSeber implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Kabelka kabelka;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy PrikazSeber
     *  
     *  @param plan herní plán, ve kterém operace proběhne
     */
    public PrikazSeber(HerniPlan plan, Kabelka kabelka)
    {
        this.plan = plan;
        this.kabelka = kabelka;
    }

    /**
     *  Provádí příkaz "seber". Pokud se sbirana vec nachazi v aktualnim prostoru,
     *  je vyjmuta a vložena do kabelky.
     *  
     *  @param nazevSbiraneVeci - nazev veci, ktera je sbírána
     *  
     *  @return zpráva, která je následně vypsána
     * 
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Co mám sebrat? Musíš zadat název věci";
        }

        String nazevSbiraneVeci = parametry[0];        
        Prostor aktualniProstor = plan.getAktualniProstor();
        Vec sbiranaVec  = aktualniProstor.najdiVec(nazevSbiraneVeci);        

        if (sbiranaVec == null || !sbiranaVec.jePrenositelna()) {
            return "Nejde";
        }

        if(kabelka.vlozVec(sbiranaVec) && sbiranaVec.jePrenositelna()){
            aktualniProstor.odeberVec(sbiranaVec);
            return "Sebral Jsi "+ nazevSbiraneVeci;
        }         
        else
        {
            return "Tohle neuzvedneš!"; 
        }        
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
    //== Soukromé metody (instancí i třídy) ========================================
}
