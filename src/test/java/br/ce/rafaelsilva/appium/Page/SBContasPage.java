package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SBContasPage extends BasePage {

    public void inserirConta(String nomeConta){
        getDriver().findElement(By.xpath("//*[@text='Conta']")).sendKeys(nomeConta);
    }

    public void salvarConta(){
        getDriver().findElement(By.xpath("//*[@text='SALVAR']")).click();
    }

    public void cliqueLongoConta(String nomeConta){
        WebElement elemento = getDriver().findElement(By.xpath("//*[@text='"+nomeConta+"']"));
        ElementOption ele = new ElementOption();
        ele.withElement(elemento);

        new TouchAction(getDriver()).longPress(new LongPressOptions().withElement(ele)).release().perform();
    }

    public void excluirConta(){
        getDriver().findElement(By.xpath("//*[@text='EXCLUIR']")).click();
    }

}
