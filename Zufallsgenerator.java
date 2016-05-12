import java.util.ArrayList;
import java.util.List;

/**
 * Ein Pseudozufallsgenerator. Erzeugt mittels Schluesseln eine Int-Liste.
 * @author Christian Staudte.
 */
public class Zufallsgenerator {
	
	private int a, b, m;
	private int schluessel;
	private List<Integer> x;
	
	/**
     * Konstruktor.
     * @param  values 	Der Array enthaelt a, b, m und den Primaerschluessel.
     */
	public Zufallsgenerator(int[] values){
		this.schluessel = 3;//values[0];
		this.a = 421;//values[1];
		this.b = 54773;//values[2];
		this.m = 259200;//values[3];
		this.x = new ArrayList<Integer>();
		
		x.add(schluessel);
	}
	
	/**
     * Erzeugt Integer mittels des Zufallalgorithmus und schreibt sie in die Liste.
     * @param  textSize    Menge an Ints die an die Liste gehangen werden.
     */
	public void kongruenzgenerator(int textSize){
		int nx = 0;
		int size = x.size();
		for(int i = size-1; i < size + textSize - 1; i++){
			nx = (a * x.get(i) + b) % m;
			x.add(nx);
		}
	}
	
	/**
     * Getter Methde um ein Listenelement zu erhalten.
     * @param  i    Position in der Liste.
     * @return		Listenelement.
     */
	public int getX(int i){
		return x.get(i);
	}
	
	/**
     * Erhalten aller Schluesselwerte.
     * @return		Einen Array mit Sekundaer- und Primaerschluesseln.
     */
	public int[] keys(){
		int[] k = new int[3];
		k[0] = a;
		k[1] = b;
		k[2] = m;
		return k;
	}
}
