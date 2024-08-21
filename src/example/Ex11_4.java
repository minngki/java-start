package example;

import java.util.*;

public class Ex11_4 {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        System.out.println("help을 입력하면 도움말을 볼 수 있다능");

        while(true) {
            System.out.println(">>");

            try{
                // 화면으로부터 라인단위로 입력받는다.
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();

                if("".equals(input)) {
                    continue;
                }
                if(input.equalsIgnoreCase("q")) {
                    System.exit(0);
                } else if(input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말을 보여준다능");
                    System.out.println(" q or Q - 프로그램을 종료한다능");
                    System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE +"개 보여준다능");
                } else if(input.equalsIgnoreCase("history")) {
                    int i = 0;
                    save(input);

                    LinkedList tmp = (LinkedList)q;
                    ListIterator it = tmp.listIterator();

                    while(it.hasNext()) {
                        System.out.println(++i + ". " + it.next());
                    }
                } else {
                    save(input);
                    System.out.println(input);
                }
            } catch (Exception e) {
                System.out.println("입력 오류");
            }
        }
    }
    public static void save(String input) {
        if(!"".equals(input)) {
            q.offer(input);
        }

        if(q.size() > MAX_SIZE) {
            q.remove();
        }
    }
}
