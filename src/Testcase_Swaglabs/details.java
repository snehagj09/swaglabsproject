package Testcase_Swaglabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class details {
	WebDriver driver;
	
	public void driversetting(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\setup\\chromedriver file\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	public void navigate(){
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
		List<WebElement> detailproduct=driver.findElements(By.xpath("//div[@class='inventory_details_desc_container']"));
		for(int j=0;j<detailproduct.size();j++){
		
			String temp=detailproduct.get(j).getText();
			System.out.println(temp);
		}
	
	
	}
	public static void main (String args[]){
		Img_name I = new Img_name();
		I.driversetting();
		
		I.navigate();

	}
	
}
