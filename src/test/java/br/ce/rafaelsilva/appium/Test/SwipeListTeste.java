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
        String path = "//android.view.ViewGroup[@index='0']//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']";
        page.swipeLeft(path,0.9, 0.1);

        //op1 +
        page.clicarBotaoMais();

        //verificar op1+
        assertEquals("Opção 1 (+)", menu.obterTexto(By.xpath("//android.widget.TextView[@text='Opção 1 (+)']")));

        //op4 para esquerda
        path = "//android.view.ViewGroup[@index='0']//android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']";
        page.swipeLeft(path, 0.9, 0.1);

        //op4 -

        //Verficar op4-

        //op5 para direita

        //verificar op5


    }

}
