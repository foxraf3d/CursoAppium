package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;

import java.time.LocalDate;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SBMovPage extends BasePage {

    public void selecionaCombo(){
        selecionarCombo(By.xpath("//android:id/text1[@text='Receita']"), "Despesa");
    }

    public void informaSwitchPagamento_Pago(){
        clicar(By.className("android.widget.Switch"));
    }

    public void dataMovimentacao(int dias){
        clicar(By.xpath("//android.view.ViewGroup[@index='4']"));
        String diaAtual = getDriver().findElement(By.xpath("//*[]")).getText();
    }

}
