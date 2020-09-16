package StepDefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class StepDefs {
WebDriver driver;
String Base_Url = "https://amazon.in";
int implicit_time = 20;

@Given("User opened Browser")
	public void User_Opened_Browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_time, TimeUnit.SECONDS);
	
	}
@Given("User Navigated to home application URL")
public void User_Navigated_to_Home_Application_Url() {
	driver.get(Base_Url);
	String Expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	String Actual = driver.getTitle();
	Assert.assertEquals("Page Title validation",Expected, Actual);
}

@When("User Search for product {String}")
public void User_Search_Product(String ProductName) {
	WebDriverWait WebDriverWait =new WebDriverWait(driver,20);
	WebElement elementsearchbox = WebDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
	elementsearchbox.sendKeys(ProductName);
	driver.findElement(By.xpath("//input[@value='Go']")).click();
	
}
	@Then("Searched Product displayed")
	public void Searched_Product_Displeyed() {
		WebDriverWait WebDriverWait1 = new WebDriverWait(driver,20);
		WebDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));
		Assert.assertEquals("Page Title Validation", "Amazon.in : Laptop",driver.getTitle());
	}

}
