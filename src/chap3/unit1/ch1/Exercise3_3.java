package chap3.unit1.ch1;

import java.util.Scanner;

// 보초법
// 선형 검색의 종료 조건 중 하나인 [검색할 값을 발견하지 못하고 배열의 끝을 지나간 경우]
// 이 비용을 반으로 줄이는 방법이 보초법이다.
// 배열의 끝[배열길이 + 1] 요소에 키 값을 넣어 초기화
// 이 때 저장하는 값을 보초(sentinel)라 한다.
// 이 보초 역할은 반복문에서 종료 판단 횟수를 2회에서 1회로 줄일 수 있다.
public class Exercise3_3 {
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;

        while(true) {
            if(a[i] == key) {
                break;
            }
            i++;
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
