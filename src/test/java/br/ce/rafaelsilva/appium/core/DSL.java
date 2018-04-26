package br.ce.rafaelsilva.appium.core;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static br.ce.rafaelsilva.appium.core.DriverFactory.*;
import static org.junit.Assert.assertEquals;

public class DSL {

    public void escrever(By by, String texto){
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String valor) {
        clicar(By.xpath("//android.widget.CheckedTextView[@text='"+valor+"']"));
    }

    public void selecionarCombo(By by, String valor){
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMArcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
   }
}
