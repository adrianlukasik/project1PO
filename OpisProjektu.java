import java.util.Map;
import java.util.TreeMap;

public class OpisProjektu {

    private Odcinek[] odcinki;

    public OpisProjektu(Odcinek[] odcinki) {
        this.odcinki = new Odcinek[odcinki.length];
        for (int i = 0; i < odcinki.length; i++)
            this.odcinki[i] = new Odcinek(odcinki[i].getDługość());
    }

    public Map<Integer, Integer> getMapaOdcinków() {
        Map<Integer, Integer> mapaOdcinków = new TreeMap<>();
        int długośćAktualnego = odcinki[0].getDługość();
        int licznikAktualnego = 1;
        for (int i = 1; i < odcinki.length; i++) {
            if (długośćAktualnego == odcinki[i].getDługość()) {
                licznikAktualnego++;
            } else {
                mapaOdcinków.put(długośćAktualnego, licznikAktualnego);
                długośćAktualnego = odcinki[i].getDługość();
                licznikAktualnego = 1;
            }
        }
        mapaOdcinków.put(długośćAktualnego, licznikAktualnego);
        return mapaOdcinków;
    }

    public int getLiczbaOdcinków() {
        return odcinki.length;
    }

    public int getDługośćOdcinka(int i) {
        return odcinki[i].getDługość();
    }

    public int getSumaDługościOdcinków() {
        int suma = 0;
        for (int i = 0; i < odcinki.length; i++)
            suma += odcinki[i].getDługość();
        return suma;
    }

    public void foo() {
        for (int i = 0; i < odcinki.length; i++)
            System.out.println(odcinki[i].getDługość());
    }

}
