public abstract class Strategia {

    public abstract Wynik rozwiążProblem(CennikPrętów cennikPrętów,
                                        OpisProjektu opisProjektu);

    protected int resztaPręta(Pręt pręt, int sumaDługościOdcinków) {
        return pręt.getDługość() - sumaDługościOdcinków;
    }
}
