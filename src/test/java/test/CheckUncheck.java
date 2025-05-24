package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckUncheck {

	@Test
	public void check() {
		// Launch Chrome
		WebDriver driver = new ChromeDriver();

		// go to url
		driver.get("https://the-internet.herokuapp.com/");

		// to maximize the screen
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(Duration.ofseconds(10));

		// open checkboxes
		WebElement CheckBox = driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a"));
		CheckBox.click();

		// Verify Heading Checkboxes
		WebElement VerifyHeading = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		String textMessage = VerifyHeading.getAccessibleName();
		Assert.assertEquals(VerifyHeading, "Checkboxes");
		

		// Click Checkbox1
		WebElement CheckBox1 = driver.findElement(By.xpath("/*[@id='checkboxes']/input[1]\n"));
		CheckBox1.click();

		// Uncheck Checkbox2
		WebElement CheckBox2 = driver.findElement(By.xpath("//*[@id=‘checkboxes’]/input[2]"));
		CheckBox2.click();

	}
}