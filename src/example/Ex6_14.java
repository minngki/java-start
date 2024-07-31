package example;

public class Ex6_14 {
    static {
        // class 초기화 블럭
        System.out.println("static { }");
    }

    {
        // instance 초기화 블럭
        System.out.println("{ }");
    }

    public Ex6_14() {
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        System.out.println("bt = new Ex6_14(); ");
        Ex6_14 bt = new Ex6_14();

        System.out.println("bt2 = new Ex6_14(); ");
        Ex6_14 bt2 = new Ex6_14();
    }
}
