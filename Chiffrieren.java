
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
    private Eingabe eingabe = new Eingabe();
    private Zufallsgenerator zgenerator;
    
    private String dateiLesen = new String();
    private String dateiSchreiben = new String();
    private Ausgabe ausgabe = new Ausgabe();
    
    public Chiffrieren(){
        this.chiffrierungsrichtung  = eingabe.chiffrierungsrichtung();
        this.dateiSchreiben         = eingabe.dateinameSchreiben();
        this.dateiLesen             = eingabe.dateinameLesen();
        
        chiffrieren();
    }
    
    public void chiffrieren(){
        int[] inp = eingabe.schluessel(chiffrierungsrichtung, dateiLesen);
        zgenerator = new Zufallsgenerator(inp);
        
        int anzahlBuchstaben = 1;
        
        String text = new String();
        String speichern = new String();
        
        if(chiffrierungsrichtung){
            try{
                FileReader      fr = new FileReader(dateiLesen);
                BufferedReader  br = new BufferedReader(fr);
                
                ausgabe.getText(zgenerator.keys()[0] + " " + zgenerator.keys()[1] + " " + zgenerator.keys()[2], dateiSchreiben);
                
                text = br.readLine();
           
                while(text != null){
                    char[] chiff = text.toCharArray();
                    zgenerator.kongruenzgenerator(chiff.length);
                    
                    for(int i = 0; i < chiff.length ; i++){
                        chiff[i] = (char)(chiff[i] ^ (zgenerator.getX(anzahlBuchstaben)%10));
                        anzahlBuchstaben++;
                        speichern += chiff[i];
                    }
                    ausgabe.getText(speichern, dateiSchreiben);
                    speichern = "";
                    text = br.readLine();
                }
                br.close();
                fr.close();
            }catch(IOException e){
                System.out.println("Sollte nie geworfen werden");
            }
           
        }else{
            try{
                FileReader      fr = new FileReader(dateiLesen);
                BufferedReader  br = new BufferedReader(fr);
                text = br.readLine();
                text = br.readLine();
           
                while(text != null){
                    char[] chiff = text.toCharArray();
                    zgenerator.kongruenzgenerator(chiff.length);
                    
                    for(int i = 0; i < chiff.length ; i++){
                        chiff[i] = (char)((zgenerator.getX(anzahlBuchstaben)%10) ^ chiff[i]);
                        anzahlBuchstaben++;
                        speichern += chiff[i];
                    }
                    ausgabe.getText(speichern, dateiSchreiben);
                    speichern = "";
                    text = br.readLine();
                }
                br.close();
                fr.close();
            }catch(IOException e){
                System.out.println("Sollte nie geworfen werden");
            }
            
            
        }
    }
}
