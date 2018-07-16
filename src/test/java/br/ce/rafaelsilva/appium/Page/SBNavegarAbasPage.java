package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SBNavegarAbasPage extends BasePage {

    public void acessarAbasSBNativo(String aba){
        getDriver().findElement(By.xpath("//*[@text='"+aba+"']")).click();
    }

}
