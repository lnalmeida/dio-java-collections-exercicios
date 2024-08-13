package list.ordenacao.pessoas.services;

import list.ordenacao.pessoas.models.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoas {
    private final List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    public List<Pessoa> listarPessoas() {
        return listaPessoas;
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        Pessoa novaPessoa = new Pessoa();
        if(!nome.isEmpty()) {
            novaPessoa.setNome(nome);
            novaPessoa.setIdade(idade);
            novaPessoa.setAltura(altura);
            listaPessoas.add(novaPessoa);
        }
    }

    public List<Pessoa> ordenarPorIdade() {
       List<Pessoa> pessoasPorIdade = new ArrayList<>(listaPessoas);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listaPessoas);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }
}
