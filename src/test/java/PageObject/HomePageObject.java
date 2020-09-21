package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject
{

	 private static final Logger logger = LogManager.getLogger(HomePageObject.class);
     WebDriver driver;
     
     private By Link_Sing_in_Securly = By.linkText("Sing in Securly" );
     
     public HomePageObject(WebDriver driver) {
    	 this.driver = driver;
     }
     public void Click_Sing_In_Securly() {
    	 driver.findElement(Link_Sing_in_Securly).click();
    	 logger.info("click Link: Sing in Securly");
     }
}
