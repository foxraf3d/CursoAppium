package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.Page.SplashPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;
import org.junit.Test;

public class SplashTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage pageSplash = new SplashPage();

    @Test
    public void deveAquardarSplashSumir(){

        //acessar menu splash
        menu.acessarFormulario("Splash");

        //Verificar que o splash esta sendo exibido
        pageSplash.isTelaSplashVisivel();

        //aguardar saída do splash
        pageSplash.aguardarSplashSumir();

        //verificar que o formulário esta aparecendo
        assertTrue(pageSplash.existeElementoPorTexto("Formul�rio"));

    }

}
