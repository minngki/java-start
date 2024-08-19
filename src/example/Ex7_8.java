package example;

public class Ex7_8 {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv1());
        b.buy(new Computer());

        System.out.println("현재 남은 돈: " + b.money);
        System.out.println("현재 보너스점수: " + b.bonusPoint);
    }
}

class Product {
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv1 extends Product {
    Tv1() {
        // 조상클래스의 생성자 Product(int price)를 호출한다.
        super(100); // Tv 가격을 100만원으로 한다.
    }

    // Object클래스의 toString()을 오버라이딩한다.
    @Override
    public String toString() { return "Tv"; }
}

class Computer extends Product {
    Computer() { super(200); }

    public String toString() { return "Computer"; }
}

class Buyer {
    int money = 200;
    int bonusPoint = 0;

    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "을 구입데스네~");
    }
}