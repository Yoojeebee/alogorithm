package chap1.unit1.ch1;

public class PraticeQ3 {
    static int min4(int a, int b, int c, int d) {
        // int형 변수 min a의 값을 초기화에
        // 임시로 가장 낮은 값 담는 변수 min에 a값을 임시 초기화
        int min = a;

        // if 문이 연달아 실행되면서 min의 값과 비교된다
        // 이 떄, min의 값은 b, c, d의 값이 작을수록 가장 작은 값으로 계속적으로 초기화되기 때문에
        // return 반환값; 은 가장 낮은 수로 초기화된 채로 넘어간다.
        if(min > b)
            min = b;
        if(min > c)
            min = c;
        if(min >d)
            min = d;

        return min;
    }
}
