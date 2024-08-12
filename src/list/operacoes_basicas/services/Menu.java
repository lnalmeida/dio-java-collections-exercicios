package list.operacoes_basicas.services;

import java.util.Scanner;

public class Menu {

    private final HandleTarefas handleTarefas;
    private boolean running = true;

    public Menu(HandleTarefas handleTarefas) {
        this.handleTarefas = handleTarefas;
    }

    public void mainMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        while (running) {
            menu(input);
        }
        input.close();
    }

    private void menu(Scanner input) throws InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.println("Menu principal");
        System.out.println("1 - Adicionar Tarefa");
        System.out.println("2 - Remover Tarefa");
        System.out.println("3 - contar Tarefas");
        System.out.println("4 - Listar Tarefa");
        System.out.println("5 - Buscar Tarefa");
        System.out.println("6 - Encerrar programa\n");
        System.out.print("escolha uma opção: ");
        int option = input.nextInt();
        switch (option) {
            case 1: {
                handleTarefas.adicionarTarefa(input);
                break;
            }
            case 2: {
                handleTarefas.removerTarefa(input);
                break;
            }
            case 3: {
                handleTarefas.contarTarefa();
                break;
            }
            case 4: {
                handleTarefas.listarTarefas();
                break;
            }
            case 5: {
                handleTarefas.buscarTarefa(input);
                break;
            }
            case 6:
                running = false;
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }

        if (this.running) {
            System.out.println("\nPressione Enter para continuar...");
            input.nextLine();
        }

    }

}
