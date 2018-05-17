package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selecionarOp1(String valor){
        clicarPorTexto(valor);
    }

    public String obterValorOp1(){
        return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }

}
