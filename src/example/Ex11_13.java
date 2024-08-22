package example;

import java.util.*;

public class Ex11_13 {
    public static void main(String[] args) {
        Set set = new TreeSet();
        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num); // set.add(new Integer(num))
        }
        // 이미 정렬되었기 때문에 따로 정렬하지 않아도 된다.
        System.out.println(set);
    }
}
