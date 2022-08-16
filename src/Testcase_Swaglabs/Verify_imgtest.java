package Testcase_Swaglabs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjetRepository_Swaglabs.Homepage;
import ObjetRepository_Swaglabs.LoginRepo;
import Utility.Utility_Swaglabs;

public class Verify_imgtest extends Utility_Swaglabs {
	

	
	LoginRepo login=new LoginRepo();
	Homepage home = new Homepage();
	
	ArrayList<String> username=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet3",0);

	ArrayList<String> password=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet3",1) ;
	
	ArrayList<String> Name=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet4",0);
	
	@Test (priority = 1)
	public void  initbrowser(){
		driversetting();
	}
	@Test (priority = 2)
	public void  login(){
		starttestcase("verify list of product");
		ArrayList<String> actuallist=new ArrayList<String>();
  for(int i=0;i<=username.size();i++){
			  
			  elementfinder(login.username).sendKeys(username.get(i));
			  elementfinder(login.password).sendKeys(password.get(i));
			  elementfinder(login.loginkey).click();
			  
			  markstatus("info","Testing of list with the user- "+username.get(i));
			  List<WebElement> allproduct=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
				for(int j=0;j<allproduct.size();j++){
				
					String temp=allproduct.get(j).getText();
					actuallist.add(temp);
					
				}
				
				for(int a=0;a<Name.size();a++){
					compare(Name.get(a),actuallist.get(a),"product displayed successfuly -"+actuallist.get(a),
							"product displayed not successfuly -"+actuallist.get(a)	);
				
				}
				 elementfinder(home.menu).click();
				  elementfinder(home.logout).click();
				actuallist.clear();

			  
  }
		driver.close();	  
	}
}
