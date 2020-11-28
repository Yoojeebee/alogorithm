package queue;

public class QueueQuiz2<E> {

    private final int MAX_QUEUE_SIZE = 5;

    private E[] capacity;

    private int front;

    private int rear;

    private int max;

    public QueueQuiz2() {
        capacity = (E[])new Object[MAX_QUEUE_SIZE];
    }

    public void enqueue(E data) {
        if(data == null) {
            System.out.println("정확한 값을 입력해주세요.");
            return;
        }

        if(rear < 0) {
            System.out.println("데이터가 들어갈 자리가 없습니다.");
            return;
        }

        if(front == 0) {
            front = capacity.length-1;
            capacity[front] = data;
            rear = front - 1;
        } else {
            capacity[rear--] = data;
        }
    }

    public E dequeue() {
        if(front == 0 || rear < 0) {
            return null;
        }

        E data = capacity[front];
        System.arraycopy(capacity, rear, capacity, rear+1, front - rear);
        capacity[rear++] = null;

        if(rear == front) {
            front = 0;
            rear = 0;
        }

        return data;
    }

}
