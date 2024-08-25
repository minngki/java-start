# 23. Annotation이란 ?
`@`: 미리 정의된 태그들을 이용해서 주석 안에 정보를 저장하고, javadoc.exe라는 프로그램이 이 정보를 읽어서 문서를 작성하는데 사용한다.
- 이 기능을 응용해서 **프로그램의 소스코드 안에서 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것이 애너테이션**이다.
- `@`를 통해서 태그내용을 프로그램에게 알리는 역할만 할 뿐이다.

# 24. 표준 Annotation

# 25. @Override
조상메서드를 오버라이딩하는 것이라는 걸 컴파일러에게 알려주는 역할이다.
- 오버라이딩할 때 반드시 붙여주도록 하자.
  - 필수는 아니지만, 알아내기 쉬운 실수를 미연에 방지하는 것!

# 26. @Deprecated
다른 것으로 대체되었으니 더 이상 사용하지 않을 것을 권한다는 의미다.

# 27. @FunctionalInterface
함수형 인터페이스를 선언할 때, 컴파일러가 올바르게 선언했는지 확인하고, 잘못된 경우 에러 발생시킨다.
- 함수형 인터페이스는 추상메서드가 하나뿐이어야 하는 제약이 있다.

# 28. @SuppressWarings
컴파일러가 보여주는 경고메세지가 나타나지 않게 억제해준다.

# 29. 메타 애너테이션
메타 애너테이션은 '에너테이션을 위한 애너테이션'이다. (애너테이션에 붙이는 애너테이션)
- 애너테이션을 정의할 때, 적용대상 target이나 유지기간 retention을 지정하는데 사용한다.

# 30. @Target
적용가능한 대상을 지정하는데 사용된다.

```java
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

// FIELD(멤버변수), TYPE(클래스,인터페이스,enum), TYPE_USE(타입이 사용되는 모든 곳)
@Target({FIELD, TYPE, TYPE_USE})
public @interface MyAnnotation { } // MyAnnotation 정의

@MyAnnotation // 적용대상이 TYPE 인 경우
class MyClass {
    @MyAnnotation // 적용대상이 FIELD 인 경우
    int i;
    
    @MyAnnotation // 적용대상이 TYPE_USE 인 경우
    MyClass mc;
}
```

# 31. @Retention
애터네이션이 유지되는 기간을 지정하는데 사용된다.
> 유지정책
> - `SOURCE`: 소스 파일 내에만 존재, 클래스 파일에 존재 X
> - `CLASS`: 클래스 파일 존재, 실행 시 사용불가 (기본값)
> - `RUNTIME`: 클래스 파일 존재, 실행 시 사용가능

# 32. @Documeted, @Inherited
- `@Documeted`: javadoc으로 작성한 문서에 포함되도록 한다.
- `@Inherited`: 애너테이션이 자손 클래스에 상속되도록 한다.

# 33. @Repeatable
보통은 하나의 대상에 한 종류의 애너테이션을 붙이지만, 얘가 붙은 애너테이션은 여러번 붙일 수 있다.
```java
@Repeatable(ToDos.class) // Todo애터네이션을 여러번 반복해서 쓸 수 있게 한다.
@interface ToDo {
    String value();
}

@ToDo("delete ... ")
@ToDo("override ... ")
class MyClass { }

@interface ToDos { // 여러 개의 ToDo애너테이션을 담을 컨테이너 애너테이션 ToDos
    ToDo[] value(); // ToDo애너테이션 배열타입의 요소를 선언. 이름은 반드시 value여야 함.
}
```

# 34. 애너테이션 타입 정의하기
직접 만들기
```java
@interface 애너테이션이름 {
    타입 요소이름(); // 애너테이션의 요소를 선언한다.
//    ...
}
```

# 35. 애너테이션의 요소

# 36. 모든 애너테이션의 조상
모든 애너테이션의 조상은 Annotation이다. 그러나 상속되지 않으므로 명시적으로 Annotation을 조상으로 지정할 수 없다.
```java
@interface TestInfo extends Annotation { // Error. 노허용 표현
}
```
- 일반적인 interface로 정의되어 있기 때문에 모든 애너테이션 객체에 대해 `equals()`, `hashCode()`, `toString()`과 같은 메서드를 호출하는 것이 가능하다.

# 37. 마커 애너테이션
값을 지정할 필요가 없는 경우, 애너테이션의 요소를 하나도 정의하지 않을 수 있다.
- 요소가 **하나도 정의되지 않은** 애너테이션을 일컫는다. (위와 같이)

# 38. 애너테이션 요소의 규칙
> - 요소의 타입은 기본형, String, enum, 애너테이션, Class만 허용된다.
> - () 안에 매개변수를 선언할 수 없다.
> - 예외를 선언할 수 없다.
> - 요소를 타입 매개변수로 정의할 수 없다.

```java
@interface AnnoTest {
    int id = 100; // OK
    String major(int i, int j); // Error
    String minor() throws Exception; // Error 
    ArrayList<T> list(); // Error 
}
```

# 39. 애너테이션의 활용 예제