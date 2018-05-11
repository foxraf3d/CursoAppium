package br.ce.rafaelsilva.appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class BasePage {

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
        clicar(By.xpath("//*[@text='"+valor+"']"));
    }

    public void selecionarCombo(By by, String valor){
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMArcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean isSwitchMArcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto){
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
        return elementos.size() > 0;
    }
}
