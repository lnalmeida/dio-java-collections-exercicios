package list.carrinho.views;

import list.carrinho.models.Item;
import list.carrinho.services.CarrinhoCompras;
import list.pesquisa.models.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewCarrinho {
    private final CarrinhoCompras carrinhoCompras;
    private final Scanner input = new Scanner(System.in);

    public ViewCarrinho() {
        this.carrinhoCompras = new CarrinhoCompras();
    }

    public ViewCarrinho(CarrinhoCompras carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }

    public void adicionarItemView(Scanner input) {
        String nome = "";
        double preco = 0;
        int quantidade = 0;
        System.out.println("Adicionar Novo Item\n");
        do {
            System.out.print("Digite o Nome do item ou '0' para voltar: ");
            nome = input.next();
            if(!nome.equals("0")) {
                System.out.print("Digite o Preço do item: ");
                preco = input.nextDouble();
                System.out.print("Digite a quantidade do item: ");
                quantidade = input.nextInt();
                System.out.println("\n");
                carrinhoCompras.adicionarItem(nome, preco, quantidade);
            }
        } while (!nome.equals("0"));
    }

    public void listarItensView() {
        System.out.print("\033[H\033[2J");
        List<Item> listaItens = carrinhoCompras.listarItens();
        if (!listaItens.isEmpty()) {
            for (Item i : listaItens) {
                System.out.println("\n--------------------------------------");
                System.out.println("Nome: ".concat(i.getNome()));
                System.out.println("Preço: R$"+i.getPreco());
                System.out.println("Quantidade: " + i.getQuantidade());
                System.out.println("Subtotal: R$" + i.getSubTotal());
                System.out.println("--------------------------------------");
            }
            System.out.println("Total de itens no carrinho: " + listaItens.size());
        } else {
            System.out.println("Seu carrinho está vazio!");
        }
    }

    public void removerItemView(Scanner input) {
        System.out.print("Digite o NOME do item a ser removido: ");
        String nome = input.next();
        if(!nome.isEmpty()) {
            carrinhoCompras.removerItem(nome);
        } else {
            System.out.println("O nome do item dve ser digitado.");
        }
    }

    public void exibirTotalCompra() {
        this.listarItensView();
        System.out.printf("O total das suas compras foi: R$%.2f",carrinhoCompras.calcularTotal() );
    }
}
