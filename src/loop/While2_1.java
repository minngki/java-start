package src.loop;

public class While2_1 {

    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i <=  3) {
            sum += i;
            System.out.println("i=" + i + " sum=" + sum);
            i++;
        }
    }
}
