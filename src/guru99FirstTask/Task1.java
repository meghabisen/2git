package guru99FirstTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		// Home page title
		String Title =driver.getTitle();
		System.out.println("The Title of page is:"+ Title);
		System.out.println("Megha");
		
		//Demo Site Title
		WebElement Symbol =driver.findElement(By.xpath("//div[@class='page-title']"));
		//WebElement Symbol =driver.findElement(By.linkText("This is demo site for   "));
		String T=Symbol.getText();
		System.out.println("Title1 is:"+T);
		
		//Click On Mobile
		driver.findElement(By.xpath("//a[@class='level0 '][.='Mobile']")).click();
		
		//Title of mobile page
		String Title1= driver.getTitle();
		System.out.println("The title of next page is:"+ Title1);
		
		WebElement obj = driver.findElement(By.xpath("//select[@title='Sort By']"));
		Select S = new Select(obj);
		S .selectByVisibleText("Name");

	}

}
