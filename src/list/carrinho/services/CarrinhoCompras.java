package list.carrinho.services;

import list.carrinho.models.Item;
import list.pesquisa.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Item> carrinho;

    public CarrinhoCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        System.out.print("\033[H\033[2J");
        Item novoItem = new Item();
        if(!nome.equals("0")){
            novoItem.setNome(nome);
            novoItem.setPreco(preco);
            novoItem.setQuantidade(quantidade);
            novoItem.setSubTotal();
            carrinho.add(novoItem);
        }
    }

    public List<Item> listarItens() {
        return carrinho;
    }

    public void removerItem(String nome) {
        List<Item> itemsRemover = new ArrayList<>();
        if(!carrinho.isEmpty()) {
            for(Item i : carrinho) {
                if(i.getNome().equalsIgnoreCase(nome)){
                    itemsRemover.add(i);
                }
            }
        }
        if(!itemsRemover.isEmpty()) {
            carrinho.removeAll(itemsRemover);
        } else {
            System.out.println("Não foram encontrados itens com o nome ".concat(nome));
        }
    }

    public double calcularTotal(){
        double totalCarrinho = 0;
        if(!carrinho.isEmpty()) {
            for(Item i : carrinho) {
                totalCarrinho+= i.getSubTotal();
            }
            return totalCarrinho;
        } else {
            return 0;
        }
    }
}
