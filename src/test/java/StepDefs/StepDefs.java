package StepDefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseCore.WebDriverFactory;
import PageObject.ComnPageObject;
import PageObject.HomePageObject;
import PageObject.ProductDetailsPageObject;
import PageObject.SearchPageObject;
import PageObject.SigninPageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
public class StepDefs {
private static final Logger logger = LogManager.getLogger(StepDefs.class);
WebDriver driver;
String Base_Url = "https://amazon.in";
int implicit_time = 20;
Scenario scn;

ComnPageObject comnpageobject;
HomePageObject Homepageobject;
ProductDetailsPageObject ProductdetailspageObject;
SearchPageObject searchpageobject;
SigninPageObject signinppageobject;


@Before
public void SetUp(Scenario scn)throws Exception
{
	this.scn = scn;
	String browserName = WebDriverFactory.GetBrowserName();
	driver = WebDriverFactory.FatchBrowser(browserName);
	logger.info("Browser Invoked");
	
	comnpageobject = new ComnPageObject(driver);
	Homepageobject = new HomePageObject(driver);
	ProductdetailspageObject = new ProductDetailsPageObject(driver);
	searchpageobject = new SearchPageObject(driver);
	signinppageobject = new SigninPageObject(driver);
}
@After
public void CleanUp() {
	WebDriverFactory.CloseBrowser();
	scn.log("Browser Closed");
}


//**@Given("User opened Browser")
	//public void User_Opened_Browser() {
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(implicit_time, TimeUnit.SECONDS);
	//**
	//}
@Given("User Navigated to home application URL")
public void User_Navigated_to_Home_Application_Url() {
	WebDriverFactory.NavigatedToUrl(Base_Url);
	scn.log("Browser Navigated to URL:" + Base_Url);
	String Expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	comnpageobject.Validate_pageTitle(Expected);
	//String Actual = driver.getTitle();
	//Assert.assertEquals("Page Title validation",Expected, Actual);
}

@When("User Search for product {String}")
public void User_Search_Product(String ProductName) {
	comnpageobject.Search_Text_box(ProductName);
	comnpageobject.Search_Btn();
	scn.log("Product Searched"+ ProductName);
	
	/*WebDriverWait WebDriverWait =new WebDriverWait(driver,20);
	WebElement elementsearchbox = WebDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
	elementsearchbox.sendKeys(ProductName);
	driver.findElement(By.xpath("//input[@value='Go']")).click();
	*/
}
	@Then("Searched Product displayed")
	public void Searched_Product_Displeyed() {
		searchpageobject.ProductSearchissuccessfull();
		/*
		WebDriverWait WebDriverWait1 = new WebDriverWait(driver,20);
		WebDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));
		Assert.assertEquals("Page Title Validation", "Amazon.in : Laptop",driver.getTitle());
		*/
	}
 @When("User Click on any Product")
 public void User_Click_on_any_Product()
 {
	 searchpageobject.ClickOnTheProductLink(0);
 }
 @Then("Product Description Displayed in new Tab")
 public void Product_Description_Displayed_in_new_Tab() {
	 WebDriverFactory.SwitchBrowserNewTab();
	 scn.log("Browser Switch to new Tab");
	 ProductdetailspageObject.ValidateProductTitleCorrectlyDisplayed();
	 ProductdetailspageObject.ValidateAddToCartButtonIsCorrectlyDisplayed();
	 
 }
}
