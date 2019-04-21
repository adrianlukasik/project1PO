import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Ciąg {

    private TreeMap<Integer, Integer> reprezentacjaCiągu;

    public Ciąg() {
        reprezentacjaCiągu = new TreeMap<>();
    }

    public Ciąg(Ciąg ciąg) {
        reprezentacjaCiągu = new TreeMap<>(ciąg.reprezentacjaCiągu);
    }

    public TreeMap<Integer, Integer> getReprezentacjaCiągu() {
        return reprezentacjaCiągu;
    }

    public int zwróćNajwiększyKlucz() {
        return Collections.max(reprezentacjaCiągu.keySet());
    }

    public int getSumaWartości() {
        int suma = 0;
        for (Integer wartość : reprezentacjaCiągu.values())
            suma += wartość;
        return suma;
    }

    public Pręt[] zwróćZestawPrętów(Pręt[] tablicaPrętów) {
        int liczbaPrętów = getSumaWartości();
        Pręt[] pręty = new Pręt[liczbaPrętów];
        int licznik = 0;
        for (Map.Entry<Integer, Integer> entry : reprezentacjaCiągu.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                pręty[licznik] = new Pręt(tablicaPrętów[entry.getKey()].getDługość(), tablicaPrętów[entry.getKey()].getCena());
                licznik++;
            }
        }
        return pręty;
    }

    public int obliczCenę(Pręt[] tablicaPrętów) {
        int cena = 0;
        for (Map.Entry<Integer, Integer> entry : reprezentacjaCiągu.entrySet())
            cena += tablicaPrętów[entry.getKey()].getCena() * entry.getValue();
        return cena;
    }

    public int obliczSumęDługościPrętów(Pręt[] tablicaPrętów) {
        int wartość = 0;
        for (Map.Entry<Integer, Integer> entry : reprezentacjaCiągu.entrySet())
            wartość += tablicaPrętów[entry.getKey()].getDługość() * entry.getValue();
        return wartość;
    }

    public void zamieńNaSąsiada() {
        int klucz = zwróćNajwiększyKlucz();
        reprezentacjaCiągu.put(klucz, reprezentacjaCiągu.get(klucz) - 1);
        reprezentacjaCiągu.put(klucz + 1, 1);
    }

    public void zamieńZDodatkowymPrętem() {
        int klucz = zwróćNajwiększyKlucz();
        reprezentacjaCiągu.put(klucz, reprezentacjaCiągu.get(klucz) + 1);
    }
}
