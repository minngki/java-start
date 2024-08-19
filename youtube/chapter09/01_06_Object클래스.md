java.lang패키지는 import문 없이도 사용할 수 있다.

# 1. Object 클래스
모든 클래스의 최고 조상이므로 모든 클래스에서 바로 사용가능하다.

# 2. Object 클래스의 메서드 - `equals()`
```java
public boolean equals(Object obj) {
    return (this==obj);
}
```
- 두 객체의 같고 다름을 참조변수의 값으로 판단하므로, 서로 다른 두 객체를 equals메서드로 비교하면 항상 false가 나온다.
- 객체 생성 시, 메모리의 비어있는 공간을 찾아 생성하므로 서로 다른 두개의 객체가 같은 주소를 갖는 일은 있을 수 없다. 그러나 두개 이상의 참조변수가 같은 주소값을 갖는 것(한 객체를 참조하는 것)은 가능하다.
> equals메서드는 결국 **두 개의 참조변수가 같은 객체를 참조하고 있는지, 즉 두 참조변수에 저장된 주소값이 같은지를 판단하는 기능** 밖에 할 수 없다.

# 3. equals()의 오버라이딩
주소가 아닌 객체에 저장된 내용(value)을 비교하도록 하면 된다.
```java
class Person {
	long id;

	public boolean equals(Object obj) {
		if(obj instanceof Person)
			return id ==((Person)obj).id; // obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환이 필요하다.
		else
			return false;
	}

	Person(long id) {
		this.id = id;
	}
}

class Ex9_2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);

		if(p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
	}
}
```

# 4. Object 클래스의 메서드 - `hashCode()`
이 메서드는 해싱기법에 사용되는 hash function을 구현한 것이다. 다량의 데이터를 저장하고 검색하는 데 유용하다.
- 찾고자하는 값을 입력하면, **그 값이 저장된 위치를 알려주는 해시코드를 반환한다.**

일반적으로 해시코드가 같은 두 객체가 존재할 수 있지만, Object클래스에 정의된 hashCode메서드는 객체의 주소값을 이용해서 해시코드를 반환하기 때문에 결코 같은 해시코드를 가질 수 없다. 


# 5. Object클래스의 메서드 - `toString()`

# 6. `toString()`의 오버라이딩
