package br.ce.rafaelsilva.appium.Test;

import br.ce.rafaelsilva.appium.Page.*;
import br.ce.rafaelsilva.appium.core.BaseTest;
import static br.ce.rafaelsilva.appium.core.Mensagens.*;

import org.junit.After;
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
    private SBMovPage movPage = new SBMovPage();
    private SBHomePage homePage = new SBHomePage();

    @Before
    public void Setup() {
        menu.acessarFormulario("SeuBarriga Nativo");
        loginPage.setEmail("foxraf3d@gmail.com");
        loginPage.setPassword("123456");
        loginPage.entrar();
    }

    @After
    public void tearDown(){
        abasPage.acessarAbasSBNativo("HOME");
        homePage.resetarBancoDeDados();
    }

    //1 - Inserir Conta
    @Test
    public void inserirConta_ComSucesso(){
        abasPage.acessarAbasSBNativo("CONTAS");
        conta.inserirConta("Conta Nova");
        conta.salvarConta();
        assertEquals((MSG.SUCESSO_INSERIRCONTA).toString(), conta.obterTexto(By.xpath("//android.widget.TextView[@text='Conta adicionada com sucesso']")));
    }

    @Test
    public void inserirConta_ContaExistente(){
        abasPage.acessarAbasSBNativo("CONTAS");
        conta.inserirConta("Conta para Exclusão");
        conta.salvarConta();

        conta.inserirConta("Conta para Exclusão");
        conta.salvarConta();

        assertEquals((MSG.FALHA_INSERIRCONTA).toString(),conta.obterTexto(By.xpath("//android.widget.TextView[@text='Problemas de comunicação']")));
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
        assertEquals((MSG.SUCESSO_EXCLUIRCONTA).toString(),conta.obterTexto(By.xpath("//android.widget.TextView[@text='Conta excluída com sucesso']")));
    }

    @Test
    public void excluirConta_ContaEmUso(){
        abasPage.acessarAbasSBNativo("CONTAS");
        esperarCarregar(1000);
        conta.cliqueLongoConta("Conta para movimentacoes");
        conta.excluirConta();
        assertEquals((MSG.FALHA_EXCLUIRCONTA_CONTA_EM_USO).toString(),conta.obterTexto(By.xpath("//android.widget.TextView[@text='Conta em uso nas movimentações']")));
    }

    //3 - Validações da Movimentação
    @Test
    public void realizarMovimentacaoConta_ComSucesso(){
        inseriContaParaTeste("Teste de Movimentação");
        abasPage.acessarAbasSBNativo("MOV...");
        movPage.combosMovimentacao("Receita", "Despesa");
        movPage.informaSwitchPagamento_Pago();
        movPage.dataMovimentacao(0);
        movPage.okDatas();
        movPage.dataPagamento(2);
        movPage.okDatas();
        movPage.preencheDescricao("Conta de Luz");
        movPage.preencheInterassado("Rafael");
        movPage.preencheValor("250,00");
        movPage.combosMovimentacao("Selecione uma conta...", "Teste de Movimentação");
        movPage.salvarMovimentacao();

        assertEquals((MSG.SUCESSO_MOVIMENTACAO).toString(), movPage.obterTexto(By.xpath("//android.widget.TextView[@text='Movimentação cadastrada com sucesso']")));
    }

    @Test
    public void realizarMovimentacaoConta_ComFalha(){
        inseriContaParaTeste("Teste de Falha");
        abasPage.acessarAbasSBNativo("MOV...");
        movPage.combosMovimentacao("Receita", "Despesa");
        movPage.informaSwitchPagamento_Pago();
        movPage.dataMovimentacao(2);
        movPage.okDatas();
        movPage.dataPagamento(2);
        movPage.okDatas();
        movPage.preencheDescricao("Conta de Luz");
        movPage.preencheInterassado("Rafael");
        movPage.preencheValor("250,00");
        movPage.combosMovimentacao("Selecione uma conta...", "Teste de Falha");
        movPage.salvarMovimentacao();

        assertEquals((MSG.FALHA_MOVIMENTACAO_DATA).toString(), movPage.obterTexto(By.xpath("//android.widget.TextView[@text='Data da Movimentação deve ser menor ou igual à data atual']")));
    }




    private void inseriContaParaTeste(String nomeConta){
        abasPage.acessarAbasSBNativo("CONTAS");
        conta.inserirConta(nomeConta);
        conta.salvarConta();
    }

}
