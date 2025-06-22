package questao9;

import java.time.LocalDate;
import java.util.*;

public class RegistroTreino {
    private LocalDate data;
    private Treino treino;
    private Set<Integer> exerciciosConcluidos = new HashSet<>();

    public RegistroTreino(LocalDate data, Treino treino) {
        this.data = data;
        this.treino = treino;
    }

    public void marcarConcluido(int numeroExercicio) {
        exerciciosConcluidos.add(numeroExercicio);
    }

    public LocalDate getData() { return data; }
    public Treino getTreino() { return treino; }
    public boolean isConcluido(int numero) {
        return exerciciosConcluidos.contains(numero);
    }
}
