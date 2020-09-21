package BaseCore;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebDriverFactory
{

	
	private static WebDriver driver = null;
	public static WebDriver FatchBrowser(String browser)throws Exception
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
		//	logger.info("Chrome Driver invoked");
			break;
		case "firefox":
			driver = new FirefoxDriver();
		//	logger.info("FireFox Browser invoked");
			break;
		case "headless":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("Headless");
			option.addArguments("Display size = 1200*600");
			driver = new ChromeDriver(option);
			//logger.info("Headless Browser invoked");
			break;
			default:
				//logger.fatal("No such Browser implemented", browser );
				throw new Exception("No such Browser implemented");
				
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//logger.info("Driver maximaze and implicit time is 20 second");
		return driver;
		
	}
	public static void NavigatedToUrl(String Url)
	{
		driver.get(Url);
		//logger.info("User Navigated to URL", Url);
	
	}
	
	public static void CloseBrowser()
	{
		driver.close();
		//logger.info("Browser Closed");
		
	}
 public static void SwitchBrowserNewTab()
 {
	 Set <String> handles = driver.getWindowHandles();
	 //logger.info("list of Windows found", handles.size());
	 //logger.info(" Windows Handeled", handles.toString());
	 Iterator <String> it = handles.iterator() ;
	 String Original = it.next();
	 String NextTab = it.next();
	 driver.switchTo().window(NextTab);
	 //logger.info("Switch to the new Tab");
	 
	 
	 }
public static String GetBrowserName()
{
	String DefaultBrow = "chrome";
	String Browserfromcmd = System.getProperty("browser");
	
	if(Browserfromcmd==null)
	{
		return DefaultBrow;
	}
		else
		{
			return Browserfromcmd;
		}
			
		
	}
}
