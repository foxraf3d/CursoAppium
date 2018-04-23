package br.ce.rafaelsilva.appium;

import br.ce.rafaelsilva.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Appium_DesafioAula16 {


    private AndroidDriver driver;

    @Before
    public void SetUp(){
        driver = DriverFactory.getDriver();
    }

    @After
    public void TearDown(){
        DriverFactory.killDriver();
    }


    @Test
    public void NovoMetodoAppiumAula16(){

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

    }



}
