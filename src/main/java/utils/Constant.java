package utils;

public class Constant {

	/**Config Properties file **/
	public final static String CONFIG_PROPERTIES_DIRECTORY = "properties/config.properties";
	
	//public final static String GECKO_DRIVER_DIRECTORY = "/Users/sandeepgangireddy/Desktop/AdvancedFramework/AdvancedFramework/src/test/java/resources/other/geckodriver";

	public final static String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir")+"/src/test/java/resources/other/geckodriver";
	
	public final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir")+"/src/test/java/resources/other/chromedriver";
	
	public final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir")+"/src/test/java/resources/other/IEDriverServer";
	
}
