package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.Page.OpcaoEscondidaTestePage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class OpcaoEscondidaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private OpcaoEscondidaTestePage opcaoEscondita = new OpcaoEscondidaTestePage();

    @Test
    public void deveEndontrarOpcaoEscondida() {
        //scroll down
        menu.scroll(0.9, 0.1);
        //clicar menu
        menu.acessarFormulario("Opção bem escondida");
        //Verificar mansagem
        assertEquals("Você achou essa opção", menu.obterTexto(By.id("android:id/message")));
        //sair
        opcaoEscondita.clicarMSGSucesso();
    }

}
