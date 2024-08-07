package example;

public class Ex7_6 {
    public static void main(String[] args) {
        Tv t = new Tv();
        SmartTv s = new SmartTv();
    }
}

class Tv {
    boolean power;
    int channel;

    void power() { power = !power; }
    void channelUp() { ++channel; }
    void channelDown() { --channel; }
}

class SmartTv extends Tv {
    String text;
    void caption() { /* 내용 생략 */}
}
