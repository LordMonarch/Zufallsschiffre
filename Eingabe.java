
/**
 * Beschreiben Sie hier die Klasse Eingabe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.*;
import java.io.*;
public class Eingabe{
   
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    
    public boolean chiffrierungsrichtung(){
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Wollt ihr Chiffrieren oder Dechiffrieren?");
		System.out.println("Irgendwas eingeben zum Chiffrieren nichts eingeben zum Dechiffrieren!");
		
		if(keyboard.nextLine().equals("")) return false;
		else return true;
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public String dateinameLesen(){
        String eingabe = new String();
        boolean iterator = true;
        Scanner keyboard = new Scanner(System.in);
        while(iterator){
            iterator = false;
            System.out.println("Bitte den Namen der Datei zum Einlesen eingeben: ");
            eingabe = keyboard.nextLine();
            File f = new File(eingabe);
            try{
                FileReader fr = new FileReader(f);
                fr.close();
            }catch(IOException e){
                System.out.println("Zuviele Sonderzeichen eingegeben oder sonst was falsch gemacht!");
                iterator = true;
            }
        }
    
        return eingabe;
    }
    
      /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public String dateinameSchreiben(){
        String eingabe = new String();
        boolean iterator = true;
        Scanner keyboard = new Scanner(System.in);
          while(iterator){
            iterator = false;
            System.out.println("Bitte den Namen der Datei zum Schreiben eingeben: ");
            eingabe = keyboard.nextLine();
            File f = new File(eingabe);
            try{
                FileWriter fw = new FileWriter(f);
                fw.close();
            }catch(IOException e){
                System.out.println("Zuviele Sonderzeichen eingegeben oder sonst was falsch gemacht!");
                iterator = true;
            }
        }
        return eingabe;
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int[] schluessel(boolean chiffrieren, String pfad){
        int[] eingabe = new int[4];
        boolean iterator = true;
        if(chiffrieren == true){
            
            for(int i = 0 ; i < 4; i++){
				if(i == 0){System.out.println("Bitte den Primaerschluessel eingeben: ");}
				if(i == 1){System.out.println("Bitte den ersten Sekundaerschluessel eingeben: ");}
				if(i == 2){System.out.println("Bitte den zweiten Sekundaerschluessel eingeben: ");}
				if(i == 3){System.out.println("Bitte den dritten Sekundaerschluessel eingeben: ");}
				iterator = true;
					while(iterator){
						iterator = false;
						try{    
							Scanner keyboard = new Scanner(System.in);
							eingabe[i] = keyboard.nextInt();
				
						}catch(InputMismatchException e){
							System.out.println("Bitte nur Zahlen eingeben");
							iterator = true;
						}
					
					}
            
			}   
		}else{
            System.out.println("Bitte den Primaerschluessel eingeben");
            iterator = true;
            while(iterator){
                iterator = false;
                try{    
                    Scanner keyboard = new Scanner(System.in);
                    eingabe[0] = keyboard.nextInt();
        
                }catch(InputMismatchException e){
                    System.out.println("Bitte nur Zahlen eingeben");
                    iterator = true;
                }
            
            }
            
            try{
                FileReader fr = new FileReader(pfad);
                BufferedReader br = new BufferedReader(fr);
				
                String zeile = br.readLine();
				String[] parts = zeile.split(" ");
				try{
					eingabe[1] = Integer.parseInt(parts[0]);
					eingabe[2] = Integer.parseInt(parts[1]);
					eingabe[3] = Integer.parseInt(parts[2]);
				}catch(Exception e){
					System.err.println("Konnte nicht parsen!");
				}
                
                fr.close();
            }catch(IOException e){
            
            }
            
    
    }
      return eingabe;
    }
}
