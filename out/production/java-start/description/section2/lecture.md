# 변수 선언과 초기화

## 초기화 하지 않은 변수 읽기
```java
package variable;

public class Var5 {
    public static void main(String[] args) {
        int a;
        System.out.println(a);
```
`java: variable a might not have been initialized`

변수를 선언하고 초기화히지 않으면, 위의 내용과 같은 에러가 발생한다. 

- 컴퓨터에서 메모리는 여러 시스템이 함께 사용되는 공간이라, 어떠한 값들이 계속 저장된다.
- 변수를 선언하면 메모리상의 어떤 공간을 차지하고 사용한다.
- 그런데 그 공간에 기존에 어떤 값이 있었는지는 아무도 모른다.
- 따라서 초기화를 하지 않으면 이상한 값이 출력될 수 있다.
- 이런 문제를 예방하기 위해 자바는 변수를 초기화 하도록 강제한다.
- 지역 변수는 개발자가 직접 초기화를 해주어야 한다.
  - 클래스 변수와 인스턴스 변수는 자바가 자동으로 초기화를 진행해준다.

## 올바른 예
```java
package src.variable;

public class Var5 {
    public static void main(String[] args) {
        //1. 변수 선언, 초기화 각각 따로
        int a;
        a = 1;
        System.out.println(a);

        int b = 2; //2. 변수 선언과 초기화를 한번에
        System.out.println(b);

        int c = 3, d = 4; //3. 여러 변수 선언과 초기화를 한번에
        System.out.println(c);
        System.out.println(d);
    }
}
```

# 변수 타입

```java
package src.variable;

public class Var7 {

    public static void main(String[] args) {
        int a = 100; //정수
        double b = 10.5; //실수
        boolean c = true; //불리언(boolean) true, false 입력 가능
        char d = 'A'; //문자 하나
        String e = "Hello Java"; //문자열, 문자열을 다루기 위한 특별한 타입 (얘만 대문자!)

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
```
### 리터럴 literal
개발자가 직접 넣은 고정된 값을 프로그래밍 용어를 리터럴 값이라고 한다.

## 변수 타입 (숫자)
```java
package src.variable;

public class Var8 {
    public static void main(String[] args) {
        //정수
        byte b = 127; //-128 ~ 127
        short s = 32767; // -32,768 ~ 32,767
        int i = 2147483647; //-2,147,483,648 ~ 2,147,483,647 (약 20억)
        //-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
        long l = 9223372036854775807L; // 소문자 l을 사용해도 되지만 1이랑 비슷해서 권장되지는 않음.

        //실수
        float f = 10.0f;
        double d = 10.0;

    }
}
```
>- `byte`: 2^8 
>- `short`: 2^16
>- `int`: 2^32
>- `long`: 2^64

- 대부분 `int`를 쓰는데 20억이 넘어갈 것 같으면 `long`을 사용한다.
  - java는 기본으로 4byte(`int`)를 효율적으로 계산하도록 되어있다.
- 메모리 자체를 많이 사용하는 것이기 때문에 사용성에 맞도록 선하는 것이 맞다.
- `double`: 실수는 대부분 double을 사용한다. `float`은 위험하다.
- `String`: 문자 하나든 문자열이든 모두 String 으로 큰 따옴표를 사용하는 것이 좋다.
 

# 변수 명명 규칙(관례)
- camel case: class-big, and so on-small

