package list.pesquisa.views;

import list.pesquisa.views.ViewLivros;

import java.util.Scanner;

public class Menu {

    private final ViewLivros viewLivros;
    private boolean running = true;

    public Menu(ViewLivros viewLivros) {
        this.viewLivros = viewLivros;
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
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Buscar por título");
        System.out.println("4 - Buscar por autor");
        System.out.println("5 - Buscar por período de publicação");
        System.out.println("6 - Encerrar programa\n");
        System.out.print("escolha uma opção: ");
        int option = input.nextInt();
        switch (option) {
            case 1: {
                viewLivros.adicionarLivrosView(input);
                break;
            }
            case 2: {
                viewLivros.listarLivrosView();
                break;
            }
            case 3: {
                viewLivros.buscarLivrosTituloView(input);
                break;
            }
            case 4: {
                viewLivros.buscarLivrosAutorView(input);
                break;
            }
            case 5: {
                viewLivros.buscarLivrosPeriodoPublicacaoView(input);
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
