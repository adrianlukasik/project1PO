import java.util.Map;

public class Minimalistyczna extends Zachłanna {

    private int indeksNajkrótszegoPręta(CennikPrętów cennikPrętów, int i,
                                        int długośćOdcinka) {
        while (i >= 0 && cennikPrętów.getDługośćPręta(i) >= długośćOdcinka)
            i--;
        i++;
        return i;
    }

    @Override
    public Wynik rozwiążProblem(CennikPrętów cennikPrętów, OpisProjektu opisProjektu) {
        Wynik wynik = new Wynik();
        Map<Integer, Integer> mapaOdcinków = opisProjektu.getMapaOdcinków();
        int sumaDługościOdcinków = 0;
        int długośćOdcinka;
        int indeks = cennikPrętów.getLiczbaPrętów() - 1;
        Pręt aktualnyPręt = cennikPrętów.getPręt(indeks);
        PodziałKupionychPrętów podział = new PodziałKupionychPrętów(aktualnyPręt);
        while (!mapaOdcinków.isEmpty()) {
            długośćOdcinka = długośćNastępnegoOdcinka(mapaOdcinków,
                    aktualnyPręt, sumaDługościOdcinków);
            if (sumaDługościOdcinków == 0) {
                indeks = indeksNajkrótszegoPręta(cennikPrętów, indeks, długośćOdcinka);
                aktualnyPręt = cennikPrętów.getPręt(indeks);
                podział = new PodziałKupionychPrętów(aktualnyPręt);
            }
            if (długośćOdcinka == 0) {
                wynik.zaaktualizujWynik(podział, resztaPręta(
                        aktualnyPręt, sumaDługościOdcinków));
                sumaDługościOdcinków = 0;
            } else {
                zdejmijOdcinek(mapaOdcinków, długośćOdcinka);
                sumaDługościOdcinków += długośćOdcinka;
                podział.dodajOdcinek(długośćOdcinka);
            }
        }
        wynik.zaaktualizujWynik(podział, resztaPręta(
                aktualnyPręt, sumaDługościOdcinków));
        return wynik;
    }
}
