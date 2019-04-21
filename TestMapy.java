import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TestMapy {

    public static void main(String[] args) {

        Map<Integer, Integer> odcinki = new TreeMap<>();

        odcinki.put(200, 2);
        odcinki.put(350, 3);
        odcinki.put(600, 1);
        odcinki.put(1500, 2);
        odcinki.put(3000, 1);
        odcinki.put(4500, 1);

        int t = Collections.max(odcinki.keySet());

        System.out.println(t);

        //System.out.println(((TreeMap<Integer, Integer>) odcinki).ceilingKey(3001));
        //System.out.println(((TreeMap<Integer, Integer>) odcinki).floorKey(199));

    }
}
