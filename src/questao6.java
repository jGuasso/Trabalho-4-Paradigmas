import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class questao6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> avistamentos = new HashMap<>();

        avistamentos.put("Gato-maracajá", 3);
        avistamentos.put("Graxaim-do-campo", 12);
        avistamentos.put("Saracura-do-mato", 25);
        avistamentos.put("Preá", 7);
        avistamentos.put("Ratão-do-banhado", 2);

        System.out.print("\nDigite o nome do animal para consultar avistamentos: ");
        String animalConsulta = sc.nextLine();

        // Verificando e exibindo o resultado
        if (avistamentos.containsKey(animalConsulta)) {
            int quantidade = avistamentos.get(animalConsulta);
            System.out.printf("\nO animal '%s' foi avistado %d vezes.%n", animalConsulta, quantidade);
        } else {
            System.out.printf("\nO animal '%s' não foi registrado ou não foi avistado.%n", animalConsulta);
        }

        sc.close();
    }
}
