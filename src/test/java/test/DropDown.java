package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown {

	@Test
	public void test() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");

		// open dropdown option
		WebElement dropdownfield = driver.findElement(By.linkText("Dropdown"));
		dropdownfield.click();

		// validate text
		WebElement title = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		String ddtitle = title.getText();

		Assert.assertEquals(ddtitle, "Dropdown list");

		// select dropdown
		WebElement dropdownEle = driver.findElement(By.xpath("//*[@id='dropdown']"));

		Select dropdown = new Select(null);

		// select option
		dropdown.selectByVisibleText("option 1");
		dropdown.selectByValue("2");
		dropdown.selectByIndex(1);

		WebElement option1 = driver.findElement(By.xpath("//*[@id='dropdown']/option[2]"));
		String attributeValue = option1.getDomAttribute("selected");
		Assert.assertEquals(attributeValue, "selected");

		driver.quit();

	}

}
