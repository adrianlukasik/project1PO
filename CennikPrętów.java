import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CennikPrętów {
    private Pręt[] pręty;

    public CennikPrętów(Pręt[] pręty) {
        this.pręty = new Pręt[pręty.length];
        for (int i = 0; i < pręty.length; i++)
            this.pręty[i] = new Pręt(pręty[i].getDługość(), pręty[i].getCena());
    }

    public int getLiczbaPrętów() {
        return pręty.length;
    }

    public int getDługośćPręta(int i) {
        return pręty[i].getDługość();
    }

    public int getCenaPręta(int i) {
        return pręty[i].getCena();
    }

    public Pręt getPręt(int i) {
        return new Pręt(pręty[i].getDługość(), pręty[i].getCena());
    }

    public int getIndeksOstatniegoPręta() {
        return pręty.length - 1;
    }

    public Pręt[] getTablicaPrętówPoDługości() {
        Pręt[] prętyPoDługości = new Pręt[pręty.length];
        for (int i = 0; i < pręty.length; i++)
            prętyPoDługości[i] = new Pręt(pręty[i].getDługość(), pręty[i].getCena());
        return prętyPoDługości;
    }

    public Pręt[] getTablicaPrętówPoCenie() {
        TreeMap<Integer, ArrayList<Integer>> mapa = new TreeMap<>();
        for (Pręt pręt : pręty) {
            if (mapa.containsKey(pręt.getCena())) {
                mapa.get(pręt.getCena()).add(pręt.getDługość());
            } else {
                ArrayList<Integer> tablica = new ArrayList<>();
                tablica.add(pręt.getDługość());
                mapa.put(pręt.getCena(), tablica);
            }
        }
        Pręt[] prętyPoCenie = new Pręt[pręty.length];
        int licznik = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> element : mapa.entrySet()) {
            while (element.getValue().size() > 0) {
                prętyPoCenie[licznik] = new Pręt(element.getValue().get(
                        element.getValue().size() - 1), element.getKey());
                element.getValue().remove(element.getValue().size() - 1);
                licznik++;
            }
        }
        return prętyPoCenie;
    }
}
