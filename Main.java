package numbers;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to Amazing Numbers!
                \s
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.""");

        long number = 1;
        while (number != 0) {
            System.out.print("Enter a Request: ");
            String numberString = scanner.nextLine();
            String[] numberStringArray = numberString.split(" ");

            number = Long.parseLong(numberStringArray[0]);

            //Single digit Entry execution
            if (1 == numberStringArray.length) {
                executeSingleDigitEntry(number);
            }

            //double digit Entry execution
            if (2 == numberStringArray.length && numberStringArray[1].chars().allMatch(Character::isDigit)) {

                long upperBound = Long.parseLong(numberStringArray[1]);

                if (upperBound > 0) {
                    executeDoubleDigitEntry(number, upperBound);
                } else {
                    System.out.println("The second parameter should be a natural number");
                }

            } else if(2 == numberStringArray.length) {System.out.println("The second parameter should be a natural number");}

            //Multi digit entry execution
            if (3 <= numberStringArray.length && executeErrorChecks(numberStringArray)) {
                int counter = 1;
                numberRequest request = new numberRequest(numberStringArray);
                AmazingNumber aNumber = new AmazingNumber(number);
                while (counter <= Long.parseLong(numberStringArray[1])) {
                    if ((request.square <= aNumber.square) &&
                            (request.palindromic <= aNumber.palindromic) &&
                            (request.buzz <= aNumber.buzz) &&
                            (request.duck <= aNumber.duck) &&
                            (request.even <= aNumber.even) &&
                            (request.gapful <= aNumber.gapful) &&
                            (request.odd <= aNumber.odd) &&
                            (request.spy <= aNumber.spy) &&
                            (request.jumping <= aNumber.jumping) &&
                            (request.sunny <= aNumber.sunny) &&
                            (request.happy <= aNumber.happy) &&
                            (request.sad <= aNumber.sad) &&
                            !((request.square - aNumber.square) == -2) &&
                            !((request.palindromic - aNumber.palindromic) == -2) &&
                            !((request.buzz - aNumber.buzz) == -2) &&
                            !((request.duck - aNumber.duck) == -2) &&
                            !((request.even - aNumber.even) ==-2) &&
                            !((request.gapful - aNumber.gapful) == -2) &&
                            !((request.odd - aNumber.odd) == -2) &&
                            !((request.spy - aNumber.spy) == -2) &&
                            !((request.jumping - aNumber.jumping) == -2) &&
                            !((request.sunny - aNumber.sunny) == -2) &&
                            !((request.happy - aNumber.happy) == -2) &&
                            !((request.sad - aNumber.sad)== -2)
                    ) {
                        counter++;
                        executeDoubleDigitEntry(number,1);
                    }
                    number+=1;
                    aNumber = new AmazingNumber(number);
                }
            }
        }
    }

    private static boolean executeErrorChecks(String[] numberStringArray) {
        ArrayList<String> temp= new ArrayList<>();
        for (int i=2; i<numberStringArray.length; i++){
            switch (numberStringArray[i].toLowerCase()){
                case "odd", "spy", "palindromic", "even", "buzz", "gapful", "duck", "sunny", "square", "happy", "jumping", "sad", "-odd", "-spy", "-palindromic", "-even", "-buzz", "-gapful", "-duck", "-sunny", "-square", "-happy", "-jumping", "-sad"
                    -> {}
                default -> {
                    temp.add(numberStringArray[i]);
                }
            }
        }
        if(temp.size()>1) {
            System.out.println("The properties " + temp.toString().toUpperCase() + " are wrong");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, JUMPING, HAPPY, SAD");
            return false;
        } else if(temp.size()==1){
            System.out.println("The property " + temp.toString().toUpperCase() + " is wrong");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, JUMPING, HAPPY, SAD");
            return false;
        }


        ArrayList<String> temp2= new ArrayList<>();

        for (int i=2; i < numberStringArray.length; i++){
            temp2.add(numberStringArray[i].toLowerCase());
        }

        if (temp2.contains("odd")&&temp2.contains("even")) {
            System.out.println("The request contains mutually exclusive properties:\n" + "[ODD, EVEN]");
            return false;
        }

        if (temp2.contains("-odd")&&temp2.contains("-even")) {
            System.out.println("The request contains mutually exclusive properties:\n" + "[-ODD, -EVEN]");
            return false;
        }

        for (int j=2;j<numberStringArray.length;j++){
            for (int k=2;k<numberStringArray.length;k++){
                if (!(k==j) && (numberStringArray[k].substring(1).equals(numberStringArray[j]))) {
                    System.out.println("The request contains mutually exclusive properties:\n[" + numberStringArray[k].toUpperCase() + ", " + numberStringArray[j].toUpperCase() + "]");
                    return false;
                }
            }
        }

        if (temp2.contains("square".toLowerCase())&&temp2.contains("sunny".toLowerCase())) {
            System.out.println("The request contains mutually exclusive properties:\n" + "[SQUARE, SUNNY]");
            return false;
        }
        if (temp2.contains("duck")&&temp2.contains("spy")) {
            System.out.println("The request contains mutually exclusive properties:\n" + "[DUCK, SPY]");
            return false;
        } else if (!numberFunctions.isNatural(Long.parseLong(numberStringArray[0]))) {
            System.out.println("The first parameter should be a natural number or zero.");
            return false;
        } else if (!numberFunctions.isNatural(Long.parseLong(numberStringArray[1]))) {
            System.out.println("The second parameter should be a natural number.");
            return false;
        }
        return true;
    }

    private static boolean executeErrorChecks2 (String[]numberStringArray){
        if (!numberFunctions.isNatural(Long.parseLong(numberStringArray[0]))) {
            System.out.println("The first parameter should be a natural number or zero.");
            return false;
        } else if (!numberFunctions.isNatural(Long.parseLong(numberStringArray[1]))) {
            System.out.println("The second parameter should be a natural number.");
            return false;
        } else {
            return true;
        }
    }


    private static void executeDoubleDigitEntry(long number, long upperBound) {
        String[] string = new String[2];
        string[0] = Long.toString(number);
        string[1]= Long.toString(upperBound);


        if (executeErrorChecks2(string)){
            for (long i = number; i < number + upperBound; i++) {
                String print = "";

                print += !numberFunctions.numberIsEven(i) ? " odd" : " even";
                if (numberFunctions.isPalindromic(i)) print += " ,palindromic";
                if (numberFunctions.isBuzz(i)) print += " ,buzz";
                if (numberFunctions.isDuck(i)) print += " ,duck";
                if (numberFunctions.isGapful(i)) print += " ,gapful";
                if (numberFunctions.isSpy(i)) print += " ,Spy";
                if (numberFunctions.isSquare(i)) print += " ,Square";
                if (numberFunctions.isSunny(i)) print += " ,Sunny";
                if (numberFunctions.isJumping(i)) print += " ,jumping";
                if (numberFunctions.isHappy(i)) print += " ,happy";
                if (!numberFunctions.isHappy(i)) print += " ,sad";

                System.out.println(i + " is" + print);
            }
        }
    }


    private static void executeSingleDigitEntry(long number) {
        //evaluate properties
        if (numberFunctions.isNatural(number)) {

            System.out.printf("Properties of %d\n", number);

            System.out.println(numberFunctions.numberIsEven(number) ? "even: true\nodd: false" : "even: false\nodd: true");
            System.out.println(numberFunctions.isBuzz(number) ? "buzz: true" : "buzz: false");
            System.out.println(numberFunctions.isDuck(number) ? "duck: true" : "duck: false");
            System.out.println(numberFunctions.isPalindromic(number) ? "palindromic: true" : "palindromic: false");
            System.out.println(numberFunctions.isGapful(number) ? "gapful: true" : "gapful: false");
            System.out.println(numberFunctions.isSpy(number) ? "Spy: true" : "Spy: false");
            System.out.println(numberFunctions.isSquare(number) ? "Square: true" : "Square: false");
            System.out.println(numberFunctions.isSunny(number) ? "Sunny: true" : "Sunny: false");
            System.out.println(numberFunctions.isJumping(number) ? "Jumping: true" : "Jumping: false");
            System.out.println(numberFunctions.isHappy(number) ? "Happy: true\nSad:false" : "Happy: false\nSad: true");
        } else {
            System.out.println("The first parameter should be a natural number or zero");
        }
    }
}






