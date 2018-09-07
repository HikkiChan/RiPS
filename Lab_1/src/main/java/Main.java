public class Main {
    public static void main(String[] args) {
        ODArray a = new ODArray(5);
        System.out.println(a.toString());

        a.setElements(1, 10);
        System.out.println(a.toString());

        double[] arr = {1, 3, 10, 2, 5};
        a.setElements(arr);
        System.out.println(a.toString());

        a.sort();
        System.out.println(a.toString());

        a.sumArrays(a);
        System.out.println(a.toString());

        a.sumArrayAndConst(5);
        System.out.println(a.toString());

        a.multiplyArray(3);
        System.out.println(a.toString());

        double[] arr1 = {1, 3, 10, 2};
        ODArray b = new ODArray(arr1);
        a.sumArrays(b);

        b.setElements(a);

        b.setElements(10, 1);
        b.setElements(1);

        ODArray c = new ODArray();
        c.setElements(b);
    }
}
