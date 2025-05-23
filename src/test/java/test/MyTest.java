package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyTest {

	@Test
	public static void test() {

		// launch chrome
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("https://the-internet.herokuapp.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to maximize the screen
		driver.manage().window().maximize();

		// click Form Authentication
		WebElement formAuthentication = driver.findElement(By.xpath("//*[@id='content']/ul/li[21]/a"));
		formAuthentication.click();

		// fill username
		WebElement usernameField = driver.findElement(By.xpath("//*[@id='username']"));
		usernameField.sendKeys("tomsimth");

		// fill password
		WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']"));
		passwordField.sendKeys("SuperSecretPassword!");

		// click on login
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button/i"));
		loginButton.click();

		// verify text after login
		WebElement textMessage = driver.findElement(By.xpath("//*[@id='content']/div/h2"));
		String verifyHeading = textMessage.getTagName();

		// validate
		if (verifyHeading.equals("Secure Area")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");

		}
		driver.quit();
	}

}
