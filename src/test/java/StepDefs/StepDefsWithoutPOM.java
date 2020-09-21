package StepDefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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

public class StepDefsWithoutPOM {
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
	public void setUp(Scenario scn){
        this.scn = scn; //Assign this to class variable, so that it can be used in all the step def methods
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_time, TimeUnit.SECONDS);
        logger.info("Browser invoked.");
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
	//@Given("User Navigated to home application URL")
	public void User_Navigated_to_Home_Application_Url() {
		driver.get(Base_Url);
		String Expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String Actual = driver.getTitle();
		Assert.assertEquals("Page Title validation",Expected, Actual);
		scn.log("Page Title Validation succesfull.Actual Site" +Actual );
	}

	//@When("User Search for product {String}")
	public void User_Search_Product(String ProductName) {
		WebDriverWait WebDriverWait =new WebDriverWait(driver,20);
		WebElement elementsearchbox = WebDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		elementsearchbox.sendKeys(ProductName);
		scn.log("Product Searched" + ProductName );
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		scn.log("Click on the Go Button");
		
	}
		//@Then("Searched Product displayed")
		public void Searched_Product_Displeyed() {
			WebDriverWait WebDriverWait1 = new WebDriverWait(driver,20);
			WebDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));
			Assert.assertEquals("Page Title Validation", "Amazon.in : Laptop",driver.getTitle());
			scn.log("Page Validate Succesfull" + driver.getTitle());
		}


}
