/**
 * 
 */
package browserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Lenovo
 *
 */
public class ConfigurationProvider {

	Properties pro;
	
	public ConfigurationProvider(){
		
		String path = System.getProperty("user.dir")+"/Configuration/config.properties";
		
		File src = new File(path);
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Unable to load config file");
		}
		
	}
	
	
	public String getBrowser(){
		
		return pro.getProperty("browser");
	}
	
	public String getURL(){
		
		return pro.getProperty("url");
	}
	
}
