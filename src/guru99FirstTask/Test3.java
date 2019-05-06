package guru99FirstTask;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Test3 {
	WebDriver driver;
  @Test
  public void taskComplited() 
  {
	  driver.findElement(By.xpath("//a[@class='level0 ']")).click();
	  driver.findElement(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']/li/div/div[3]/button/span")).click();
	  driver.findElement(By.xpath("//td[@class='product-cart-actions']/input")).sendKeys("1000");
	  driver.findElement(By.xpath("//td[@class='product-cart-actions']/button/span")).click();
	String Text =  driver.findElement(By.xpath("//td[@class='product-cart-info']/p")).getText();
	System.out.println("The error msg is:"+ Text);
	driver.findElement(By.xpath("//td[@class='a-right cart-footer-actions last']/button[@id='empty_cart_button']/span/span")).click();
	String Title =driver.findElement(By.xpath("//div[@class='page-title'] ")).getText();
	System.out.println("The page title is:"+ Title);
	  
  }
  @BeforeMethod
  public void beforeMethod()  
   { 
	  Set <Cookie> Cookies =driver.manage().getCookies();
	  for(Cookie Cookie : Cookies)
	  {
		  System.out.println("The name of cookie is:"+Cookie.getName());
	  }
	  
	   }

  @AfterMethod
  public void afterMethod() throws IOException {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("E:\\MEGHA\\CJC new\\Megha Eclips\\guru99\\SCrn"));
 
  }

  @BeforeClass
  public void beforeClass() {
	  driver.manage().window().maximize();
	  System.out.println("Maximize the browser");
  }

  @AfterClass
  public void afterClass() {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void beforeTest() 
  {
	  driver.get("http://live.guru99.com/");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Close db connection");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
      driver = new ChromeDriver();
  }

  @AfterSuite
  public void afterSuite() {
	 // driver.close();
  }

}
