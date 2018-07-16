package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SBLoginPage extends BasePage {

    public void setEmail(String email){
        getDriver().findElement(By.xpath("//android.widget.EditText[@text='Nome']")).sendKeys(email);
    }

    public void setPassword(String senha){
        getDriver().findElement(By.xpath("//android.widget.EditText[@text='Senha']")).sendKeys(senha);
    }

    public void entrar(){
        getDriver().findElement(By.xpath("//*[@text='ENTRAR']")).click();
    }

}
