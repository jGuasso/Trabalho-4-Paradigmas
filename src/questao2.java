import java.util.ArrayList;
import java.util.Scanner;
class Aluno {
    String matricula;
    String nome;
    double[] notas = new double[4];
    double media;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public void calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        this.media = soma / 4;
    }

    public boolean aprovado() {
        return media >= 7;
    }
}

public class questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();

        while (true) {
            System.out.print("\nDigite a matrícula ('sair' para terminar): ");
            String matricula = sc.nextLine();

            if (matricula.equals("sair")) {
                break;
            }

            System.out.print("\nDigite o nome do aluno: ");
            String nome = sc.nextLine();

            Aluno aluno = new Aluno(matricula, nome);

            for (int i = 0; i < 4; i++) {
                System.out.print("NOTA " + (i+1) + ": ");
                aluno.notas[i] = sc.nextDouble();
            }

            aluno.calcularMedia();
            alunos.add(aluno);
            sc.nextLine();
        }

        System.out.println("\nRelatório de Aprovação");
        System.out.println("---------------------");

        for (Aluno aluno : alunos) {
            System.out.printf("\nAluno: %s (%s)", aluno.nome, aluno.matricula);
            System.out.printf("\nNotas: N1=%.1f, N2=%.1f, N3=%.1f, N4=%.1f",
                    aluno.notas[0], aluno.notas[1], aluno.notas[2], aluno.notas[3]);
            System.out.printf("\nMédia: %.1f - Situação: %s\n",
                    aluno.media, aluno.aprovado() ? "Aprovado" : "Reprovado");
        }

        System.out.println("\nAlunos Aprovados:");
        System.out.println("----------------");
        for (Aluno aluno : alunos) {
            if (aluno.aprovado()) {
                System.out.printf("- %s (Matrícula: %s) - Média: %.1f\n",
                        aluno.nome, aluno.matricula, aluno.media);
            }
        }

        sc.close();
    }
}
