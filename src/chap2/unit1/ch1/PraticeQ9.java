package chap2.unit1.ch1;

// Exercise13의 dayOfYear를 leftYear로 메소드명을 바꾸고 메서드 출력 내용을
// 올해 남은 일짜를 구한다(12월 31일 이면 0, 12월 30일 이면 1)
public class PraticeQ9 {
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? 1: 0;
    }

    static int leftYear(int y, int m, int d) {

        while(true) {
            d += mdays[isLeap(y)][--m];
            if(m == 1)
                break;
        }

        return 365 - d;
    }

    public static void main(String[] args) {
        System.out.println(leftYear(2020, 12, 31) + 1);
    }
}
