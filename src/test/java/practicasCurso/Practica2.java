/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicasCurso;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Cris Katalon
 */
public class Practica2 {

    String driverPath = "";
    String URL = "";
    String email = "";
    String textActual = "";
    String textExpected = "";
    WebDriver driver = null;

    @Before
    public void precondiciones() {
        driverPath = "C:\\Users\\admin\\Documents\\Curso\\chromedriver.exe";
        URL = "http://automationpractice.com/index.php";
        email = "mmmbopzombie@hotmail.com";
        textActual = "";
        textExpected = "YOUR PERSONAL INFORMATIO";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test_uno() throws InterruptedException {

        try {

            driver.get(URL);
            Thread.sleep(3000);
            WebElement element = driver.findElement(By.className("login"));
            element.click();
            WebElement mail = driver.findElement(By.id("email_create"));
            mail.sendKeys(email);
            WebElement botonsubmit = driver.findElement(By.name("SubmitCreate"));
            botonsubmit.click();
//            driver.findElement(By.className("login")).click();
//            driver.findElement(By.id("email_create")).sendKeys(email);
//            driver.findElement(By.name("SubmitCreate")).click();
            Thread.sleep(3000);
            textActual = driver.findElement(By.className("page-subheading")).getText();
            Assert.assertEquals(textExpected, textActual);
        } catch (Exception e) {
            System.out.println("Falló ejecución " + e);
        } catch (AssertionError a) {
            System.out.println("Falló la aserción " + a);
        }

    }

    @Test
    public void test_dos() throws InterruptedException {
        try {

            driver.get(URL);
            Thread.sleep(3000);
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email_create")).sendKeys(email);
            driver.findElement(By.name("SubmitCreate")).click();
            Thread.sleep(3000);
            textActual = driver.findElement(By.className("page-subheading")).getText();
            Assert.assertEquals(textExpected, textActual);
        } catch (Exception e) {
            System.out.println("Falló ejecución " + e);
        } catch (AssertionError a) {
            System.out.println("Falló la aserción " + a);
        }

    }

    @After
    public void postcondiciones() {
        driver.quit();
    }
}
