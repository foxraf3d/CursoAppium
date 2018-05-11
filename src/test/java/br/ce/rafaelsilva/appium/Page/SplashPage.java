package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SplashPage extends BasePage {

    public boolean isTelaSplashVisivel(){
        return existeElementoPorTexto("Splash!");
    }


    public void aguardarSplashSumir(){
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait espera = new WebDriverWait(getDriver(), 10);
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text = 'Splash!']")));
    }
}
