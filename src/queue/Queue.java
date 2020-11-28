package queue;

public class Queue {

    // 큐 최대 사이즈
    private final int MAX_QUEUE_SIZE = 5;

    // 데이터를 담는 배열
    private int[] capacity;

    // 큐의 앞자리
    private int front;

    // 큐의 뒷자리
    private int rear;

    // 큐의 데이터를 가리키는 커서
    private int cosor;

    // 큐 클래스의 생성자 - 기본 생성자, 사이즈를 인자 값으로 받아오는 생성자
    public Queue() {
        capacity = new int[MAX_QUEUE_SIZE];
    }
    public Queue(int queue_size) {
        capacity = new int[queue_size];
    }

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

    public int dequeue() {
        // front가 0은 배열에 데이터가 없다는 뜻
        // 리어가 0보다 작다는 말은 배열에 데이터를 넣을 자리가 없다는 뜻
        if(front == 0 || rear < 0) {
            return 0;
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

    public int peek() {
        // front가 0이라는 뜻은 데이터가 없다는 뜻
        if(front == 0) {
            System.out.println("존재하는 데이터가 없습니다!");
            return 0;
        }
        return capacity[front];
    }

    public int indexOf(int data) {
        // 인자 값으로 받은 data와 같은 값을 갖고 있는 위치를 알려주는 변수
        int cosor = 0;

        for(int i = front; i > rear; i--) {
            if(capacity[i] == data)
                cosor = i;
        }

        return cosor;
    }

    public void clear() {
        for(int i = front; i > rear; i--) {
            capacity[i] = 0;
        }
    }

    public int capacity() {
        return MAX_QUEUE_SIZE;
    }

    public boolean isEmpty() {
        return front == 0 ? true : false;
    }

    public boolean isFull() {
        return rear < 0 ? true : false;
    }
}