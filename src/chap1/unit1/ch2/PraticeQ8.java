package chap1.unit1.ch2;

import java.util.Scanner;

// 가우스 덧셈을 이용한 1부터 n까지의 합을 구하기
public class PraticeQ8 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구하는 프로그램을 작성하시오.");

        System.out.print("n의 값: ");
        int n = stdIn.nextInt();

        int result = 0;

        if(n % 2 == 0) {
            result = (1 + n) * (1 * n)/2;
        } else {
            result = (1 + n) * (1 * n)/2 - (1 - n)/2;
        }

        System.out.println("result의 값: " + result);
    }
}
