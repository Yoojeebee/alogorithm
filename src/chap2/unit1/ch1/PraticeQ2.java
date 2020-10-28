package chap2.unit1.ch1;

import java.util.Scanner;

public class PraticeQ2 {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    static void reverse(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
            swap(a, i, a.length - i - 1);
            System.out.println("a[" + i + "]과 a[" + (a.length - i - 1) + "]를 교환합니다.");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for(int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        reverse(x);
    }
}
