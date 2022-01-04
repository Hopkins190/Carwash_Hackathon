package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDrivers {
	public WebDriver getDriver(String browser) {
    	WebDriver driver = null;
    	if(browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("start-maximized");
    		options.addArguments("--disable-blink-features=AutomationControlled");
    		options.addArguments("--disable-notifications");
    		driver = new ChromeDriver(options);	
    	}
    	else if(browser.equalsIgnoreCase("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		FirefoxOptions options = new FirefoxOptions();
    		options.addArguments("start-maximized");
    		options.addArguments("--disable-blink-features=AutomationControlled");
    		options.addArguments("--disable-notifications");
    		driver = new FirefoxDriver(options);
    	}
    	return driver;
	}
}
