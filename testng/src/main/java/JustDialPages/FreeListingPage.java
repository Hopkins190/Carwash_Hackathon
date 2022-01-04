package JustDialPages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class FreeListingPage {
	public String Message(WebDriver driver,ExtentTest test,ExtentReports extent) throws IOException {
	    try {
			driver.findElement(By.id("h_flist")).click();
			driver.findElement(By.id("fcom")).sendKeys("car wash");
			driver.findElement(By.xpath("//*[@id=\"fmb0\"]")).sendKeys("12345");
			driver.findElement(By.xpath("//*[@id=\"add_div0\"]/div[3]/button")).click();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.pollingEvery(Duration.ofSeconds(5));
			String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"intial_div\"]/span[2]"))).getText();
			
			test = extent.createTest("Listing Page");
	  		
	  		test.log(Status.INFO, "This step shows usage of log,info");
			test.info("This test shows Listing Page and entering wrong value and printing on Console");
			test.pass("Passed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\Listing_Page.png").build());

			
			return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\Listing_Page.png").build());
		}
		return null;
  }
}
