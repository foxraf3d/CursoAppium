package br.ce.rafaelsilva.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FormularioTest {

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\ProjGIT\\CursoAppium\\src\\test\\resources\\CTAppium-1-0.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionar Formulário
        List<AndroidElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

        for(AndroidElement elemento:elementosEncontrados) {
            String opcao = elemento.getText();
            if ("Formulário".equalsIgnoreCase(opcao)){
                elemento.click();
                break;
            }
        }

        //Escrever nome
        MobileElement campoNome = (MobileElement) driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Rafael Simplício");

        //Checar nome escrito
        String text = campoNome.getText();
        assertEquals("Rafael Simplício", text);

        driver.quit();
    }

    @Test
    public void devePreencherCombo() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\ProjGIT\\CursoAppium\\src\\test\\resources\\CTAppium-1-0.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionar Formulário
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        //Clicar no Combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //Selecionar opção desejada
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //Verificar opção selecionada
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        assertEquals("Nintendo Switch", text);

        driver.quit();
    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\ProjGIT\\CursoAppium\\src\\test\\resources\\CTAppium-1-0.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionar Formulário
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

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

        driver.quit();
    }

}
