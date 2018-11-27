package utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import pageObjects.BasePage;
import pageObjects.ContactUs_Page;
import pageObjects.Products_Page;

public class DriverFactory {
	public static WebDriver driver;
	public static BasePage basePage;
	public static ContactUs_Page contactUsPage;
	public static Products_Page productsPage;
	

	@SuppressWarnings("deprecation")
	public WebDriver getDriver() throws Exception {
		try {
			//Read Config
			Properties p = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");
			switch (browserName) {

			// Firefox setup
			case "firefox":
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver",Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			// Chrome setup
			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver",
							Constant.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					//ChromeOptions options = new ChromeOptions();
					//1driver = new ChromeDriver(options);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			// IE setup
			case "ie":
				if (null == driver) {
					DesiredCapabilities caps = DesiredCapabilities
							.internetExplorer();
					System.setProperty("webdriver.ie.driver",
							Constant.IE_DRIVER_DIRECTORY);
					caps.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(caps);
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser! - Exception: "
					+ e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		    contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
		    productsPage = PageFactory.initElements(driver, Products_Page.class);
		    basePage = PageFactory.initElements(driver, BasePage.class);
		
		}
		return driver;
	}
}
