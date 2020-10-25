package chap1.unit1.ch2;

import java.util.Scanner;

// 양의 정수를 입력받고 자릿수를 출력하는 프로그램 작성
public class PraticeQ11 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int num = 0;
        do {
            System.out.print("양의 정수를 입력하시오: ");
            num = stdIn.nextInt();
            if(num < 0)
                System.out.println("0보다 큰 수를 입력하시오!");
        } while(num > 0);

        int result = 0;

        while(num > 0) {
            result += num % 10 > 0 ? 1 : 0;
            num = num / 10;
        }

        System.out.println(result +" 자리수입니다.");
    }
}
