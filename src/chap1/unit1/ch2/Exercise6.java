package chap1.unit1.ch2;

import java.util.Scanner;

// 입력되는 값이 0이하일 경우 다시 반복문을 실행하게 만들어 0과 음수의 값
// 초기화를 막음
public class Exercise6 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = 0;

        System.out.println("1부터 n까지의 합을 구합니다.");

        do {
            System.out.println("n의 값: ");
            n = stdIn.nextInt();
        } while(n > 0);

        int sum = 0;

        for(int i = 0; i <= n; i++)
            sum += i;

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}
