package com.softwareinstitute.andreeaholban.moviesProject.selenium;// Generated by Selenium IDE
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class SeliniumFilmTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    options.addArguments("disable-gpu");
    //WebDriverManager.chromedriver().setup();
    //driver = new ChromeDriver();
    driver = new ChromeDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void seeMovies() {
    driver.get("http://3.93.172.228:3000/home");
    driver.manage().window().setSize(new Dimension(788, 824));
    driver.findElement(By.cssSelector(".MoviesBox .Drop")).click();
    driver.findElement(By.cssSelector(".MoviesBox > .Header")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Dune")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".Container"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".Container"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".Container"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
  }

  @Test
  public void addDeleteMovie() {
    driver.get("http://3.93.172.228:3000");
    driver.manage().window().setSize(new Dimension(788, 824));
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".LoginButtons:nth-child(4)")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Logged in successfully", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".MoviesBox .Add")).click();
    driver.findElement(By.name("title")).click();
    driver.findElement(By.name("title")).sendKeys("Test add movie");
    driver.findElement(By.name("length")).click();
    driver.findElement(By.name("length")).sendKeys("100");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Saved", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".MoviesBox .Drop")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Test add movie")).click();
    driver.findElement(By.cssSelector(".MovieButtons:nth-child(1)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Deleted", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.close();
  }

  @Test
  public void rateMovie() {
    driver.get("http://3.93.172.228:3000");
    driver.manage().window().setSize(new Dimension(788, 824));
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".MoviesBox .Drop")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Harry Potter")).click();
    driver.findElement(By.cssSelector(".MovieSubheader:nth-child(2) > .RateBox")).click();
    driver.findElement(By.cssSelector(".MovieSubheader:nth-child(2) > .RateBox")).sendKeys("7");
    driver.findElement(By.cssSelector(".MovieSubheader:nth-child(2) > .RateButtons")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String text = driver.findElement(By.cssSelector(".MovieSubheader:nth-child(2) > .Rating")).getText();
    assertEquals("7", text);
    driver.close();
  }

  @Test
  public void addDeleteGenre() {
    driver.get("http://3.93.172.228:3000");
    driver.manage().window().setSize(new Dimension(788, 824));
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".MoviesBox .Drop")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Harry Potter")).click();
    driver.findElement(By.cssSelector(".LoginButtons:nth-child(4)")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Logged in successfully", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".MovieSubheader:nth-child(2) > .MovieLeftButtons:nth-child(2)")).click();
    driver.findElement(By.cssSelector("label > input")).click();
    driver.findElement(By.cssSelector("label > input")).sendKeys("Family");
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Genre added", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".GenresBox .Drop")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Family")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Harry Potter")).click();
    driver.findElement(By.cssSelector(".MovieSubheader:nth-child(2) > .MovieLeftButtons:nth-child(3)")).click();
    driver.findElement(By.cssSelector("label > input")).click();
    driver.findElement(By.cssSelector("label > input")).sendKeys("Family");
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Genre deleted", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.close();
  }

  @Test
  public void addDeleteActor() {
    driver.get("http://3.93.172.228:3000");
    driver.manage().window().setSize(new Dimension(788, 824));
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".MoviesBox .Drop")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Harry Potter")).click();
    driver.findElement(By.cssSelector(".LoginButtons:nth-child(4)")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Logged in successfully", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".MovieSubheader:nth-child(4) > .MovieLeftButtons:nth-child(2)")).click();
    driver.findElement(By.cssSelector("label:nth-child(2) > input")).click();
    driver.findElement(By.cssSelector("label:nth-child(2) > input")).sendKeys("Daniel");
    driver.findElement(By.cssSelector("label:nth-child(4) > input")).click();
    driver.findElement(By.cssSelector("label:nth-child(4) > input")).sendKeys("Radcliff");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Actor added", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".ActorsBox .Drop")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Daniel Radcliff")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Harry Potter")).click();
    driver.findElement(By.cssSelector(".MovieSubheader:nth-child(4) > .MovieLeftButtons:nth-child(3)")).click();
    driver.findElement(By.cssSelector("label:nth-child(2) > input")).click();
    driver.findElement(By.cssSelector("label:nth-child(2) > input")).sendKeys("Daniel");
    driver.findElement(By.cssSelector("label:nth-child(4) > input")).click();
    driver.findElement(By.cssSelector("label:nth-child(4) > input")).sendKeys("Radcliff");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Actor deleted", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.close();
  }

  @Test
  public void updateMovie() {
    driver.get("http://3.93.172.228:3000");
    driver.manage().window().setSize(new Dimension(788, 824));
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".LoginButtons:nth-child(4)")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Logged in successfully", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".MoviesBox .Drop")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Harry Potter")).click();
    driver.findElement(By.cssSelector(".MovieHeader > .MovieButtons")).click();
    driver.findElement(By.name("title")).click();
    driver.findElement(By.name("title")).sendKeys("Harry Potter");
    driver.findElement(By.name("length")).click();
    driver.findElement(By.name("length")).sendKeys("120");
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      alert.accept();
      assertEquals("Movie updated", text);
    } catch (Exception e) {
      //exception handling
    }
    driver.findElement(By.cssSelector(".close")).click();
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.close();
  }

  @Test
  public void searchMovie() {
    driver.get("http://3.93.172.228:3000");
    driver.manage().window().setSize(new Dimension(788, 824));
    driver.findElement(By.cssSelector(".TextBox")).click();
    driver.findElement(By.cssSelector(".TextBox")).sendKeys("spider");
    driver.findElement(By.cssSelector(".SearchButton")).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Spiderman: Homecoming")).click();
    driver.close();
  }

}
