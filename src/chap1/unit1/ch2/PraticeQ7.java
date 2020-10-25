package chap1.unit1.ch2;

import java.util.Scanner;

// 1부터 n까지의 합을 구하는 값 구하기
public class PraticeQ7 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값: ");
        int n = stdIn.nextInt();

        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += i;
            if(i == 7) {
                System.out.print(i + " = " + sum);
            } else {
                System.out.print(i + " + ");
            }
        }
        System.out.println();

        stdIn.close();
    }
}

