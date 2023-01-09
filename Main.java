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
                    if (request.square <= aNumber.square &&
                            request.palindromic <= aNumber.palindromic &&
                            request.buzz <= aNumber.buzz &&
                            request.duck <= aNumber.duck &&
                            request.even <= aNumber.even &&
                            request.gapful <= aNumber.gapful &&
                            request.odd <= aNumber.odd &&
                            request.spy <= aNumber.spy &&
                            request.jumping <= aNumber.jumping &&
                            request.sunny <= aNumber.sunny
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
            if (!(numberStringArray[i].equalsIgnoreCase("odd") ||
                    numberStringArray[i].equalsIgnoreCase("spy") ||
                    numberStringArray[i].equalsIgnoreCase("palindromic") ||
                    numberStringArray[i].equalsIgnoreCase("even") ||
                    numberStringArray[i].equalsIgnoreCase("buzz") ||
                    numberStringArray[i].equalsIgnoreCase("gapful") ||
                    numberStringArray[i].equalsIgnoreCase("duck") ||
                    numberStringArray[i].equalsIgnoreCase("sunny") ||
                    numberStringArray[i].equalsIgnoreCase("square")||
                    numberStringArray[i].equalsIgnoreCase("jumping"))) {
                temp.add(numberStringArray[i]);
            }
        }
        if(temp.size()>1) {
            System.out.println("The properties " + temp.toString().toUpperCase() + " are wrong");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, Jumping");
            return false;
        } else if(temp.size()==1){
            System.out.println("The property " + temp.toString().toUpperCase() + " is wrong");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, Jumping");
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
        } else {
            System.out.println("The first parameter should be a natural number or zero");

        }
    }
}






