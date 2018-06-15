package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarFormulario(String valor){
        clicarPorTexto(valor);
    }

}
