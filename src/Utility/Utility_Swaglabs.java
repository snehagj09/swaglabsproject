package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Utility_Swaglabs {

	public WebDriver driver;

	public ExtentHtmlReporter htmlreporter;

	public ExtentReports report;

	public ExtentTest logger;

	 
	  String browsername ;
	  String applicationlink;
	String timestamp=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

	             

	              public void driversetting(){
	            	  
	            	
					try {
						FileInputStream fs = new FileInputStream("D:\\selenium\\setup\\textexcel\\BrowserLink_SwgLabs.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(fs);
					XSSFSheet sheet = workbook.getSheet("Sheet1");
					XSSFRow row = sheet.getRow(1);
					browsername=row.getCell(0).getStringCellValue();
					 applicationlink = row.getCell(1).getStringCellValue();
	            	  workbook.close();
	            	  fs.close();
	               	  } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	  
	            	  if(browsername.equalsIgnoreCase("chrome")){
	            		  System.setProperty("webdriver.chrome.driver","D:\\selenium\\setup\\chromedriver file\\chromedriver.exe" );
	            		  driver=new ChromeDriver();
	            	  }
	            	  else if(browsername.equalsIgnoreCase("Firefox")){
	            		  
	            	  }

	                          
	                           driver.manage().window().maximize();

	                           driver.manage().timeouts().implicitlyWait(5,TimeUnit.MINUTES);

	                           //driver.get("https://www.facebook.com/");

	                           //driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

	                           //driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

	                           //driver.get("https://www.irctc.co.in/nget/train-search");
	                           driver.get(applicationlink);

	              }

	public WebElement elementfinder(By objby){

	              WebElement temp=driver.findElement(objby);

	              return temp;

	}

	public ArrayList<String> dataread(String filepath,String Sheetname,int cellno){

	ArrayList<String> obja=new   ArrayList<String>();

	try{

	              FileInputStream fs=new FileInputStream(filepath);

	              XSSFWorkbook workbook=new XSSFWorkbook(fs);

	              XSSFSheet objsheet=workbook.getSheet(Sheetname);

	              int rowcount=objsheet.getLastRowNum();

	              for(int i=1;i<=rowcount;i++){

	                           XSSFRow row=objsheet.getRow(i);

	                           String temp=row.getCell(cellno).getStringCellValue();

	                           obja.add(temp);//saving value in arraylist

	              }

	             

	              workbook.close();

	              fs.close();

	}catch(Exception e){

	              e.printStackTrace();

	}

	return obja;

	}

	@BeforeSuite

	public void init(){

	              htmlreporter=new ExtentHtmlReporter("D:\\selenium\\setup\\ExtentReports\\SampleReport"+timestamp+".html");

	             

	              report =new ExtentReports();

	 

	              report.attachReporter(htmlreporter);

	}

	public void starttestcase(String testcasename){

	              logger=report.createTest(testcasename);

	}

	public void markstatus(String statusname,String description){

	              if (statusname.equalsIgnoreCase("pass")){

	                           logger.log(Status.PASS,description);

	              }

	              else if(statusname.equalsIgnoreCase("Fail")){

	                           logger.log(Status.FAIL,description);

	              }

	              else if(statusname.equalsIgnoreCase("Info")){

	                           logger.log(Status.INFO,description);}}

	 

	public void compare(String expected,String actual, String passmessage,String failmessage){

	              if(expected.equals(actual)){

	                           markstatus("PASS", passmessage);

	              }

	              else{

	                           markstatus("FAIL", failmessage);

	}}

	@AfterSuite

	public void endreport(){

	              report.flush();

	}

	             

}
