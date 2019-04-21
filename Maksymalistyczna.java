import java.util.Map;

public class Maksymalistyczna extends Zachłanna {

    @Override
    public Wynik rozwiążProblem(CennikPrętów cennikPrętów,
                                OpisProjektu opisProjektu) {
        Wynik wynik = new Wynik();
        Map<Integer, Integer> mapaOdcinków = opisProjektu.getMapaOdcinków();
        int sumaDługościOdcinków = 0;
        int długośćOdcinka;
        Pręt aktualnyPręt = cennikPrętów.getPręt(
                cennikPrętów.getLiczbaPrętów() - 1);
        PodziałKupionychPrętów podział = new PodziałKupionychPrętów(aktualnyPręt);
        while (!mapaOdcinków.isEmpty()) {
            długośćOdcinka = długośćNastępnegoOdcinka(mapaOdcinków,
                    aktualnyPręt, sumaDługościOdcinków);
            if (sumaDługościOdcinków == 0)
                podział = new PodziałKupionychPrętów(aktualnyPręt);
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
