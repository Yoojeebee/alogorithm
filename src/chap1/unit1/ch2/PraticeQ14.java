package chap1.unit1.ch2;

import java.util.Scanner;

// Q.14
// 입력한 수를 한 변으로 하는 정사각형을 * 기호로 출력하는 프로그램을 작성하시오.
public class PraticeQ14 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("사각형을 출력합니다.");
        System.out.print("단 수: ");
        int star = stdIn.nextInt();

        for(int i  = 0; i < star; i++) {
            for(int j = 0 ; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
