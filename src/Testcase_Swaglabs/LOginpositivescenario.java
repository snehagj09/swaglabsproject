package Testcase_Swaglabs;

import org.testng.annotations.Test;
import java.util.ArrayList;

import org.testng.annotations.Test;

import ObjetRepository_Swaglabs.Homepage;
import ObjetRepository_Swaglabs.LoginRepo;
import Utility.Utility_Swaglabs;

public class LOginpositivescenario extends Utility_Swaglabs {
	
	LoginRepo login=new LoginRepo();
	Homepage home = new Homepage();
	
	ArrayList<String> username=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet3",0);

	ArrayList<String> password=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet3",1);
	String exphomeurl="https://www.saucedemo.com/inventory.html";
	String explogurl="https://www.saucedemo.com/";

	
	@Test (priority = 1)
	public void  initbrowser(){
		driversetting();
	}
	
	
	@Test (priority = 2)
	public void login(){
	
		starttestcase("Login positive scenario");
		  for(int i=0;i<=username.size();i++){
			  
			  elementfinder(login.username).sendKeys(username.get(i));
			  elementfinder(login.password).sendKeys(password.get(i));
			  elementfinder(login.loginkey).click();
			  
			  String actualurl= driver.getCurrentUrl();
				compare(exphomeurl, actualurl, "login successfull with user - "+username.get(i), "login failed user - " +username.get(i));
			  
				
			  elementfinder(home.menu).click();
			  elementfinder(home.logout).click();
			  String actualurl2= driver.getCurrentUrl();
				compare(explogurl, actualurl2, "logout successfull with user - "+home.logout, "logout failed user - " +home.logout);
		  }

		  driver.close();
	}
	
	
	
}
