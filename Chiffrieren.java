
/**
 * Beschreiben Sie hier die Klasse Chiffrieren.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.io.*;
public class Chiffrieren
{
    private boolean chiffrierungsrichtung;
    Eingabe eingabe = new Eingabe();
    Zufallsgenerator zgenerator;
    private String text = new String();
    
    Chiffrieren(){
    this.chiffrierungsrichtung = eingabe.chiffrierungsrichtung();
    zgenerator = new Zufallsgenerator();
    }
    
    public void chiffrieren(){
        
        
        String lesen = new String();
        String schreiben = new String();
        if(chiffrierungsrichtung == true){
           lesen = eingabe.dateinameLesen();
           try{
           FileReader fr = new FileReader(lesen);
           BufferedReader br = new BufferedReader(fr);
           text = br.readLine();
           
           while(text != null){
               
            
            }
           
           
           }catch(IOException e){System.out.println("Sollte nie geworfen werden");}
           
        }
    
    }
    
    
}
