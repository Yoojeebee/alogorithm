package chap2.unit1.ch1;

// 그 해의 시간 경과를 알려주는 날짜 클래스
public class Exercise13 {

    // 윤년은 2차원 배열의 [0][...] 자리 즉, 1행 자리에 초기화
    // 평년은 2차원 배열의 [1][...] 자리 즉, 2행 자리에 초기화
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    // 윤년인지 아닌지 판단
    static int isLeap(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? 1: 0;
    }

    // isLeap 메서드에서 윤년인지 아닌지 판단
    // 이 때 0, 1의 값은 mdays의 2차원 배열 레 1행의 자리에 초기화
    // mdays메소드의 1행의 자리에 들어간 값에 따라서 평년인지 윤년 구분
    static int dayOfYear(int y, int m, int d) {
        int days = d;

        for(int i = 1; i < m; i++) {
            days += mdays[isLeap(y)][i-1];
            System.out.println("일: " + days);
        }

        return days;
    }

    public static void main(String[] args) {

        System.out.println(dayOfYear(2020, 12, 20));
    }
}
