package chap2.unit1.ch1;

import java.util.Scanner;

public class PraticeQ3 {
    static int sumof(int[] a) {
        int total = 0;
        for(int i = 0; i < a.length; i++) {
            total += a[i];
        }
        return total;
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

        int total = sumof(x);

        System.out.println("total: " + total);

        stdIn.close();
    }
}
