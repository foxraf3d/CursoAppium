package br.ce.rafaelsilva.appium.Test;
import br.ce.rafaelsilva.appium.Page.CliquesPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static org.junit.Assert.*;
import org.junit.Test;

public class CliquesTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage clique = new CliquesPage();

    @Test
    public void deveRealizarCliqueLongo(){
        //Acessar menu
        menu.acessarFormulario("Cliques");

        //Clique longo
        clique.cliqueLongo();

        //Verificar o texto
        assertEquals("Clique Longo", clique.obterTextoCampo());
    }
}
