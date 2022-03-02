package ss10_arraylist.thuc_hanh.thuc_hanh1;

public class TestSimpleList {
    public static void main(String[] args) {
        SimpleList<Integer> listInteger = new SimpleList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));
    }
}
