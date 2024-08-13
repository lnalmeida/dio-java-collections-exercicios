package list.soma;

import list.soma.views.MenuNumeros;
import list.soma.views.SomaNumerosView;

public class Main {
    public static void main(String[] args) {
        SomaNumerosView somaNumerosView = new SomaNumerosView();
        MenuNumeros menuNumeros = new MenuNumeros(new SomaNumerosView());

        try {
            menuNumeros.mainMenu();
        } catch (InterruptedException e) {
            System.out.println("Ocorreu uma exceção.");
            e.printStackTrace();
        }
    }
}
