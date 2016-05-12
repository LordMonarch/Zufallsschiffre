import java.io.*;

/**
 * Ausgabe um Text in eine Datei zu schreiben.
 * @author Christian Staudte.
 */
public class Ausgabe {
	
	/**
     * Schreibt eine Zeile Text in eine gegebene Datei.
     * @param  text		Textzeile, die geschrieben werden soll.
	 * @param  path		Dateienpfad.
     */
	public void getText(String text, String path){
		//Sofortiges schliessen wenn ausgefuert
		try(FileWriter fw = new FileWriter(path, true); //true: nicht ueberschreiben, sondern Text anhaengen
			BufferedWriter bw = new BufferedWriter(fw); 
			PrintWriter pw = new PrintWriter(bw)){
				
			pw.println(text);
		} catch (IOException ioe) {
				System.err.println("Problem! Konnte nicht in die Datei schreiben:\n" + ioe);
		}
	}
}
