import java.util.Scanner;

public class Main {

    private static CennikPrętów wczytajCennik(Scanner scanner) {
        int C = scanner.nextInt();
        Pręt[] pręty = new Pręt[C];
        for (int i = 0; i < C; i++)
            pręty[i] = new Pręt(scanner.nextInt(), scanner.nextInt());
        CennikPrętów cennikPrętów = new CennikPrętów(pręty);
        return cennikPrętów;
    }

    private static OpisProjektu wczytajOpis(Scanner scanner) {
        int P = scanner.nextInt();
        Odcinek[] odcinki = new Odcinek[P];
        for (int i = 0; i < P; i++)
            odcinki[i] = new Odcinek(scanner.nextInt());
        OpisProjektu opisProjektu = new OpisProjektu(odcinki);
        return opisProjektu;
    }

    private static Strategia wczytajStrategię(Scanner scanner) {
        scanner.nextLine();
        String nazwaStrategii = scanner.nextLine();
        Strategia strategia;
        switch (nazwaStrategii) {
            case "minimalistyczna":
                strategia = new Minimalistyczna();
                break;
            case "maksymalistyczna":
                strategia = new Maksymalistyczna();
                break;
            case "ekonomiczna":
                strategia = new Ekonomiczna();
                break;
            case "ekologiczna":
                strategia = new Ekologiczna();
                break;
                default:
                    strategia = new Minimalistyczna();
                    break;
        }
        return strategia;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CennikPrętów cennikPrętów = wczytajCennik(scanner);
        OpisProjektu opisProjektu = wczytajOpis(scanner);
        Strategia strategia = wczytajStrategię(scanner);
        Wynik wynik = strategia.rozwiążProblem(cennikPrętów, opisProjektu);
        wynik.wypiszWynik();
    }
}
