package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.Page.WebViewPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebViewTeste extends BaseTest {

    MenuPage menu = new MenuPage();
    WebViewPage page = new WebViewPage();

    @After
    public void TearDown(){
        page.sairContextoWeb();
    }

    @Test
    public void deveRealizarLogin(){
        //acessar o menu
        menu.acessarFormulario("SeuBarriga Híbrido");
        esperarCarregar(3000);
        page.entrarContextoWeb();

        //preencher email
        page.setEmail("foxraf3d@gmail.com");

        //senha
        page.setSenha("123456");

        //entrar
        page.entrar();

        //verificar mensagem de sucesso
        assertEquals("Bem vindo, RAFAEL SIMPLICIO DA SILVA!", page.getMessage());

    }

}
