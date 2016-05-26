/**
 * Main Klasse
 */
 
import java.util.Scanner;

public class Main{
	public static void main(String[]args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wie viel Geld haben Sie zur Verfuegung:");
		
		//Initialisiere Fische, Unvertraeglichkeiten und Kosten:
		int geld = scanner.nextInt();
		Auswahl a = new Auswahl(geld);
		
		//Starte die Auswahl:
		a.moeglichkeiten();
	}
}
