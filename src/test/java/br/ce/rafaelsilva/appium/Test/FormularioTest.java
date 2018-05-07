package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.FormularioPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormularioTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void SetUp(){
        menu.acessarFormulário("Formulário");
    }

    @After
    public void TearDown(){
        DriverFactory.killDriver();
    }

    @Test
    public void devePreencherCampoTexto(){
        page.escreverNome("Rafael Simplício");
        assertEquals("Rafael Simplício", page.obterNome());
    }

    @Test
    public void devePreencherCombo(){
        page.selecionarCombo("Nintendo Switch");
        assertEquals("Nintendo Switch", page.obterValorCombo());
    }

    @Test
    public void deveInteragirSwitchCheckBox(){
        assertFalse(page.isCheckMarcado());
        assertFalse(page.isSwitchMarcado());

        page.clicarCheck();
        page.clicarSwitch();

        assertTrue(page.isCheckMarcado());
        assertFalse(page.isSwitchMarcado());

    }

}
