package list.pesquisa.services;

import list.pesquisa.models.Livro;

import java.util.*;

public class CatalogoLivros {
    private final List<Livro> catalogoLivros;

    public CatalogoLivros() {
        this.catalogoLivros = new ArrayList<>();
    }

    public List<Livro> listarCatalogoLivros() {
        return catalogoLivros;
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        System.out.print("\033[H\033[2J");
            Livro novoLivro = new Livro();
            if(!titulo.equals("0")){
                novoLivro.setTitulo(titulo);
                novoLivro.setAutor(autor);
                novoLivro.setAnoPublicacao(anoPublicacao);
                catalogoLivros.add(novoLivro);
            }
    }

    public List<Livro> buscarLivroPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        if(!catalogoLivros.isEmpty()) {
            for(Livro l : catalogoLivros) {
                if(l.getAutor().equalsIgnoreCase(autor)) {
                    livrosEncontrados.add(l);
                }
            }
        }
        return livrosEncontrados.stream().toList();
    }

    public List<Livro> buscarLivroPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        if(!catalogoLivros.isEmpty()) {
            for(Livro l : catalogoLivros) {
                if(l.getTitulo().equalsIgnoreCase(titulo)) {
                    livrosEncontrados.add(l);
                }
            }
        }
        return livrosEncontrados.stream().toList();
    }

    public List<Livro> buscarLivroPorIntervaloDePublicacao(int anoInicial, int anoFinal) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        if(!catalogoLivros.isEmpty()) {
            for(Livro l : catalogoLivros) {
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <=anoFinal) {
                    livrosEncontrados.add(l);
                }
            }
        }
        return livrosEncontrados.stream().toList();
    }
}
