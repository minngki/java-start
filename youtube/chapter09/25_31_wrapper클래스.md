# 25. wrapper 클래스
- 8개의 **기본형(객체X)을 객체로 다뤄야할 때** 사용하는 클래스
```java
public final class Integer extends Number implements Comparable {
//  ...
  private int value;
//  ...
}
```
- 래퍼클래스
    - `Integer`
    - `int value;`

# 26. wrapper 클래스 예제


# 27. Number 클래스
- **모든 숫자 래퍼 클래스의 조상**

# 28. 문자열을 숫자로 변환하기
<p align="center">
<img src=../image/stringToNumber.png>
</p>

# 29. 문자열을 숫자로 변환하기 예제


# 30. 오토박싱 & 언박싱
- 오토박싱 (auto boxing): 기본형에서 wrapper클래스(객체)로 변경하는 것
- 언박싱 (unboxing): wrapper클래스(객체)에서 기본형으로 변경하는 것

# 31. 오토박싱 & 언박싱 예제
