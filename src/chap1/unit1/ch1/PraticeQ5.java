package chap1.unit1.ch1;

import java.util.Scanner;

// 정적 메서드 med3의 조건문이 효율이 떨어지는 이유?
/*
    1. 조건문 내 너무 많은 조건식이 들어가 가독성이 떨어진다
    2. 예를 들어 if문의 b >= a 의 경우가 참일 경우 b <= a 는 실행하지 않아도 될 조건문이지만
       같은 조건식에 들어가 있기 때문에 효율이 떨어진다
* */
public class PraticeQ5 {

    static int med3(int a, int b, int c) {
        if( ((b >= a) && (c <= a)) || ((b <= a) && (c >= a)) ) {
            return a;
        } else if( ((a > b) && (c < b)) || ((a < b) && (c > b)) ) {
            return b;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.print("a의 값: ");
        int a = stdIn.nextInt();

        System.out.print("b의 값: ");
        int b = stdIn.nextInt();

        System.out.print("c의 값: ");
        int c = stdIn.nextInt();

        System.out.println("중앙값은 " + med3(a,b,c) +"입니다.");

        stdIn.close();
    }
}
