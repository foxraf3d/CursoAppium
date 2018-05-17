package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.AccordionPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class AccordionTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion() {
        //Acessar menu Accordion
        menu.acessarFormulário("Accordion");

        //Clicar na opção 1
        page.selecionarOp1("Opção 1");

        //Verificar texto opção 1
        esperarCarregar(1000);
        assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());

    }
}
