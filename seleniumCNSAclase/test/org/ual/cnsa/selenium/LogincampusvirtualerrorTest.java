package org.ual.cnsa.selenium;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LogincampusvirtualerrorTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException{
	// Browser selector 
	int browser = 2; // 0: firefox, 1: chrome,...
	Boolean headless = false;
	
	switch (browser) {
	case 0:  // firefox
		// Firefox 
		// Descargar geckodriver de https://github.com/mozilla/geckodriver/releases
		// Descomprimir el archivo geckodriver.exe en la carpeta drivers

		System.setProperty("webdriver.gecko.driver",  "drivers/geckodriver.exe");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		if (headless) firefoxOptions.setHeadless(true);
		driver = new FirefoxDriver(firefoxOptions);
		
		break;
	case 1: // chrome
		// Chrome
		// Descargar Chromedriver de https://chromedriver.chromium.org/downloads
		// Descomprimir el archivo chromedriver.exe en la carpeta drivers

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		if (headless) chromeOptions.setHeadless(true);
		chromeOptions.addArguments("window-size=1920,1080");
		driver = new ChromeDriver(chromeOptions);
		
		break;

  case 2: // remote
    // Remote
		FirefoxOptions firefoxOptions2 = new FirefoxOptions();
		if (headless) firefoxOptions2.setHeadless(true);
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions2);

    break;

	default:
		fail("Please select a browsereeer....");
		break;
	}
	
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void logincampusvirtualerror() {
    // Test name: login-campus-virtual-error
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://www.ual.es/");
    // 2 | setWindowSize | 842x633 | 
    driver.manage().window().setSize(new Dimension(842, 633));
    // 3 | click | linkText=Campus on-line | 
    driver.findElement(By.linkText("Campus online")).click();
    // 4 | click | linkText=Acceso a Campus Virtual | 
    driver.findElement(By.linkText("Acceso a campus virtual")).click();
    // 5 | click | linkText=Login |
    {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
    }
    driver.findElement(By.linkText("Login")).click();
    // 6 | click | name=ssousername | 
    driver.findElement(By.name("ssousername")).click();
    // 7 | type | name=ssousername | pepito
    driver.findElement(By.name("ssousername")).sendKeys("pepito");
    // 8 | type | name=password | pepito
    driver.findElement(By.name("password")).sendKeys("pepito");
    // 9 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
    // 10 | verifyText | css=.alert | Ha introducido un usuario y password incorrecto
    assertThat(driver.findElement(By.cssSelector(".alert")).getText(), is("Ha introducido un usuario y password incorrecto"));
    // 11 | assertElementPresent | css=.alert | 
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".alert"));
      assert(elements.size() > 0);
    }
  }
}
