package br.ce.rafaelsilva.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Appium_DesafioAula16 {


    AndroidDriver driver;

    private void IniciaCapacidades() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\ProjGIT\\CursoAppium\\src\\test\\resources\\CTAppium-1-0.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void NovoMetodoAppiumAula16() throws MalformedURLException {

        //Inicar capacidades do Appium
        IniciaCapacidades();

        //Acessar o formulário
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

        //Preencher campo Nome
        driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Rafael Simplício");

        //Selecionar valor para combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //Selecionar checkbox para true
        MobileElement checkbox = (MobileElement) driver.findElement(MobileBy.AccessibilityId("check"));
        checkbox.click();
        String ticado = checkbox.getAttribute("checked");


        //Selecionar switch para false
        MobileElement deslize = (MobileElement) driver.findElement(MobileBy.AccessibilityId("switch"));
        deslize.click();
        String dedar = deslize.getAttribute("checked");

        //Salvar as informações
        driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

        //Validar informações dos campos
        WebElement textoNome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Rafael Simplício']"));
        assertEquals("Nome: Rafael Simplício", textoNome.getText());

        WebElement textoConsole = driver.findElement(By.xpath("//android.widget.TextView[@text='Console: switch']"));
        assertEquals("Console: switch", textoConsole.getText());

        assertTrue(dedar.equals("false"));

        assertTrue(ticado.equals("true"));

        //Fechar instância
        driver.quit();

    }



}
