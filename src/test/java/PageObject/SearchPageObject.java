package PageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


public class SearchPageObject {
   private static final Logger logger = LogManager.getLogger(SearchPageObject.class);
   private WebDriver driver;
   
   private By Search_Categories_Segment = By.id("s-refinements");
   private By Product_List = By.xpath("//a[@class='a-link-normal a-text-normal']");
   
 public SearchPageObject(WebDriver driver) {
	   this.driver = driver;
}
 public void ProductSearchissuccessfull() {
	 if(driver.findElement(Search_Categories_Segment).isDisplayed())
	 {
		 Assert.assertTrue(true);
		 logger.info("search page is Displayed because refinement category is displayed");
	 }
	 else
	 {
		 logger.fatal("refinement category is not displayed");
		 Assert.fail("refinement category is  not displayed");
	 }
 }
public String ClickOnTheProductLink(int productIndex) {
	List <WebElement> listOfProduct = driver.findElements(Product_List);
	logger.info("Name of product Displayed" + listOfProduct.size() );
	listOfProduct.get(productIndex).click();
	 logger.info("Clicked on the Link in the List with index: " + productIndex +
             ". Link Text: " + listOfProduct.get(productIndex).getText());
	 
	 return listOfProduct.get(productIndex).getText();
}
}