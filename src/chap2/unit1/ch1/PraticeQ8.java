package chap2.unit1.ch1;

// Exercise13의 변수 i, days를 제외하고 while문을 사용해 출력
public class PraticeQ8 {
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? 1: 0;
    }

    static int dayOfYear(int y, int m, int d) {

        while(true) {
           d += mdays[isLeap(y)][--m];
            if(m == 1)
                break;
        }

        return d;
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear(2020, 12, 20));
    }
}
