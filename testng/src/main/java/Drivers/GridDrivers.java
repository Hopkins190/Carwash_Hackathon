package Drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridDrivers {
public WebDriver getGridDriver(String browser) throws MalformedURLException {
		if(browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			String remoteUrl = "http://172.19.168.101:4444/wd/hub";
			RemoteWebDriver driver = new RemoteWebDriver(new URL(remoteUrl),caps);
			ChromeOptions options = new ChromeOptions();
    		options.addArguments("start-maximized");
    		options.addArguments("--disable-blink-features=AutomationControlled");
    		options.addArguments("--disable-notifications");
    		driver = new ChromeDriver(options);
			return driver;
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			String remoteUrl = "http://172.19.168.101:4444/wd/hub";
			RemoteWebDriver driver = new RemoteWebDriver(new URL(remoteUrl),caps);
			return driver;
		}
		return null;
	}
}
