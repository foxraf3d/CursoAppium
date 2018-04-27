package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {
    private DSL dsl = new DSL();

    public void escreverNome(String nome){
        dsl.escrever(MobileBy.AccessibilityId("nome"), nome );
    }

    public String obterNome(){
        return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
    }
}
