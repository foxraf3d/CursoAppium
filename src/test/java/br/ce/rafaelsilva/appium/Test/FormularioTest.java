package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.FormularioPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import br.ce.rafaelsilva.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class FormularioTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void SetUp(){
        menu.acessarFormulário("Formulário");
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
        assertTrue(page.isSwitchMarcado());

        page.clicarCheck();
        page.clicarSwitch();

        assertTrue(page.isCheckMarcado());
        assertFalse(page.isSwitchMarcado());

    }

    @Test
    public void deveAlterarData(){
        page.clicarPorTexto("01/01/2000");
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");

        assertTrue(page.existeElementoPorTexto("20/2/2000"));
    }

    @Test
    public void deveAlterarHora(){
        page.clicarPorTexto("06:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        page.clicarPorTexto("OK");

        assertTrue(page.existeElementoPorTexto("10:40"));
    }

    @Test
    public void deveInteragirComSeekBar(){
        //Clicar no seekbar
        page.clicarSeekBar(0.67);

        //Salvar
        page.clicarSalvar("SALVAR");

        //Obter o valor
        assertEquals("Slider: 67",page.obterTexto(By.xpath("//android.widget.TextView[@index='14']")));
    }

}
