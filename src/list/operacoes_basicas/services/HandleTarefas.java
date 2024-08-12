package list.operacoes_basicas.services;

import list.operacoes_basicas.models.Tarefa;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleTarefas {
    private Tarefa _tarefa;
    private final List<Tarefa> listaTarefas;

    public HandleTarefas() {
        this.listaTarefas = new ArrayList<>();
    }

    public void buscarTarefa(Scanner input) {
        System.out.print("\033[H\033[2J");
        System.out.print("Digite o ID da tarefa a ser consultada ou (-1) pra sair: ");
        int tarefaConsultada = input.nextInt();
        boolean tarefaEncontrada = false;
        if(tarefaConsultada != -1) {
            for (Tarefa t : listaTarefas) {
                if(t.getId() == tarefaConsultada) {
                    System.out.println("Tarefa encontrada");
                    System.out.println("Tarefa: ID: " + t.getId() + " - Descrição: " + t.getDescricao());
                    tarefaEncontrada = true;
                    break;
                }
            }
            if(!tarefaEncontrada){
                System.out.println("Tarefa com o ID " + tarefaConsultada + " não encontrarda.");
            }

        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public void adicionarTarefa(Scanner input) {
        System.out.print("\033[H\033[2J");
        String descricao = "";
        do {
            Tarefa novaTarefa = new Tarefa();
            System.out.print("Descreva a nova tarefa (ou digite 'fim' para encerrar): ");
            descricao = input.next();
            if(!descricao.equals("fim")){
                novaTarefa.setId(listaTarefas.size() + 1);
                novaTarefa.setDescricao(descricao);
                listaTarefas.add(novaTarefa);
            }
        } while (!descricao.equals("fim"));
    }

    public void removerTarefa(Scanner input)  {
        System.out.print("\033[H\033[2J");
        System.out.print("Digite o índice da tarefa que deseja remover: ");
        int idTarefa = input.nextInt();
        if (idTarefa >= 1) {
            listaTarefas.removeIf(t -> t.getId() == idTarefa);
        } else {
            System.out.println("ÍD inválido ou não encontrado.");
        }
    }

    public void contarTarefa() {
        System.out.print("\033[H\033[2J");
        System.out.println("O total de tarefas cadastradas é: " + listaTarefas.size());
    }

    public void listarTarefas() throws InterruptedException{
        System.out.print("\033[H\033[2J");
        System.out.println("Tarefas Cadastradas");
        for(Tarefa t : listaTarefas) {
            System.out.println("ID: - " + t.getId() + " - Descrição: " + t.getDescricao());
        }
    }
}
