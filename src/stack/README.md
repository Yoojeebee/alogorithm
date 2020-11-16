# 스택

데이터를 일시적으로 저장하기 위한 자료구조 중 하나로 가장 나중에 넣은 데이터를 가장 먼저 꺼내는
후입선출(LIFO, Last In First Out)의 형태를 가지고 있으며 데이터를 넣는 작업을 푸시(push), 스택에서 데이터를
꺼내는 작업을 팝(pop)이라고 한다.

![stack_push_pop](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/stack_push_pop.jpg?raw=true) 
  
위의 이미지는 데이터를 스택에 푸시(push)하고 팝(pop)하는 과정을 그림으로 표현한 것이다.  
<br/>
이렇게 푸시(push)와 팝(pop)을 통해 데이터의 순서가 생기며 가장 위에 있는 데이터를 top이라 하고 가장 아랫 부분을
bottom이라 한다.  
위의 그림과 아래의 그림을 보면 데이터의 추가 삭제는 항상 맨 위 즉, top에서 일어난다. 즉, top은 데이터의 추가 및 삭제가 일어나면서 
항상 값이 변한다는 의미이다.  
그러므로, top은 가장 최신의 데이터를 가지고 있고, bottom은 첫 번째로 들어온 데이터를 가지고 있다 

![stack_top_bottom](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/stack_top_bottom.jpg?raw=true)

이렇게 여러개의 데이터가 쌓이게 되면 데이터의 추가 및 삭제에 있어서 데이터의 위치를 알려주는 커서(=포인터)가 필요하다.
데이터의 위치를 알려주는 커서는 아래의 그림의 형태를 가지고 있다.

![stack_cosor](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/stack_cosor.jpg?raw=true)

<br/>
  
## 스택 구현 클래스 만들기(배열)
스택을 구현하는 클래스를 만들기 위한 필드, 생성자, 메서드 순으로 설명<br/>

> 스택 클래스는 오직 0보다 큰 정수값을 가지는 클래스이며 0보다 작은 값 즉, 음의 값은 다루지 않는 클래스를 조건으로 만든 클래스

<br/>

#### 필드(=멤버변수)
푸시(push)된 데이터를 담는 곳 그리고 그 데이터의 용량을 결정하는 변수를 구현
~~~java
public class Stack {

    // 스택 데이터 사이즈(= 용량)를 결정하는 변수
    private final int DEFAULT_STACK_SIZE = 10;    
    
    // 스택 데이터를 담는 변수
    public int[] capacity;
}
~~~
<br/>

스택의 최신의 데이터를 가지는 top과 첫 번째로 들어온 데이터를 가진 bottom 변수를 구현
```java
public class Stack {
    
    ...

    // 스택에 쌓여있는 데이터들 중 최신의 데이터 값을 가지고 있는 변수
    public int top;
    
    // 스택에 쌓여있는 데이터들 중 첫 번째로 들어온 데이터의 값을 가지고 있는 변수
    public int bottom;
}
```
<br/>

스택에 있는 데이터를 알려주는 커서(= 포인터)의 역할을 하는 cosor 변수를 구현
```java
public class Stack {
    ...
    
    // 스택에 있는 데이터를 알려주는 변수
    public int cosor;
}
```
<br/>
<br/>
  
#### 생성자
생성자는 기본 생성자 및 데이터를 담는 변수의 용령을 결정하는 생성자 두 개의 생성자 구현
```java
public class Stack {
    ...
    
    // 스택의 용량이 10으로 고정된 클래스의 생성자
    public Stack() {
        this.top = 0;
        this.bottom = 0;
        this.capacity = new int[DEFAULT_STACK_SIZE];
    }
    // 스택의 용량이 size로 고정된 클래스의 생성자
    public Stack(int size) {
        this.top = 0;
        this.bottom = 0;
        this.capacity = new int[size];
    }

}
```
<br/>
<br/>
  
#### 메서드(가장 중요)
> return 0; 는 반환하는 메서드의 조건이 일치하지 않을 경우 설정한 값(0은 거짓 1은 참이라는 불리언 자료형에서 참조)
- 푸시(push) 메서드  

    스택에 데이터를 넣는 메서드
```java
public int push(int item) {
    // item의 값이 정수값 0보다 큰 정수일 경우에만 푸시 되도록 하는 조건문
    if(item >= 0) {
        // 스택 데이터를 담는 capacity의 cosor에 itme 데이터를 초기화시킨다.
        capacity[cosor++] = item;

        // top은 가장 최신의 데이터인 item으로 초기화 시킨다
        top = item;

        return 1;
    }
    return 0;
}
```
<br/>

- 팝(pop) 메서드  

    스택의 꼭대기 top에 있는 데이터를 제거하고 그 값을 반환하는 메서드이다
```java
public int pop() {
    // top의 값이 0일 경우는 데이터가 없다는 뜻이기에 이와 같은 조건문 추가
    if(top != 0) {
        // item 변수에 top에 있는 값을 초기화 
        int item = top;
    
        // --cosor를 하는 이유는 push시 cosor의 위치를 1씩 증가시키기 때문에
        // --cosor를 하게 되면 top의 값이 있는 자리로 커서가 돌아오고
        // 이 커서가 가리키는 스택의 데이터를 0으로 초기화
        capacity[--cosor] = 0;

        // cosor가 0이 아니라는 말은 아직 데이터가 더 있다는 뜻으로 조건문을 통해
        // top의 데이터를 재초기화
        // cosor가 0일 경우는 더 이상 데이터가 없다는 뜻으로 top, bottom 데이터를 0으로 초기화
        if(cosor != 0) {
            top = capacity[cosor - 1];
        } else {
            top = 0;
            bottom = 0;
        }

        return item;
    }
    return 0;
}
```
<br/>

- 피크(peek) 메서드  

    스택의 top에 있는 데이터가 어떤 데이터인지 확인하는 메서드
```java
public int peek() {
    // top이 0이 아니라는 것은 데이터가 최소 1개 이상은 들어있다는 뜻이기에 이와 같은 조건문 추가
    if(top != 0) {
        return top;
    }
    return 0;
}
```
<br/>

문제  
스택을 다루는 메서드들은 push, pop, peek 이외에도 수 많은 것이 있다.  
밑에 제시된 메서드들을 추가로 추가하고 push, pop, peek 메서드도 수정할 것이 있으면 수정한 뒤 Stack 클래스를 완성시킨다.

- 검색 메서드 indexOf  
```java
/**
  * 매개변수 data를 통해 들어온 인자 값이 스택에 있을 경우 cosor의 몇 번째 자리에 있는지 반환하는 메서드
  * @param data -> 0보다 큰 정수 값
  * @return 스택에 data가 있으면 cosor의 자리를 반환, 아니면 0을 반환
  */
public int indexOf(int data) { ... }
``` 
<br/>

- 스택이 꽉 차면 자동으로 추가하는 메서드 capacitySizeUp
```java
/**
  * push 메서드 실행시 capacity의 데이터가 더 이상 들어 갈 수 없을 때 capacity의 용량을 늘리는 메서드
  * 단, 최대로 늘릴 수 있는 크기는 20이하로 설정
  * @param item -> push 메서드 실행 시 데이터가 더 이상 들어 갈 수 없을 때 매개변수로 값을 받아와 처리
  * @return 실행이 제대로 되었다면 1을 반환, 그렇지 않다면 0을 반환
  */
private int capacitySizeUp(int item) { ... }
```