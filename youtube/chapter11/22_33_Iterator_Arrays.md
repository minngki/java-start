# 22. Iterator, ListIterator, Enumeration
Iterator, ListIterator, Enumeration 모두 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스다.
- Enumeration은 Iterator의 구버전이며, ListIterator은 Iterator의 기능을 향상시킨 것이다.


> - **Iterator**: 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스
> - **ListIterator**: Iterator에 양방향 조회기능추가 (List를 구현한 경우만 사용가능)
> - **Enumeration**: Iterator의 구버전

```java
public interface Iterator {
    boolean hasNext();
    Object next();
    void remove();
}
```

```java
public interface Collection {
//    ...
    public Iterator iterator();
//    ...
}
```
- Collection인터페이스에는 Iterator를 구현한 클래스의 인스턴스를 반환하는 iterator()를 정의하고 있다.


### 주로 반복문과 사용
```java
List list = new ArrayList(); // 다른 컬렌션으로 변경할 때는 이 부분만 고침 된다.
Iterator it = list.iterator();

while(it.hasNext()) { // boolean hasNext() 읽어올 요소가 있는지 확인
    System.out.println(it.next()); // Object next() 다음 요소를 읽어옴
}
```

# 23. Iterator, ListIterator, Enumeration 예제
아래는 List클래스의 모든 요소를 출력하는 예시이다.

```java
Iterator it = list.iterator();

while(it.hasNext()) {
    Object obj = it.next();
    System.out.println(obj);
}
```
- while과 `iterator` 사용

```java
for (int i = 0; i < list.size(); i++) {
    Object obj = list.get(i);
    System.out.println(obj);
}
```
- for문과 `get()`

# 24. Map과 Iterator
Map인터페이스는 key, value가 있으므로 iterator()를 직접 호출할 수 없고, `keySet()`이나 `entrySet()` 같은 메서드를 통해 키와 값을 따로 Set의 형태로 호출할 수 있다.

```java
Map map = new HashMap();
Iterator it = map.entrySet().iterator();
```

# 25. Arrays의 메서드(1) - 복사
> 🤔 **array와 arrayList의 차이점은?**
> - Array와 ArrayList은 모든 것이 비슷하지만, **길이를 조정할 수 있는가? 없는가?**의 차이가 있다. 
> - Array는 **고정 길이**라서 정해진 길이의 배열을 모두 채우면, 새로운 데이터를 추가하고 싶을 경우 새로운 배열 생성 필요
> - ArrayList는 **가변 길이**지만 내부적으론 배열로 구성되어있다. 
>   - Default로 10개의 공간을 가진 배열로 시작하지만 최적화(지연 초기화)로 인해 막 생성하면 0개의 사이즈로 시작됩니다. 
>   - 다만, 편리함의 대가로 살짝 Array보다 느리니 Array로 충분히 처리 가능하다거나 코딩 테스트나 알고리즘을 풀 때에는 Array를 활용해주는 것이 좋다.



## 배열의 복사 - `copyOf()`, `copyOfRange()`
- `copyOf()`: 배열 전체를 복사해서 새로운 배열 생성하여 반환한다.
- `copyOfRange()`: 배열 일부를 복사해서 새로운 배열 생성하여 반환한다.
  - 지정된 범위의 끝은 포함되지 않는다.

```java
int[] arr = {0,1,2,3,4};
int[] arr2 = Arrays.copyOf(arr, arr.length); // arr2 = [0,1,2,3,4]
int[] arr3 = Arrays.copyOf(arr,3); // arr3 = [0,1,2]
int[] arr4 = Arrays.copyOf(arr,7); // arr4 = [0,1,2,3,4,0,0]
int[] arr5 = Arrays.copyOfRange(arr,2,4); // arr5 = [2,3]
int[] arr6 = Arrays.copyOfRange(arr,0,7); // arr6 = [0,1,2,3,4,0,0]
```
> cf. Arrays에 정의된 메서드느 모두 static메서드

# 26. Arrays의 메서드(1) - 채우기, 정렬, 검색

## 배열 채우기 - `fill()`, `setAll()`
- `fill()`: 배열의 모든 요소를 지정된 값으로 채운다.
- `setAll()`: 배열을 채울 때 사용할 **함수형 인터페이스를 매개변수**로 받는다.
```java
int[] arr = new int[5];
Arrays.fill(arr, 9); // arr = [9,9,9,9,9]
Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1) // arr = [5,1,4,2,1]
```

## 배열의 정렬과 검색 - `sort()`, `binarySearch()`
- `sort()`: 배열을 정렬한다.
- `binarySearch()`: 배열에 저장된 요소를 검색한다.
  - 검색할 값의 index를 찾아서 반환하는데, 반드시 배열이 정렬된 상태여야 올바른 결과를 얻는다.
  - 만일 검색할 값과 일치하는 요소들이 여러 개라면, 이 중 어떤 것이 반환될지 알 수 없다. ㅋㅋ

```java
import java.util.Arrays;

int[] arr = {3, 2, 0, 1, 4};
int idx = Arrays.binarySearch(arr, 2); // idx = -5, 잘못된 값

Arrays.sort(arr);
System.out.println(Arrays.toString(arr)); // [0,1,2,3,4]
int idx = Arrays.binarySearch(arr, 2); // idx = 2
```

> linear search 순차 검색 <-> binary search 이진 검색
> - linear search: 배열이 정렬되어있을 필요는 없지만 배열의 요소를 하나씩 비교하므로 시간이 많이 걸린다.
> - binary search: 검색할 범위를 반복적으로 절반씩 줄여가면서 검색하기 때문에 검색속도가 굉장히 빠르다.

# 27. Arrays의 메서드(3) - 비교와 출력
## 문자열의 비교와 출력 - `equals()`, `toString()`
- `equals()`: 문자열 비교가 아닌 '배열에 저장된 배열의 주소'를 비교하므로 항상 false가 나온다.
- `toString()`: 생략

## 다차원배열의 비교와 출력 - `deepEquals()`, `deepToString()`
- `deepEquals()`
- `deepToString()`: 3차원 이상의 배열에도 동작한다. ㅇ0ㅇ

```java
String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

System.out.println(Arrays.equals(str2D,str2D2)); // false
System.out.println(Arrays.equals(str2D,str2D2)); // true
```

# 27. Arrays의 메서드(4) - 변환
## 배열을 List로 변환 - `asList(Object... a)`
- `asList(Object... a)`: 배열을 List에 담아서 반환한다.
  - 매개변수의 타입이 가변인수라서 배열 생성없이 저장할 요소들만 나열하는 것이 가능하다.
  - ‼️ 반환한 List의 크기를 변경할 수 없다. 즉, **추가/삭제 불가, 저장 내용은 변경 가능**

```java
List list = Arrays.asList(new Integer[]{1,2,3,4,5}); // list = [1,2,3,4,5]
List list = Arrays.asLsit(1,2,3,4,5); // list = [1,2,3,4,5]
list.add(6) // 예외발생

// 크기 변경이 필요하다면
List list = new ArrayList(Arrays.asList(1,2,3,4,5));
```


## `parallel*()`, `spliterator()`, `stream()`
- `parallel*()`: 여러 쓰레드가 작업을 나누어 처리하도록 한다.
- `spliterator()`: 여러 쓰레드가 처리할 수 있게 하나의 작업을 여러 작업으로 나누는 Spliterator를 반환한다. 
- `stream()`: 컬렉션을 스트림으로 변환한다.

# 29. Arrays의 메서드의 예제

# 30. Comparator와 Comparable
인터페이스로 컬렉션을 정렬하는데 필요한 메서드를 정의한다.
> - Comparator: 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용, (`java.util` package)
> - Comparable: 기본 정렬기준을 구현하는데 사용, (`java.lang` package)

```java
public interface Comparator {
    int compare(Object o1, Object o2);

    boolean equals(Object obj);
}
public interface Comparable {
  int compareTo(Object o); // 객체 자신 this와 o를 비교
}
```
# 30. Comparator와 Comparable 예제

# 32. Integer와 Comparable
Integer클래스의 일부에서 Comparable의 compareTo(Object o)를 구현해놓았다. (참고만 하자..)
Compaable을 구현한 클래스들은 기본적으로 오름차순으로 정렬되어 있지만, 내림차순 또는 다른 기준으로 정렬하고 싶다면 Comparator를 통해 정렬할 수 있다.


# 33. Integer와 Comparable 예제

