/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazPouzij představují implementaci příkazu "pouzij",
 * který slouží k využití funkcí předmětů
 *
 * @author    Václav Pleskač
 * @version   1.00.000
 */
public class PrikazPouzij implements IPrikaz
{
    private static final String NAZEV = "pouzij";
    private HerniPlan plan;

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazPouzij(HerniPlan plan)
    {
        this.plan = plan;
    }
/**
 * Provadi prikaz "pouzij" - pouzije danou vec a vykoná příslušný příkaz.
 * 
 * @parametr pouzivanaVec - věc, kterou se chystáme použít
 * @return - zpráva pro hráče
 */
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0){
            return "Zadejte název věci, kterou chcete použít";      
        }
        String nazevPouzivaneVeci = parametry [0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        Prostor viteznyProstor = plan.getViteznyProstor();
        Vec pouzivanaVec = aktualniProstor.najdiVec(nazevPouzivaneVeci);

        if (pouzivanaVec.getNazev().equals("kouzelne_zrcadlo")) {
            return "Vy: Zrcadlo zrcadlo, kdo je v zemi zdejší, nejhezčí a nejkrásnější? \n"+
                    "Zrcadlo: Hádej :)";
        }
        else{
            if(pouzivanaVec.getNazev().equals("kristalova_koule")){
                return "Vy: Vidím nějakou místnost, vypadá jako "+ viteznyProstor.nazev + "\n"
                + "Teď už vím, kde hledat!";
            }
            return "to tu není";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

    }
