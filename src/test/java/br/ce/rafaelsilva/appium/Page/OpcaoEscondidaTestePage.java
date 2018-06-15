package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class OpcaoEscondidaTestePage extends BasePage {

    public void clicarMSGSucesso(){
        clicar(By.id("android:id/button1"));
    }
}
