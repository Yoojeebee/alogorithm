package chap1.unit1.ch1;

import java.util.Scanner;

// 입력한 정수값이 양수, 음수, 0 인지 판
public class Exercise3 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int n = stdIn.nextInt();

        if(n > 0)
            System.out.println("이 수는 양수입니다.");
        if(n < 0)
            System.out.println("이 수는 음수입니다.");
        else
            System.out.println("이 수는 0입니다.");

        stdIn.close();
    }
}
