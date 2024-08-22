# 46. HashMap과 Hashtable

HashMap과 Hashtable의 관계는 Vector와 ArrayList의 관계와 같아서 HashTable보다는 새로운 버전인 HashMap을 사용하자.

## HashMap

- Map을 구현한 것이므로 key와 value을 묶어서 하나의 데이터(entry)로 저장한다는 특징이 있다.
- Hashing을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어서 뛰어난 성능을 보인다.

## Hashing

<p align="center">
<img src=../image/hashing.png>
</p>
해시함수로 해시테이블에 데이터를 저장, 검색
- 해시테이블은 배열과 연결리스트가 조합된 형태이다.


해시테이블에 저장된 데이터를 가져오는 과정 ?

1. 키로 해시함수를 호출해서 해시코드를 얻는다.
2. 해시코드(함수의 반환값)에 대응하는 연결리스트를 배열에서 찾는다.
3. 연결리스트에서 키와 일치하는 데이터를 찾는다.

## Map과 HashMap과 TreeMap의 차이 ?

둘의 가장 큰 차이는 특정 키에 대한 값을 찾는 과정에서,

- `Map`은 red-black tree 알고리즘을 이용한다.
- `HashMap`은 이름 그대로 Hash Table 을 이용해서 키-값 관계를 유지한다.
    - key 또는 value 값으로써 null 을 허용한다.
- `TreeMap`과 `HashMap`의 다른 점은, `SortedMap`을 상속하였으며, Key값들에 대한 정렬이 이루어진다는 점이다.

# 47. HashMap의 key와 value

# 48. HashMap의 메서드

# 49. HashMap 예제

# 50. HashMap 예제2

# 51. HashMap 예제3

# 52. Collections의 메서드 - 동기화

- `java.util.Collection`은 인터페이스이고, `java.util.Collections`는 클래스다.

## 컬렉션의 동기화

**multi-thread 프로그래밍에서는 하나의 객체를 여러 쓰레드가 동시에 접근 가능하므로 데이터의 무결성**을 유지해야한다.

- 즉, **공유되는 객체에 동기화가 필요**하다.

```java
List syncList = Collecitons.synchronizedList(new ArrayList(...));
```

# 53. Collections의 메서드 - 변경불가, 싱글톤

## 변경불가 컬렉션 만들기

읽기전용으로 만들어야 할 때는 ? `unmodifiable*`를 사용하자.

```java
static Collection unmodifiableCollection(Collection c);

static List unmodifiableList(List list);

static Set unmodifiableSet(Set s);

static Map unmodifiableMap(Map m);
...
```

## 싱글톤 컬렉션 만들기

단 하나의 객체만을 저장해야 할 때는 ? `singleton*`를 사용하자.

```java
static List singletonList(List list);

static Set singleton(Object o); // singletonSet이 아님을 주의 !!!

static Map singletonMap(Object key, Object value);
``` 

# 54. Collections의 메서드 - 단일 컬렉션

## 한 종류의 객체만 저장하는 컬렉션 만들기

컬렉션에 모든 종류의 객체를 저장할 수 있다는 건 장점이자 단점이다. 대부분의 경우, 한 종류의 객체를 저장하므로 잘 살펴보자.
한 종류의 객체만 저장해야 할 때는 ? `checked*`를 사용하자.

```java
static Collection checkedCollection(Collection c, Class type);

static List checkedList(List list, Class type);

static Set checked(Set s, Class type);

static Map checkedMap(Map m, Class type);

static Queue checkedQueue(Queue queue, Class type);
...
``` 

ex)

```java
List list = new ArrayList();
List checkedList = checkedList(list, String.class); // String만 저장가능
checkedList.

add("abc"); // OK.
checkedList.

add(3); // 에러. 
```

- 저장 요소의 타입은 제네릭으로 쉽게 처리할 수 있지만, 이런 메서드가 제공되는 이유는 호환성 때문이다.
    - 제네릭은 JDK1.5부터 도입됨

# 55. Collections 예제

# 56. 컬렉션 클래스 정리 & 요약

<p align="center">
<img src=../image/collectionSummary.png>
</p>
<p align="center">
<img src=../image/collectionSummary2.png>
</p>
