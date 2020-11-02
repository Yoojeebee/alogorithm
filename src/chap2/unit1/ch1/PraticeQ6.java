package chap2.unit1.ch1;

public class PraticeQ6 {
    static public char[] convertNumber(int decimalNumber, int convertNumber) {
        int digitNumber = 0;
        String convert = "0123456789ABCDEF";
        char[] digit = new char[16];

        do {
            digit[digitNumber++] = convert.charAt(decimalNumber % convertNumber);
            decimalNumber = decimalNumber / convertNumber;
        } while(decimalNumber != 0);

        for(int i = 0; i < digit.length / 2; i++) {
            char temp = digit[digit.length - i - 1];
            digit[digit.length - i - 1] = digit[i];
            digit[i] = temp;
        }

        return digit;
    }
}
