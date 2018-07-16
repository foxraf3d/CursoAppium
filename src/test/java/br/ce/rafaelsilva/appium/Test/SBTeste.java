package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.MenuPage;
import br.ce.rafaelsilva.appium.Page.SBContasPage;
import br.ce.rafaelsilva.appium.Page.SBLoginPage;
import br.ce.rafaelsilva.appium.Page.SBNavegarAbasPage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class SBTeste extends BaseTest {

    /*
     * 1 - Inserir Conta
     * 2 - Excluir Conta
     * 3 - Validações da Movimentação
     * 4 - Exclusão + Saldo
     */

    private MenuPage menu = new MenuPage();
    private SBLoginPage loginPage = new SBLoginPage();
    private SBNavegarAbasPage abasPage = new SBNavegarAbasPage();
    private SBContasPage conta = new SBContasPage();

    @Before
    public void Setup() {
        menu.acessarFormulario("SeuBarriga Nativo");
        loginPage.setEmail("foxraf3d@gmail.com");
        loginPage.setPassword("123456");
        loginPage.entrar();
    }

    //1 - Inserir Conta
    @Test
    public void inserirConta_ComSucesso(){
        abasPage.acessarAbasSBNativo("CONTAS");
        conta.inserirConta("Conta Nova");
        conta.salvarConta();
        assertEquals("Conta adicionada com sucesso",conta.obterTexto(By.xpath("//android.widget.TextView[@text='Conta adicionada com sucesso']")));
    }

    @Test
    public void inserirConta_ContaExistente(){
        abasPage.acessarAbasSBNativo("CONTAS");
        conta.inserirConta("Conta para Exclusão");
        conta.salvarConta();

        conta.inserirConta("Conta para Exclusão");
        conta.salvarConta();

        assertEquals("Problemas de comunicação",conta.obterTexto(By.xpath("//android.widget.TextView[@text='Problemas de comunicação']")));
    }

    //2 - Excluir Conta
    @Test
    public void excluirConta_ComSucesso(){
        abasPage.acessarAbasSBNativo("CONTAS");
        conta.inserirConta("Conta para Exclusão");
        conta.salvarConta();
        esperarCarregar(1000);
        conta.cliqueLongoConta("Conta para Exclusão");
        conta.excluirConta();
        assertEquals("Conta excluída com sucesso",conta.obterTexto(By.xpath("//android.widget.TextView[@text='Conta excluída com sucesso']")));
    }

    @Test
    public void excluirConta_ContaEmUso(){
        abasPage.acessarAbasSBNativo("CONTAS");
        esperarCarregar(1000);
        conta.cliqueLongoConta("Conta para movimentacoes");
        conta.excluirConta();
        assertEquals("Conta em uso nas movimentações",conta.obterTexto(By.xpath("//android.widget.TextView[@text='Conta em uso nas movimentações']")));
    }

    //3 - Validações da Movimentação



}
