package guru99FirstTask;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task4 {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
	  WebDriver driver =  new ChromeDriver();
	  driver.get("http://live.guru99.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//a[@class='level0 ']")).click();
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("//button[@title='Compare']/span/span")).click();
	  
	  String Mainwindow = driver.getWindowHandle();
	  
	  Set<String> w1=driver.getWindowHandles();
	 Iterator<String> itr = w1.iterator();
	 while(itr.hasNext())
	 {
		 String Childwindow = itr.next();
		 if(!Mainwindow.equalsIgnoreCase(Childwindow))
		 {
			 driver.switchTo().window(Childwindow);
			 driver.manage().window().maximize();
			boolean I1= driver.findElement(By.xpath("//img[@alt='Sony Xperia']")).isDisplayed();
			System.out.println("Sony is avalable:"+I1);
			 boolean I2 =driver.findElement(By.xpath("//img[@alt='IPhone']")).isDisplayed();
			System.out.println("Iphone is available:"+I2);
			
			if (I1==I2==true)
			{
				driver.findElement(By.xpath("//button[@title='Close Window']/span")).click();
				System.out.println("Iphone and sony is display on next comparision window");
			}
			else
			{
				System.out.println("Iphone and sony is NOT display on next comparision window");
			}
			
			 
			 
		 }
		 
		 
		 
		 
		 
		 //driver.switchTo().window(itr.next());
		 //String T1 = driver.getTitle();
		 //System.out.println("The title of page is :"+T1);
	 }
  }
}
