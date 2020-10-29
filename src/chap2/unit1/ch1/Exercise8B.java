package chap2.unit1.ch1;

import java.util.Scanner;

public class Exercise8B {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // 변화하는 정수
        int no;

        // 기수
        int cd;

        // 변환 후의 자릿수
        int dno;

        // 다시 한 번?
        int retry;

        // 변환 후 각 자리의 숫자를 넣어두는 문자 배
        char[] cno = new char[32];

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = stdIn.nextInt();
            } while(no < 0);

            do{
                System.out.print("어떤 진수로 변환할까요? (2 ~ 36) : ");
                cd = stdIn.nextInt();
            } while(cd < 2 || cd > 36);

            dno = Exercise8A.cardConvR(no, cd, cno);

            System.out.print(cd + "진수로는 ");
            for(int i = dno - 1; i >= 0; i--) {
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1.예 / 2. 아니오) : ");
            retry = stdIn.nextInt();

        } while(retry == 1);
    }
}
