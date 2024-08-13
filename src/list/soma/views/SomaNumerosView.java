package list.soma.views;


import list.carrinho.models.Item;
import list.soma.services.SomaNumeros;

import java.util.List;
import java.util.Scanner;

public class SomaNumerosView {
    private final SomaNumeros somaNumeros;
    private final Scanner input = new Scanner(System.in);

    public SomaNumerosView() {
        this.somaNumeros = new SomaNumeros();
    }

    public SomaNumerosView(SomaNumeros somaNumeros) {
        this.somaNumeros = somaNumeros;
    }

    public void adicionarNumeroView(Scanner input) {
        String numero = "";
        System.out.println("Adicionar Novo Item\n");
        do {
            System.out.print("Digite um númeroo item ou 'f' para voltar: ");
            numero = input.next();
            if(!numero.equalsIgnoreCase("f")) {
                System.out.println("\n");
                somaNumeros.adicionaNumero(Integer.parseInt(numero));
            }
        } while (!numero.equals("f"));
    }

    public void listarNumerosView() {
        System.out.print("\033[H\033[2J");
        List<Integer> listanumeros = somaNumeros.listarNumeros();
        if (!listanumeros.isEmpty()) {
            System.out.println("Numeros inclusos na lista:");
            for (int n : listanumeros) {
                System.out.println(n);
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public void encontrarMaiorNumeroView() {
        System.out.print("\033[H\033[2J");
        System.out.println("O maior número da lista é: " + somaNumeros.encontrarMaiorNumero());
    }

    public void encontrarMenorrNumeroView() {
        System.out.print("\033[H\033[2J");
        System.out.println("O menor número da lista é: " + somaNumeros.encontrarMenorNumero());
    }

    public void calcularSomaView() {
        System.out.print("\033[H\033[2J");
        System.out.println("A soma de todos os números da lista é: " + somaNumeros.calcularSoma());
    }
}
