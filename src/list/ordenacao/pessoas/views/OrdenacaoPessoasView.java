package list.ordenacao.pessoas.views;

import list.ordenacao.pessoas.services.OrdenacaoPessoas;

import java.util.Scanner;

public class OrdenacaoPessoasView {
    private final OrdenacaoPessoas ordenacaoPessoas;
    private final Scanner input = new Scanner(System.in);

    public OrdenacaoPessoasView() {
        this.ordenacaoPessoas = new OrdenacaoPessoas();
    }

    public OrdenacaoPessoasView(OrdenacaoPessoas ordenacaoPessoas) {
        this.ordenacaoPessoas = ordenacaoPessoas;
    }

    public void adicionarPessoasView(Scanner input) {
        String nome = "";
        int idade = 0;
        double altura = 0;
        System.out.println("Adicionar nova pessoas");
        do {
            System.out.print("Digite o Nome da pessoa ou '0' para voltar: ");
            nome = input.next();
            if(!nome.equals("0")) {
                System.out.print("Digite a idade: ");
                idade = input.nextInt();
                System.out.print("Digite a altura: ");
                altura = input.nextDouble();
                System.out.println("\n");
                ordenacaoPessoas.adicionarPessoa(nome, idade, altura);
            }
        } while (!nome.equals("0"));
    }

    public void ordenaPorIdadeView() {
        System.out.println("Lista ordenadas por idade:");
        System.out.println(ordenacaoPessoas.ordenarPorIdade().toString());
    }

    public void ordenaPorAlturaView() {
        System.out.println("Lista ordenadas por altura:");
        System.out.println(ordenacaoPessoas.ordenarPorAltura().toString());
    }
}
