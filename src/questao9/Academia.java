package questao9;

import java.util.*;
import java.time.LocalDate;

public class Academia {
    private Map<String, Aluno> alunos = new HashMap<>();
    private Map<Integer, Plano> planos = new HashMap<>();
    private Map<Integer, Exercicio> exercicios = new HashMap<>();

    public void cadastrarAluno(Aluno aluno) {
        alunos.put(aluno.getCpf(), aluno);
    }

    public void cadastrarPlano(Plano plano) {
        planos.put(plano.getCodigo(), plano);
    }

    public void cadastrarExercicio(Exercicio exercicio) {
        exercicios.put(exercicio.getNumero(), exercicio);
    }

    public Aluno buscarAlunoPorCpf(String cpf) {
        return alunos.get(cpf);
    }

    public List<Aluno> buscarAlunoPorNome(String nome) {
        List<Aluno> encontrados = new ArrayList<>();
        for (Aluno a : alunos.values()) {
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(a);
            }
        }
        return encontrados;
    }

    public void iniciarTreino(String cpf, String nomeTreino) {
        Aluno aluno = alunos.get(cpf);
        if (aluno == null) return;
        for (Treino t : aluno.getTreinos()) {
            if (t.getNome().equalsIgnoreCase(nomeTreino)) {
                aluno.getRegistros().add(new RegistroTreino(LocalDate.now(), t));
            }
        }
    }

    public void emitirRelatorioPresenca(String cpf, LocalDate inicio, LocalDate fim) {
        Aluno aluno = alunos.get(cpf);
        System.out.println("Presenças de " + aluno.getNome() + ":");
        for (RegistroTreino r : aluno.getRegistros()) {
            if (!r.getData().isBefore(inicio) && !r.getData().isAfter(fim)) {
                System.out.println(r.getData());
            }
        }
    }

    public void relatorioEvolucaoCarga(String cpf, int numeroExercicio) {
        Aluno aluno = alunos.get(cpf);
        System.out.println("Evolução de carga para exercício " + numeroExercicio + ":");
        for (RegistroTreino r : aluno.getRegistros()) {
            for (Treino.ItemTreino item : r.getTreino().getExercicios()) {
                if (item.getExercicio().getNumero() == numeroExercicio) {
                    System.out.println(r.getData() + " - " + item.getCarga() + " kg");
                }
            }
        }
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos.values());
    }

    public List<Plano> getPlanos() {
        return new ArrayList<>(planos.values());
    }

    public List<Exercicio> getExercicios() {
        return new ArrayList<>(exercicios.values());
    }

    public Exercicio buscarExercicioPorNumero(int numero) {
        return exercicios.get(numero);
    }
}
