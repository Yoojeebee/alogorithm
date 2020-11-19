package stack;

// Stack 클래스
public class Stack {

    // 상수
    private final int DEFAULT_CAPACITY_SIZE = 5;
    private final int MAX_CAPACITY_SIZE = 20;

    /* 멤버 변수 */
    private int top;
    private int bottom;
    private int cosor;
    private int[] capacity;

    /* 생성자 */
    public Stack() {
        this.cosor = 0;
        this.capacity = new int[DEFAULT_CAPACITY_SIZE];
    }
    public Stack(int capacity) {
        this.cosor = 0;
        this.capacity = new int[capacity];
    }

    /* 메서드 */
    public int push(int data) {
        if(data >= 0) {
            if(cosor < capacity.length) {
                if(bottom == 0) {
                    bottom = data;
                }
                capacity[cosor++] = data;
                top = data;
                return 1;
            } else {
                if(capacitySizeUp(data) == 1)
                    return 1;
            }
        }
        return 0;
    }

    public int pop() {
        if(top != 0) {
            int data = top;
            capacity[--cosor] = 0;
            if(cosor != 0) {
                data = top;
                top = capacity[cosor - 1];
            } else {
                top = 0;
                bottom = 0;
            }
            return data;
        }
        return 0;
    }

    public int peek() {
        if(top != 0) {
            return top;
        }
        return 0;
    }

    public int indexOf(int data) {
        if(top != 0) {
            for(int i = cosor-1; i >= 0; i--) {
                if(capacity[i] == data) {
                    System.out.println(capacity[i]);
                    return i;
                }
            }
        }
        return 0;
    }

    private int capacitySizeUp(int data) {
        if(cosor == capacity.length) {
            if((cosor + 1) <= MAX_CAPACITY_SIZE) {
                int[] capacityCopy = capacity;
                capacity = new int[capacity.length + 5];
                System.arraycopy(capacityCopy, 0, capacity, 0, capacityCopy.length);
                capacity[cosor++] = data;
                top = data;
                return 1;
            } else {
                System.out.println("스택 사이즈가 20을 넘었습니다!");
            }
        }
        return 0;
    }

    public void clear() {
        for(int i = cosor -1; i >= 0; i--) {
            capacity[i] = 0;
        }
        top = 0;
        bottom = 0;
    }

    public int capacity() {
        if(top != 0) {
            return capacity.length;
        }
        return 0;
    }

    public int size() {
        if(top != 0) {
            return cosor;
        }
        return 0;
    }

    public boolean isFull() {
        if (cosor == capacity.length) {
            return true;
        }
        return false;
    }

    public void printStackData() {
        if(top != 0) {
            for (int i = cosor - 1; i >= 0; i--) {
                System.out.println(capacity[i]);
            }
        } else {
            System.out.println("스택이 비어 있습니다.");
        }
    }
}
