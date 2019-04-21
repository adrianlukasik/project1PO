public class Pręt {

    private int długość;
    private int cena;

    public Pręt(int długość, int cena) {
        this.długość = długość;
        this.cena = cena;
    }

    public int getCena() {
        return cena;
    }

    public int getDługość() {
        return długość;
    }

    @Override
    public String toString() {
        return długość + " " + cena;
    }
}
