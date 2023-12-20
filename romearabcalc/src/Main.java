import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main (String[] args ) throws Exception {
        System.out.println("Введите пример");
        Scanner s = new Scanner(System.in);
        String primer =s.nextLine();
        String [] strings = primer.split(" ");
        if (strings.length != 3) {
            throw new IOException("больше либо меньше трех операндов");
        }
        if ((strings[0].equals("I") || strings[0].equals("II") || strings[0].equals("III") || strings[0].equals("IV") || strings[0].equals("V") || strings[0].equals("VI") || strings[0].equals("VII") || strings[0].equals("VIII") || strings[0].equals("IX") || strings[0].equals("X")) && (strings[2].equals("1") || strings[2].equals("2") || strings[2].equals("3") || strings[2].equals("4") || strings[2].equals("5") || strings[2].equals("6") || strings[2].equals("7") || strings[2].equals("8") || strings[2].equals("9") || strings[2].equals("10")) || (strings[2].equals("I") || strings[2].equals("II") || strings[2].equals("III") || strings[2].equals("IV") || strings[2].equals("V") || strings[2].equals("VI") || strings[2].equals("VII") || strings[2].equals("VIII") || strings[2].equals("IX") || strings[2].equals("X")) && (strings[0].equals("1") || strings[0].equals("2") || strings[0].equals("3") || strings[0].equals("4") || strings[0].equals("5") || strings[0].equals("6") || strings[0].equals("7") || strings[0].equals("0") || strings[0].equals("9") || strings[0].equals("10"))){
            throw new IOException("можно пользоваться только одной системой счисления");// проверяем что оба числа одного типа: либо оба числа - римские, либо оба числа - арабские
        }
        String[] arabtorome = new String [] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] arr = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};// мог использовать массив arabtorome, но чтобы мой код хотя бы немного был понятен сделаю новый
        boolean b=false;
        for(int i=0; i<10; i++){
            if (strings[0].equals(arr[i])){
                for(int j=0; j<10; j++){
                    if (strings[2].equals(arr[j])){
                        if (i<j){
                            throw new IOException("римские числа не могут быть отрицательными");
                        }
                        String result=arabtorome[calculate(i+1, strings[1], j+1) - 1];
                        System.out.println(result);
                        b = true;
                    }
                }
            }
        }
        if (b != true){
            int num1 = Integer.parseInt(strings[0]);
            int num2 = Integer.parseInt(strings[2]);
            System.out.println(calculate(num1, strings[1], num2));
        }
    }


    public static int calculate(int a, String operation, int b) throws Exception {
        if ((a<1)||(a>10)||(b<1)||(b>10)){
            throw new Exception("числа могут быть только от 1 до 10");
        }
        if (operation.equals("+")){
            return a + b;
        } else if (operation.equals("-")){
            return a - b;
        } else if (operation.equals("*")) {
            return a * b;
        } else if (operation.equals("/")) {
            return a / b;
        } else throw new RuntimeException("неправильно ввели знак");
    }
}





