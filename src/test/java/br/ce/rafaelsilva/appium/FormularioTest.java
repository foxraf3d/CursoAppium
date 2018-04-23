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

}
