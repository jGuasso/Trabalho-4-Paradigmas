import java.util.ArrayList;
import java.util.Iterator;
public class questao1 {
    public static void main(String[] args) {
        var l = new ArrayList<String>();
        l.add("Curitiba");
        l.add("Santa Maria");
        l.add("Florianópolis");
        l.add("Manaus");
        l.add("São Paulo");
        l.add("Brasília");

        Iterator<String> iterator = l.iterator();

        while (iterator.hasNext()) {
            String cidade = iterator.next();

            if (cidade.length() % 2 != 0) {
                iterator.remove();
            }
        }

        System.out.println(l);
    }
}
