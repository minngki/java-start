package example;

public class Ex7_10 {
    public static void main(String[] args) {
        Unit[] group = { new Marine(), new Tank(), new DropShip() };

        for (int i = 0; i < group.length; i++) {
            group[i].move(100,200);
        }
    }
}

abstract class Unit {
    int x,y; // 현재 위치
    abstract void move(int x, int y);
    void stop() { /* 현재 위치에 정지 */}
}
class Marine extends Unit{ // 보병
    void move(int x, int y) {
        System.out.println("Marine[x="+x+",y=" +y+"]");
    }
    void stimPack() { /* 스팀팩 사용 */}
}

class Tank extends Unit{ // 탱크
    void move(int x, int y) {
        System.out.println("Tank[x="+x+",y=" +y+"]");
    }
    void changeMode() { /* 공격모드 변환 */}
}

class DropShip extends Unit{ // 수송선
    void move(int x, int y) {
        System.out.println("DropShip[x="+x+",y=" +y+"]");
    }
    void load() { /* 선택 대상을 태운다. */}
    void unload() { /* 선택 대상을 내린다. */}
}