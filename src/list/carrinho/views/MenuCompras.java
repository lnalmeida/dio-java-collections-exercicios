package list.carrinho.views;

import java.util.Scanner;

public class MenuCompras {
    private final ViewCarrinho viewCarrinho;
    private boolean running = true;


    public MenuCompras(ViewCarrinho viewCarrinho) {
        this.viewCarrinho = viewCarrinho;
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
        System.out.println("1 - Adicionar item");
        System.out.println("2 - Listar itens da compra");
        System.out.println("3 - Remover item pelo nome");
        System.out.println("4 - Fechar compra");
        System.out.println("5 - Encerrar programa\n");
        System.out.print("escolha uma opção: ");
        int option = input.nextInt();
        switch (option) {
            case 1: {
                viewCarrinho.adicionarItemView(input);
                break;
            }
            case 2: {
                viewCarrinho.listarItensView();
                break;
            }
            case 3: {
                viewCarrinho.removerItemView(input);
                break;
            }
            case 4: {
                viewCarrinho.exibirTotalCompra();
                break;
            }
            case 5:
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
