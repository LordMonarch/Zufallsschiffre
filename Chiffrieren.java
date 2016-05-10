
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
    
    String dateiLesen = new String();
    String dateiSchreiben = new String();
    Ausgabe ausgabe = new Ausgabe();
    public Chiffrieren(){
    this.chiffrierungsrichtung = eingabe.chiffrierungsrichtung();
    this.dateiSchreiben = eingabe.dateinameSchreiben();
    this.dateiLesen = eingabe.dateinameLesen();
    
    }
    
    public void chiffrieren(){
        
        if(chiffrierungsrichtung == true){
        
        zgenerator = new Zufallsgenerator( eingabe.schluessel(chiffrierungsrichtung, dateiLesen));
    }else{
        
        zgenerator = new Zufallsgenerator( eingabe.schluessel(chiffrierungsrichtung, dateiSchreiben));
    }
        
        int anzahlBuchstaben = 1;
        char[] chiff;
        String text = new String();
        String speichern = new String();
        if(chiffrierungsrichtung == true){
          
           try{
           FileReader fr = new FileReader(dateiLesen);
           BufferedReader br = new BufferedReader(fr);
           text = br.readLine();
           
           
           
           while(text != null){
               chiff = text.toCharArray();
               for(int i = 0; i < chiff.length ; i++){
                   zgenerator.kongruenzgenerator(anzahlBuchstaben);
                   chiff[i] = (char)(chiff[i] ^ zgenerator.getX(anzahlBuchstaben));
                   anzahlBuchstaben += 1;
                   speichern += chiff[i];
                }
                ausgabe.text(speichern, dateiSchreiben);
                speichern = "";
            }
           
           
           }catch(IOException e){System.out.println("Sollte nie geworfen werden");}
           
        }else{
        
        
        }
    
    }
    
    
}
