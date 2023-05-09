import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class dz1 {

    // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    public static int sum(int a, int b) throws Exception{
        int result = a+b;
        if (result == Integer.MIN_VALUE || result == Integer.MAX_VALUE){
            throw new Exception("Слишком длинное число, попробуйте другие числа.");
        } else{
            return result;
        }      
    }

    public static int minus(int a, int b) throws Exception{
        int result = a-b;
        if (result == Integer.MIN_VALUE || result == Integer.MAX_VALUE){
            throw new Exception("Слишком длинное число, попробуйте другие числа.");
        } else{
            return result;
        }      
    }
    
    public static int devide(int a, int b){
        int result = 0;
        try{
            result = (int)Math.round(a/b);
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println("Вы не можете поделить на 0");
        }
        return result;
    }

    // Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
    // Добавила в код виды ошибок: NumberFormatException и ArrayIndexOutOfBoundsException

    public static int sum2d(String[][] arr){
        int sum = 0;
        for (int i = 0; i <arr.length; i++){
            for (int j = 0; j < 5; j++) {
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.out.printf("Переданное значение '%s' не может быть переконвертированно в число", arr[i][j]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Исключение:" + e);
                }
            }
        }
        return sum;
    }

    public static String fileToSrting(String path){
        String line = null;
        try(FileReader fr = new FileReader(path)) {
            line = fr.toString();
        } catch(FileNotFoundException f) {
            System.out.println(f);
        } catch (IOException io){
            System.out.println(io);
        } catch (NullPointerException n){
            line = "";
        }
        return line;
    }

    public static String ArrayToString(int[] array){
        String res = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1){
                res += Integer.toString(array[i]) + "]";
            } else {
                res += Integer.toString(array[i]) + ", ";
            }
        }
        return res;
    }

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.

    public static int[] minusOfArrays(int[] array1, int[] array2) throws Exception{
        if (array1.length != array2.length){
            throw new ArrayIndexOutOfBoundsException("Массивы разной длинны, попробуйте другие массивы.");
        }
        int length = array1.length;
        int[] res = new int [length];
        for (int i = 0; i < length; i++) {
            res[i] = minus(array1[i], array2[i]);
        }
        return res;
    }

    //* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

    public static int[] devisionOfArrays(int[] array1, int[] array2) throws RuntimeException{
        try {
            int length = array1.length;
            int[] res = new int [length];
            for (int i = 0; i < length; i++) {
                res[i] = devide(array1[i], array2[i]);
            }
            return res;
        } catch (RuntimeException e){
            System.out.printf("Операция не выполнилась, ошибка:\n %s\n", e);
            throw new RuntimeException();
        }
    }


    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(System.in, "UTF-8")) {
            System.out.println("Введите первое число:");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите второе число:");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.printf("%s / %s = %s\n", a, b, devide(a, b));
        } catch (RuntimeException e){
            System.out.printf("Операция не выполнилась, ошибка:\n %s \n", e);
            throw new RuntimeException();
        } finally {

            int[] array1 = {1,2,3,4,5,4};
            int[] array2 = {5,4,3,2,1};

            int[] res3 = minusOfArrays(array1, array2);

            System.out.printf("Сумма двух массивов %s и %s равна %s\n", ArrayToString(array1), ArrayToString(array2), ArrayToString(res3));

            int[] res4 = devisionOfArrays(array1, array2);

            System.out.printf("Частное двух массивов %s и %s равна %s\n", ArrayToString(array1), ArrayToString(array2), ArrayToString(res4));
        }
    }
}
