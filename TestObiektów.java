import java.util.ArrayList;

public class TestObiektów {

    public static void main(String[] args) {
        int[] tab1 = new int[3];
        tab1[0] = tab1[1] = tab1[2] = 777;
        int[] tab2 = tab1;
        System.out.println(tab2[0] + " " + tab2[1] + " " +tab2[2]);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(17);
        arr.add(18);
        arr.add(2312);
        arr.add(233);
        ArrayList<Integer> tab = arr;

        System.out.println(tab.size());
        tab.remove(tab.size() - 1);
        System.out.println(arr.size());
        System.out.println(tab.size());
        System.out.println(arr);
        System.out.println(tab);
    }
}
