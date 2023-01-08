package numbers;

public class AmazingNumber {
    public int buzz=0, sunny=0, even=0, odd=0, duck=0, gapful=0, palindromic=0, square=0, spy=0, jumping=0;
    public AmazingNumber(long number){

        if(numberFunctions.isBuzz(number)){
            buzz=1;
        }

        if (numberFunctions.isPalindromic(number)) {
            palindromic=1;
        }

        if (numberFunctions.isSunny(number)) {
            sunny=1;
        }
        if (numberFunctions.numberIsEven(number)) {
            even=1;
            odd=0;
        }

        if (!numberFunctions.numberIsEven(number)) {
            even=0;
            odd=1;
        }
        if (numberFunctions.isDuck(number)) {
            duck=1;
        }
        if (numberFunctions.isGapful(number)) {
            gapful=1;
        }
        if (numberFunctions.isSquare(number)) {
            square=1;
        }
        if (numberFunctions.isSpy(number)) {
            spy=1;
        }
        if (numberFunctions.isJumping(number)) {
            jumping=1;
        }
    }


}
