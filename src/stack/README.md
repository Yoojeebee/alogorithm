# 스택

데이터를 일시적으로 저장하기 위한 자료구조 중 하나로 가장 나중에 넣은 데이터를 가장 먼저 꺼내는
후입선출(LIFO, Last In First Out)이며 스택에 데이터를 넣는 작업을 푸시(push), 스택에서 데이터를
꺼내는 작업을 팝(pop)이라고 한다.

![stack_push_pop](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/stack_push_pop.jpg?raw=true) 
  
위의 이미지는 데이터를 스택에 푸시(push)하고 팝(pop)하는 과정을 그림으로 표현한 것이다.  
<br/>
이렇게 푸시(push)와 팝(pop)을 하는 위치를 가리켜 가장 위 꼭대기를 top이라 하고 가장 아랫 부분을
bottom이라 한다.

![stack_top_bottom](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/stack_top_bottom.jpg?raw=true)

위의 그림과 아래의 그림을 보면 데이터의 추가 삭제는 항상 맨 위 즉, top에서 일어나고 이곳에서 
푸시(push)와 팝(pop)이 일어나고 있다. 


## 스택 구현 클래스 만들기(배열)
스택을 구현하는 클래스``int형``를 만들기 위한 필드, 생성자, 메서드 순으로 설명<br/>
<br/>
#### 필드(=멤버변수)
푸시(push)된 데이터를 담는 곳 그리고 그 데이터의 용량을 결정하는 변수를 구현
~~~java
public class Stack {

    // 데이터의 용령을 결정하는 변수
    private final int DEFAULT_STACK_SIZE = 10;    
    
    // 푸시(push)된 데이터를 담는 곳
    public int[] capacity;
}
~~~
<br/>

그리고 이 스택의 최상위에 있는 데이터를 가리키는 top과 최하위를 있는 데이터를
 가리키는 bottom 변수를 구현
```java
public class Stack {
    
    // 데이터의 용령을 결정하는 변수
    private final int DEFAULT_STACK_SIZE = 10;    
    
    // 푸시(push)된 데이터를 담는 곳
    public int[] capacity;

    // 스택에 쌓여있는 데이터들 중 가장 최상위에 위치한 곳을 가리키는 변수 
    public int top;
    
    // 스택에 쌓여있는 데이터들 중 가장 최하위에 위치한 곳을 가리키는 변수
    public int bottom;
}
```
