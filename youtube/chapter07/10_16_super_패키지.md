# 10. 참조변수 super
`super`: **자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조**하는데 사용되는 참조변수

멤버변수와 지역변수의 이름이 같을 때 `this`를 붙여서 구별했듯이 상속받은 멤버와 자신의 멤버와 이름이 같을 때는 `super`를 붙여서 구별할 수 있다.

```java
class Ex7_2 {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    }
}

class Parent { int x = 10; /* super.x */}

class Child extends Parent {
    int x = 20; // this.x
    void method() {
        System.out.println("x=" + x);
        System.out.println("this.x =" + this.x);
        System.out.println("super.x =" + super.x);
    }
}
```

```java
class Ex7_3 {
        public static void main(String[] args) {
            Child2 c = new Child2();
            c.method();
        }
}
class Parent2 { int x = 50; /* super.x와 this.x 둘 다 가능 */}

class Child2 extends Parent2 {
    void method() {
        System.out.println("x=" + x);
        System.out.println("this.x =" + this.x);
        System.out.println("super.x =" + super.x);
    }
}
```
- 모든 인스턴스 메서드에는 `this`와 `super`가 지역변수로 존재하는데, 이 둘에는 자신이 속한 인스턴스의 주소가 자동으로 저장된다.
- 조상의 멤버와 자신의 멤버를 구별하는데 사용된다는 점만 제외하면 `this`와 `super`는 근본적으로 같다.

# 11. super() - 조상의 생성자
`this()`처럼 `super()`도 생성자다. `super()`는 조상의 생성자를 호출하는데 사용된다.
```java
class Point {
    int x,y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

```java
class Point3D extends Point {
    int z;
    
    Point(int x, int y, int z) {
        this.x = x; // 조상의 멤버를 초기화
        this.y = y; // 조상의 멤버를 초기화
        this.z = z;
    }
}
```
- `Point3D`클래스의 생성자가 조상인 `Point` 클래스로부터 상속받은 x,y를 초기화한다.
- 틀린 코드는 아니지만, 생성자 `Point3D()`를 아래처럼 조상의 멤버는 조상의 생성자를 통해 초기화하는 것이 바람직하다.

```java
Point(int x, int y, int z) {
        super(x, y); // 조상클래스의 생성자 Point(int x, int y)를 호출
        this.z = z; // 자신의 멤버를 초기화
    }
```


# 12. 패키지 package
패키지: **클래스의 묶음**
- 클래스 또는 인터페이스를 포함시킬 수 있다.
- 서로 관련된 클래스들끼리 그룹 단위로 묶어 놓음으로써 클래스를 효율적으로 관리할 수 있다.
- 같은 이름의 클래스일지라도 서로 다른 패키지에 존재하는 것이 가능하므로, 자신의 패키지 체계를 유지함으로써 다른 개발자가 개발한 클래스 라이브러리의 클래스와 이름이 충돌하는 것을 피할 수 있다.
- **사실 클래스의 full name은 패키지명을 포함**한 것이다.
  - `String`클래스의 실제 이름은 java.lang.String이다. `java.lang`패키지에 속한 `String`클래스라는 의미다.
  - 그래서 같은 이름의 클래스일 지라도 서로 다른 패키지에 속하면 패키지명으로 구별이 가능하다.
- 클래스가 물리적으로 하나의 클래스파일(`.class`)인 것과 같이 패키지는 물리적으로 하나의 디렉토리다.
- 디렉토리가 하위 디렉토리를 가질 수 있는 것처럼, 패키지도 다른 패키지를 포함할 수 있으며 점`.`으로 구분한다.

# 13. 패키지의 선언
`package 패키지명;`
- 반드시 소스파일에서 주석과 공백을 제외한 첫 번째 문장이어야 한며, 하나의 소스파일에 단 한 번만 선언될 수 있다.
- 해당 소스파일에 포함된 모든 클래스나 인터페이스는 선언된 패키지에 속하게 된다.
- 패키지명은 대소문자를 모두 허용하지만, 클래스명과 쉽게 구분하기 위해 소문자로 하는 것을 원칙으로 하고 있다.
- 자바는 기본적으로 제공하는 unnamed package가 있다.
  - 소스파일에 자신이 속할 패키지를 지정하지 않은 클래스는 자동적으로 여기에 속하게 된다.


# 14. 클래스 패스 class path

# 15. import문 
```java
java.util.Date today = new java.util.Date();
```
⬇️
```java
import java.util.Date; 
    // ... 
    Date today = new Date();
```

# 16. static import문
```java
import static java.lang.Integer.*;
import static java.lang.Math.random;
import static java.lang.System.out;
```