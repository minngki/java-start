package example;

public class Ex6_10 {
    public static void main(String[] args) {
        MyMath3 mm = new MyMath3();
        System.out.println("mm.add(3,3): " + mm.add(3,3));
        System.out.println("mm.add(3L,3): " + mm.add(3L,3));
        int[] a = {100, 200, 300};
        System.out.println();

    }
}


class MyMath3 {
    int add(int a, int b) {
        System.out.println("int add(int a, int b): " );
        return a+b;
    }
    long add(long a, int b) {
        System.out.println("long add(int a, int b): " );
        return a+b;
    }
}
