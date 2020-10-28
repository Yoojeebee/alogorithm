package chap2.unit1.ch1;

import java.util.Scanner;

public class PraticeQ5 {
    static void copy(int[] a, int[] b) {
        for(int i = 0; i < b.length; i++) {
            a[i] = b[b.length -i - 1];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();

        int[] a = new int[num];
        int[] b = new int[num];

        for(int i = 0; i < num; i++) {
            System.out.print("b[" + i + "]: ");
            b[i] = stdIn.nextInt();
        }

        copy(a, b);

        for(int i = 0; i < num; i++) {
            System.out.println(i +"번째 a[" + i + "]: "+ a[i] + ", b[" + i + "]: "+ b[i]);
        }

        stdIn.close();
    }
}
