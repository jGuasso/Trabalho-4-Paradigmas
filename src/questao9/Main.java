package questao9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Academia service = new Academia();
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("\n----- MENU ACADEMIA -----");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Listar alunos");
            System.out.println("3. Buscar aluno por CPF");
            System.out.println("4. Buscar aluno por nome");
            System.out.println("5. Cadastrar plano");
            System.out.println("6. Listar planos");
            System.out.println("7. Cadastrar exercício");
            System.out.println("8. Listar exercícios");
            System.out.println("9. Cadastrar treino para aluno");
            System.out.println("10. Iniciar treino");
            System.out.println("11. Relatório de presenças");
            System.out.println("12. Relatório de evolução de carga");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> buscarAlunoPorCpf();
                case 4 -> buscarAlunoPorNome();
                case 5 -> cadastrarPlano();
                case 6 -> listarPlanos();
                case 7 -> cadastrarExercicio();
                case 8 -> listarExercicios();
                case 9 -> cadastrarTreino();
                case 10 -> iniciarTreino();
                case 11 -> relatorioPresencas();
                case 12 -> relatorioEvolucao();
                case 0 -> executando = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        LocalDate nascimento = LocalDate.parse(scanner.nextLine(), dtf);
        Aluno aluno = new Aluno(cpf, nome, nascimento);
        service.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private static void listarAlunos() {
        System.out.println("--- Alunos ---");
        for (Aluno a : service.getAlunos()) {
            System.out.println(a.getCpf() + " " + a.getNome() + " " + dtf.format(a.getDataNascimento()));
        }
    }

    private static void buscarAlunoPorCpf() {
        System.out.print("Digite o CPF: ");
        Aluno a = service.buscarAlunoPorCpf(scanner.nextLine());
        if (a != null) {
            System.out.println(a.getNome() + " - " + dtf.format(a.getDataNascimento()));
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void cadastrarPlano() {
        System.out.print("Código: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Valor mensal: ");
        double valor = Double.parseDouble(scanner.nextLine());
        service.cadastrarPlano(new Plano(codigo, nome, valor));
        System.out.println("Plano cadastrado.");
    }

    private static void listarPlanos() {
        System.out.println("--- Planos ---");
        for (Plano p : service.getPlanos()) {
            System.out.println(p);
        }
    }

    private static void cadastrarExercicio() {
        System.out.print("Número: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Músculos ativados (separados por vírgula): ");
        List<String> musculos = Arrays.asList(scanner.nextLine().split(", *"));
        service.cadastrarExercicio(new Exercicio(numero, nome, musculos));
        System.out.println("Exercício cadastrado.");
    }

    private static void listarExercicios() {
        System.out.println("--- Exercícios ---");
        for (Exercicio e : service.getExercicios()) {
            System.out.println(e);
        }
    }

    private static void cadastrarTreino() {
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno aluno = service.buscarAlunoPorCpf(cpf);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        System.out.print("Nome do treino: ");
        String nomeTreino = scanner.nextLine();
        Treino treino = new Treino(nomeTreino);
        while (true) {
            System.out.print("Número do exercício (0 para sair): ");
            int num = Integer.parseInt(scanner.nextLine());
            if (num == 0) break;
            Exercicio e = service.buscarExercicioPorNumero(num);
            if (e == null) {
                System.out.println("Exercício não encontrado.");
                continue;
            }
            System.out.print("Séries: ");
            int series = Integer.parseInt(scanner.nextLine());
            System.out.print("Repetições mínimas: ");
            int repMin = Integer.parseInt(scanner.nextLine());
            System.out.print("Repetições máximas: ");
            int repMax = Integer.parseInt(scanner.nextLine());
            System.out.print("Carga (kg): ");
            double carga = Double.parseDouble(scanner.nextLine());
            System.out.print("Descanso (minutos): ");
            int descanso = Integer.parseInt(scanner.nextLine());
            treino.adicionarExercicio(e, series, repMin, repMax, carga, descanso);
        }
        aluno.getTreinos().add(treino);
        System.out.println("Treino adicionado.");
    }

    private static void iniciarTreino() {
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome do treino: ");
        String nome = scanner.nextLine();
        service.iniciarTreino(cpf, nome);
        System.out.println("Treino iniciado.");
    }

    private static void relatorioPresencas() {
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        System.out.print("Data início (dd/MM/yyyy): ");
        LocalDate inicio = LocalDate.parse(scanner.nextLine(), dtf);
        System.out.print("Data fim (dd/MM/yyyy): ");
        LocalDate fim = LocalDate.parse(scanner.nextLine(), dtf);
        service.emitirRelatorioPresenca(cpf, inicio, fim);
    }

    private static void buscarAlunoPorNome() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        List<Aluno> encontrados = service.buscarAlunoPorNome(nome);
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            for (Aluno a : encontrados) {
                System.out.println(a.getCpf() + " - " + a.getNome());
            }
        }
    }

    private static void relatorioEvolucao() {
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        System.out.print("Número do exercício: ");
        int numero = Integer.parseInt(scanner.nextLine());
        service.relatorioEvolucaoCarga(cpf, numero);
    }
}

