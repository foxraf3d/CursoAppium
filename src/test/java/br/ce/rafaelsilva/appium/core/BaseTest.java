package br.ce.rafaelsilva.appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizaClasse(){
        DriverFactory.killDriver();
    }

    @After
    public void TearDown(){
        gerarScreenShot();
        DriverFactory.getDriver().resetApp();
    }

    public void gerarScreenShot(){
        File imagem = (DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imagem, new File("target/screenshot/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
