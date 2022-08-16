package Testcase_Swaglabs;

import java.util.ArrayList;

import org.testng.annotations.Test;

import ObjetRepository_Swaglabs.LoginRepo;
import ObjetRepository_Swaglabs.Homepage;
import ObjetRepository_Swaglabs.LoginRepo;
import ObjetRepository_Swaglabs.Productdetails;
import Utility.Utility_Swaglabs;

public class Verifydetailsofproduct_04 extends  Utility_Swaglabs{
	LoginRepo login=new LoginRepo();
	Homepage home = new Homepage();
	Productdetails objproductdetailsrepo=new Productdetails();
	ArrayList<String> username=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet3",0);

	ArrayList<String> password=dataread("D:\\selenium\\setup\\textexcel\\Swag_labs.xlsx","Sheet3",1) ;
	
ArrayList<String> productdetailsexp=dataread("D:\\selenium\\setup\\testexcel\\Swag_labs.xlsx","Sheet5",0);
	
	ArrayList<String> productdetailsactual=new ArrayList<String>();
	
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
			  
			
			markstatus("info","Testing product details with user - "+username.get(i));
			elementfinder(home.backpack).click();
			
	productdetailsactual.add(elementfinder(objproductdetailsrepo.productname).getText());
	productdetailsactual.add(elementfinder(objproductdetailsrepo.description).getText());
	productdetailsactual.add(elementfinder(objproductdetailsrepo.productcost).getText());
	
	for(int j=0;j<productdetailsexp.size();j++){
		compare(productdetailsexp.get(j),productdetailsactual.get(j),
				"The Value is displayed correctly - "+productdetailsactual.get(j),
				"The Value is displayed not correctly - "+productdetailsactual.get(j));
	}
	productdetailsactual.clear();
	 elementfinder(home.menu).click();
	  elementfinder(home.logout).click();
	}
	driver.close();
	}

}
