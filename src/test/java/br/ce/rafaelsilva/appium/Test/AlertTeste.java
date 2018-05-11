package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.AlertPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;
import org.junit.Test;

public class AlertTeste extends BaseTest {


    private MenuPage menu = new MenuPage();
    private AlertPage pageAlerta = new AlertPage();

    @Test
    public void deveConfirmarAlerta(){
        //acessar menu alerta
        menu.acessarFormulário("Alertas");
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

}
