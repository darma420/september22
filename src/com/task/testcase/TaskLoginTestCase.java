package com.task.testcase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.task.helper.Xlutility;
import com.task.testpage.TaskPage;
public class TaskLoginTestCase {
	public static WebDriver driver;
	Xlutility xl = new Xlutility();
   // LoginPage page;
	TaskLoginTestCase() {
		System.setProperty("webdriver.chrome.driver","E:\\ASSIGN\\New folder (12)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
        driver.get("http://52.172.14.78:2017/Uniserve-Web/fortunetech/LogInAction.do");

	}
	@Test
	public void login() throws Exception {
		String Output_excel = "./xlfolder/datasource1.xls";
		int rowcount = xl.getRowCount(Output_excel, "Sheet1");
		for(int i=1;i<=23;i++){
		String username = xl.readExcel12(0, 1);
		String password = xl.readExcel12(1, 1);
	 	String date = xl.readExcel12(2, i);

		String description = xl.readExcel12(3, i);
		String client = xl.readExcel12(4, 1);
		String client1 = xl.readExcel12(5, 1);
		String description1 = xl.readExcel12(6, 1);

		String crname = xl.readExcel12(7, 1);
		String stageName = xl.readExcel12(9, 1);
		TaskPage page = PageFactory.initElements(driver,
				TaskPage.class);
		
		page.test(driver, username, password,date,description,client,client1,description1,crname,stageName);
	}
	}
	public static WebDriver getDriver() {
		return driver;
	}
		 
}
