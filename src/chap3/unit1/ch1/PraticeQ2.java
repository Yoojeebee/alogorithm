package chap3.unit1.ch1;

import java.util.Scanner;

public class PraticeQ2 {
    static int seqSearchSen(int[] a, int n, int key) {
        for(int i = 0; i < a.length; i++) {
            if(i == 0)
                System.out.print("\t|\t" + i);
            else
                System.out.print("\t" + i);
        }
        System.out.print("\n----+------------------------------\n");

        int i;
        for(i = 0; ;i++) {

            for(int x = 0; x <= i; x++) {
                if(x == 0)
                    System.out.print("\t|");
                else
                    System.out.print("\t");

                if(x == i)
                    System.out.print("\t*");
            }
            System.out.println();

            for(int j = 1; j < a.length+1; j++) {
                if(j / 2 == 0)
                    System.out.print("   " + i + "|\t" + a[j-1]);
                else
                    System.out.print("\t" + a[j-1]);
            }
            System.out.println();

            if(a[i] == key)
                break;
        }
        System.out.println();

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열에 들어갈 갯수 입력 >");
        int num = scanner.nextInt();

        int[] numbers = new int[num];

        for(int i = 0; i < numbers.length; i++) {
            System.out.print("배열 numbers[" + i + "]번째 입력값 > ");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("키 값 입력 >");
        int key = scanner.nextInt();

        int seqSearchSen = seqSearchSen(numbers, num, key);

        if(seqSearchSen == -1) {
            System.out.println("해당 키 값의 요소는 없습니다.");
        } else {
            System.out.println("numbers[" + seqSearchSen + "]의 값: " + numbers[seqSearchSen]);
        }
    }
}
