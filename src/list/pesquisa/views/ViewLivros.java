package list.pesquisa.views;

import list.pesquisa.models.Livro;
import list.pesquisa.services.CatalogoLivros;

import java.util.List;
import java.util.Scanner;

public class ViewLivros {
    private CatalogoLivros catalogoLivros;
    private final Scanner input = new Scanner(System.in);

    public ViewLivros(CatalogoLivros catalogoLivros) {
        this.catalogoLivros = catalogoLivros;
    }

    public ViewLivros() {
        this.catalogoLivros = new CatalogoLivros();
    }

    public void adicionarLivrosView(Scanner input) {
        System.out.print("\033[H\033[2J");
        String titulo = "";
        String autor = "";
        int anoPublicacao = 0;
        System.out.println("Adicionar Novo Livro\n");
        do {
            System.out.print("Digite o Título do livro ou '0' para voltar: ");
            titulo = input.next();
            if(!titulo.equals("0")) {
                System.out.print("Digite o Autor do livro: ");
                autor = input.next();
                System.out.print("Digite o Anode Publicação do livro: ");
                anoPublicacao = input.nextInt();
                System.out.println("\n");
                catalogoLivros.adicionarLivro(titulo, autor, anoPublicacao);
            }
        } while (!titulo.equals("0"));
    }

    public void buscarLivrosTituloView(Scanner input) {
        System.out.print("\033[H\033[2J");
        System.out.print("Buscar Livro(s) pelo Título\n");
        System.out.print("Digite o títuloa ser consultado:");
        String titulo = input.next();
        List<Livro> livrosEncontrados = catalogoLivros.buscarLivroPorTitulo(titulo);
        if(!livrosEncontrados.isEmpty()) {
            System.out.println("Livro(s) encontrado(s): ");
            for(Livro l : livrosEncontrados) {
                System.out.println(l.toString());
            }
            System.out.println("Total de livros encontrados: " + livrosEncontrados.size());
        } else {
            System.out.println("Nenhum livro encontrado com esse título.");
        }
    }

    public void buscarLivrosAutorView(Scanner input) {
        System.out.print("\033[H\033[2J");
        System.out.print("Buscar Livro(s) pelo Autor\n");
        System.out.print("Digite o autor a ser consultado: ");
        String autor = input.next();
        List<Livro> livrosEncontrados = catalogoLivros.buscarLivroPorAutor(autor);
        if(!livrosEncontrados.isEmpty()) {
            System.out.println("Livro(s) encontrado(s): ");
            for(Livro l : livrosEncontrados) {
                System.out.println(l.toString());
            }
            System.out.println("Total de livros encontrados: " + livrosEncontrados.size());
        } else {
            System.out.println("Nenhum livro encontrado com esse autor.");
        }
    }

    public void buscarLivrosPeriodoPublicacaoView(Scanner input) {
        System.out.print("\033[H\033[2J");
        System.out.print("Buscar Livro(s) pelo Período de Publicação\n");
        System.out.print("Digite o ano inicial do intervalo a ser consultado: ");
        int anoInicial = input.nextInt();
        System.out.print("Digite o ano final do intervalo a ser consultado: ");
        int anoFinal = input.nextInt();
        if(anoInicial > anoFinal) {
            System.out.println("Intervalo inválido. O ano inicial deve ser maior que o ano final.");
        }
        List<Livro> livrosEncontrados = catalogoLivros.buscarLivroPorIntervaloDePublicacao(anoInicial, anoFinal);
        if(!livrosEncontrados.isEmpty()) {
            System.out.println("Livro(s) encontrado(s): ");
            for(Livro l : livrosEncontrados) {
                System.out.println(l.toString());
            }
        } else {
            System.out.println("Nenhum livro encontrado nesse período de publicação.");
        }
    }

    public void listarLivrosView() {
        System.out.print("\033[H\033[2J");
        List<Livro> listaLivros = catalogoLivros.listarCatalogoLivros();
        if (!listaLivros.isEmpty()) {
            for(Livro l : listaLivros){
                System.out.println("\n--------------------------------------");
                System.out.println("Tútulo: ".concat(l.getTitulo()));
                System.out.println("Autor: ".concat(l.getAutor()));
                System.out.println("Tútulo: "+l.getAnoPublicacao());
                System.out.println("--------------------------------------");
            }
            System.out.println("Total de livros encontrados: " + listaLivros.size());
        } else {
            System.out.println("Não há livors cadastrados!");
        }

    }
}
