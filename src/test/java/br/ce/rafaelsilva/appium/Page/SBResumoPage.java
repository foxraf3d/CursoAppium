package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SBResumoPage extends BasePage {

    public void swipeMovimentacaoResumo(){
        swipeElement((MobileElement)getDriver().findElement(By.xpath("//*[@text='Movimentacao 3, calculo saldo']")),0.9,0.1);
    }

    public void deletarResumo(){
        clicarPorTexto("Del");
        //getDriver().findElement(By.xpath("//*[@text='Del']")).click();
    }

    public void atualizar(){
        clicarPorTexto("ATUALIZAR");
        //getDriver().findElement(By.xpath("//*[@text='ATUALIZAR']")).click();
    }

}

