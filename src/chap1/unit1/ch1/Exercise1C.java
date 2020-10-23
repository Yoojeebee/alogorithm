package chap1.unit1.ch1;

import java.util.Scanner;

// 세 개의 정수값들 중 중앙값을 구하는 클래스
public class Exercise1C {

    static int med3(int a, int b, int c) {

        if(a >= b) {
            if(a > b) {
                if(b >= c) {
                    if(b > c)
                        return b;
                    else
                        return b;
                } else {
                    if(a >= c) {
                        if(a > c)
                            return c;
                        else
                            return c;
                    } else {
                        return a;
                    }
                }
            } else {
                if(b >= c) {
                    if(b > c)
                        return b;
                    else
                        return b;
                } else {
                    return a;
                }
            }
        }
        else {
            if(a >= c) {
                if(a > c)
                    return a;
                else
                    return a;
            } else {
                if(b >= c) {
                    if(b > c)
                        return c;
                    else
                        return c;
                } else {
                    return b;
                }
            }
        }

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
    }
}
