package com.github.eifellovkas.snehurka.logika;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom; //kvuli f-ci random a postave trpaslika


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan extends Observable{

    private Prostor aktualniProstor;
    private Prostor viteznyProstor;
    private boolean vyhra = false;
    private Hra hra;
    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Hra hra) {
    	zalozProstoryHry();
    	this.hra = hra;
    	


    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor komnata_snehurky = new Prostor("komnata_snehurky","Komnata, kde bydlím já, Sněhurka", false, 0,0);
        Prostor tajna_chodba = new Prostor("tajna_chodba", "Tajná chodba...hmm!", false,-96,-6);
        Prostor tajemna_komnata = new Prostor("tajemna_komnata","Tady jsem nikdy nebyla! Je to tajemná komnata!", true,-160,53);
        Prostor hlavni_chodba = new Prostor("hlavni_chodba","Tohle je hlavní chodba, vede všude!", false,90,44);
        Prostor prazdna_komnata1 = new Prostor("prazdna_komnata1","Nikdo tu už dlouho nebydlí", false,96,-52);
        Prostor prazdna_komnata2 = new Prostor("prazdna_komnata2","Tady také už dlouho nikdo nebydlí", false,101,123);
        Prostor komnata_prince = new Prostor("komnata_prince","Princ je na cestách a zbyla po něm prázdná komnata", true,203,76);
        Prostor kumbal = new Prostor("kumbal","Je tu všechno, co nemá svoje místo jinde", false,203,2);

        // přiřazují se průchody mezi prostory (sousedící prostory)
        komnata_snehurky.setVychod(hlavni_chodba);
        komnata_snehurky.setVychod(tajna_chodba);
        tajna_chodba.setVychod(tajemna_komnata);
        tajna_chodba.setVychod(komnata_snehurky);
        tajemna_komnata.setVychod(tajna_chodba);
        hlavni_chodba.setVychod(komnata_snehurky);
        hlavni_chodba.setVychod(prazdna_komnata1);
        hlavni_chodba.setVychod(kumbal);
        hlavni_chodba.setVychod(prazdna_komnata2);
        hlavni_chodba.setVychod(komnata_prince);
        prazdna_komnata1.setVychod(hlavni_chodba);
        kumbal.setVychod(hlavni_chodba);
        prazdna_komnata2.setVychod(hlavni_chodba);
        komnata_prince.setVychod(hlavni_chodba);

     //vytvářejí se věci a vkládají se do jednotlivých prostor
     Vec kristalova_koule = new Vec ("kristalova_koule", false, "kristalova_koule.jpg");
     Vec kouzelne_zrcadlo = new Vec ("kouzelne_zrcadlo", false, "kouzelne_zrcadlo.jpg");
     Vec koste = new Vec ("koste", true, "koste.png");
     Vec klic_rezavy = new Vec ("rezavy_klic", true, "rezavy_klic.png");//klíč k prázdné komnatě č.1
     Vec klic_leskly = new Vec ("leskly_klic", true, "leskly_klic.png");//klíč k princově komnatě
     Vec stul = new Vec("stul", false, "stul.png");
     Vec zrcadlo = new Vec("zrcadlo", false, "zrcadlo.jpg");
     Vec pochoden = new Vec("pochoden", true, "pochoden.png");
     Vec zamcena_skrin = new Vec("zamcena_skrin", false, "zamcena_skrin.png");

     tajemna_komnata.vlozVec(kristalova_koule);
     tajemna_komnata.vlozVec(kouzelne_zrcadlo);
     kumbal.vlozVec(klic_rezavy);
     kumbal.vlozVec(klic_leskly);
     kumbal.vlozVec(koste);
     prazdna_komnata1.vlozVec(stul);
     prazdna_komnata2.vlozVec(zamcena_skrin);
     komnata_prince.vlozVec(zrcadlo);
     hlavni_chodba.vlozVec(pochoden);

        Postava trpaslik = new Postava("Šmudla");

        int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        //System.out.println(randomNum); - kontrolni cast kodu, ktera je ve hre zbytecna
        if(randomNum == 1){
            prazdna_komnata1.vlozPostavu(trpaslik);
            viteznyProstor = prazdna_komnata1;
        }
        else{
            if(randomNum == 2){
                kumbal.vlozPostavu(trpaslik);
                viteznyProstor = kumbal;
            }
            else{
                if(randomNum == 3){
                    prazdna_komnata2.vlozPostavu(trpaslik);
                    viteznyProstor = prazdna_komnata2;
                }
                else{
                    komnata_prince.vlozPostavu(trpaslik);
                    viteznyProstor = komnata_prince;
                }
            }

        }

        aktualniProstor = komnata_snehurky;  // hra začíná v domečku  
        }



    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    public Prostor getViteznyProstor(){
        return viteznyProstor;
    }
    
    public boolean isVyhra(){
        if(aktualniProstor.equals(viteznyProstor)){
            return true;
        }
        return false;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

	@Override
	public void notifyObservers(){
		setChanged();
		super.notifyObservers();
}

}
