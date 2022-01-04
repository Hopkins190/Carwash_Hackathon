package JustDialPages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Drivers.GridDrivers;
import Drivers.StaticDrivers;
import Utils.PropertiesFiles;
import Utils.ScreenShot;

public class Main {
 
  WebDriver driver;
  String getBrowser;
  String getWebsiteURL;
  String getInputLocation;
  String getInputValue;
  String getDriverSetup;
  ExtentHtmlReporter htmlReporter;
  ExtentReports extent;
  ExtentTest test;
  ScreenShot screenShotPage = new ScreenShot();

  @BeforeSuite
	public void setup() throws InterruptedException, IOException {
	  	
	    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/extenttt.html");
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	    htmlReporter.config().setDocumentTitle("Automation Report");
	    htmlReporter.config().setReportName("Functional Report");
	    
	    test = extent.createTest("SettingUp Drivers");
	    
	    try {
			PropertiesFiles file = new PropertiesFiles();
			getBrowser = file.properties("getBrowser");
			getWebsiteURL = file.properties("getWebsiteURL");
			getInputLocation = file.properties("getInputLocation");
			getInputValue = file.properties("getInputValue");
			getDriverSetup = file.properties("getDriverSetup");
			
			
			if(getDriverSetup.equalsIgnoreCase("NormalDriverSetup")) {
				StaticDrivers getWebDriver = new StaticDrivers();
				driver = getWebDriver.getDriver(getBrowser);
			}
			else if(getDriverSetup.equalsIgnoreCase("GridDriverSetup")) {
				GridDrivers getGridDriver = new GridDrivers();
				driver = getGridDriver.getGridDriver(getBrowser);
			}
			
			driver.get(getWebsiteURL);
			screenShotPage.screenshot(driver, "Before_Suite");
			driver.manage().window().maximize();
			test.log(Status.INFO, "This step shows usage of log,info");
			test.info("This test shows setting up drivers and getting URL from user");
			test.pass("Passed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\Before_Suite.png").build());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\Before_Suite.png").build());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\screenshot1.png").build());
			e.printStackTrace();
		}
		
	}
  	@Test(priority = 0)
  	public void searchTextBoxAndRemoveAd() throws IOException {
  		Actions actions = new Actions(driver);
		
  		test = extent.createTest("Search TextBox and RemoveAd");
  		
  		
		try {
			driver.findElement(By.id("city")).sendKeys(getInputLocation);
			driver.findElement(By.id("srchbx")).sendKeys(getInputValue, Keys.ENTER);
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.pollingEvery(Duration.ofSeconds(5));
			WebElement cross = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_deal_div\"]/section/span")));
			actions.moveToElement(cross).click().perform();
			
			screenShotPage.screenshot(driver, "Car_Wash_Page");
			
			test.log(Status.INFO, "This step shows usage of log,info");
			test.info("This test shows searching textbox and removind Ad");
			test.pass("Passed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\Car_Wash_Page.png").build());
			
		}
			catch (IOException e) {
			}
		
  	}
  	@Test(priority = 1)
  	public void CarServiceInfoSearching() throws IOException, InterruptedException {
  		
  		CarServiceInfoPage helper = new CarServiceInfoPage();

  		helper.selectCity(driver,test,extent);
  		screenShotPage.screenshot(driver, "Car_Wash_Page");

  		
  	}
  	@Test(priority = 2)
	public void ListingPage() throws IOException{
		FreeListingPage freeListingJava = new FreeListingPage();
		String ErrMessage = freeListingJava.Message(driver,test,extent);
		System.out.println("Error Message After entering wrong value in Input Field: " + ErrMessage);
		System.out.println();
		
				
		screenShotPage.screenshot(driver, "Listing_Page");
	}
  	@SuppressWarnings("static-access")
	@Test(priority = 3)
	public void FitnessPage() throws IOException {
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[1]/div/div/div[1]/aside/a/span")).click();
		FitnessPage fitnessJava = new FitnessPage();
		Object[] output = new Object[20];
		output  = fitnessJava.fitness(driver,test,extent);
		
		for(int i=0;i<output.length;i++) {
			if(output[i] != null) {
				System.out.println(output[i]);
			}
		}
		
		screenShotPage.screenshot(driver, "Fitness_Page");
  	}
  	@AfterSuite
	public void closeBrowser() throws IOException {
  		test = extent.createTest("Closing Down Browser");
  		test.info("This test shows performs closing the browser");
		test.pass("Passed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\screenshot6.png").build());
  		
  		extent.flush();
		driver.close();	
		driver.quit();
	}
}
