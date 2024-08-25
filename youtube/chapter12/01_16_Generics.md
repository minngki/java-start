# 1. Generics

컴파일 시 타입 체크를 해주는 기능 (complile-time type check)
> - 타입 안정성을 제공함
> - 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해짐

```java
ArrayList tvList = new ArrayList();

tvList.

add(new Tv());
Tv t = (Tv) tvList.get(0);
```

```java
// 제네릭 적용
ArrayList<Tv> tvList = new ArrayList<Tv>();

tvList.

add(new Tv());
Tv t = (Tv) tvList.get(0); // 형변환 불필요
```

# 2. 타입 변수

ArrayList클래스 선언에서 클래스 이름 옆의 `<>`안에 있는 대문자 알파벳을 타입변수라고 한다. (일반적으로 Type의 T를 사용)

- 기호의 종류만 다를 뿐, 임의의 참조형 타입을 의미한다는 것은 동일하다.
- Map<K,V>

```java
ArrayList<Tv> tvList = new ArrayList<Tv>();
```

# 3. 타입 변수에 대입하기

타입 변수 E대신 지정된 타입 Tv를 '대입된 타입(parameterized type)'이라고 한다.

# 4. 제네릭의 용어
```java
class Box<T> {}
```
> - `Box<T>`: 지네릭 클래스. 'T의 Box' 또는 'T Box'라고 읽는다.
> - `T`: 타입변수 또는 타입 매개변수. (T는 타입문자)
> - `Box`: 원시타입 raw type

```java
Box<String> b = new Box<String>();
```
- '지네릭 타입 호출': 매개변수에 타입을 지정하는 것 (ex. `Box<String>`)
- '매개변수화된 타입(parameterized type)': 지정된 타입 (ex. `String`)

**Q. `Box<String>`과 `Box<Integer>`는 별개의 클래스를 호출하는 것일까?**
- `Box<T>`에 서로 다른 타입을 대입하여 호출하는 것일 뿐, 이 둘이 별개의 클래스를 의미하는 것은 아님!
  - `add(2,3)` 와 `add(4,7)`가 서로 다른 메서드를 호출하는 게 아닌 것처럼 말이다.
- 컴파일 후에 `Box<String>`과 `Box<Integer>`는 이들의 **원시타입인 `Box`로 바뀐다. 즉, 제네릭 타입이 제거된다.**


# 5. 제네릭 타입과 다형성
제네릭 클래스 객체를 생성 시, 참조변수에 지정해준 제네릭 타입과 생성자에 지정해준 제네릭 타입은 일치해야 한다.  
클래스 Tv와 Product가 서로 상속관계에 있어도 일치해야 한다.
```java
ArrayList<Tv> list = new ArrayList<Tv>(); // OK. 일치
ArrayList<Product> list = new ArrayList<Tv>(); // Error. 불일치
//...
class Product {}
class Tv extends Product {}
class Audio extends Product {}
```

그러나 제네릭 타입이 아닌 **클래스 타입 간에 다형성을 적용하는 것은 가능**하다. (제네릭 타입은 일치해야한다.)
```java
List<Tv> list = new ArrayList<Tv>(); // OK. 다형성. ArrayList가 List를 구현
List<Tv> list = new LinkedList<Tv>(); // OK. 다형성. LinkedList가 List를 구현
```

그렇다면 ArrayList에 Product의 자손 객체만 저장할 수 없을까?
```java
ArrayList<Product> list = newArrayList<Product>();
list.add(new Product());
list.add(new Tv());
list.add(new Audio());

Product p = list.get(0); // 형변환 필요없다.
Tv t = (Tv)list.get(1); // Product의 자손객체들은 형변환을 필요로 한다.
```


# 7. Iterator<E>

# 8. HashMap<K,V>
키 타입: String, 값 타입: Student인 HashMap을 생성하려면 다음과 같이 한다.
```java
HashMap<String, Student> map = new HashMap<String, Studyent>(); // 생성
map.put("javaKing", new Student("javaKing",1,1,100,100)); // save data
```

# 9. 제한된 제네릭 클래스
**타입 매개변수 T에 지정할 수 있는 타입의 종류를 제한하는 방법 ?**
- `extends`를 사용하여 특정 타입의 자손들만 대입할 수 있게 제한할 수 있다.

```java
import java.util.ArrayList;

FruitBox<Toy> fruitBox = new FruitBox<Toy>();
fruitBox.add(new Toy()); // OK. 과일상자에 장난감을 담을 수 있다.

class FruitBox<T extends Fruit> { // Fruit 자손만 타입으로 지정가능
  ArrayList<T> list = new ArrayList<T>();
}
```
**여전히 한 종류의 타입만 담을 수 있지만, Fruit클래스의 자손들만 담을 수 있다는 제한이 더 추가된 것.**
```java
FruitBox<Apple> appleBox = new FruitBox<Apple>; // OK
FruitBox<Toy> appleBox = new FruitBox<Toy>; // Error. Toy는 Fruit의 자손이 아님
```

만일 인터페이스를 구현해야 한다는 제약이 필요하다면, `implements`가 아닌 `extends`를 사용한다.
```java
interface Eatable {}
class FruitBox<T extends Eatable> {}

// 클래스와 인터페이스 모두 구현하려면 &를 사용한다.
class FruitBox<T extends Fruit & Eatable> {}
```

# 10. 제한된 제네릭 클래스 예제

# 11. 제네릭의 제약
### 1. 모든 객체에 대해 동일하게 동작해야하는 static멤버에 타입 변수 T를 사용할 수 없다. 
- **T는 인스턴스 변수로 간주되기 때문**
- **static멤버는 인스턴스 변수를 참조할 수 없다.**

```java
class Box<T> {
    static T item; // Error
    static int compare(T t1, T t2) {} // Error
}
```
➡️ static멤버는 타입 변수에 지정된 타입에 관계없이 동등해야 하는데, `Box<Apple>.item`, `Box<Grape>.item` 이렇게 타입변수가 다른 것이면 안 된다는 의미다.

### 2. 제네릭 타입의 배열을 생성하는 것도 허용되지 않는다.
제네릭 배열 타입의 참조변수를 선언하는 것은 가능하지만, `new T[10]`과 같이 배열을 생성하는 것은 안된다.
```java
class Box<T> {
    T[] itemArr; // OK. T타입의 배열을 위한 참조변수
    T[] toArray() {
        T[] tmpArr = new T[itemArr.length]; // Error. generic 배열 생성 불가
        return tmpArr;
    }
}
```
- **이유는 `new`연산자 때문인데, 이 연산자는 컴파일 시점에 타입 T가 무엇인지 정확히 알아야한다.**
  - 위의 코드는 컴파일 시점에 T가 어떤 타입인지 알 수 없기 때문에 에러가 난다.
  - `instanceof`연산자도 같은 이유로 T를 피연산자로 사용할 수 없다.

# 12. 와일드 카드
## 제네릭 타입에 다형성을 적용하는 방법?
제네릭 타입으로 와일드카드를 사용하면 된다. (any랑 같은 건가 ?)
- 기호 `?`를 사용하는데, `extends`와 `super`로 상한(upper bound)과 하한(lower bound)을 제한할 수 있다.

> - `<? extends T>`: 와일드 카드의 상한 제한. T와 그 자손들만 가능
> - `<? super T>`: 와일드 카드의 하한 제한. T와 그 조상들만 가능
> - `<?>`: 제한 없음. 모든 타입이 가능. `<? extends Object>`와 동일
```java
ArrayList<? extends Tv> list = new ArrayList<Tv>();
ArrayList<? extends Tv> list = new ArrayList<Audio>();
```

# 13. 와일드 카드 예제

# 14. 제네릭 메서드
제네릭 메서드: 메서드 선언부에 제네릭 타입이 선언된 메서드
- `Collections.sort()`
```java
static <T> void sort(List<T> list, Comparator<? super T> c);
```
- **제네릭 클래스(List)에 정의된 타입 문자 T와 제네릭 메서드(sort)에 정의된 타입 문자 T는 전혀 다른 별개**의 것이라는 걸 유의하자.
```java
class FruitBox<T> {
//    ...
  static <T> void sort(List<T> list, Comparator<? super T> c);
//    ...
}
```
- 제네릭 메서드는 그냥 클래스에도 정의할 수 있다.
- **static멤버는 타입 매개변수를 사용할 수 없지만, 메서드는 제네릭 타입을 선언하고 사용하는 것은 가능하다.. 웅..**
  - **메서드에 선언된 제네릭 타입은 지역 변수를 선언한 것과 같다**고 생각하자.
  - 타입 매개변수는 **메서드 내에서만 지역적으로 사용될 것**이므로 메서드가 static이건 아니건 상관이 없다.


# 15. 제네릭 타입의 형변환
### 제네릭 타입과 원시 타입 간의 형변환이 가능할까 ?
제네릭 타입과 Non-제네릭 타입간의 형변환은 항상 가능하다. 다만 경고는 발생.
```java
Box box = null;
Box<Object> objBox = null;

box = (Box)objBox; // OK(Warning). generic -> primitive
objBox = (Box<Object>)box; // OK(Warning). primitive -> generic 
```

### parameterized type이 다른 제네릭 타입 간에는 형변환이 가능할까 ?
```java
Box<Object> objBox = null;
Box<String> strBox = null;

objBox = (Box<Object>)strBox; // Error, Box<String> -> Box<Object>
strBox = (Box<String>)objBox; // Error, Box<Object> -> Box<String>
```
- 대입된 타입이 Object여도 안 된다.
- 선언할 때는 모든 타입을 대입할 수 있지만, 이미 대입된 타입의 변수에 다른 타입을 할당은 물론이고, 형변환도 되지 않는다.

### `Box<? extends Object>`로 형변환이 될까 ?
```java
Box<? extends Object> wBox = new Box<String>();
```
- Object가 최상 클래스이므로 Object의 자손인 String으로 형변환할 수 있다.

# 16. 제네릭 타입의 제거
컴파일러는 제네릭 타입을 이용해서 소스파일을 체크하고 필요한 곳에 형변환을 넣어준 후, 제네릭 타입을 제거한다.
즉, 컴파일된 파일(*.class)에는 제네릭 타입에 대한 정보가 없다.
- 제네릭 도입 이전의 소스코드와의 호환성을 유지하기 위해서다.
- typescript build하면 js 파일에서 없는 것처럼.