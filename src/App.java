import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    // =========================================================
    // EXERCICIO 01 - Fila com valores fixos
    // =========================================================
    public static Queue<Integer> criarFilaValoresFixos() {
        Queue<Integer> fila = new LinkedList<>();

        fila.offer(10);
        fila.offer(20);
        fila.offer(30);
        fila.offer(40);
        fila.offer(50);

        System.out.println("Fila completa: " + fila);

        fila.poll(); // remove o primeiro (10)

        System.out.println("Fila apos remocao: " + fila);

        return fila;
    }

    // =========================================================
    // EXERCICIO 02 - Fila de nomes
    // =========================================================
    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();

        fila.offer("Ana");
        fila.offer("Carlos");
        fila.offer("Pedro");
        fila.offer("Juliana");

        System.out.println("Primeiro elemento: " + fila.peek());
        System.out.println("Quantidade de elementos: " + fila.size());

        return fila;
    }

    // =========================================================
    // EXERCICIO 03 - Remover 10 numeros da fila
    // =========================================================
    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
        List<Integer> removidos = new ArrayList<>();

        while (!fila.isEmpty()) {
            int elemento = fila.poll();
            removidos.add(elemento);
            System.out.println("Removido: " + elemento);
        }

        return removidos;
    }

    // =========================================================
    // EXERCICIO 04 - Fila de atendimento
    // =========================================================
    public static List<String> atenderClientes(Queue<String> fila) {
        List<String> atendidos = new ArrayList<>();

        System.out.println("Proximo cliente: " + fila.peek());
        System.out.println("Fila completa: " + fila);

        while (!fila.isEmpty()) {
            String cliente = fila.poll();
            atendidos.add(cliente);
            System.out.println("Atendendo: " + cliente);
        }

        return atendidos;
    }

    // =========================================================
    // EXERCICIO 05 - Fila de impressao
    // =========================================================
    public static void adicionarDocumento(Queue<String> fila, String documento) {
        fila.offer(documento);
        System.out.println("Documento adicionado: " + documento);
    }

    public static String imprimirDocumento(Queue<String> fila) {
        if (fila.isEmpty()) {
            System.out.println("Nenhum documento na fila.");
            return null;
        }
        String documento = fila.poll();
        System.out.println("Imprimindo: " + documento);
        return documento;
    }

    public static String proximoDocumento(Queue<String> fila) {
        if (fila.isEmpty()) {
            System.out.println("Nenhum documento pendente.");
            return null;
        }
        String proximo = fila.peek();
        System.out.println("Proximo documento: " + proximo);
        return proximo;
    }

    // =========================================================
    // MENU PRINCIPAL
    // =========================================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n=============================");
            System.out.println("   ATIVIDADE - FILAS EM JAVA");
            System.out.println("=============================");
            System.out.println("1. Fila com valores fixos");
            System.out.println("2. Fila de nomes");
            System.out.println("3. Remover 10 numeros da fila");
            System.out.println("4. Fila de atendimento");
            System.out.println("5. Fila de impressao");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- Exercicio 01 ---");
                    criarFilaValoresFixos();
                    break;

                case 2:
                    System.out.println("\n--- Exercicio 02 ---");
                    criarFilaNomes();
                    break;

                case 3:
                    System.out.println("\n--- Exercicio 03 ---");
                    Queue<Integer> filaNumeros = new LinkedList<>();
                    for (int i = 1; i <= 10; i++) {
                        filaNumeros.offer(i * 10);
                    }
                    System.out.println("Fila inicial: " + filaNumeros);
                    removerTodosElementos(filaNumeros);
                    break;

                case 4:
                    System.out.println("\n--- Exercicio 04 ---");
                    Queue<String> filaAtendimento = new LinkedList<>();
                    System.out.print("Quantos clientes deseja cadastrar? ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Nome do cliente " + (i + 1) + ": ");
                        String nome = scanner.nextLine();
                        filaAtendimento.offer(nome);
                    }
                    atenderClientes(filaAtendimento);
                    break;

                case 5:
                    System.out.println("\n--- Exercicio 05 ---");
                    Queue<String> filaImpressao = new LinkedList<>();
                    adicionarDocumento(filaImpressao, "Relatorio.pdf");
                    adicionarDocumento(filaImpressao, "Contrato.docx");
                    adicionarDocumento(filaImpressao, "Planilha.xlsx");
                    System.out.println("Documentos pendentes: " + filaImpressao);
                    proximoDocumento(filaImpressao);
                    imprimirDocumento(filaImpressao);
                    System.out.println("Documentos pendentes: " + filaImpressao);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
