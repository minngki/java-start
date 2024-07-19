# 배열

## 배열 변수 선언
```java
package src.array;

public class Array1Ref1 {

    public static void main(String[] args) {
        int[] students; //배열 변수 선언
        students = new int[5]; //배열 생성
        System.out.println(students); // 참조값(주소) 반환
        //변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        //변수 값 사용
        System.out.println("학생1 점수: " + students[0]);
        System.out.println("학생2 점수: " + students[1]);
        System.out.println("학생3 점수: " + students[2]);
        System.out.println("학생4 점수: " + students[3]);
        System.out.println("학생5 점수: " + students[4]);
    }
}
```

- `new int[5]`: 배열을 생성하면 배열의 크기만큼 메모리를 확보한다.
  - `int`형 5개 사용하면 4btye * 5 = 20byte를 확보한다.
- 배열을 생성하고 나면 자바는 메모리 어딘가에 있는 이 배열에 접근할 수 있는 참조값(주소)(`x001`)을 반환한다.

## 기본형 vs 참조형
- 자바의 변수 데이터 타입을 가장 크게 보면 기본형과 참조형을 분류할 수 있다. 
### 기본형 (Primitive Type)
- 사용하는 값을 직접 넣을 수 있다.
- `int`, `long`, `double`, `boolean` 처럼 변수에 사용할 값을 직접 넣을 수 있는 데이터 타입을 기본형이라 한다.
### 참조형 (Reference Type)
- 메모리의 참조값을 넣을 수 있다.
- `int[] students`와 같이 데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 탕입을 참조형이라고 한다.
- 뒤에서 학습하는 객체나 클래스를 담을 수 잇는 변수들도 모두 참조형이다.

### 배열은 왜 복잡하게 참조형을 사용할까 ?

기본형은 모두 사이즈가 명확하게 정해져있다.
```java
int i; //4btye
long l; //8btye
double d; //8btye
```

배열은 동적으로 사이즈를 변경할 수 있다.
```java
int size = 10000;
new int[size]; //이 코드가 실행되는 시점에 배열의 크기가 정해진다.
```

#### 기본형
- 기본형은 선언과 동시에 크기가 정해진다. 
- 따라서 크기를 동적으로 바꾸거나 할 수 있다. 
- 사용할 값을 직접 지정한다.
- 더 빠르고 메모리를 효율적으로 처리한다.
#### 참조형
- 동적 메모리 할당이 가능하다. 유연성 제공
- 더 복잡한 데이터 구조를 만들고 관리할 수 있다.


## 배열 리팩터링
```java
package src.array;

public class Array1Ref2 {

    public static void main(String[] args) {
        int[] students; //배열 변수 선언
        students = new int[5]; //배열 생성

        //변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        //변수 값 사용
        for (int i = 0; i < students.length; i++) {
            System.out.println("학생" + (i + 1) + " 점수: " + students[i]);
        }
    }
}
```
- `(i + 1)`: 괄호 안 쳐주면 문자열로 처리되므로 주의한다.

## 배열 생성과 초기화
```java
package src.array;

public class Array1Ref4 {

    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};

        //변수 값 사용
        for (int i = 0; i < students.length; i++) {
            System.out.println("학생" + (i + 1) + " 점수: " + students[i]);
        }
    }
}
```
- `int[] students = {90, 80, 70, 60, 50}`: 자바에서 알아서 `new int[5]`를 만든다.


# 2차원 배열
`int[][] arr = new int[2][3];`

```java
// 2x3 2차원 배열을 만든다.
int[][] arr = {
    {1,2,3},
    {4,5,6}
}; //행2, 열3
```

## 배열의 행과 열의 길이
```java
for (int row = 0; row < arr.length; row++) {
    for (int column = 0; column < arr[row].length; column++) {
        arr[row][column] = i++;
    }
}
```
- `arr.length`: `{{...},{...}}` 이므로 2
- `arr[i].length`: 각 일차원 배열의 길이~~

