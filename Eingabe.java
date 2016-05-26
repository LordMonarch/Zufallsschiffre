/**
 * Einlesen der Datein, in welchen die Fische
 * und Unvertraeglichkeiten gespeichert sind.
 */

import java.util.*;
import java.io.*;

public class Eingabe{
	
	//Attribute:
	private String fischListe;
	private String unvertraeglich;
	
	//Konstruktor:
	public Eingabe(String fischListe, String unvertraeglich){
		this.fischListe = fischListe;
		this.unvertraeglich = unvertraeglich;
		
		getFische(fischListe);
		getUnvertraeglichkeiten(unvertraeglich);
	}
	
	
	//Methoden:
	private void getFische(String fileName){
		try{
            FileReader fr	  = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
				
            String line;
			Fisch f;
			
			//schreibe alle Fische aus Datei in Fischgruppe:
			while((line = br.readLine()) != null){
				String[] split = line.split("_");
				f = new Fisch(Integer.parseInt(split[1]), split[0]);
				Fischgruppe.fische.add(f);
			} 
            fr.close();
			
        }catch(IOException e){
            System.err.println("Fehler beim Lesen der Datei: " + e);
        }
	}
	
	private void getUnvertraeglichkeiten(String fileName){
		try{
            FileReader fr	  = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
				
            String line;
			
			//Schreibe alle Unvertraeglichkeiten in die HashMap:
			while((line = br.readLine()) != null){
				String[] split = line.split("_");
				String[] others = new String[split.length-1];
				for(int i = 0; i < split.length-1; i++){
					others[i] = split[i+1];
				}
				Fischgruppe.unvertraeglichkeiten.put(split[0], others);
			} 
            fr.close();
			
        }catch(IOException e){
            System.err.println("Fehler beim Lesen der Datei: " + e);
        }
	}
}