package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class AbasPage extends BasePage {

    public String verificaTelaPorTexto(By by){
        String valor = obterTexto(by);
        return valor;
    }

    public void acessarAbaPorTexto(String valor){
        clicarPorTexto(valor);
    }

}
