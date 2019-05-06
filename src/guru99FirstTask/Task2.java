package guru99FirstTask;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Task2 {
	WebDriver driver;
  @Test
  public void test() {
	  String TitlePage=driver.getTitle();
	  System.out.println("The Title of page is:"+ TitlePage);
	  
	 String T1= driver.findElement(By.xpath("//div[@class='page-title']")).getText();
	 System.out.println("Tagline of homepage is:"+ T1);
	 
	 driver.findElement(By.xpath("//a[@class='level0 ']")).click();
	 System.out.println("Click on mobile");
	 
	 String price=driver.findElement(By.xpath("//span[@class='price']")).getText();
	 System.out.println("The price of sony xperia is :"+price);
	 
	 driver.findElement(By.xpath("//a[@title='Sony Xperia']")).click();
	 System.out.println("Click on sonyXperia");
	 
	 String Rate=driver.findElement(By.xpath("//span[@class='price']")).getText();
	 System.out.println("The price of sony in detail pg:"+ Rate);
	 
	 if(price.equals(Rate))
	 {
		 System.out.println("The price of Sony is same $100");
	 }
	 else
	 {
		 System.out.println("The price are miss match");
	 }
  }
  @BeforeMethod
  public void cookiePath() {
	 Set<Cookie> Cookies = driver.manage().getCookies();
	 for (Cookie Cookie: Cookies)
	 {
		 System.out.println("The Path of cookie is:"+ Cookie.getPath());
	 }
  }

  @AfterMethod
  public void screenshot() {
	  System.out.println("Capture Screen Shot");
  }

  @BeforeClass
  public void maximize() {
	  driver.manage().window().maximize();
	  System.out.println("Browser maximize succesfully");
	  
  }

  @AfterClass
  public void deleteallCookie() {
	  System.out.println("Cookies are deleted");
  }

  @BeforeTest
  public void url() {
	  driver.get("http://live.guru99.com/");
	  System.out.println("Guru99 Open");
  }

  @AfterTest
  public void closeconnection() {
	  System.out.println("Connections are close");
  }

  @BeforeSuite
  public void openBrowser() {
	
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
     driver = new ChromeDriver();
	  System.out.println("Chrome Browser open");
  }

  @AfterSuite
  public void quite() {
	  System.out.println("Close the driver");
	  
  }

}
