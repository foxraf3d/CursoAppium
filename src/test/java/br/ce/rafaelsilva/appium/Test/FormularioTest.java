package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.FormularioPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.DSL;
import br.ce.rafaelsilva.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FormularioTest {

    private DSL dsl = new DSL();
    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void SetUp(){
        menu.acessarFormulário();
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
        //Clicar no Combo
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

        //Verificar opção selecionada
        assertEquals("Nintendo Switch", dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView")));
    }

    @Test
    public void deveInteragirSwitchCheckBox(){
        //Verificar status dos elementos
        assertFalse(dsl.isCheckMArcado(By.className("android.widget.CheckBox")));
        assertTrue(dsl.isCheckMArcado(MobileBy.AccessibilityId("switch")));


        //Clicar nos elementos
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));

        //Verificar estados alterados
        assertTrue(dsl.isCheckMArcado(By.className("android.widget.CheckBox")));
        assertFalse(dsl.isCheckMArcado(MobileBy.AccessibilityId("switch")));

    }

}
