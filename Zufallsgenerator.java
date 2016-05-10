 

import java.util.ArrayList;
import java.util.List;

public class Zufallsgenerator {
    private int a, b, m;
    private int schluessel;
    private List<Integer> x;
    
    public Zufallsgenerator(int[] values){
        this.a = values[1];
        this.b = values[2];
        this.m = values[3];
        this.schluessel = values[0];
        this.x = new ArrayList<Integer>();
        
        x.add(schluessel);
    }
    
    public void kongruenzgenerator(int textSize){
  int nx = 0;
  int size = x.size();
  for(int i = size-1; i < size + textSize - 1; i++){
   nx = (a * x.get(i) + b) % m;
   System.out.println(nx);
   x.add(nx);
  }
 }
    
    public int getX(int i){
        return x.get(i);
    }
}
