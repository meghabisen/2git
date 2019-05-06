package guru99FirstTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task5 {
  @Test
  public void f() throws InterruptedException 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://live.guru99.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[@class='label']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//div[@class='links']/ul/li/a")).click();
	  driver.findElement(By.xpath("//a[@title='Create an Account']/span/span")).click();
	  // Login details
	  
	  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Megha");
	  driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("K");
	  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Bisen");
	  driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("bisenmegha@gmail.com");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("megha@123");
	  driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("megha@123");
	  driver.findElement(By.xpath("//button[@title='Register']/span/span")).click();
	  System.out.println("Registration is done");
	  // confirm registration
	  driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[@class='label']")).click();
	  driver.findElement(By.xpath("//div[@class='links']/ul/li/a")).click();
	  driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("bisenmegha@gmail.com");
	  driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("megha@123");
	  driver.findElement(By.xpath("//button[@name='send']")).click();
	  System.out.println("Login in website");
	  //driver.switchTo().alert().dismiss();
	  String Msg = driver.findElement(By.xpath("//p[@class='welcome-msg']")).getText();
	  System.out.println("Registration is done:"+ Msg);
	  
	  // Click on TV 
	  
	  driver.findElement(By.xpath("//li[@class='level0 nav-2 last']/a")).click();
	  driver.findElement(By.xpath("//li[@class='item last']/div/div[3]/ul/li/a[.='Add to Wishlist']")).click();
	  driver.findElement(By.xpath("//button[@name='save_and_share']/span/span")).click();
	  driver.findElement(By.xpath("//textarea[@name='emails']")).sendKeys("meghabisen14@gmail.com,avni@gmail.com");
	  driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("How's my choice");
	  driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
	  boolean image=driver.findElement(By.xpath("//td[@class='wishlist-cell0 customer-wishlist-item-image']/a")).isDisplayed();
	  System.out.println("Lcd display:"+image);
	  if(image==true)
	  {
		  System.out.println("Expected wishlist shared successfully");
	  }
	  else
	  {
		  System.out.println("Expected wishlist is NOT shared successfully");
	  }
	  
	  
}
}
