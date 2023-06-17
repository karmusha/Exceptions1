import java.util.Scanner;

public class dz2 {
    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    // (типа float), и возвращает введенное значение. Ввод текста вместо числа не
    // должно приводить к падению приложения, вместо этого, необходимо повторно
    // запросить у пользователя ввод данных.

    public static Float askFloat() {
        float number = 0;
        boolean state = true;
        Scanner scanner = new Scanner(System.in, "UTF-8");
        while (state) {
            try {
                System.out.println("Введите число: ");
                number = Float.parseFloat(scanner.nextLine());
                state = false;
            } catch (NumberFormatException e) {
                System.out.println("Невозможно сконвертировать символ в число.");
                state = true;
            }
        }
        scanner.close();
        return number;
    }

    public static void main(String[] args) {

        // 1
        //float number = askFloat();
        //System.out.println(number);

        // 2
        // Если необходимо, исправьте данный код (задание 2)
        int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // объявила массив
        try {
            int d = 1;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) { // добавила ArrayIndexOutOfBoundsException
            System.out.println("Catching exception: " + e);
        }

        // 3
        // Дан следующий код, исправьте его там, где требуется.

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) { // перенесла в конец
            System.out.println("Что-то пошло не так...");
        }

        // 4
        String st = askString();
        System.out.println(st);
    }

    public static void printSum(Integer a, Integer b) throws Exception { // исправила на Exception
        System.out.println(a + b);
    }

    // 4
    // Разработайте программу, которая выбросит Exception, когда пользователь вводит
    // пустую строку. Пользователю должно показаться сообщение, что пустые строки
    // вводить нельзя.

    public static String askString() {
        boolean state = true;
        String st = "";
        Scanner scanner = new Scanner(System.in, "UTF-8");
        while (state) {
            try {
                System.out.println("Введите строку:");
                st = scanner.nextLine();
                if (st.equals("")) {
                    System.out.println("Пустые строки вводить нельзя. Попробуйте ещё раз.");
                } else {
                    state = false;
                }
            } catch (Exception e) {
                System.out.println("Что-то пошло не так...");
                state = true;
            }
        }
        scanner.close();
        return st;
    }

}
    