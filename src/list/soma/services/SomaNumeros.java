package list.soma.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SomaNumeros {
    private List<Integer> listaNumeros;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionaNumero(int numero) {
        listaNumeros.add(numero);
    }

    public int calcularSoma() {
        int totalSoma = 0;
        if(!listaNumeros.isEmpty()) {
            for(int n : listaNumeros) {
                totalSoma += n;
            }
        } else {
            System.out.println("A lista está vazia!");
        }
        return totalSoma;
    }

    public int encontrarMaiorNumero() {
        Optional<Integer> maiorNumero = Optional.of(0);
        if(!listaNumeros.isEmpty()) {
            maiorNumero = listaNumeros.stream().max(Comparator.naturalOrder());
            return maiorNumero.orElse(0);
        } else {
            System.out.println("A lista está vazia!");
            return 0;
        }
    }

    public int encontrarMenorNumero() {
        Optional<Integer> menorNumero = Optional.of(0);
        if(!listaNumeros.isEmpty()) {
            menorNumero = listaNumeros.stream().min(Comparator.naturalOrder());
            return menorNumero.orElse(0);
        } else {
            System.out.println("A lista está vazia!");
            return 0;
        }
    }

    public List<Integer> listarNumeros() {
        return listaNumeros;
    }
}
