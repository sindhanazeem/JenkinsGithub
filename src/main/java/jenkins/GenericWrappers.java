package jenkins;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers{
	//To use driver object in all the methods
    //Driver can be Firefox or Chrome. So RemoteWebDriver used as common instead of ChromeDriver class
	RemoteWebDriver driver; 
     
	int i=1;
	public String s;
	public void invokeApp(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		takeSnap();
		System.out.println("The browser:" + browser + " launched successfully");

	}


	public void enterById(String idValue, String data) {
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);	
		takeSnap();
		System.out.println("The data: "+data+" entered successfully in field :"+idValue);		
	}


	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
    driver.findElementByName(nameValue).clear();
    driver.findElementByName(nameValue).sendKeys(data);
    takeSnap();
    System.out.println("The data: "+data+" entered successfully in field :"+nameValue);		
	}


	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath(xpathValue).clear();
		driver.findElementByXPath(xpathValue).sendKeys(data);
	    takeSnap();
	    System.out.println("The data: "+data+" entered successfully in field :"+xpathValue);		
		}


	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
         String s=driver.getTitle();
		if(title.equalsIgnoreCase(s))
		{
			System.out.println("The given title "+title+"matches with the page title "+s);
		}
		else
		{
			System.out.println("The given title "+title+" doesnt match with the page title "+s);
		
		}
	}


	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		
		String varText=driver.findElementById(id).getText();
		
		if(varText.equalsIgnoreCase(text))
		{
			System.out.println("The given text "+text+" matches with the page text "+varText);

		}
		else
		{
			System.out.println("The given text "+text+" doesnt match with the page text "+varText);
		}
	}


	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

String s=driver.findElementByXPath(xpath).getText();
		
		if(s.equalsIgnoreCase(text))
		{
			System.out.println("The given text "+text+" matches with the page text "+s);

		}
		else
		{
			System.out.println("The given text "+text+" doesnt match with the page text "+s);
		}
	}


	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
       String s=driver.findElementByXPath(xpath).getText();
		
		if(s.contains(text))
		{
			System.out.println("The given text "+text+" matches with the page text "+s);

		}
		else
		{
			System.out.println("The given text "+text+" doesnt match with the page text "+s);
		}
		
        takeSnap();
	}


	public void clickById(String id) {
		// TODO Auto-generated method stub
		driver.findElementById(id).click();
		takeSnap();
		System.out.println("The element with Id: "+id+" is clicked.");
	

	}


	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		takeSnap();
		System.out.println("The element with class Name: "+classVal+" is clicked.");
	}


	public void clickByName(String name) {
		// TODO Auto-generated method stub
		driver.findElementByName(name).click();
		takeSnap();
		System.out.println("The button with class Name: "+name+" is clicked.");

	}


	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		driver.findElementByLinkText(name).click();
		takeSnap();
		System.out.println("The Link with Link Text: "+name+" is clicked.");
		

	}


	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		driver.findElementByLinkText(name).click();
	
		System.out.println("The Link with Link Text: "+name+" is clicked.");
		


	}


	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		takeSnap();
      driver.findElementByXPath(xpathVal).click();
      
      try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("The Link with Xpath: "+xpathVal+" is clicked.");
	}


	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).click();
		
	    System.out.println("The Link with Xpath: "+xpathVal+" is clicked No Snap.");
		
	}


	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String s=driver.findElementById(idVal).getText();
		takeSnap();
		System.out.println("The text received is: "+s+" ");
		
		return null;
	}


	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		s=driver.findElementByXPath(xpathVal).getText();
		
		System.out.println("The text received is: "+s+" ");
		
		
		return null;
	}


	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		/* 
		 WebElement objWebEle=driver.findElementById(id);
		 Select objSelect = new Select(objWebEle);
		 objSelect.selectByVisibleText(value);
		 
		 			OR		*/
		 
		Select objSelect = new Select(driver.findElementById(id));
		objSelect.selectByVisibleText(value);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		takeSnap();
		System.out.println("The Drop down with id "+id+" and Visible text "+value+" is selected");
	}


	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		Select objSelect = new Select(driver.findElementById(id));
		objSelect.selectByIndex(value);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		takeSnap();
		System.out.println("The Drop down with id "+id+" and index "+value+" is selected");
	
	}


	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		Set <String> varWinHandle=driver.getWindowHandles();
		//String varWinHandle=driver.getWindowHandle();
		//driver.switchTo().window(varWinHandle);
		for (String varForEach : varWinHandle) {
			driver.switchTo().window(varForEach);
			break;
		}
		//takeSnap();
		System.out.println(driver.getCurrentUrl());
		System.out.println("The Parent window is selected");
	}


	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		Set <String> varWinHandle=driver.getWindowHandles();
		
		for (String varForEach : varWinHandle) {
			driver.switchTo().window(varForEach);
			System.out.println(varForEach);
			
		}
		takeSnap();
		System.out.println(driver.getCurrentUrl());
		System.out.println("The Last window is selected");
		
	}


	public void acceptAlert() {
		// TODO Auto-generated method stub
		//takeSnap();
		//Alert objAlert=driver.switchTo().alert();
		//objAlert.accept();
		//System.out.println("In Alert window");
		//driver.switchTo().alert().accept();
		//System.out.println("OK button is clicked");

		Alert alt=driver.switchTo().alert();
		alt.accept();
		System.out.println("In Alert window");
		takeSnap();
	}


	public void dismissAlert() {
		// TODO Auto-generated method stub
		takeSnap();
		driver.switchTo().alert().dismiss();
		System.out.println("Cancel button is clicked");

	}


	public String getAlertText() {
		// TODO Auto-generated method stub
		String alertText=driver.switchTo().alert().getText();
		System.out.println("The alert Text displayed is "+alertText);
		takeSnap();
		return null;
	}


	public void takeSnap() {
		// TODO Auto-generated method stub
		
		File objsrc=driver.getScreenshotAs(OutputType.FILE);
		File dest= new File("./snaps/snap"+i+".jpg");
		i++;
		try {
			FileUtils.copyFile(objsrc, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void closeBrowser() {
		driver.close();
		System.out.println("The browser is closed");
		takeSnap();
	}


	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();
		takeSnap();
		System.out.println("All the browsers are closed");
		

	}

}