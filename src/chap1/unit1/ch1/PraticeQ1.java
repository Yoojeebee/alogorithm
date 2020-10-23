package chap1.unit1.ch1;

public class PraticeQ1 {
    static int max4(int a, int b, int c, int d) {
        // int형 변수 max에 a의 값을 초기화
        // 임시로 가장 높은 값을 담는 변수 max에 a값을 임시 초기화
        int max = a;

        // if 문이 연달아 실행되면서 max의 값과 비교된다
        // 이 떄, max의 값은 b, c, d의 값이 크면 가장 큰 값으로 계속적으로 초기화되기 때문에
        // return 반환값; 은 가장 높은 수로 초기화된 채로 넘어간다.
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        if(d > max)
            max = d;

        return max;
    }
}
