package src.array.ex;

import java.util.Scanner;

public class ProductAdminEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxProduct = 10;
        String[] productNames = new String[maxProduct];
        int[] productPrices = new int[maxProduct];
        int productCount = 0;
        while (true) {
            System.out.print("1. 상품 등록 | 2. 상품 목록 | 3. 종료\n메뉴를 선택하세요:");
            int menuNum = sc.nextInt(); // 여기서 enter를 치게 되면 \n도 입력값에 포함되기 때문에
            sc.nextLine(); // 왜 해야하는가?: 엔터입력값을 받아주기 위해 변수에 저장하지 않는 일반 scanner를 넣어주는 것임.
            if (menuNum == 1) {
                if (productCount == maxProduct) {
                    System.out.println("더 이상 상품을 등록할 수 없습니다.");
                    break;
                }
                System.out.print("상품 이름을 입력하세요:");
                productNames[productCount] = sc.nextLine(); // 여기서 제대로 된 입력값을 받아야하기 때문이다.
                System.out.print("상품 가격을 입력하세요:");
                productPrices[productCount] = sc.nextInt();

                productCount++;
            } else if (menuNum == 2) {
                if (productCount==0) {
                    System.out.println("등록된 상품이 없습니다.");
                    continue;
                }
                for (int i = 0; i < productCount; i++) {
                    System.out.println(productNames[i]+": "+productPrices[i]+'원');
                };
            }
            else if (menuNum == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 번호를 입력하셨습니다.");
            }

        }

    }
}
