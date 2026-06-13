import java.util.*;

public class App {

    // ─────────────────────────────────────────
    // Exercício 01 – Fila com valores fixos
    // ─────────────────────────────────────────
    public static Queue<Integer> criarFilaValoresFixos() {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);
        fila.add(50);
        return fila;
    }

    static void exercicio01() {
        Queue<Integer> fila = criarFilaValoresFixos();

        System.out.println("=== Exercício 01 – Fila com Valores Fixos ===");
        System.out.println("Fila completa: " + fila);

        int removido = fila.poll();
        System.out.println("Elemento removido: " + removido);
        System.out.println("Fila após remoção: " + fila);
    }

    // ─────────────────────────────────────────
    // Exercício 02 – Fila de nomes
    // ─────────────────────────────────────────
    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Pedro");
        fila.add("Juliana");
        return fila;
    }

    static void exercicio02() {
        Queue<String> fila = criarFilaNomes();

        System.out.println("=== Exercício 02 – Fila de Nomes ===");
        System.out.println("Primeiro elemento: " + fila.peek());
        System.out.println("Quantidade de elementos: " + fila.size());
        System.out.println("Fila completa: " + fila);
    }

    // ─────────────────────────────────────────
    // Exercício 03 – Remover 10 números da fila
    // ─────────────────────────────────────────
    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
        List<Integer> removidos = new ArrayList<>();
        while (!fila.isEmpty()) {
            removidos.add(fila.poll());
        }
        return removidos;
    }

    static void exercicio03() {
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            fila.add(i * 10); // 10, 20, ..., 100
        }

        System.out.println("=== Exercício 03 – Remover 10 Números ===");
        System.out.println("Fila inicial: " + fila);

        List<Integer> removidos = removerTodosElementos(fila);
        System.out.println("Ordem de remoção (FIFO): " + removidos);
        System.out.println("Fila após remoção: " + fila);
    }

    // ─────────────────────────────────────────
    // Exercício 04 – Fila de atendimento
    // ─────────────────────────────────────────
    public static List<String> atenderClientes(Queue<String> fila) {
        List<String> atendidos = new ArrayList<>();
        while (!fila.isEmpty()) {
            atendidos.add(fila.poll());
        }
        return atendidos;
    }

    static void exercicio04() {
        Queue<String> fila = new LinkedList<>();
        fila.add("Maria");
        fila.add("José");
        fila.add("Lucas");
        fila.add("Fernanda");

        System.out.println("=== Exercício 04 – Fila de Atendimento ===");
        System.out.println("Fila completa: " + fila);
        System.out.println("Próximo a ser atendido: " + fila.peek());

        List<String> atendidos = atenderClientes(fila);
        System.out.println("Ordem de atendimento: " + atendidos);
        System.out.println("Fila após atendimentos: " + fila);
    }

    // ─────────────────────────────────────────
    // Exercício 05 – Fila de impressão
    // ─────────────────────────────────────────
    public static void adicionarDocumento(Queue<String> fila, String documento) {
        fila.add(documento);
    }

    public static String imprimirDocumento(Queue<String> fila) {
        return fila.poll(); // remove e retorna o primeiro
    }

    public static String proximoDocumento(Queue<String> fila) {
        return fila.peek(); // apenas consulta, sem remover
    }

    static void exercicio05() {
        Queue<String> fila = new LinkedList<>();

        System.out.println("=== Exercício 05 – Fila de Impressão ===");

        adicionarDocumento(fila, "Relatorio_Mensal.pdf");
        adicionarDocumento(fila, "Contrato.docx");
        adicionarDocumento(fila, "Planilha.xlsx");

        System.out.println("Documentos na fila: " + fila);
        System.out.println("Próximo documento: " + proximoDocumento(fila));

        String impresso = imprimirDocumento(fila);
        System.out.println("Documento impresso: " + impresso);
        System.out.println("Documentos pendentes: " + fila);
    }

    // ─────────────────────────────────────────
    // Menu principal
    // ─────────────────────────────────────────
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   ATIVIDADE – FILAS EM JAVA  ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Fila com valores fixos   ║");
            System.out.println("║  2. Fila de nomes            ║");
            System.out.println("║  3. Remover 10 números       ║");
            System.out.println("║  4. Fila de atendimento      ║");
            System.out.println("║  5. Fila de impressão        ║");
            System.out.println("║  0. Sair                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1 -> exercicio01();
                case 2 -> exercicio02();
                case 3 -> exercicio03();
                case 4 -> exercicio04();
                case 5 -> exercicio05();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
