package br.ce.rafaelsilva.appium;

import br.ce.rafaelsilva.appium.core.DSL;
import br.ce.rafaelsilva.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Appium_DesafioAula16 {

    private DSL dsl = new DSL();

    @Before
    public void SetUp(){
        dsl.clicarPorTexto("Formulário");
    }

    @After
    public void TearDown(){
        DriverFactory.killDriver();
    }


    @Test
    public void NovoMetodoAppiumAula16(){

        //Preencher campo Nome
        dsl.escrever(By.xpath("//*[@text='Formulário']"), "Rafael Simplício");

        //Selecionar valor para combo
        dsl.clicar(MobileBy.AccessibilityId("console"));
        dsl.clicarPorTexto("Nintendo Switch");

        //Selecionar checkbox para true
        dsl.clicar(MobileBy.AccessibilityId("check"));

        //Selecionar switch para false
        dsl.clicar(MobileBy.AccessibilityId("switch"));


        //Salvar as informações
        dsl.clicar(By.xpath("//*[@text='SALVAR']"));

        //Validar informações dos campos
        assertEquals("Nome: Rafael Simplício", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Rafael Simplício']")));
        assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Console: switch']")));
        assertFalse(dsl.isCheckMArcado(MobileBy.AccessibilityId("check")));
        assertTrue(dsl.isCheckMArcado(MobileBy.AccessibilityId("switch")));

    }



}
