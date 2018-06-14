package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void clicarAlertaConfirm(){
        clicarPorTexto("ALERTA CONFIRM");
    }

    public void clicarAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
    }

    public void clicarForaCaixa(){
        toque(100, 150);
    }

    public String obterTituloAlerta(){
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta(){
        return obterTexto(By.id("android:id/message"));
    }

    public void confirmar(){
        clicarPorTexto("Confirmar");
    }

    public void sair(){
        clicarPorTexto("Sair");
    }

}
