package queue;

public class QueueQuiz3 {

    private final int MAX_QUEUE_SIZE = 5;

    private int front;
    private int rear;

    // 데이터의 개수가 들어가 있는 변수
    private int max;

    private int[] capacity;

    public QueueQuiz3() {
        capacity = new int[MAX_QUEUE_SIZE];
        front = 0;
        rear = capacity.length - 1;
    }

    // front 커서에서 들어가는 enqueue
    public void frontEnqueue(int frontData) {
        if(frontData < 0) {
            System.out.println("0보다 큰 수를 입력하시오.");
            return;
        }

        if (max == capacity.length){
            System.out.println("데이터가 꽉 찼습니다.");
            return;
        }

        capacity[front++] = frontData;
        max++;
        if(max == capacity.length) {
            System.out.println("front쪽 데이터가 꽉 찼습니다.");
            return;
        }
    }

    // rear 커서에서 들어가는 enqueue
    public void rearEnqueue(int rearData) {
        if(rearData < 0) {
            System.out.println("0보다 큰 수를 입력하시오.");
            return;
        }

        if (max == capacity.length){
            System.out.println("데이터가 꽉 찼습니다.");
            return;
        }

        capacity[rear--] = rearData;
        max++;
        if(max == capacity.length) {
            System.out.println("rear쪽 데이터가 꽉 찼습니다.");
            return;
        }
    }

    // front 커서에서 들어가는 dequeue
    public int frontDequeue() {
        if(front == 0) {
            System.out.println("꺼낼 값이 없습니다.");
            return 0;
        }

        int frontData = capacity[--front];
        max--;
        if(front == 0) {
            System.out.println("front쪽 데이터는 없습니다.");
        }
        if(max == 0) {
            System.out.println("큐에 데이터가 없습니다.");
        }
        return frontData;
    }

    // rear 커서에서 들어가는 dequeue
    public int rearDequeue() {
        if(rear == 0) {
            System.out.println("꺼낼 값이 없습니다.");
            return 0;
        }

        int rearData = capacity[++rear];
        max--;
        if(rear == capacity.length - 1) {
            System.out.println("front쪽 데이터는 없습니다.");
        }
        if(max == 0) {
            System.out.println("큐에 데이터가 없습니다.");
        }
        return rearData;
    }
}
