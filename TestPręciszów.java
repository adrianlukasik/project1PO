public class TestPręciszów {

    public static void main(String[] args) {

        Pręt[] pręty = new Pręt[3];
        pręty[0] = new Pręt(4000, 201);
        pręty[1] = new Pręt(4500, 160);
        pręty[2] = new Pręt(10000, 200);
        CennikPrętów cennikPrętów = new CennikPrętów(pręty);

        Pręt[] prętyPoCenie = cennikPrętów.getTablicaPrętówPoCenie();
        for (int i = 0; i < prętyPoCenie.length; i++)
            System.out.println(prętyPoCenie[i].toString());
    }
}
