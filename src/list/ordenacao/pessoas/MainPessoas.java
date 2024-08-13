package list.ordenacao.pessoas;

import list.ordenacao.pessoas.views.MenuOrdenacao;
import list.ordenacao.pessoas.views.OrdenacaoPessoasView;

public class MainPessoas {
    public static void main(String[] args) {
        OrdenacaoPessoasView ordenacaoPessoasView = new OrdenacaoPessoasView();
        MenuOrdenacao menuOrdenacao = new MenuOrdenacao(new OrdenacaoPessoasView());

        try {
            menuOrdenacao.mainMenu();
        } catch (InterruptedException e) {
            System.out.println("Ocorreu uma exceção.");
            e.printStackTrace();
        }
    }
}
