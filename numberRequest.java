package numbers;

public class numberRequest {
    public int buzz=0, sunny=0, even=0, odd=0, duck=0, gapful=0, palindromic=0, square=0, spy=0, jumping=0;

    public numberRequest(String[] array){
        for (int i = 2; i < array.length; i++){
            switch (array[i].toLowerCase()){
                case "buzz" -> {buzz=1;}
                case "sunny" -> {sunny=1;}
                case "even" -> {even=1;}
                case "odd" -> {odd=1;}
                case "duck" -> {duck=1;}
                case "gapful" -> {gapful=1;}
                case "palindromic" -> {palindromic=1;}
                case "square" -> {square=1;}
                case "spy" -> {spy=1;}
                case "jumping" -> {jumping=1;}
                default -> {}
            }
        }
    }
}
