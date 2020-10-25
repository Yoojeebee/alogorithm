package chap1.unit1.ch2;

import java.util.Scanner;

// b가 a보다 높은 정수 값을 입력하게끔 만들면서 b-a의 값을 구하시오.
public class PraticeQ10 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("b -a의 값을 구하시오.");

        int a = 0;
        int b = 0;

        for(;;) {
            System.out.print("a의 값: ");
            a = stdIn.nextInt();

            System.out.print("b의 값: ");
            b = stdIn.nextInt();

            if( (b > a) && (b!=a) ) {
                break;
            }
            else{
                System.out.println("a보다 큰 값을 입력하세요!");
                continue;
            }
        }

        System.out.println("b - a = " + (b-a));
    }
}
