# 스코프

### 스코프 존재 이유
- 비효율적인 메모리 사용
- 코드 복잡성 증가

# 형변환
- 작은 범위에서 큰 범위로는 당연히 값을 넣을 수 있다.
    - int -> long -> double
- 큰 범위에서 작은 범위는 다음과 같은 문제가 발생한다.
    - 소수점 버림
    - 오버플로우

➡️ 큰 그릇은 작은 그릇에 담긴 내용물을 담을 수 있다.

## 자동 형변환
```java
package src.casting;

public class Casting1 {
    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;

        longValue = intValue; //int -> long
        System.out.println("longValue = " + longValue);

        doubleValue = intValue; //int -> double
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L; //long -> double
        System.out.println("doubleValue2 = " + doubleValue);
    }
}
```

## 명시적 형변환
```java
package src.casting;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647; //int 최고값
        long maxIntOver = 2147483648L; //int 최고값 + 1(초과)
        int intValue = 0;

        intValue = (int) maxIntValue; //형변환
        System.out.println("maxIntValue casting=" + intValue);

        intValue = (int) maxIntOver; //형변환
        System.out.println("maxIntOver casting=" + intValue);
    }
}
```

## 계산과 형변환
1. 같은 타입끼리의 계산은 같은 타입의 결과를 낸다.
2. 서로 다른 타입의 계산은 큰 범위로 자동 형변환이 일어난다.

```java
package src.casting;

public class Casting4 {
    public static void main(String[] args) {
        int div1 = 3 / 2;
        System.out.println("div1 = " + div1); //1

        double div2 = 3 / 2; // int로 먼저 계산이 되었으니 답은 1.0
        System.out.println("div2 = " + div2); //1.0

        double div3 = 3.0 / 2; // double로 실수이니 3.0/2.0 으로 연산하여 1.5
        System.out.println("div3 = " + div3); //1.5

        double div4 = (double) 3 / 2; // 3을 double 형변환시켜서 1.5 
        System.out.println("div4 = " + div4); //1.5

        int a = 3;
        int b = 2;
        double result = (double) a / b;
        System.out.println("result = " + result); //1.5
    }
}
```