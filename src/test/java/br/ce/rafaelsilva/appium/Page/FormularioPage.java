package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome){
        escrever(MobileBy.AccessibilityId("nome"), nome );
    }

    public String obterNome(){
        return obterTexto(MobileBy.AccessibilityId("nome"));

    }

    public void selecionarCombo(String valor){
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo(){
        return obterTexto(By.xpath("//android.widget.TextView[@text='Nintendo Switch']"));
    }

    public void clicarCheck(){
        clicar(MobileBy.AccessibilityId("check"));
    }

    public void clicarSwitch(){
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public  void clicarSalvar(String label){
        clicar(By.xpath("//*[@text='"+label+"']"));
    }

    public boolean isCheckMarcado(){
        return isCheckMArcado(MobileBy.AccessibilityId("check"));
    }

    public boolean isSwitchMarcado(){
        return isSwitchMArcado(MobileBy.AccessibilityId("switch"));
    }

    public String obterNomeCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[@index='12']"));
    }

    public String obterConsoleCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[@index='13']"));
    }
}
