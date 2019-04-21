public class Ekonomiczna extends Strategia {

    private boolean algorytmPlecakowy(Pręt[] pręty, OpisProjektu opisProjektu, int[] ciągUstawień) {
        int[] stan = new int[pręty.length];
        for (int i = 0; i < stan.length; i++)
            stan[i] = 0;
        for (int i = 0; i < ciągUstawień.length; i++) {
            stan[ciągUstawień[i]] += opisProjektu.getDługośćOdcinka(i);
            if (stan[ciągUstawień[i]] > pręty[ciągUstawień[i]].getDługość())
                return false;
        }
        return true;
    }

    private void wygenerujWynik(Wynik wynik, Pręt[] pręty, OpisProjektu opisProjektu, int[] ciągUstawień) {
        PodziałKupionychPrętów[] podziały = new PodziałKupionychPrętów[pręty.length];
        for (int i = 0; i < podziały.length; i++)
            podziały[i] = new PodziałKupionychPrętów(pręty[i]);
        int[] sumaDługościOdcinków = new int[pręty.length];
        for (int i = 0; i < sumaDługościOdcinków.length; i++)
            sumaDługościOdcinków[i] = 0;
        for (int i = 0; i < opisProjektu.getLiczbaOdcinków(); i++) {
            podziały[ciągUstawień[i]].dodajOdcinek(opisProjektu.getDługośćOdcinka(i));
            sumaDługościOdcinków[ciągUstawień[i]] += opisProjektu.getDługośćOdcinka(i);
        }
        for (int i = 0; i < pręty.length; i++)
            wynik.zaaktualizujWynik(podziały[i], resztaPręta(pręty[i], sumaDługościOdcinków[i]));
    }

    private void znajdźWynik(Pręt[] pręty, OpisProjektu opisProjektu, int[] ciągUstawień, int i, Wynik wynik) {
        if (wynik.brakWyniku()) {
            if (i == ciągUstawień.length) {
                if (algorytmPlecakowy(pręty, opisProjektu, ciągUstawień))
                    wygenerujWynik(wynik, pręty, opisProjektu, ciągUstawień);
            } else {
                for (int j = 0; j < pręty.length; j++) {
                    ciągUstawień[i] = j;
                    znajdźWynik(pręty, opisProjektu, ciągUstawień, i + 1, wynik);
                }
            }
        }
    }

    void dodajKolejneDoMapy(MapaCiągów mapaCiągów, Ciąg ciąg,
                            Pręt[] prętyZCennika, int liczbaOdcinków) {
        if (ciąg.getSumaWartości() < liczbaOdcinków) {
            int indeksNajdłuższegoPręta = ciąg.zwróćNajwiększyKlucz();
            if (indeksNajdłuższegoPręta < prętyZCennika.length - 1) {
                Ciąg ciągSąsiadów = new Ciąg(ciąg);
                ciągSąsiadów.zamieńNaSąsiada();
                mapaCiągów.dodajCiąg(ciągSąsiadów.obliczCenę(prętyZCennika), ciągSąsiadów);
            }
            Ciąg ciągZDodatkowymPrętem = new Ciąg(ciąg);
            ciągZDodatkowymPrętem.zamieńZDodatkowymPrętem();
            mapaCiągów.dodajCiąg(ciągZDodatkowymPrętem.obliczCenę(prętyZCennika), ciągZDodatkowymPrętem);
        }
    }

    public Wynik rozwiążProblem(CennikPrętów cennikPrętów,
                                OpisProjektu opisProjektu) {
        Pręt[] pręty = cennikPrętów.getTablicaPrętówPoCenie();
        Wynik wynik = new Wynik();
        MapaCiągów mapaCiągów = new MapaCiągów();
        Ciąg ciąg = new Ciąg();
        ciąg.getReprezentacjaCiągu().put(0, 1);
        mapaCiągów.dodajCiąg(pręty[0].getCena(), ciąg);
        while (wynik.brakWyniku()) {
            ciąg = mapaCiągów.zwróćMinimalnyCiąg();
            if (ciąg.obliczSumęDługościPrętów(pręty) > opisProjektu.getSumaDługościOdcinków())
                znajdźWynik(ciąg.zwróćZestawPrętów(pręty),opisProjektu, new int[opisProjektu.getLiczbaOdcinków()], 0, wynik);
            dodajKolejneDoMapy(mapaCiągów, ciąg, pręty, opisProjektu.getLiczbaOdcinków());
        }
        return wynik;
    }
}
