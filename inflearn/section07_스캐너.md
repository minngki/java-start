# Scanner
`System.out`을 통해서 출력을 하듯이, System.in을 통해서 사용자의 입력을 받을 수 있다.
자바가 제공하는 `System.in`을 통해 사용자 입력을 받으려면 여러 과정을 거쳐야 해서 복잡하고 어렵다.

자바는 이런 문제를 해결하기 위해 `Scanner`라는 클래스를 제공한다.
```java
package src.scanner;

import java.util.Scanner;

public class Scanner1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열을 입력하세요:");
        String str = scanner.nextLine(); //입력을 String으로 가져온다.
        System.out.println("입력한 문자열: " + str);

        System.out.print("정수를 입력하세요:");
        int intValue = scanner.nextInt();
        System.out.println("입력한 정수: " + intValue);

        System.out.print("실수를 입력하세요:");
        double doubleValue = scanner.nextDouble();
        System.out.println("입력한 실수: " + doubleValue);
    }
}
```
- 주의! 다른 타입을 입력하면 오류가 난다.

```java
package src.scanner;

import java.util.Scanner;

public class Scanner1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("hello \n");
        System.out.print("world \n");
        System.out.println("hello");
        System.out.println("world");
    }
}
```
- `print()` 만 사용할 때 개행을 따로 해야한다.