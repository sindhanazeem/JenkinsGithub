package jenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstProgram {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	@Test
	public void jenkinsMethod(){
		//Launch the Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Instantiate the Object
		ChromeDriver driver=new ChromeDriver();
		
		//Load the Url
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		//Enter the Password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click on Login
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click on Logout
		driver.findElementByClassName("decorativeSubmit").click();
	}

}
