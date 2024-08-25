package example;

import java.util.*;

public class Ex12_1 {
    static class Product {}
    static class Tv extends Product {}
    static class Audio extends Product {}

    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv> tvList = new ArrayList<Tv>();
//        ArrayList<Product> productList = new ArrayList<Tv>(); // Error
//        List<Tv> tvList = new ArrayList<Tv>(); // Ok. 다형성

        productList.add(new Tv());
        productList.add(new Audio());

        tvList.add(new Tv());
        tvList.add(new Tv());

        printAll(productList);
//         printAll(tvList);
    }
    public static void printAll(ArrayList<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }
}

