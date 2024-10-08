# 반복문

## do-while
- 조건에 상관없이 한 번은 무조건 실행해야할 때 사용한다.

## 무한 반복 코드
```java
for (;;) {
    // 코드
        };

while (true) {
    // 코드
        };
```

### while vs for
정해진 횟수만큼 반복한다면 for문, 그렇지 않으면 while문을 사용한다.

#### for
- 장점
  - 초기화, 조건 체크, 반복 후의 작업을 한 줄에서 처리할 수 있어 편리하다.
  - 정해진 횟수만큼의 반복을 수행하는 경우 사용하기 적합하다.
  - 루프 변수의 범위가 for 루프 블록에 제한되므로, 다른 고셍서 이 변수를 실수로 변경할 가능성이 적다.
- 단점
  - 루프의 조건이 루프 내부에서 변경되는 경우, for 루프는 관리하기 어렵다.
  - 복잡한 조건을 가진 반복문을 작성하기에는 while문이 더 적합할 수 있다.

#### while
- 장점
  - 루프의 조건이 루프 내부에서 변경되는 경우, while 루프는 이를 관리하기 쉽다.
  - for 루프보다 더 복잡한 조건과 시나리오에 적합하다.
  - 조건이 충족되는 동안 계속해서 루프를 실행하며, 종료 시점을 명확하게 알 수 없는 경우 유용하다.
- 단점
  - 초기화, 조건 체크, 반복 후의 작업이 분산되고 있어 코드를 이해하거나 작성하기 어려울 수 있다.
  - 루프 변수가 while 블록 바깥에서도 접근 가능하므로, 이 변수를 실수로 변경하는 상황이 발생할 수 있다.


