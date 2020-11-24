# 큐(queue)  
스택과 마찬가지로 데이터를 쌓아 두기 위한 자료구조이며 가장 먼저 넣은 데이터를 가장 먼저 꺼내는 
선입선출(First-In-First-Out) 구조로 되어 있다.  

큐에 데이터를 넣는 작업을 인큐(enqueue) 

![queue_enqueue](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/queue_enqueue.jpg?raw=true)

<br/>

큐에 데이터를 꺼내는 작업을 디큐(dequeue)  

![queue_enqueue](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/queue_dequeue.jpg?raw=true)

<br/>

큐의 데이터들 중 가장 먼저 데이터가 들어온 자리 - 프런트(front)  
큐의 데이터들 중 가장 늦게 데이터가 들어올 자리 - 리어(rear)

![queue_enqueue](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/queue_front_rear.jpg?raw=true)

<br/>

## 큐(Queue)를 배열로 구현해보기
큐를 구현하는 클래스를 만들기 위한 필드, 생성자, 메서드 순으로 설명<br/>

> 큐 클래스는 오직 0보다 큰 정수값을 가지는 클래스이며 0보다 작은 값 즉, 음의 값은 다루지 않는 클래스를 조건으로 만든 클래스  

<br/>

#### 필드(=멤버변수)

- 큐의 최대사이즈를 결정하는 변수 `MAX_QUEUE_SIZE`
- 큐의 자료구조 형태로 넣을 배열 변수 `capacity`
- 큐에 들어올 데이터들 중 가장 먼저 데이터가 들어온 자리 변수 `front`
- 큐에 들어올 데이터들 중 가장 늦게 데이터가 들어올 자리 변수 `rear`
- 큐의 자료구조 형태로 있는 배열 안에 데이터 개수를 가리키는 변수 `dataCnt`

```java
public class Queue {

    private final int MAX_QUEUE_SIZE = 20;

    private int[] capacity;

    private int front;

    private int rear;

    private int dataCnt;
}
```
<br/>

#### 생성자

- 기본 생성자
- 큐의 배열 사이즈를 인자 값으로 받아오는 생성자
```java
public class Queue {

    public Queue() {
        capacity = new int[MAX_QUEUE_SIZE];
    }
    public Queue(int queue_size) {
        capacity = new int[queue_size];
    }

}
```
<br/>

#### 메서드
> return 0; 는 반환하는 메서드의 조건이 일치하지 않을 경우 설정한 값(0은 거짓 1은 참이라는 불리언 자료형에서 참조)

- 인큐(enqueue)  
    큐의 자료구조에 데이터를 넣는 작업
```java
public class Queue {

    public void enqueue(int data) {
        // data가 0보다 큰지 확인
        if(0 > data) {
            System.out.println("0보다 큰 정수를 입력하시오.");
            return;
        }
    
        // 큐의 데이터를 담는 배열 데이터 남는 자리 확인(rear는 자리 커서)
        if(rear < 0) {
            System.out.println("데이터가 들어갈 자리가 없습니다.");
            return;
        }
    
        // 데이터가 처음으로 들어올 경우 프런트와 리어 값을 초기화하고 배열에 데이터를 넣는다.
        if(front == 0) {
            front = capacity.length-1;
            capacity[front] = data;
            rear = front - 1;
        } else {
            capacity[rear--] = data;
       }
    }

}
```
<br/>

- 디큐(dequeue)  
    큐의 자료구조에 데이터를 빼는 작업
```java
public class Queue {
    public int dequeue() {
        // front가 0은 배열에 데이터가 없다는 뜻
        // 리어가 0보다 작다는 말은 배열에 데이터를 넣을 자리가 없다는 뜻
        if(front == 0 || rear < 0) {
            return -1;
        }

        int data = capacity[front];
        System.arraycopy(capacity, rear, capacity, rear+1, front - rear);
        capacity[rear++] = 0;
        // System.arraycopy(src, srcPos, dest, destPos, length)
        // src = 복사할 배열
        // srcPos = 복사할 배열 위치(시작점)
        // dest = 복사받을 배열
        // destPos = 복사받을 배열 위치(시작점)
        // length = 카피되는 배열 요소 수

        // rear와 front가 같다는 말은 배열에 데이터가 없다는 뜻
        if(rear == front) {
            front = 0;
            rear = 0;
        }

        return data;
    }
}
```
<br/>

- 피크(peek)  
    큐의 자료구조 배열에 있는 데이터들 중 프론트 자리에 있는 값을 확인하는 작업
 ```java
public class Queue {
    public int peek() {
        // front가 0이라는 뜻은 데이터가 없다는 뜻
        if(front == 0) {
            System.out.println("존재하는 데이터가 없습니다!");
            return 0;
        }
        return capacity[front];
    }
}
```
<br/>

- 검색(indexOf)  
    큐의 자료구조 배열에 있는 데이터들 중 입력한 값이 어느 위치에 있는 알려주는 작업
```java
public class Queue {
    public int indexOf(int data) {
        // 인자 값으로 받은 data와 같은 값을 갖고 있는 위치를 알려주는 변수
        int cosor = 0;

        for(int i = front; i > rear; i--) {
            if(capacity[i] == data)
                cosor = i;
        }

        return cosor;
    }
}
```
<br/>

- 삭제(clear)  
    현재 큐의 자료구조 배열에 있는 모든 데이터를 삭제하는 작업
```java
public class Queue {
    public void clear() {
        for(int i = front; i > rear; i--) {
            capacity[i] = 0;
        }
    }
}
```
<br/>

- 용량(capacity)  
    큐의 자료구조 배열의 최대 용량을 반환하는 작업
```java
public class Queue {
    public int capacity() {
        return MAX_QUEUE_SIZE;
    }
}
```