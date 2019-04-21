import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public abstract class Strategia {

    public abstract Wynik rozwiążProblem(CennikPrętów cennikPrętów,
                                        OpisProjektu opisProjektu);

    protected void zdejmijOdcinek(Map<Integer, Integer> mapaOdcinków,
                                int długośćOdcinka) {
        if (mapaOdcinków.containsKey(długośćOdcinka)) {
            mapaOdcinków.put(długośćOdcinka, mapaOdcinków.get(długośćOdcinka) - 1);
            if (mapaOdcinków.get(długośćOdcinka) == 0)
                mapaOdcinków.remove(długośćOdcinka);
        }
    }

    protected int resztaPręta(Pręt pręt, int sumaDługościOdcinków) {
        return pręt.getDługość() - sumaDługościOdcinków;
    }

    protected int długośćNastępnegoOdcinka(Map<Integer, Integer> mapaOdcinków,
                                         Pręt pręt, int sumaDługościOdcinków) {
        if (sumaDługościOdcinków == 0)
            return Collections.max(mapaOdcinków.keySet());
        else if (((TreeMap<Integer, Integer>) mapaOdcinków).floorKey(
                resztaPręta(pręt, sumaDługościOdcinków)) != null)
            return ((TreeMap<Integer, Integer>) mapaOdcinków).floorKey(
                    resztaPręta(pręt, sumaDługościOdcinków));
        else
            return 0;
    }
}
