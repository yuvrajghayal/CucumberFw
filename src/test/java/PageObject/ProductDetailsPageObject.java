package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPageObject
{
       private static final Logger logger = LogManager.getLogger(ProductDetailsPageObject.class);
       private WebDriver driver;
       private By Product_Title = By.id("productTitle");
       private By add_to_cart_button = By.id("add-to-cart-button");
       
public ProductDetailsPageObject(WebDriver driver) {
	    this.driver = driver;
}
public void ValidateProductTitleCorrectlyDisplayed() {
	if(driver.findElement(Product_Title).isDisplayed()) {
		Assert.assertTrue(true);
		logger.info("Product Title is Displayed");
	}
	else {
		logger.fatal("Product Title is  not Displayed");
		Assert.fail("Product Title is Displayed");
		
	}
}
public void ValidateAddToCartButtonIsCorrectlyDisplayed() {
	if(driver.findElement(add_to_cart_button).isDisplayed()) {
		Assert.assertTrue(true);
		logger.info("Add to cart Button is Displayed");
	}
	else
	{
		logger.fatal("Add to cart Button is Not Displayed");
		Assert.fail("Add to cart Button is Not Displayed");
	}
}
}
