import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String input;
        Scanner scn= new Scanner(System.in);
        System.out.print("Введите выражение: ");
        input =scn.nextLine();
        calc(input);
    }
        public static String calc(String input) {
            Converter converter = new Converter();
            String[] actions = {"+", "-", "/", "*"};
            String[] regActions = {"\\+", "-", "/", "\\*"};
            String exp = input;
            int actionIndex = -1;
            for (int i = 0; i < exp.length(); i++) {
                if (exp.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }
            if (actionIndex == -1) {
                System.out.println("Некорректное выражение");
            } else {
                String[] data = exp.split(regActions[actionIndex]);
                if (data.length >= 3) {
                    System.out.println("Введите не больше двух чисел.");
                } else  {
                    if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                        int a, b;

                        boolean isRoman = converter.isRoman(data[0]);
                        if (isRoman) {
                            a = converter.romanToInt(data[0]);
                            b = converter.romanToInt(data[1]);
                        } else {
                            a = Integer.parseInt(data[0]);
                            b = Integer.parseInt(data[1]);
                        }
                        if ( a < 0 || b < 0){
                            System.out.println("Введите число больше 0");
                        }else {
                            if (a > 10 || b > 10) {
                                System.out.println("Введите число не больше 10");
                            } else  {
                                int result;
                                switch (actions[actionIndex]) {
                                    case "+":
                                        result = a + b;
                                        break;
                                    case "-":
                                        result = a - b;
                                        break;
                                    case "*":
                                        result = a * b;
                                        break;
                                    default:
                                        result = a / b;
                                        break;
                                }
                                if (isRoman) {
                                    if (result <= 0) {
                                        System.out.println("Ответ отрицательный");
                                    } else {
                                        System.out.println(converter.intToRoman(result));
                                    }
                                } else {
                                    System.out.println(result);
                                }
                            }
                        }
                        } else{
                            System.out.println("Числа должны быть в одном формате.");
                        }
                }
            }
            return exp;
        }
}
