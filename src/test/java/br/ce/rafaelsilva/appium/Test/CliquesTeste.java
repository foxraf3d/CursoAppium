package br.ce.rafaelsilva.appium.Test;
import br.ce.rafaelsilva.appium.Page.CliquesPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CliquesTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage clique = new CliquesPage();

    @Before
    public void setup(){
        menu.acessarFormulario("Cliques");
    }

    @Test
    public void deveRealizarCliqueLongo(){
        //Clique longo
        clique.cliqueLongo();

        //Verificar o texto
        assertEquals("Clique Longo", clique.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo(){
        //Clique duplo
        clique.clicarPorTexto("Clique duplo");
        clique.clicarPorTexto("Clique duplo");

        //Verificar o texto
        assertEquals("Duplo Clique", clique.obterTextoCampo());
    }


}
