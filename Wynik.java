import java.util.ArrayList;

public class Wynik {

    private int kosztZakupu;
    private int sumaOdpadów;
    private ArrayList<PodziałKupionychPrętów> zestawienie;

    public Wynik() {
        kosztZakupu = 0;
        sumaOdpadów = 0;
        zestawienie = new ArrayList<>();
    }

    public void zaaktualizujWynik(PodziałKupionychPrętów podział, int odpad) {
        kosztZakupu += podział.getCenaPrętu();
        sumaOdpadów += odpad;
        zestawienie.add(podział);
    }

    public void wypiszWynik() {
        System.out.println(kosztZakupu);
        System.out.println(sumaOdpadów);
        for (int i = 0; i < zestawienie.size(); i++)
            zestawienie.get(i).wypiszPodział();
    }

    public boolean brakWyniku() {
        return zestawienie.isEmpty();
    }
}
