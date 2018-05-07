package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.DSL;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormularioPage {
    private DSL dsl = new DSL();

    public void escreverNome(String nome){
        dsl.escrever(MobileBy.AccessibilityId("nome"), nome );
    }

    public String obterNome(){
        return dsl.obterTexto(MobileBy.AccessibilityId("nome"));

    }

    public void selecionarCombo(String valor){
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo(){
        return dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nintendo Switch']"));
    }

    public void clicarCheck(){
        dsl.clicar(MobileBy.AccessibilityId("check"));
    }

    public void clicarSwitch(){
        dsl.clicar(MobileBy.AccessibilityId("switch"));
    }

    public  void clicarSalvar(String label){
        dsl.clicar(By.xpath("//*[@text='"+label+"']"));
    }

    public boolean isCheckMarcado(){
        return dsl.isCheckMArcado(MobileBy.AccessibilityId("check"));
    }

    public boolean isSwitchMarcado(){
        return dsl.isSwitchMArcado(MobileBy.AccessibilityId("switch"));
    }

    public String obterNomeCadastrado(){
        return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='12']"));
    }

    public String obterConsoleCadastrado(){
        return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='13']"));
    }
}
