package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.AlertPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlertTeste extends BaseTest {


    private MenuPage menu = new MenuPage();
    private AlertPage pageAlerta = new AlertPage();

    @Before
    public void Setup(){
        menu.acessarFormulario("Alertas");
    }

    @Test
    public void deveConfirmarAlerta(){

        //clicar em alert confirm
        pageAlerta.clicarAlertaConfirm();

        //vefificar os textos
        assertEquals("Info", pageAlerta.obterTituloAlerta());
        assertEquals("Confirma a operação?", pageAlerta.obterMensagemAlerta());

        //confirmar alerta
        pageAlerta.confirmar();

        //verificar nova mensagem
        assertEquals("Confirmado", pageAlerta.obterMensagemAlerta());

        //sair
        pageAlerta.sair();
    }


    @Test
    public void deveClicarForaAlerta(){
        //clicar alerta simples
        pageAlerta.clicarAlertaSimples();

        //clicar fora da caixa
        esperarCarregar(1000);
        pageAlerta.clicarForaCaixa();

        //verificar que a mensagem não esta presente
        assertFalse(pageAlerta.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }


}
