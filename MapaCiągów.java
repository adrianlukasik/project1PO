import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class MapaCiągów {

    private TreeMap<Integer, ArrayList<Ciąg>> mapaCiagów;

    public MapaCiągów() {
        mapaCiagów = new TreeMap<>();
    }

    public TreeMap<Integer, ArrayList<Ciąg>> getMapaCiagów() {
        return mapaCiagów;
    }

    /* Parametr może być sumą długości prętów lub sumą cen. */
    public void dodajCiąg(int parametr, Ciąg ciąg) {
        if (mapaCiagów.containsKey(parametr)) {
            mapaCiagów.get(parametr).add(ciąg);
        } else {
            ArrayList<Ciąg> tablica = new ArrayList<>();
            tablica.add(ciąg);
            mapaCiagów.put(parametr, tablica);
        }
    }

    public Ciąg zwróćMinimalnyCiąg() {
        int klucz = Collections.min(mapaCiagów.keySet());
        ArrayList<Ciąg> tablica = mapaCiagów.get(klucz);
        Ciąg ciąg = tablica.get(tablica.size() - 1);
        tablica.remove(tablica.size() - 1);
        if (tablica.isEmpty())
            mapaCiagów.remove(klucz);
        return ciąg;
    }
}
