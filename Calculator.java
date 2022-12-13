import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        calc();

    }
        public static String calc() {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
        }
        String[] data = exp.split(regActions[actionIndex]);
        if (data.length >= 3) {
            System.out.println("Введите не больше двух чисел.");
        }

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            if (a > 10 || b > 10) {
                System.out.println("Введите число не больше 10");
            }
            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if(isRoman) {
                System.out.println(converter.intToRoman(result));
            } else {
                System.out.println(result);
            }

        }else {
            System.out.println("Числа должны быть в одном формате.");
        }
        return exp;
    }
}
