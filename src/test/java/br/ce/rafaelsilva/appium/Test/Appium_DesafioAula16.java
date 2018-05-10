package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.FormularioPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import br.ce.rafaelsilva.appium.core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Appium_DesafioAula16 extends BaseTest {


    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void SetUp(){
        menu.acessarFormulário("Formulário");
    }

    @Test
    public void NovoMetodoAppiumAula16(){

        //Preencher campo Nome
        page.escreverNome("Rafael Simplício");

        //Selecionar valor para combo
        page.selecionarCombo("Nintendo Switch");

        //Selecionar checkbox para true
        page.clicarCheck();

        //Selecionar switch para false
        page.clicarSwitch();

        //Salvar as informações
        page.clicarSalvar("SALVAR");

        //Validar informações dos campos
        assertEquals("Nome: Rafael Simplício", page.obterNomeCadastrado());
        assertEquals("Console: switch", page.obterConsoleCadastrado());
        assertTrue(page.isCheckMarcado());
        assertFalse(page.isSwitchMarcado());

    }



}
