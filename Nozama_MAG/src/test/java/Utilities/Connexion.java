package Utilities;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import Utilities.Constants;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Connexion {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Test
	public void testConnexion(WebDriver driver) throws Exception {
		String URL = Constants.URL;
		driver.get(URL);

		driver.manage().window().setSize(new Dimension(1024, 1112));
		{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'block-user-0\']/div/h2"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.xpath("//input[@id=\'edit-name\']")).click();
		driver.findElement(By.xpath("//input[@id=\'edit-name\']")).sendKeys("store1");
		driver.findElement(By.xpath("//input[@id=\'edit-pass\']")).click();
		driver.findElement(By.xpath("//input[@id=\'edit-pass\']")).sendKeys("store1");
		{
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit();
		{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/h2"));
			assert (elements.size() > 0);
		}
	}


}

