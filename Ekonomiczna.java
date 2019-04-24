public class Ekonomiczna extends Plecakowa {

    @Override
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
            if (ciąg.obliczSumęDługościPrętów(pręty) >= opisProjektu.getSumaDługościOdcinków())
                znajdźWynik(ciąg.zwróćZestawPrętów(pręty),opisProjektu, new int[opisProjektu.getLiczbaOdcinków()], 0, wynik);
            dodajKolejneDoMapy(mapaCiągów, ciąg, pręty, opisProjektu.getLiczbaOdcinków());
        }
        return wynik;
    }

    @Override
    protected void dodajKolejneDoMapy(MapaCiągów mapaCiągów, Ciąg ciąg, Pręt[] prętyZCennika, int liczbaOdcinków) {
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
}
