package list.ordenacao.pessoas.services;

import list.ordenacao.pessoas.models.Pessoa;

import java.util.Comparator;

public class ComparatorPorAltura implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}
