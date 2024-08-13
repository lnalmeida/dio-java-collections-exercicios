package list.soma.views;

import list.soma.services.SomaNumeros;

import java.util.Scanner;

public class MenuNumeros {

    private final SomaNumerosView somaNumerosView;
    private boolean running = true;

    public MenuNumeros(SomaNumerosView somaNumerosView) {
        this.somaNumerosView = somaNumerosView;
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
        System.out.println("1 - Adicionar número");
        System.out.println("2 - Listar números");
        System.out.println("3 - Obter maior número");
        System.out.println("4 - Obter menor número");
        System.out.println("5 - Obter a soma de todos os números");
        System.out.println("6 - Encerrar programa\n");
        System.out.print("escolha uma opção: ");
        int option = input.nextInt();
        switch (option) {
            case 1: {
                somaNumerosView.adicionarNumeroView(input);
                break;
            }
            case 2: {
                somaNumerosView.listarNumerosView();
                break;
            }
            case 3: {
                somaNumerosView.encontrarMaiorNumeroView();
                break;
            }
            case 4: {
                somaNumerosView.encontrarMenorrNumeroView();
                break;
            }
            case 5: {
                somaNumerosView.calcularSomaView();
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
