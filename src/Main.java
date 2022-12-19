import java.util.Arrays;
import java.util.Scanner;
class Calculator {
    public static String calc(String input) throws Exception {
        String[] reg = input.split(" ");
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] rome2 = {null, "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String first = reg[0];
        String oper = reg[1];
        String second = reg[2];
        int num1;
        int num2;
        if (reg.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
        }
        if (Arrays.asList(rome).contains(first) && Arrays.asList(rome).contains(second)) {
            num1 = Arrays.asList(rome2).indexOf(reg[0]);
            num2 = Arrays.asList(rome2).indexOf(reg[2]);
        } else {
            num1 = Integer.parseInt(first);
            num2 = Integer.parseInt(second);
        }
        char operation = oper.charAt(0);
        int result = calc2(num1, num2, operation);
        if (Arrays.asList(rome).contains(first)) {
            if (result < 0) {
                throw new Exception("В римской системе нет отрицательных чисел.");
            }
            String result1 = rome2[result];
            return result1;
        }
        return Integer.toString(result);
    }
    public static int calc2(int num1, int num2, char operation) throws Exception {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new Exception("Операция не распознана. Повторите ввод.");
        }
        return result;
    }
    public static void main(String[] agrs) throws Exception {
        System.out.println("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Значение выражения: " + calc(input));
    }
}