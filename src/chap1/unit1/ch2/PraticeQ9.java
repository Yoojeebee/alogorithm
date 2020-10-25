package chap1.unit1.ch2;

import java.util.Scanner;

// 입력한 두 정수 값 a, b 사이의 모든 숫자들을 더하는 값을 구하기(a, b 정수 포함)
public class PraticeQ9 {
    static int sumof(int a, int b) {
        int max = 0;
        int min = 0;

        int result = 0;

        if(a >= b) {
            max = a;
            min = b;
        } else{
            max = b;
            min = a;
        }

        for(int i = min; i <= max ; i++) {
           result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("a와 b의 정수를 입력하시오.");
        System.out.print("a의 값: ");
        int a = stdIn.nextInt();

        System.out.print("b의 값: ");
        int b = stdIn.nextInt();

        System.out.println("a와 b를 포함한 그 사이에 있는 모든 정수들의 합: " + sumof(a, b));
    }
}
