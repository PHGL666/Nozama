package MAG_002_SUITE;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Constants;
import Utilities.Connexion;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class MAG_002_GLOBAL {
	public static WebDriver driver;
	static Connexion connexion = new Connexion();

	@Test
	public void test() {
		Class[] testClasses = { ParallelChrome.class, ParallelFirefox.class };
		// System.out.println("running multiple classes serially");
		System.out.println("running multiple classes in parallel");
		// System.out.println("running methods in a class in parallel"); MONTE ET DESCEND
		JUnitCore.runClasses(ParallelComputer.classes(), testClasses);
	}

	public static class ParallelChrome {

		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "S:\\TESTEUR INFORMATIQUE\\7_SELENIUM\\Chromedriver.exe");
			driver = new ChromeDriver();
			//js = (JavascriptExecutor) driver;
			//vars = new HashMap<String, Object>();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		@After
		public void tearDown() {
			driver.quit();
		}

// CONNEXION

		@Test
		public void allTestCasesMag002() throws Exception {

			connexion.testConnexion(driver);

			/*
			 * String URL = Constants.URL; driver.get(URL);
			 * 
			 * driver.manage().window().setSize(new Dimension(1024, 1112)); {
			 * List<WebElement> elements =
			 * driver.findElements(By.xpath("//div[@id=\'block-user-0\']/div/h2")); assert
			 * (elements.size() > 0); }
			 * driver.findElement(By.xpath("//input[@id=\'edit-name\']")).click();
			 * driver.findElement(By.xpath("//input[@id=\'edit-name\']")).sendKeys("store1")
			 * ; driver.findElement(By.xpath("//input[@id=\'edit-pass\']")).click();
			 * driver.findElement(By.xpath("//input[@id=\'edit-pass\']")).sendKeys("store1")
			 * ; { List<WebElement> elements =
			 * driver.findElements(By.xpath("//input[@id=\'edit-submit\']")); assert
			 * (elements.size() > 0); }
			 * driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit(); {
			 * List<WebElement> elements = driver
			 * .findElements(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/h2"));
			 * assert (elements.size() > 0); }
			 */
// DEBUT CT MAG_002_N
			/*
			assertThat(driver.findElement(By.xpath("//a[contains(text(),\'Créer un article\')]")).getText(),is("Créer un article"));
			*/
			driver.findElement(By.xpath("//a[contains(text(),\'Créer un article\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Produit\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Produit\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-title\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-title\']")).click();
			driver.findElement(By.xpath("//input[@id=\'edit-title\']")).sendKeys("Gameboy");
			driver.findElement(By.xpath("//input[@id=\'edit-model\']")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-model\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-model\']")).sendKeys("gb");
			driver.findElement(By.cssSelector(".fieldset-wrapper > table:nth-child(2) tr")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-sell-price\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-sell-price\']")).sendKeys("1000");
			driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).click();
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-messages-inner\']/div")).getText(),
					is("Le contenu \'Gameboy\', de type \'Produit\', a été créé."));
// FIN SCENARIO MAG_002_N
			// RETOUR ACCUEIL
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Accueil\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Accueil\')]")).click();
// DEBUT MAG_002_A2 MODIFICATION D'UN PRODUIT
			{
				List<WebElement> elements = driver.findElements(By.cssSelector("#block-menu-menu-shop .title"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver
						.findElements(By.xpath("//a[contains(text(),\'Liste des produits\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Liste des produits\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.linkText("Nom"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Gameboy\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Gameboy\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Modifier\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Modifier\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Produit\')]"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-sell-price\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.cssSelector(".fieldset-wrapper > table:nth-child(2) tr")).click();
			driver.findElement(By.xpath("//input[@id=\'edit-sell-price\']")).click();
			driver.findElement(By.xpath("//input[@id=\'edit-sell-price\']")).sendKeys("60");
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit();
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-messages-inner\']/div")).getText(),
					is("Le contenu \'Gameboy\', de type \'Produit\', a été mis à jour."));
// FIN SCENARIO MAG_002_A2 MODIFICATION D'UN PRODUIT
			// RETOUR ACCUEIL
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Accueil\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Accueil\')]")).click();
// DEBUT SCENARIO MAG_002_A1 SUPPRESSION ARTICLE
			{
				List<WebElement> elements = driver
						.findElements(By.xpath("//a[contains(text(),\'Liste des produits\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Liste des produits\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("(//a[contains(text(),\'Nom\')])[2]"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Gameboy\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Gameboy\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Modifier\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Modifier\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Produit\')]"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-delete\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-delete\']")).click();
			{
				List<WebElement> elements = driver.findElements(By.id("edit-submit"));
				assert (elements.size() > 0);
			}
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-inner-inner\']/h1")).getText(),
					is("Êtes-vous sûr de vouloir supprimer Gameboy ?"));
			driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit();
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-messages-inner\']/div")).getText(),
					is("Le contenu \'Gameboy\', de type \'Produit\', a été supprimé."));
// FIN SCENARIO MAG_002_A1 SUPPRESSION ARTICLE
			// DECONNEXION
			{
				List<WebElement> elements = driver
						.findElements(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/h2"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Se déconnecter\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Se déconnecter\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
				assert (elements.size() > 0);
			}
		}
		// FIN DECONNEXION
	}
// FIN SUITE MAG_002

	public static class ParallelFirefox {
		private WebDriver driver;
		private Map<String, Object> vars;
		JavascriptExecutor js;

		@Before
		public void setUp() {
			System.setProperty("webdriver.gecko.driver", "S:\\TESTEUR INFORMATIQUE\\7_SELENIUM\\geckodriver.exe");
			driver = new FirefoxDriver();
			js = (JavascriptExecutor) driver;
			vars = new HashMap<String, Object>();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		@After
		public void tearDown() {
			driver.quit();
		}

//CONNEXION
		@Test
		public void allTestCasesMag002() throws Exception {
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
				List<WebElement> elements = driver
						.findElements(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/h2"));
				assert (elements.size() > 0);
			}
//DEBUT CT MAG_002_N
			assertThat(driver.findElement(By.xpath("//a[contains(text(),\'Créer un article\')]")).getText(),
					is("Créer un article"));
			driver.findElement(By.xpath("//a[contains(text(),\'Créer un article\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Produit\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Produit\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-title\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-title\']")).click();
			driver.findElement(By.xpath("//input[@id=\'edit-title\']")).sendKeys("Gameboy");
			driver.findElement(By.xpath("//input[@id=\'edit-model\']")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-model\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-model\']")).sendKeys("gb");
			// driver.findElement(By.cssSelector(".fieldset-wrapper > table:nth-child(2)
			// tr")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-sell-price\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-sell-price\']")).sendKeys("1000");
			driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).click();
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-messages-inner\']/div")).getText(),
					is("Le contenu \'Gameboy\', de type \'Produit\', a été créé."));
//FIN SCENARIO MAG_002_N
			// RETOUR ACCUEIL
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Accueil\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Accueil\')]")).click();
//DEBUT MAG_002_A2 MODIFICATION D'UN PRODUIT
			{
				List<WebElement> elements = driver.findElements(By.cssSelector("#block-menu-menu-shop .title"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver
						.findElements(By.xpath("//a[contains(text(),\'Liste des produits\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Liste des produits\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.linkText("Nom"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Gameboy\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Gameboy\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Modifier\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Modifier\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Produit\')]"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-sell-price\']"));
				assert (elements.size() > 0);
			}
			// driver.findElement(By.cssSelector(".fieldset-wrapper > table:nth-child(2)
			// tr")).click();
			driver.findElement(By.xpath("//input[@id=\'edit-sell-price\']")).click();
			driver.findElement(By.xpath("//input[@id=\'edit-sell-price\']")).sendKeys("60");
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit();
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-messages-inner\']/div")).getText(),
					is("Le contenu \'Gameboy\', de type \'Produit\', a été mis à jour."));
//FIN SCENARIO MAG_002_A2 MODIFICATION D'UN PRODUIT
			// RETOUR ACCUEIL
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Accueil\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Accueil\')]")).click();
//DEBUT SCENARIO MAG_002_A1 SUPPRESSION ARTICLE
			{
				List<WebElement> elements = driver
						.findElements(By.xpath("//a[contains(text(),\'Liste des produits\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Liste des produits\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("(//a[contains(text(),\'Nom\')])[2]"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Gameboy\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Gameboy\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Modifier\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Modifier\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Produit\')]"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-delete\']"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//input[@id=\'edit-delete\']")).click();
			{
				List<WebElement> elements = driver.findElements(By.id("edit-submit"));
				assert (elements.size() > 0);
			}
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-inner-inner\']/h1")).getText(),
					is("Êtes-vous sûr de vouloir supprimer Gameboy ?"));
			driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit();
			assertThat(driver.findElement(By.xpath("//div[@id=\'content-messages-inner\']/div")).getText(),
					is("Le contenu \'Gameboy\', de type \'Produit\', a été supprimé."));
//FIN SCENARIO MAG_002_A1 SUPPRESSION ARTICLE
			// DECONNEXION
			{
				List<WebElement> elements = driver
						.findElements(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/h2"));
				assert (elements.size() > 0);
			}
			{
				List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Se déconnecter\')]"));
				assert (elements.size() > 0);
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Se déconnecter\')]")).click();
			{
				List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
				assert (elements.size() > 0);
			}
		}
		// FIN DECONNEXION
	}
//FIN SUITE MAG_002
}
