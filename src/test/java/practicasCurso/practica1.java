/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicasCurso;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Cris Katalon
 */
public class practica1 {

    String driverPath = "";
    String URL = "";
    String email = "";
    String textActual = "";
    String textExpected = "";
    WebDriver driver = null;

    @Before
    public void precondiciones() {
        driverPath = "C:\\Users\\Cris Katalon\\Downloads\\chromedriver_win32_88\\chromedriver.exe";
        URL = "http://automationpractice.com/index.php";
        email = "mmmbopzombie@hotmail.com";
        textActual = "";
        textExpected = "YOUR PERSONAL INFORMATIO";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void test_uno() throws InterruptedException {

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
