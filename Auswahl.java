/**
 * Zur Verwaltung aller Fische und Unvertraeglichkeiten
 */

import java.util.*;

public class Auswahl {
	
	private Fisch[] fische;
	private int lastElement = 0;
	
	private int geld;
	private Eingabe eingabe;
	private List<Fisch> liste
	
	/**
     * Konstruktor.
     * @param  geld 	Das Geld, das zur Verfuegung stehen soll
     */
	public Auswahl(int geld){
		
		this.geld = geld;
		
		//Alle Fische und Unvertareglichkeiten einlesen:
		eingabe = new Eingabe("Fische.txt", "Unvertraeglichkeiten.txt");
		
		//Leere Fischliste zum Speichern:
		liste = new ArrayList<Fisch>();
	}
	
	/**
     * Suche rekursiv nach moeglichkeiten, um das Geld auszugeben
     */
	public void moeglichkeiten(){
		for(int i = 0; i < Fischgruppe.fische.size(); i++){
			
			//kaufe Fisch:
			String name = Fischgruppe.fische.get(i).getName();
			geld -= Fischgruppe.fische.get(i).getPreis(); 
			liste.add(Fischgruppe.fische.get(i));
			
			//unvertraeglich?
			boolean unvertraeglich = false;
			for(int j = 0; j < liste.size(); j++){
				
				if(Fischgruppe.unvertraeglichkeiten.containsKey(name)){
					String values[] = Fischgruppe.unvertraeglichkeiten.get(name);
					for(int k = 0; k < values.length; k++){
						if(values[k].equals(liste.get(j).getName())){
							unvertraeglich = true;
						}
					}
				}
				
			}
			
			if(geld < 0 || unvertraeglich){
				//Gib letzten Fisch zurueck:
				geld += liste.get(liste.size()-1).getPreis(); 
				liste.remove(liste.size()-1);
				unvertraeglich = false;
			}
			
			else if(geld > 0){
				//kaufe naechsten Fisch:
				moeglichkeiten(); 
			}
			
			else if(geld == 0){
				
				//Fuege neue Moeglichkeit ein
				for(int j = 0; j < liste.size(); j++){
					System.out.print(liste.get(j).getName() + ": " + liste.get(j).getPreis() + " | ");
				}
				System.out.println();
				
				//Gib letzten Fisch zurueck:
				geld += liste.get(liste.size()-1).getPreis();
				liste.remove(liste.size()-1);
			}
		}
		if(liste.size() > 0){
			//Gib letzten Fisch zurueck:
			geld += liste.get(liste.size()-1).getPreis();
			liste.remove(liste.size()-1);
		}
		
	}
}
