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

- 검색 메서드 indexOf  
    스택 본체의 배열에 입력한 데이터 값이 포함되어 있는지 확인하며, 포함되어 있다면 배열의 어디에 있는지를 알려주는 메서드
```java
public int indexOf(int data) {
    // top이 0이 아니라는 것은 데이터가 최소 1개 이상은 들어있다는 뜻이기에 이와 같은 조건문 추가
   if(top != 0) {
        // cosor - 1 을 한 이유는 cosor는 push시 자동적으로 1이 증가되어 다음 위치에 저장될 위치로 옮겨가기 때문에
        // 데이터가 저장되어 있는 지점부터 데이터를 확인하려면 -1을 해줘야 한다
       for(int i = cosor-1; i < cosor; i--) {
           if(capacity[i] == data)
               return i;
       }
   }
   return 0;
}
```
<br/>

- 스택의 모든 요소를 삭제하는 메서드 clear  
    스택에 쌓여있는 모든 데이터를 삭제
```java
public void clear() {
    // cosor - 1 을 한 이유는 cosor는 push시 자동적으로 1이 증가되어 다음 위치에 저장될 위치로 옮겨가기 때문에
    // 데이터가 저장되어 있는 지점부터 데이터를 확인하려면 -1을 해줘야 한다
    for(int i = cosor -1; i == 0; i--) {
        // 스택에 push된 모든 데이터들을 0으로 초기화(= null)
        capacity[i] = 0;
    }
    // 스택의 모든 데이터가 초기화되었으므로 top, bottom도 초기화(= null)
    top = 0;
    bottom = 0;
}
```
<br/>

- 용량을 확인하는 메서드 capacity  
    스택의 용량(Stack클래스의 배열 capacity의 길이)을 반환한다
```java
public int capacity() {
    // top의 값이 0이 아니라는 것은 스택에 데이터가 있다는 뜻이고 그 뜻은 데이터의 용량이 설정되어 있다는 의미이다
    if(top != 0) {
        return capacity.length;
    }
    return 0;
}
```
<br/>

- 데이터 수를 확인하는 메서드 size  
    현재 스택에 쌓여 있는 데이터 수(cosor의 값)을 반환
```java
public int size() {
    // top의 값이 0이 아니라는 것은 스택에 데이터가 있다는 뜻이고 그 뜻은 데이터의 용량이 설정되어 있다는 의미이다
    if(top != 0) {
        return cosor;
    }
    return 0;
}
```
<br/>

- 스택이 비어 있는지 검사하는 메서드 isEmpty  
    스택(Stack클래스의 capacity)이 비어있는지 확인하며 비어 있으면 true, 아니면 false
```java
public boolean isEmpty() {
    // top의 값이 0이 아니라는 것은 스택에 데이터가 있다는 뜻이고 그 뜻은 데이터의 용량이 설정되어 있다는 의미이다
    if(top != 0) {
        return false;
    }
    return true;
}
```
<br/>

- 스택이 가득 찼는지 검사하는 메서드 isFull  
    스택(Stack클래스의 capacity)의 용량이 가득 찼는지(= 데이터가 모든 배열의 요소에 들어갔는지) 확인하며 맞으면 true, 아니면 false
```java
public boolean isFull() {
    // cosor: 다음 위치는 가리키는 변수
    // capacity.length: 배열의 길이
    // 만약, 용량 10의 capacity가 꽉차게 되면 cosor의 위치는 10(cosor 변수는 다음 위치의 값을 저장해야 되기 때문에 +1)
    // capacity.length의 값은 10 그러므로 cosor의 값과 capacity.length이 같으면 용량이 꽉 찼다는 의미 
    if(cosor == capacity.length) {
        return true;
    }
    return false;
}
```
<br/>

- 스택 안에 있는 모든 데이터를 표시하는 메서드 printStackData  
    스택(Stack클래스의 capacity)에 쌓여 있는 모든 데이터를 바닥(bottom)에서 꼭대기(top)순으로 표시
```java
public void printStackData() {
    // top의 값이 0이 아니라는 것은 스택에 데이터가 있다는 뜻이고 그 뜻은 데이터의 용량이 설정되어 있다는 의미이다
    if(top != 0) {
        for (int i = cosor - 1; i >= 0; i--) {
            System.out.println(capacity[i]);
        }
    } else {
        System.out.println("스택이 비어 있습니다.");
    }
}
```
