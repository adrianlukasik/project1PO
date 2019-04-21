import java.util.Map;

public class TestGetMapaOdcinków {

    public static void main(String[] args) {
        Odcinek[] odcinki = new Odcinek[10];
        odcinki[0] = new Odcinek(200);
        odcinki[1] = new Odcinek(200);
        odcinki[2] = new Odcinek(350);
        odcinki[3] = new Odcinek(350);
        odcinki[4] = new Odcinek(350);
        odcinki[5] = new Odcinek(600);
        odcinki[6] = new Odcinek(1500);
        odcinki[7] = new Odcinek(1500);
        odcinki[8] = new Odcinek(3000);
        odcinki[9] = new Odcinek(4500);

        Pręt[] pręty = new Pręt[3];
        pręty[0] = new Pręt(4000, 100);
        pręty[1] = new Pręt(4500, 160);
        pręty[2] = new Pręt(10000, 200);

        OpisProjektu opisProjektu = new OpisProjektu(odcinki);
        CennikPrętów cennikPrętów = new CennikPrętów(pręty);

        Strategia mini = new Minimalistyczna();
        Wynik wynik = mini.rozwiążProblem(cennikPrętów, opisProjektu);
        wynik.wypiszWynik();

        /*Strategia maxi = new Maksymalistyczna();
        Wynik wynik = maxi.rozwiążProblem(cennikPrętów, opisProjektu);
        wynik.wypiszWynik();*/


        //Map<Integer, Integer> mapa = opisProjektu.getMapaOdcinków();
        //System.out.println(mapa);
    }
}
