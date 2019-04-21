import java.util.ArrayList;

public class PodziałKupionychPrętów {

    private Pręt pręt;
    private ArrayList<Odcinek> odcinki;

    public PodziałKupionychPrętów(Pręt pręt) {
        this.pręt = pręt;
        this.odcinki = new ArrayList<>();
    }

    public void dodajOdcinek(int długośćOdcinka) {
        Odcinek odcinek = new Odcinek(długośćOdcinka);
        odcinki.add(odcinek);
    }

    public void wypiszPodział() {
        System.out.print(pręt.getDługość());
        for (int i = 0; i < odcinki.size(); i++)
            System.out.print(" " + odcinki.get(i).getDługość());
        System.out.println();
    }

    public int getCenaPrętu() {
        return pręt.getCena();
    }
}
