package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts {
	
	@Test
	public void test() {
		
		 WebDriver driver = new ChromeDriver();
		 driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//go to JavaScript Alerts
		WebElement jcAlerts = driver.findElement(By.linkText("JavaScript Alerts"));
		jcAlerts.click();
		
		// click on JSalert
		WebElement jsAlertButton=driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button"));
		jsAlertButton.click();
		
		//switch screen to alert and accept
		Alert alert =driver.switchTo().alert();
		alert.accept();
		
		//validate message
		WebElement message = driver.findElement(By.id ("result"));
		String msg = message.getText();
		Assert.assertEquals(msg,"You successfully clicked an alert");
		
	driver.quit();
		
		
	}
	@Test
	public void test2(){
		 WebDriver driver = new ChromeDriver();
		 driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//go to JavaScript Alerts
		WebElement jcAlerts = driver.findElement(By.linkText("JavaScript Alerts"));
		jcAlerts.click();
		
		//click on js Confirm
		WebElement jsConfirmButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
		jsConfirmButton.click();
		
		Alert alert =driver.switchTo().alert();
		alert.accept();
		
		//validate message
		String msg = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(msg, "You clicked: Ok");
		
		// to click cancel
	 driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
		
		alert =driver.switchTo().alert();
		alert.dismiss();
		String msg2 = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(msg, "You clicked: Cancel");
		 driver.quit();
		 
		
	}
	@Test
	public void test3() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//go to JavaScript Alert
		WebElement jsAlert=driver.findElement(By.linkText("JavaScript Alerts"));
		jsAlert.click();
		
		//go to JS Prompt
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
		
		//go to alert
		Alert alert  = driver.switchTo().alert();
		alert.sendKeys("passed");
		alert.accept();
		
		String msg = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(msg,"You entered: passed");
		
		
	}
	
	}


