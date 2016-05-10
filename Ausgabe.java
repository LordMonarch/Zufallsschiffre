 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ausgabe {
	public void text(String text, String path){
		Writer writer;
		try {
			File f = new File("path");
			writer = new FileWriter(f);
			BufferedWriter bWriter = new BufferedWriter(writer);
			
			//write:
			bWriter.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
