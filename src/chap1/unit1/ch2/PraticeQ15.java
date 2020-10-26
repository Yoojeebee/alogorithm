package chap1.unit1.ch2;

// Q.15
// 왼쪽 아래가 직각인 이등변 삼각형 출력
// 왼쪽 위가 직각인 이등변 삼각형 출력
// 오른쪽 위가 직각인 이등변 삼각형 출력
// 오른쪽 아래가 직각인 이등변 삼각형 출력
public class PraticeQ15 {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5 ; j++) {
                System.out.print("[" + i + "][" + j + "] ");
            }
            System.out.println();
        }
    }
}
