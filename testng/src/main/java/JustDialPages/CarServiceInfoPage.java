package JustDialPages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
public class CarServiceInfoPage
{
	//SELECTING CITY
	public void selectCity(WebDriver driver, ExtentTest test,ExtentReports extent) throws InterruptedException, IOException
	{
				driver.findElement(By.xpath("//*[@id=\"distdrop_rat\"]/span")).click();
				
				List<WebElement> rating=driver.findElements(By.className("green-box"));
				List<WebElement> votes=driver.findElements(By.xpath("//p[@class='newrtings ']//span[@class='rt_count lng_vote']"));
				List<WebElement> servicesname=driver.findElements(By.className("lng_cont_name")); System.out.println("Top Five Car Wash Services"); int noofitems=0; for(int i = 0; i < servicesname.size(); i++) {
					//obtain text 
					String rate = rating.get(i).getText();
					String vote = votes.get(i).getText();
					String newvote= vote.substring(0,vote.length()-5);
					int updatedvote=0;
					float updatedrate=Float.parseFloat(rate);
					try
					{
						updatedvote=Integer.parseInt(newvote.replaceAll("[^0-9]",""));
					}catch(Exception e)
					{
						e.printStackTrace();
					} if(updatedrate >= 4.0 && updatedvote>= 20 && noofitems<5){ System.out.println(servicesname.get(i).getText());
					System.out.println(rating.get(i).getText());
					System.out.println(votes.get(i).getText());
					noofitems=noofitems+1;
					}
					
					test = extent.createTest("Car Wash Page");
					try {
			  		test.log(Status.INFO, "This step shows usage of log,info");
					test.info("This test shows Listing Page and entering wrong value and printing on Console");
				    test.pass("Passed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\Car_Wash_Page.png").build());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						test.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\Car_Wash_Page.png").build());
					}
				}
	}
}
