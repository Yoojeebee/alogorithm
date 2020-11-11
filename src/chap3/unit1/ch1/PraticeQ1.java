package chap3.unit1.ch1;

import java.util.Scanner;

public class PraticeQ1 {
    static int seqSearchSen(int[] a, int n, int key) {
        int i;
        for(i = 0; ;i++) {
            if(a[i] == key)
                break;
        }

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열에 들어갈 갯수 입력 >");
        int num = scanner.nextInt();

        int[] numbers = new int[num+1];

        for(int i = 0; i < numbers.length-1; i++) {
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
