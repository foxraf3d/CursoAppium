package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.DragAndDropPage;
import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class DragAndDropTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragAndDropPage page = new DragAndDropPage();

    private  String [] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private  String [] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    public void deveEfetuarDragNDrop(){
        //acessar menu
        menu.scroll(0.9, 0.1);
        menu.acessarFormulario("Drag and drop");

        //verificar estado inicial
        assertArrayEquals(estadoInicial, page.obterLista());

        //arrastar "Esta" para "e arraste para"
        page.arrastar("Esta", "e arraste para");

        //vefificar estado intermediário
        assertArrayEquals(estadoIntermediario, page.obterLista());

        //arrastar "Faça um clique longo" para "é uma lista"

        //Verificar estado final
    }

}
