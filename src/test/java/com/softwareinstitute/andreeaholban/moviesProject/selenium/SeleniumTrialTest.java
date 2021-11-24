package com.softwareinstitute.andreeaholban.moviesProject.selenium;// Generated by Selenium IDE
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SeleniumTrialTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void seleniumTrial() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(784, 824));
    driver.findElement(By.cssSelector(".HomeButton")).click();
    driver.findElement(By.cssSelector(".MoviesBox .Drop")).click();
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
  }
}
