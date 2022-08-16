package Testcase_Swaglabs;

import org.testng.annotations.Test;
import java.util.ArrayList;

import org.testng.annotations.Test;

import ObjetRepository_Swaglabs.LoginRepo;
import ObjetRepository_Swaglabs.NegativetestCase;
import Utility.Utility_Swaglabs;

public class Negativetestcase01 extends Utility_Swaglabs{

	LoginRepo login=new LoginRepo();
	NegativetestCase negcase=new NegativetestCase();
	ArrayList<String> username=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet2",0);

	ArrayList<String> password=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet2",1) ;
	
	
	String expoerror="Epic sadface: Sorry, this user has been locked out.";
	@Test (priority = 1)
	public void  initbrowser(){
		driversetting();
	}
	
	
	@Test (priority = 2)
	public void login(){
	
		starttestcase("Login with negative scenario");
		  for(int i=0;i<=username.size();i++){
			  
			  elementfinder(login.username).sendKeys(username.get(i));
			  elementfinder(login.password).sendKeys(password.get(i));
			  elementfinder(login.loginkey).click();
		  
		  String actualerror=elementfinder(negcase.negmsg).getText();
		  compare(expoerror, actualerror, "Negative case pass - "+username.get(i), "Negcase failed  - " +username.get(i));
		}
		  driver.close();
	}
}
