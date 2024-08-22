# 34. HashSet

- Set인터페이스를 구현한 가장 대표적인 컬렉션
- Set 특징대로 중복된 요소를 저장하지 않는다.
- 데이터를 추가할 땐, `add()`, `addAll()` 메서드를 사용하는데, 추가할 값이 이미 저장되어있는 요소라면 `false`를 반환하며 추가에 실패함을 알린다.
- 이러한 특징으로 중복제거가 용이하다. (중복X, 정렬X)
- 저장순서를 유지하지 않으므로, 저장순서를 유지하고 싶다면 `LinkedHashSet`을 사용해야한다.

# 35. HashSet 예제1

- 문자열과 숫자는 중복이 되지 않으므로 ['1', 1] 이렇게 저장될 수 있다.

# 36. HashSet 예제2

```java
import java.util.*;

public class Ex11_10 {
    public static void main(String[] args) {
        Set set = new HashSet();
        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(new Integer(num));
        }

        List list = new LinkedList(set); // LinkedList(Collection c)
        Collections.sort(list); // Collections.sort(List list)
        System.out.println(list);
    }
}
```

- `sort()` 메서드는 List인터페이스 타입을 필요로 하기 때문에 `LinkedList`클래스의 생성자 `LinkedList(Collection c)`을 이용한다.
- `new Integer(num)` 객체를 생성하는 것은 불필요한 객체 생성을 유발할 수 있으며, 자바의 최신 버전에서는 권장되지 않는 방식

# 37. HashSet 예제3

```java
package example;

import java.util.*;

public class Ex11_11 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + ":" + age;
    }
}
```

- 결과: `[David:10, abc, David:10]`
    - 왜 `David:10`가 중복되어 들어갈까? 두 개의 인스턴스를 같은 것으로 인식하게 만들어야 한다.
    - Person클래스에 아래의 두 메서드를 추가(오버라이딩)해야 한다.

```java
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + ":" + age;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person p = (Person) obj;
        return name.equals(p.name) && age == p.age;

    }

    public int hashCode() {
        return Objects.hash(name, age); // int hash(Object... values)
    }
}
```

- HashSet의 `add()`메서드는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기 위해
    - 추가하려는 요소의 `equals()`와 `hashCode()`를 호출한다.
    - 때문에 `equals()`뿐만 아니라 `hashCode()`도 목적에 맞게 오버라이딩해야 한다.

# 38. HashSet 예제4

# 39. TreeSet

Binary search tree라는 자료구조 형태로 데이터를 저장하는 컬렉션 클래스다.

### 이진 탐색 트리 Binary search tree

- 정렬, 검색, 범위검색(range search) 에 높은 성능을 보이는 자료구조이며
- TreeSet은 이진 탐색 트리의 성능 향상시킨 '레드-블랙 트리(Red-Black tree)'로 구현되어 있다.
- Set 특징대로 **중복된 요소를 저장하지 않으며 정렬된 위치에 저장하므로 저장순서를 유지하지도 않는다.**
    - (중복X, 정렬O)
- 이진트리는 연결리스트처럼 여러 개 노드가 서로 연결된 구조로, 각 노드에 최대 2개의 노드가 연결할 수 있다.
    - 루트라고 불리는 하나의 노드에서부터 시작해서 계속 확장한다.

```java
class TreeNode {
    TreeNode left; // 왼쪽 자식노드
    Object element; // 객체를 저장하기 위한 참조변수
    TreeNode right; // 오른쪽 자식노드
}
```

# 40. 이진 탐색 트리 Binary search tree

**부모노드의 왼쪽에는 부모노드의 값보다 작은 값의 자식노드를 오른쪽에는 큰 값의 자식노드를 저장하는 이진 트리**다.

- 즉, `왼쪽 노드 - 부모 노드 - 오른쪽 노드` 순으로 읽어오면 오름차순으로 정렬된 순서를 얻을 수 있다.

<p align="center">
<img src=../image/binarySearchTree.png>
</p>

> - 노드의 추가.삭제에 시간이 걸린다. (반복 비교로 자리를 찾아 저장)
    >

- 추가: 데이터를 순차적으로 저장하는 것이 아니라 저장위치를 찾아서 저장해야한다.

> - 삭제: 트리의 일부를 재구성해야 하므로 연결리스트보다 시간이 더 걸린다.
> - 검색(범위검색)과 정렬에 유리하다.
    >

- 배열이나 연결리스트에 비해 기능이 뛰어ㅏ다.

> - 저장된 개수에 비례해서 검색시간이 증가하긴 하지만 값의 개수가 10배 증가해도 특정값을 찾는데 필요한 비교횟수가 3~4번 증가할 정도로 효율이 뛰어나다.
> - 중복된 값을 저장하지 못한다.

# 41. 이진 탐색 트리의 저장과정

컴퓨터는 알아서 값을 비교하지 못하므로, TreeSet에 저장되는 객체가 Comparable을 구현하던가 아니면, Comparator를 제공해서 두 객체를 비교할 방법을 알려줘야 한다.
그렇지 않으면 객체를 저장할 때 예외가 발생한다.

# 42. TreeSet의 메서드

# 43. TreeSet 예제

```java
package example;

import java.util.*;

public class Ex11_13 {
    public static void main(String[] args) {
        Set set = new TreeSet();
        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num); // set.add(new Integer(num))
        }
        // 이미 정렬되었기 때문에 따로 정렬하지 않아도 된다.
        System.out.println(set);
    }
}
```

- num이 int 타입이지만, TreeSet에 추가될 때 자동으로 Integer 객체로 변환된다.
- 기본 타입을 HashSet에 넣을 때도 역시 **오토박싱**이 일어나 Integer 객체가 추가된다.
    - 그러나 코드에서 new Integer(num)을 명시적으로 사용하여 Integer 객체를 생성하는 것은 불필요한 객체 생성을 유발할 수 있으며, 자바의 최신 버전에서는 권장되지 않는 방식이다.

# 44. TreeSet 예제2

subSet()을 이용해서 범위검색할 때는 시작범위는 포함되지만 끝 범위는 포함되지 않는다.

- `set.subSet('b', 'd')`: 'b', 'c'로 시작하는 단어들만 포함된다.
- `set.subSet('b', 'd'+ 'zzz')`: 만약 'd'도 포함하고 싶다면 끝 범위에 `zzz`를 붙이면 된다.
    - `set`에 `dZZZZ`, `dance`라는 문자열이 포함되어있다면, `[..., 'dZZZZ', 'dance']`가 반환되는데, 대문자가 소문자보다 우선하기 때문이다.

# 45. TreeSet 예제3
