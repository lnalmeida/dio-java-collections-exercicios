package list.pesquisa;

import list.pesquisa.views.Menu;
import list.pesquisa.views.ViewLivros;

public class Main {
    public static void main(String[] args) {
        ViewLivros vieLivros = new ViewLivros();
        Menu menu = new Menu(new ViewLivros());

        try {
            menu.mainMenu();
        } catch (InterruptedException e) {
            System.out.println("Ocorreu uma exceção.");
            e.printStackTrace();
        }
    }
}
