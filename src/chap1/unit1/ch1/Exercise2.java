package chap1.unit1.ch1;

// 3개의 정수값 가운데 가장 큰 값을 뽑는 정적 메서드 max3m
public class Exercise2 {
    static int max3m(int a, int b, int c) {
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;

        return max;
    }

    public static void main(String[] args) {
        // Max3m의 static 메서드의 매개변수에 정수값을 입력
        // 가장 큰 정수값을 반환한다
        System.out.println("max(1, 2, 3) = " + Exercise2.max3m(1,2,3));
        System.out.println("max(1, 3, 2) = " + Exercise2.max3m(1,3,2));
        System.out.println("max(2, 1, 3) = " + Exercise2.max3m(2,1,3));
        System.out.println("max(2, 3, 1) = " + Exercise2.max3m(2,3,1));
        System.out.println("max(3, 1, 2) = " + Exercise2.max3m(3,1,2));
        System.out.println("max(3, 2, 1) = " + Exercise2.max3m(3,2,1));
    }
}
