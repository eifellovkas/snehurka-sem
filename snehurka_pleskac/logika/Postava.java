/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/*******************************************************************************
 * Instance třídy Postava představují ...
 *
 * @author    Václav Pleskač
 * @version   1.00.000
 */
public class Postava
{
    private String jmeno;
    
  
    /***************************************************************************
     *  Konstruktor ....
     */
    public Postava(String jmeno)
    {
        this.jmeno = jmeno;
    }

    /**
     * Metoda vracející jméno postavy
     * @return jmeno
     */
    public String getJmeno(){
        return jmeno;
    }
}
