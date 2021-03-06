package br.ce.rafaelsilva.appium.Page;
import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb(){
        Set<String> contextHandles = getDriver().getContextHandles();
        getDriver().context((String)contextHandles.toArray()[1]);
    }

    public void sairContextoWeb(){
        getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }

    public void setEmail(String valor){
        getDriver().findElement(By.id("email")).sendKeys(valor);
    }

    public void setSenha(String senha){
        getDriver().findElement(By.id("senha")).sendKeys(senha);
    }

    public void entrar(){
        clicar(By.xpath("//button[@type='submit']"));
    }

    public String getMessage(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

}
