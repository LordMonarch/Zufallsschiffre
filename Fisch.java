/**
 * Einzelne Fische, jeweils mit Namen und Preis
 */

public class Fisch {
	private int preis;
	private String name;
	
	/**
     * Konstruktor.
     * @param  preis, name 	Name des Fisches und Preis, der er kostet
     */
	public Fisch(int preis, String name){
		this.preis = preis;
		this.name = name;
	}
	
	/**
     * get Methode fuer den Preis
	 * @return preis
     */
	public int getPreis(){
		return preis;
	}
	
	/**
     * get Methode fuer den Namen
	 * @return name
     */
	public String getName(){
		return name;
	}
}
