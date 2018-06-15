package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class SwipeTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveRealizarSwipe(){
        //acessar menu
        menu.acessarFormulario("Swipe");
        //verificar texto "a esquerda"
        assertEquals("a esquerda", menu.obterTexto(By.xpath("//android.widget.TextView[@text='a esquerda']")));
        //swipe para direita
        menu.swipe(0.9, 0.1);
        //verificar texto "E veja se"
        assertEquals("E veja se", menu.obterTexto(By.xpath("//android.widget.TextView[@text='E veja se']")));
        //clicar botão Direita
        menu.clicarPorTexto("›");
        //verificar texto 'Chegar até o fim!'
        assertEquals("Chegar até o fim!", menu.obterTexto(By.xpath("//android.widget.TextView[@text='Chegar até o fim!']")));
        //swipe esquerda
        menu.swipe(0.1, 0.9);
        //clicar botão esquerda
        menu.clicarPorTexto("‹");
        //verificar texto "a esquerda"
        assertEquals("a esquerda", menu.obterTexto(By.xpath("//android.widget.TextView[@text='a esquerda']")));
    }

}
