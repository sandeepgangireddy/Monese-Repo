package utils;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;



public class ReadConfigFile {

	protected InputStream input = null;
    protected Properties prop = null;
    
    public ReadConfigFile() {
    	try {
    		input = ReadConfigFile.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
    		prop = new Properties();
    		prop.load(input);
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public String getBrowser() {
    	if(prop.getProperty("browser") == null)
    		return "";
    	return prop.getProperty("browser");
    	
    }
    
}

