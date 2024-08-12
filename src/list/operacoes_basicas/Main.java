package list.operacoes_basicas;

import list.operacoes_basicas.services.HandleTarefas;
import list.operacoes_basicas.services.Menu;

public class Main {
    public static void main(String[] args) {
        HandleTarefas handelTarefas = new HandleTarefas();
        Menu menu = new Menu(new HandleTarefas());

        try {
            menu.mainMenu();
        } catch (InterruptedException e) {
            System.out.println("Ocorreu uma exceção.");
            e.printStackTrace();
        }
    }
}
