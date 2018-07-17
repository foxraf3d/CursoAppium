package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;
import java.time.LocalDate;
import java.time.MonthDay;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SBMovPage extends BasePage {

    public void combosMovimentacao(String nomeCombo, String valor){
        selecionarCombo(By.xpath("//*[@text='"+nomeCombo+"']"), valor);
    }

    public void informaSwitchPagamento_Pago(){
        clicar(By.className("android.widget.Switch"));
    }

    public void dataMovimentacao(int dias){
        clicar(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView"));
        MonthDay md = MonthDay.now();
        int hoje = md.getDayOfMonth();
        String data = String.valueOf((hoje + dias));
        getDriver().findElement(By.xpath("//*[@text='"+data+"']")).click();
    }

    public void dataPagamento(int dias){
        clicar(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"));
        MonthDay md = MonthDay.now();
        int hoje = md.getDayOfMonth();
        String data = String.valueOf((hoje + dias));
        getDriver().findElement(By.xpath("//*[@text='"+data+"']")).click();
    }

    public void okDatas(){
        clicar(By.id("android:id/button1"));
    }

    public void salvarMovimentacao(){
        clicar(By.xpath("//*[@text='SALVAR']"));
    }

    public  void preencheDescricao(String descricao){
        getDriver().findElement(By.xpath("//*[@text='Descrição']")).sendKeys(descricao);
    }

    public void preencheInterassado(String interessado){
        getDriver().findElement(By.xpath("//*[@text='Interessado']")).sendKeys(interessado);
    }

    public void preencheValor(String valor){
        getDriver().findElement(By.xpath("//*[@text='Valor']")).sendKeys(valor);
    }
}
