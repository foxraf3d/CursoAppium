package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBHomePage extends BasePage {

    public void resetarBancoDeDados(){
        clicar(By.xpath("//*[@text='RESET']"));
    }

}
