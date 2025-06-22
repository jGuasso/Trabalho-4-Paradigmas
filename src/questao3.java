import java.util.TreeSet;
import java.util.NavigableSet;
public class questao3 {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(20);
        numeros.add(10);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        System.out.println("lower(30): " + numeros.lower(30));
        System.out.println("higher(30): " + numeros.higher(30));
        System.out.println("floor(30): " + numeros.floor(30));
        System.out.println("ceiling(30): " + numeros.ceiling(30));

        NavigableSet<Integer> decrescente = numeros.descendingSet();
        System.out.println(decrescente);
    }
}
