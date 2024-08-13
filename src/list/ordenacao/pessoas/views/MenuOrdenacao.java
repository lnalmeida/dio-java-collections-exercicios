package list.ordenacao.pessoas.views;

import java.util.Scanner;

public class MenuOrdenacao {

    private final OrdenacaoPessoasView ordenacaoPessoasView;
    private boolean running = true;

    public MenuOrdenacao(OrdenacaoPessoasView ordenacaoPessoasView) {
        this.ordenacaoPessoasView = ordenacaoPessoasView;
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
        System.out.println("1 - Adicionar pessoa");
        System.out.println("2 - Ordenar pessoas por idade");
        System.out.println("3 - OIrdenar pessoas por altura");
        System.out.println("4 - Encerrar programa\n");
        System.out.print("escolha uma opção: ");
        int option = input.nextInt();
        switch (option) {
            case 1: {
                ordenacaoPessoasView.adicionarPessoasView(input);
                break;
            }
            case 2: {
                ordenacaoPessoasView.ordenaPorIdadeView();
                break;
            }
            case 3: {
                ordenacaoPessoasView.ordenaPorAlturaView();
                break;
            }
            case 4:
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
