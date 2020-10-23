package chap1.unit1.ch1;

public class Pratice {
    public static void main(String[] args) {
        // 연습문제 Q.1
        int result1 = PraticeQ1.max4(1, 2, 3, 4);
        System.out.println("result1의 값: " + result1);
        int result2 = PraticeQ1.max4(3, 4, 1, 3);
        System.out.println("result2의 값: " + result2);

        // 연습문제 Q.2
        int result3 = PraticeQ2.min3(1, 2, 3);
        System.out.println("result3의 값: " + result3);
        int result4 = PraticeQ2.min3(3, 1, 3);
        System.out.println("result4의 값: " + result4);

        // 연습문제 Q.3
        int result5 = PraticeQ3.min4(1, 2, 3, 4);
        System.out.println("result5의 값: " + result5);
        int result6 = PraticeQ3.min4(3, 4, 1, 3);
        System.out.println("result6의 값: " + result6);
    }
}
