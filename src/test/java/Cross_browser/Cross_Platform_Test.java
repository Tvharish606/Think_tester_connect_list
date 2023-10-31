package Cross_browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Cross_Platform_Test
{
	WebDriver driver;
	ChromeOptions chromeoptions=new ChromeOptions();
	FirefoxOptions firefoxoptions=new FirefoxOptions();
	@Parameters("browser")
	@BeforeTest
	public void initalize(String browser)
	{
	if(browser.equalsIgnoreCase("chrome"))
		{
		System.out.println("chrome_browser_laucnhed");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();		
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.out.println("firefox_browser_laucnhing");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
	}
	@Test
		public void connent_app_log() 
	  {
		  driver.get("https://thinking-tester-contact-list.herokuapp.com");
		  System.out.println(driver.getTitle());
	  }
	@AfterTest
	public void tear_down()
	{
		driver.close();
	}
	}
