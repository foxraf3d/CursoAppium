package br.ce.rafaelsilva.appium;

import br.ce.rafaelsilva.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FormularioTest {

    private AndroidDriver driver;

    @Before
    public void SetUp(){
        driver = DriverFactory.getDriver();
        //Selecionar Formulário
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
    }

    @After
    public void TearDown(){
        DriverFactory.killDriver();
    }

    @Test
    public void devePreencherCampoTexto(){

        //Escrever nome
        MobileElement campoNome = (MobileElement) driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Rafael Simplício");

        //Checar nome escrito
        String text = campoNome.getText();
        assertEquals("Rafael Simplício", text);

    }

    @Test
    public void devePreencherCombo() throws MalformedURLException {

        //Clicar no Combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //Selecionar opção desejada
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //Verificar opção selecionada
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        assertEquals("Nintendo Switch", text);

    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {

        //Verificar status dos elementos
        MobileElement check = (MobileElement) driver.findElement(By.className("android.widget.CheckBox"));
        MobileElement switc = (MobileElement) driver.findElement((MobileBy.AccessibilityId("switch")));
        assertTrue(check.getAttribute("checked").equals("false"));
        assertTrue(switc.getAttribute("checked").equals("true"));

        //Clicar nos elementos
        check.click();
        switc.click();

        //Verificar estados alterados
        assertFalse(check.getAttribute("checked").equals("false"));
        assertFalse(switc.getAttribute("checked").equals("true"));

    }

}
