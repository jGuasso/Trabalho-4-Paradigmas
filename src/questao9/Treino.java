package questao9;

import java.util.*;

public class Treino {
    private String nome;
    private List<ItemTreino> exercicios = new ArrayList<>();

    public Treino(String nome) {
        this.nome = nome;
    }

    public void adicionarExercicio(Exercicio ex, int series, int repMin, int repMax, double carga, int descanso) {
        exercicios.add(new ItemTreino(ex, series, repMin, repMax, carga, descanso));
    }

    public List<ItemTreino> getExercicios() { return exercicios; }
    public String getNome() { return nome; }

    public static class ItemTreino {
        private Exercicio exercicio;
        private int series, repMin, repMax, descanso;
        private double carga;

        public ItemTreino(Exercicio exercicio, int series, int repMin, int repMax, double carga, int descanso) {
            this.exercicio = exercicio;
            this.series = series;
            this.repMin = repMin;
            this.repMax = repMax;
            this.carga = carga;
            this.descanso = descanso;
        }

        public Exercicio getExercicio() { return exercicio; }
        public double getCarga() { return carga; }
        public void setCarga(double carga) { this.carga = carga; }
    }
}
