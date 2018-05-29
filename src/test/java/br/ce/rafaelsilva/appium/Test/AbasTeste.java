package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.AbasPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

public class AbasTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AbasPage page = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        //Acessar o menu Abas
        menu.acessarFormulário("Abas");

        //Verificar que esta na Aba 1
        assertEquals("Este é o conteúdo da Aba 1",page.verificaTelaPorTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']")));

        //Acessar a Aba 2
        page.acessarAbaPorTexto("ABA 2");

        //Verificar que está na Aba 2
        assertEquals("Este é o conteúdo da Aba 2", page.verificaTelaPorTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']")));

    }
}
