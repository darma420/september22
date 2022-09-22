package com.task.testpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.task.helper.Xlutility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TaskPage {
	public static ExtentReports report;
	public static ExtentTest logger;
	WebDriver driver;
	@FindBy(xpath="//h4[normalize-space(text())='Mobility users']")
    WebElement mobilityUser;
	@FindBy(xpath=".//*[@id='username']")
    WebElement userName;
	@FindBy(xpath=".//*[@id='password']")
    WebElement passWord;
	@FindBy(xpath="//input[@class='loginbt']")
    WebElement login;
	@FindBy(xpath="//a[normalize-space(text())='New task']")
    WebElement newTask;
	@FindBy(xpath=".//*[@id='datetimepickerInPopUp']")
    WebElement currentDate;
	@FindBy(xpath=".//*[@id='divNewTask']/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[1]/div/div[1]/table/tbody/tr[5]/td[5]")
    WebElement timeDate;
	@FindBy(xpath=".//*[@id='clientComboId1']")
    WebElement clientName;
	@FindBy(xpath=".//*[@id='projectComboId1']")
    WebElement projectName;
	@FindBy(xpath=".//*[@id='lobComboId1']")
    WebElement lineOfBusiness;
	@FindBy(xpath="//select[@id='CRComboId1']")
    WebElement crName;
	@FindBy(xpath=".//*[@id='TaskComboId1']")
    WebElement taskType;
	@FindBy(xpath=".//*[@id='SubTaskComboId1']")
    WebElement subTaskType;
	@FindBy(xpath=".//*[@id='taskDesc1']")
    WebElement description;
	@FindBy(xpath=".//*[@id='UserType']")
    WebElement userType;
	@FindBy(xpath=".//*[@id='DeliveryType']")
    WebElement deliverType;
	@FindBy(xpath=".//*[@id='Complexity']")
    WebElement complexity;
	@FindBy(xpath=".//*[@id='Quality']")
    WebElement quality;
	@FindBy(xpath=".//*[@id='TAT']")
    WebElement tat;
	@FindBy(xpath=".//*[@id='hoursSpent1']")
    WebElement minuteSpent;
	@FindBy(xpath="//select[@id='AssignedUserComboId1']")
    WebElement reportedTo;
	@FindBy(xpath=".//*[@id='AssignedUserComboId1']")
    WebElement reportTo;
	@FindBy(xpath=".//*[@id='activityStatusComboId1']")
    WebElement activityStatus;
	@FindBy(xpath="//button[@onclick='saveNewTask()']")
    WebElement saveNext;
	@FindBy(xpath="//button[normalize-space(text())='Draft']")
    WebElement draft;
	@FindBy(xpath=".//*[@id='dcheckAll']")
    WebElement checkAll;
	@FindBy(xpath="//a[normalize-space(text())='Submit']")
    WebElement submit;
	@FindBy(xpath="//*[@id='bs-example-navbar-collapse-1']/ul[4]/li/a/b")
    WebElement signOut;
	@FindBy(xpath="//*[@id='bs-example-navbar-collapse-1']/ul[4]/li/ul/li[4]/a")
    WebElement logOut;
	@FindBy(xpath="//*[@id='divNewTask']/div[2]/div/div[3]")
    WebElement dateLeft;
	@FindBy(xpath="//select[@id='CRComboId1']")
    WebElement crname;
	@FindBy(xpath="//select[@id='StageComboId1']")
    WebElement stage;
	@FindBy(xpath="//img[@src='../images/ModuleImages/Task-Management.png']")
    WebElement taskManagement;

	
	public   TaskPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	public void test(WebDriver driver,String username,String password,String date,String option,String client,String client1,String description1,String crname,String stageName)throws Exception
	{
		try{
		Thread.sleep(4000);
		System.out.println("pooooooooooooooo");
		userName.sendKeys(username);
		passWord.sendKeys(password);
		Thread.sleep(2000);
		login.click();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath(".//*[@id='forceRadio']"))
				.size() > 0) {
			driver.findElement(By.xpath("//input[@name='Submit']"))
					.click();
			Thread.sleep(1000);
			userName.sendKeys(username);
			passWord.sendKeys(password);
			login.click();
			/*driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@class='loginbt']")).click();*/
			Thread.sleep(1500);
		}
		Thread.sleep(1500);
		driver.switchTo().frame(0);
		Thread.sleep(1500);
		/*taskManagement.click();
		Thread.sleep(1500);
		driver.switchTo().frame(0);
		Thread.sleep(1500);*/
		for(int i=1;i<=4;i++)
		{
		newTask.click();
		Thread.sleep(1500);
		currentDate.click();
		Thread.sleep(1000);
		dateLeft.click();
		dateLeft.click();
		dateLeft.click();
		Thread.sleep(1000);
		//currentDate.clear();
		Thread.sleep(1000);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		currentDate.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1500);
		currentDate.sendKeys(date);
		Thread.sleep(2500);
		Select entity = new Select(clientName);
		entity.selectByValue(client);
		Thread.sleep(2500);
		//entity.selectByVisibleText(client);
		/*Select entity17 = new Select(projectName);
		entity17.selectByValue("38");
		Thread.sleep(2000);*/
		Select entity1 = new Select(lineOfBusiness);
		entity1.selectByValue("11");
		//entity1.selectByValue("3");
		Thread.sleep(1500);
		/*Select entity18 = new Select(crName);
		entity18.selectByVisibleText(crname);
		Thread.sleep(1500);
		Select entity1008 = new Select(stage);
		entity1008.selectByVisibleText(stageName);
		Thread.sleep(500);
*/		Select entity2 = new Select(taskType);
		entity2.selectByValue("93");
		Thread.sleep(500);
		Select entity3 = new Select(subTaskType);
		entity3.selectByValue("562");
		Thread.sleep(2000);
		description.sendKeys(option);
		Thread.sleep(500);
		Select entity4 = new Select(userType);
		entity4.selectByValue("1");
		Thread.sleep(500);
		Select entity5 = new Select(deliverType);
		entity5.selectByValue("Sequential");
		Thread.sleep(500);
		Select entity6 = new Select(complexity);
		entity6.selectByValue("5");
		Thread.sleep(500);
		Select entity7 = new Select(quality);
		entity7.selectByValue("5");
		Thread.sleep(500);
		Select entity8 = new Select(tat);
		entity8.selectByValue("5");
		Thread.sleep(500);
		minuteSpent.sendKeys("120");
		/*Thread.sleep(500);
		Select entity83 = new Select(reportTo);
		entity83.selectByValue("182");
*/		Thread.sleep(1000);
		Select entity9 = new Select(activityStatus);
		entity9.selectByValue("InProgress");
		Thread.sleep(1500);
		saveNext.click();
		Thread.sleep(4000);
		}
		Thread.sleep(5000);
		draft.click();
		Thread.sleep(4000);
		checkAll.click();
		Thread.sleep(3500);
		submit.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		signOut.click();
		Thread.sleep(500);
		logOut.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
