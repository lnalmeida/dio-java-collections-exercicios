package list.carrinho;

import list.carrinho.views.MenuCompras;
import list.pesquisa.views.Menu;
import list.carrinho.views.ViewCarrinho;

public class Main {
    public static void main(String[] args) {
        ViewCarrinho viewCarrinho = new ViewCarrinho();
        MenuCompras menuCompras = new MenuCompras(new ViewCarrinho());

        try {
            menuCompras.mainMenu();
        } catch (InterruptedException e) {
            System.out.println("Ocorreu uma exceção.");
            e.printStackTrace();
        }
    }
}
