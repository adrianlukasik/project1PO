import java.util.ArrayList;
import java.util.TreeMap;

public class TestPretow {

    public static void main(String[] args) {

        // ciąg prętów trzymamy w treemapie.
        TreeMap<Integer, Integer> mapaPrętów = new TreeMap<>();
        // wrzucamy pręt o indeksie 0 i liczbie sztuk 5.
        mapaPrętów.put(0, 5);
        // wrzucamy pręt o indeksie 1 i liczbie sztuk 1.
        mapaPrętów.put(1, 2);
        // interpretujemy to jako ciąg [5,2,0]

        System.out.println(mapaPrętów);

        TreeMap<Integer, Integer> mapaPrętówClone = new TreeMap<>(mapaPrętów);

        mapaPrętów.put(11, 3);

        System.out.println(mapaPrętów);
        System.out.println(mapaPrętówClone);

        // mapaCiągów.
        TreeMap<Integer, ArrayList<TreeMap<Integer, Integer>>> mapaCiągów =
                new TreeMap<>();

        Pręt[] pręty = new Pręt[3];
        pręty[0] = new Pręt(4000, 100);
        pręty[1] = new Pręt(4500, 160);
        pręty[2] = new Pręt(10000, 200);
        CennikPrętów cennikPrętów = new CennikPrętów(pręty);

        int suma = 0;

        for (Integer key : mapaPrętów.keySet()) {
            suma += mapaPrętów.get(key) * cennikPrętów.getCenaPręta(key);
        }

        mapaCiągów.put(suma, new ArrayList<>());

        System.out.println(mapaCiągów.get(suma).size());

        mapaCiągów.get(suma).add(mapaPrętów);

        System.out.println(mapaCiągów.get(suma).size());

        System.out.println(suma);
    }
}
