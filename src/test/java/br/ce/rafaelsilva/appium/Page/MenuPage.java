package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.DSL;

public class MenuPage {

    private DSL dsl = new DSL();

    public void acessarFormulário(){
        dsl.clicarPorTexto("Formulário");
    }

}
