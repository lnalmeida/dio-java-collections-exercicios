package list.operacoes_basicas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarefas {
    private static Scanner input = new Scanner(System.in);
    private static List<String> tarefas = new ArrayList<String>();

    private static void menu() throws InterruptedException {
            System.out.print("\033[H\033[2J");
            System.out.println("Menu principal");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Remover Tarefa");
            System.out.println("3 - contar Tarefas");
            System.out.println("4 - Listar Tarefa");
            System.out.println("5 - Buscar Tarefa");
            System.out.println("6 - Encerrar programa\n");
            System.out.print("escolha uma opção: ");
            int option = input.nextInt();
            boolean running = true;
            switch (option) {
                    case 1: {
                        adicionarTarefa();
                        break;
                    }
                    case 2: {
                        removerTarefa();
                        break;
                    }
                    case 3: {
                        contarTarefa();
                        break;
                    }
                    case 4: {
                        listarTarefas();
                        break;
                    }
                    case 5: {
                        buscarTarefa();
                        break;
                    }
                    case 6:
                        running = false;
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            if (running) {
                System.out.println("\nPressione Enter para continuar...");
                input.nextLine();
            }

        }

    private static void buscarTarefa() {
        System.out.print("\033[H\033[2J");
        System.out.print("Digite o indice da tarefa a ser consultada ou (-1) pra sair: ");
        int tarefaConsultada = input.nextInt();
        if(tarefaConsultada != -1) {
            String result = tarefas.get(tarefaConsultada);
            System.out.println("Tarefa: ".concat(result));
        }
        try {
            menu();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void adicionarTarefa() {
        System.out.print("\033[H\033[2J");
        String novaTarefa;
        do {
            System.out.print("Descreva a nova tarefa (ou digite 'fim' para encerrar): ");
            novaTarefa = input.next();
            if(!novaTarefa.equals("fim")){
                tarefas.add(novaTarefa);
            }
        } while (!novaTarefa.equals("fim"));
        try {
            menu();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void removerTarefa() throws InterruptedException {
        try {
            System.out.print("\033[H\033[2J");
            System.out.print("Digite o índice da tarefa que deseja remover: ");
            int indiceTarefa = input.nextInt();
            tarefas.remove(indiceTarefa);
            System.out.println("Tarefa " + indiceTarefa + " removida.");
            Thread.sleep(2000);
            menu();
        } catch (Exception ex) {
            System.out.println("Erro na exclusão");
        }

    }

    private static void contarTarefa() throws InterruptedException {
        try {
            System.out.print("\033[H\033[2J");
            System.out.println("O total de tarefas cadastradas é: " + (tarefas.size()));
            Thread.sleep(2000);
            menu();
        } catch ( Exception ex) {
            System.out.println("Algo deu errado");
        }

    }

    private static void listarTarefas() throws InterruptedException{
        System.out.print("\033[H\033[2J");
        System.out.println("Tarefas Cadastradas");
        for(String tarefa : tarefas) {
            System.out.println(" - ".concat(tarefa));
        }
        Thread.sleep(5000);
        menu();

    }


    public static void main(String[] args) {
        System.out.println("Lista de Tarefas");
        try {
            menu();
            input.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
