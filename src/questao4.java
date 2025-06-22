import java.util.PriorityQueue;

class Paciente implements Comparable<Paciente> {
    private String nome;
    private int nivelUrgencia;

    public Paciente(String nome, int nivelUrgencia) {
        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
    }

    @Override
    public int compareTo(Paciente outro) {
        return Integer.compare(this.nivelUrgencia, outro.nivelUrgencia);
    }

    @Override
    public String toString() {
        return nome + " (Urgência: " + nivelUrgencia + ")";
    }
}

public class questao4 {
    public static void main(String[] args) {
        PriorityQueue<Paciente> filaAtendimento = new PriorityQueue<>();

        filaAtendimento.add(new Paciente("João Antônio Guasso", 3));
        filaAtendimento.add(new Paciente("Leonardo Brisolla", 1));
        filaAtendimento.add(new Paciente("João Vitor Bernardi", 5));
        filaAtendimento.add(new Paciente("Luan Tiago Streck", 2));
        filaAtendimento.add(new Paciente("Enzo Santin", 4));

        System.out.println("Ordem de atendimento:");
        while (!filaAtendimento.isEmpty()) {
            Paciente paciente = filaAtendimento.poll();
            System.out.println("Atendendo: " + paciente);
        }

    }
}
