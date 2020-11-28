package stack;

public class StackQuiz {

    // 스택 최대 사이즈
    private final int MAX_STACK_SIZE = 11;

    private int leftCosor;
    private int rightCosor;

    private Object[] capacity;

    private IntegerStack integerStack;
    private StringStack stringStack;

    public StackQuiz() {
        capacity = new Object[MAX_STACK_SIZE];
        leftCosor = 0;
        rightCosor = capacity.length - 1;

        integerStack = new IntegerStack();
        stringStack = new StringStack();
    }

    // int형 스택 푸시
    public void push(int data) {
        if(data < 0) {
            return;
        }

        if(leftCosor >= capacity.length / 2) {
            System.out.println("int 스택은 꽉 찼습니다.");
            return;
        }

        if(leftCosor < capacity.length / 2) {
            if(integerStack.bottom == 0) {
                integerStack.bottom = data;
            }
            integerStack.capacity[integerStack.cosor++] = data;
            capacity[leftCosor++] = data;
            integerStack.top = data;
        }
    }

    // String 스택 푸시
    public void push(String data) {
        if(data == null) {
            return;
        }

        if(capacity.length / 2 >= rightCosor) {
            System.out.println("String 스택은 꽉 찼습니다.");
            return;
        }

        if(capacity.length / 2 < rightCosor ) {
            if(stringStack.bottom == null) {
                stringStack.bottom = data;
            }
            stringStack.capacity[stringStack.cosor++] = data;
            capacity[rightCosor--] = data;
            stringStack.top = data;
        }
    }

    public int intPop() {
        if(integerStack.cosor >= 0) {
            // Object배열 내용 삭제
            int data = integerStack.top;
            capacity[leftCosor--] = null;

            // IntegerStack 배열 내용 삭제
            // IntegerStack 커서의 자리를 앞으로 뒤로
            if(integerStack.cosor == integerStack.capacity.length) {
                integerStack.cosor--;
                integerStack.capacity[integerStack.cosor] = 0;
            }

            if(integerStack.cosor - 1 >= 0) {
                int topData = integerStack.capacity[--integerStack.cosor];
                integerStack.capacity[integerStack.cosor] = 0;
                integerStack.top = topData;
            } else {
                integerStack.cosor = 0;
                integerStack.top = 0;
                integerStack.bottom = 0;
            }

            return data;
        }

        System.out.println("IntegerStack은 이미 비어있습니다.");
        return 0;
    }

    public String stringPop() {
        if(stringStack.cosor >= 0) {
            String data = stringStack.top;
            capacity[rightCosor--] = null;

            if(stringStack.cosor == stringStack.capacity.length) {
                stringStack.cosor--;
                stringStack.capacity[stringStack.cosor] = null;
            }

            if(stringStack.cosor - 1 >= 0) {
                String topData = stringStack.capacity[--stringStack.cosor];
                stringStack.capacity[stringStack.cosor] = null;
                stringStack.top = topData;
            } else {
                stringStack.cosor = 0;
                stringStack.top = null;
                stringStack.bottom = null;
            }

            return data;
        }

        System.out.println("StringStack은 이미 비어있습니다.");
        return null;
    }

    class IntegerStack {
        // Integer 스택 최대 사이즈
        private final int MAX_INTEGER_STACK_SIZE = MAX_STACK_SIZE / 2;

        private int top;
        private int bottom;
        private int cosor;

        private int[] capacity;

        public IntegerStack() {
            capacity = new int[MAX_INTEGER_STACK_SIZE];
            top = 0;
            bottom = 0;
            cosor = 0;
        }
    }

    class StringStack {
        // Integer 스택 최대 사이즈
        private final int MAX_STRING_STACK_SIZE = MAX_STACK_SIZE / 2;

        private String top;
        private String bottom;
        private int cosor;

        private String[] capacity;

        public StringStack() {
            capacity = new String[MAX_STRING_STACK_SIZE];
            top = null;
            bottom = null;
            cosor = 0;
        }
    }
}
