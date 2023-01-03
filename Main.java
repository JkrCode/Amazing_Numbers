package numbers;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to Amazing Numbers!
                \s
                Supported requests:
                - enter a natural number to know its properties
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                numbers are to be printed;
                - two natural numbers and a property to search for;
                - two natural numbers and two properties to search for;
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
            if (2 == numberStringArray.length) {
                long upperBound = Long.parseLong(numberStringArray[1]);

                if (upperBound > 0) {
                    executeDoubleDigitEntry(number, upperBound);
                } else {
                    System.out.println("The second parameter should be a natural number");
                }

            }

            //triple digit Entry execution
            if (3 == numberStringArray.length) {
                long upperBound = Long.parseLong(numberStringArray[1]);
                switch (numberStringArray[2].toLowerCase()) {
                    case "spy", "odd", "even", "buzz","square","sunny", "palindromic", "gapful", "duck" -> executeTripleDigitEntry(number, upperBound, numberStringArray[2]);
                    default ->
                            System.out.println("The property " + numberStringArray[2].toLowerCase() + " is wrong.\nAvailable properties:[BUZZ, DUCK, PALINDROMIC, GAPFUL, SQUARE, SUNNY SPY, EVEN, ODD]");
                }
            }

            //quatro digit entry execution
            if (4 == numberStringArray.length && executeErrorChecks(numberStringArray)) {
                long[] tempNumberArray = new long[999999];
                int counter=0;

                for (int i = 0; i < 999999; i++) {
                    if ((numberStringArray[2].equalsIgnoreCase("spy") && numberFunctions.isSpy(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("even") && numberFunctions.numberIsEven(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("odd") && !numberFunctions.numberIsEven(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("palindromic") && numberFunctions.isPalindromic(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("duck") && numberFunctions.isDuck(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("buzz") && numberFunctions.isBuzz(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("gapful") && numberFunctions.isGapful(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("square") && numberFunctions.isSquare(number+i))||
                            (numberStringArray[2].equalsIgnoreCase("sunny") && numberFunctions.isSunny(number+i))) {
                        tempNumberArray[counter]=number+i;
                        counter++;
                    }
                }
                int counter2 =0;
                for (int i =0; i<999999; i++){
                    if ((numberStringArray[3].equalsIgnoreCase("spy") && numberFunctions.isSpy(tempNumberArray[i]))||
                            (numberStringArray[3].equalsIgnoreCase("odd") && !numberFunctions.numberIsEven(tempNumberArray[i])) ||
                            (numberStringArray[3].equalsIgnoreCase("even") && numberFunctions.numberIsEven(tempNumberArray[i]))||
                            (numberStringArray[3].equalsIgnoreCase("palindromic") && numberFunctions.isPalindromic(tempNumberArray[i]))||
                            (numberStringArray[3].equalsIgnoreCase("buzz") && numberFunctions.isBuzz(tempNumberArray[i]))||
                            (numberStringArray[3].equalsIgnoreCase("gapful") && numberFunctions.isGapful(tempNumberArray[i]))||
                            (numberStringArray[3].equalsIgnoreCase("duck") && numberFunctions.isDuck(tempNumberArray[i]))||
                            (numberStringArray[3].equalsIgnoreCase("Sunny") && numberFunctions.isSunny(tempNumberArray[i]))||
                            (numberStringArray[3].equalsIgnoreCase("Square") && numberFunctions.isSquare(tempNumberArray[i]))){
                        executeDoubleDigitEntry(tempNumberArray[i], 1);
                        counter2++;
                    }
                    if (counter2==Long.parseLong(numberStringArray[1])){
                        break;
                    }
                }
            }
        }
    }

    private static boolean executeErrorChecks(String[] numberStringArray) {
        boolean b = true;
            if (!(numberStringArray[3].equalsIgnoreCase("odd") ||
                    numberStringArray[3].equalsIgnoreCase("spy") ||
                    numberStringArray[3].equalsIgnoreCase("palindromic") ||
                    numberStringArray[3].equalsIgnoreCase("even") ||
                    numberStringArray[3].equalsIgnoreCase("buzz") ||
                    numberStringArray[3].equalsIgnoreCase("gapful") ||
                    numberStringArray[3].equalsIgnoreCase("duck") ||
                    numberStringArray[3].equalsIgnoreCase("sunny") ||
                    numberStringArray[3].equalsIgnoreCase("square")))
                if (!(numberStringArray[2].equalsIgnoreCase("odd") ||
                        numberStringArray[2].equalsIgnoreCase("spy") ||
                        numberStringArray[2].equalsIgnoreCase("palindromic") ||
                        numberStringArray[2].equalsIgnoreCase("even") ||
                        numberStringArray[2].equalsIgnoreCase("buzz") ||
                        numberStringArray[2].equalsIgnoreCase("gapful") ||
                        numberStringArray[2].equalsIgnoreCase("duck") ||
                        numberStringArray[2].equalsIgnoreCase("sunny") ||
                        numberStringArray[2].equalsIgnoreCase("square"))) {
                    System.out.println("The properties [" + numberStringArray[2].toUpperCase() + ", " + numberStringArray[3] + "] are wrong");
                    System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD");
                    return false;
                }

            switch (numberStringArray[3].toLowerCase()) {
                case "spy", "odd", "even", "buzz", "square", "sunny", "palindromic", "gapful", "duck" -> {
                }
                default -> {
                    System.out.println("The property " + "[" + numberStringArray[3].toUpperCase() + "] is wrong");
                    System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD");
                    return false;
                }
            }
            switch (numberStringArray[2].toLowerCase()) {
                case "spy", "odd", "even", "buzz", "square", "sunny", "palindromic", "gapful", "duck" -> {
                }
                default -> {
                    System.out.println("The property " + "[" + numberStringArray[2].toUpperCase() + "] is wrong");
                    System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD");
                    return false;
                }


            }  if ((numberStringArray[2].equalsIgnoreCase("Even") || numberStringArray[2].equalsIgnoreCase("odd")) &&
                    (numberStringArray[3].equalsIgnoreCase("Even") || numberStringArray[3].equalsIgnoreCase("odd")) || (numberStringArray[2].equalsIgnoreCase("Duck") || numberStringArray[2].equalsIgnoreCase("Spy")) &&
                    (numberStringArray[3].equalsIgnoreCase("Duck") || numberStringArray[3].equalsIgnoreCase("Spy")) || (numberStringArray[2].equalsIgnoreCase("Sunny") || numberStringArray[2].equalsIgnoreCase("Square")) &&
                    (numberStringArray[3].equalsIgnoreCase("Sunny") || numberStringArray[3].equalsIgnoreCase("Square"))) {
                System.out.println("The request contains mutually exclusive properties:\n" + "[" + numberStringArray[2] + "," + numberStringArray[3] + "]");
                return false;
            } else if (!numberFunctions.isNatural(Long.parseLong(numberStringArray[0]))) {
                System.out.println("The first parameter should be a natural number or zero.");
                return false;
            } else if (!numberFunctions.isNatural(Long.parseLong(numberStringArray[1]))) {
                System.out.println("The second parameter should be a natural number.");
                return false;
            }

        return b;

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

    private static void executeTripleDigitEntry(long number, long upperBound, String str){
        long counter =1;
        str=str.toLowerCase();

        while (counter<=upperBound){
            if ((str.equalsIgnoreCase("spy") && numberFunctions.isSpy(number))||
                    (str.equalsIgnoreCase("odd") && !numberFunctions.numberIsEven(number)) ||
                    (str.equalsIgnoreCase("even") && numberFunctions.numberIsEven(number))||
                    (str.equalsIgnoreCase("palindromic") && numberFunctions.isPalindromic(number))||
                    (str.equalsIgnoreCase("buzz") && numberFunctions.isBuzz(number))||
                    (str.equalsIgnoreCase("gapful") && numberFunctions.isGapful(number))||
                    (str.equalsIgnoreCase("duck") && numberFunctions.isDuck(number))||
                    (str.equalsIgnoreCase("Sunny") && numberFunctions.isSunny(number))||
                    (str.equalsIgnoreCase("Square") && numberFunctions.isSquare(number))){
                executeDoubleDigitEntry(number, 1);
                counter++;
            }
            number++;
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
        } else {
            System.out.println("The first parameter should be a natural number or zero");

        }
    }
}





