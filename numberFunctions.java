package numbers;
import java.util.Arrays;

public class numberFunctions {
    static boolean isPalindromic(long number) {
        int numberOfDigits = 0;
        long temp1 = number;

        while (temp1 > 0) {
            temp1 = temp1 / 10;
            numberOfDigits += 1;
        }
        long[] array2 = new long[numberOfDigits];
        long[] array = new long[numberOfDigits];

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = number % 10;
            number = number / 10;
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[array2.length - 1 - i];
        }

        if (Arrays.equals(array, array2)) {
            return true;
        } else {
            return false;
        }
    }
    static boolean isSquare(long number){
        double temp = Math.sqrt((double)number);
        long temp2 = (long) temp;
        if(temp2 * temp2 == number){
            return true;
        } else {
            return false;
        }
    }

    static boolean isSunny(long number){
        if(isSquare(number+1)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isGapful(long number) {
        long temp1 = number % 10;
        long temp2 = number;
        while (temp2 >= 10) {
            temp2 = temp2 / 10;
        }
        temp2 *= 10;
        if (number % (temp1 + temp2) == 0 && number > 99) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuck(long number) {
        long temp = number;
        while (temp >= 10) {
            if (temp % 10 == 0) {
                return true;
            } else {
                temp = temp / 10;
            }
        }
        return false;
    }

    public static boolean isNatural(long number) {
        if (number > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberIsEven(long number) {
        if (number % 2 == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isBuzz(long number) {
        long temp = number;
        while (temp >= 10) temp = temp % 10;
        if ((number % 7 == 0) || temp == 7) {
            return true;
        } else return false;


    }

    public static boolean isSpy(long number) {

        int numberOfDigits = 0;
        long temp1 = number;

        while (temp1 > 0) {
            temp1 = temp1 / 10;
            numberOfDigits += 1;
        }
        long[] array = new long[numberOfDigits];

        {
            int i = array.length - 1;
            while (i >= 0) {
                array[i] = number % 10;
                number = number / 10;
                i--;
            }
        }
        long temp2 =0;
        long temp3=1;
        {
            int i=0;
            while (i<numberOfDigits) {
                temp2+=array[i];
                i++;
            }
        }

        int i=0;
        while (i<numberOfDigits) {
            temp3*=array[i];
            i++;
        }

        return temp3 == temp2;
    }

    public static boolean isJumping(long number) {
        while(number>9) {
            long temp = number % 10;
            number = number / 10;
            if (!(Math.abs((number%10) - temp) == 1)) {
                return false;
            }
        }return true;
    }
}


