package br.ce.rafaelsilva.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class CalculadoraTest {

    @Test
    public void deveSomarDoisValores() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        //instalando a aplicação - Disponibilizar o apk na pasta Resources do projeto
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\ProjGIT\\CursoAppium\\src\\test\\resources\\CTAppium-1-0.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/formula");
        el5.click();

        System.out.println(el5.getText());
        assertEquals("4", el5.getText()) ;


        driver.quit();
    }

}
