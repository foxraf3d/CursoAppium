package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.Page.SwipeListPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

public class SwipeListTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SwipeListPage page = new SwipeListPage();

    @Test
    public void deveInteragirSwipeList(){

        //clicar swipe list
        menu.acessarFormulario("Swipe List");
        esperarCarregar(1000);

        //op1 para esquerda
        page.swipeRight("Opção 1");

        //op1 +
        page.clicarBotaoMais();

        //verificar op1+
        assertEquals("Opção 1 (+)", menu.obterTexto(By.xpath("//android.widget.TextView[@text='Opção 1 (+)']")));

        //op4 para esquerda
        page.swipeRight("Opção 4");

        //op4 -
        page.clicarPorTexto("(-)");

        //Verficar op4-
        assertEquals("Opção 4 (-)", menu.obterTexto(By.xpath("//android.widget.TextView[@text='Opção 4 (-)']")));

        //op5 para direita
        page.swipeLeft("Opção 5 (-)");

        //verificar op5
        assertEquals("Opção 5", menu.obterTexto(By.xpath("//android.widget.TextView[@text='Opção 5']")));

    }

}
