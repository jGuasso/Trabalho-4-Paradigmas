import java.util.Map;
import java.util.TreeMap;
public class questao5 {
    public static void main(String[] args) {
        TreeMap<String, Double> arvores = new TreeMap<>();
        arvores.put("Angico-Vermelho", 37.5);
        arvores.put("Guajuvira", 13.5);
        arvores.put("Pau-Ferro", 12.5);
        arvores.put("Araçá-Amarelo", 4.5);
        arvores.put("Canela-Sassafrás", 20.0);

        for (Map.Entry<String, Double> entrada : arvores.entrySet()) {
            System.out.printf("%-16s - %.1f metros%n", entrada.getKey(), entrada.getValue());
        }
    }
}
