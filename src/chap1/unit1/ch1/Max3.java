package chap1.unit1.ch1;

import java.util.Scanner;

// 세 정수 중 가장 큰 값을 구하는 Max3 클래스
public class Max3 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값: ");
        int a = stdIn.nextInt();
        System.out.println("b의 값: ");
        int b = stdIn.nextInt();
        System.out.println("c의 값: ");
        int c = stdIn.nextInt();

        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;

        System.out.println("최댓값은 " + max + "입니다.");
    }
}
