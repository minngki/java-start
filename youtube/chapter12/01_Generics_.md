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
