# 조건문

## if, else if, else
```java
package src.cond;

public class If3 {
    public static void main(String[] args) {
        int age = 14;

        if (age <= 7) {
            System.out.println("미취학");
        }
        if (age >= 8 && age <= 13) {
            System.out.println("초등학생");
        }
        if (age >= 14 && age <= 16) {
            System.out.println("중학생");
        }
        if (age >= 17 && age <= 19) {
            System.out.println("고등학생");
        }
        if (age >= 20) {
            System.out.println("성인");
        }
    }
}
```

- `if`: 하나의 조건절에서 확인하고 끝나면 되는데, 중복 체크를 하게 되는 경우이다.
- `else if, else`: 하게 되면 조건에 해당되는 조건문만 실행하고 나머지는 빠져나온다.
- 조건절에 해당하는 명령어가 하나라면, 중괄호를 생략해도 되지만 가독성을 위해 작성하는 것을 권고한다.

```java
if (true)
    System.out.println("해당 문구는 실행됩니다.");
    System.out.println("해당 문구는 괄호가 없으므로 실행되지 않습니다.");
```

## switch
- break 가 있어야 해당 조건문에서 빠져나온다.
  - 없으면 그대로 쭉 조건절을 실행한다.


### java 14이상 가능
```java
package src.cond;

public class Switch4 {
    public static void main(String[] args) {
        int grade = 2;

        int coupon = switch (grade) {
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default ->  500;
        };
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
```

