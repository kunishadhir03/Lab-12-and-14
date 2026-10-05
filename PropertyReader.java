package Labs;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    
	public static Properties prop ;
	
	static {
		
		try{
			FileInputStream fis = new FileInputStream("C:\\Training\\Java\\Sep2026\\configuration\\configuration.properties");
			
			prop = new Properties();
			
			prop.load(fis);
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
				
				
	}
}
