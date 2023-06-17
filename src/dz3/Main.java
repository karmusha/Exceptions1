package dz3;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    // Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
    // Фамилия Имя Отчество дата_рождения номер_телефона пол
    // Форматы данных:
    // * фамилия, имя, отчество - строки
    // * дата_рождения - строка формата dd.mm.yyyy
    // * номер_телефона - целое беззнаковое число без форматирования
    // * пол - символ латиницей f или m.

    // Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
    // Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
    // Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
    // Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
    // Не забудьте закрыть соединение с файлом.
    // При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in, "UTF-8");
            Userinfo userinfo = checkUserInfo(scanner); // Создаём юзера
            System.out.println(userinfo.toString());
            exportToFile(userinfo); // Заносим данные юзера в файл
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ошибка:\n" + e);
        }
    }

    // Заносим данные юзера в файл
    public static void exportToFile (Userinfo userinfo){
        String filePath = "./";
        String fullFileName = filePath+userinfo.getUserLastName()+".txt";
        File f = new File(fullFileName);

        try(FileWriter writer = new FileWriter(fullFileName, true)){
            if (f.exists()) {
                writer.append(userinfo.toString());  
            } else {
                writer.write(userinfo.toString());                
            }
            writer.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    // Проверяем, что пользователь ввёл правильную строку по количеству элементов и их типу
    public static Userinfo checkUserInfo(Scanner scanner) throws Exception {
        String string = askString(scanner); // запросили строку
        String[] array = string.split(" "); // разбили на элементы
        System.out.println(Arrays.toString(array));

        int count = 6;
        if (array.length < count){ // проверяем на минимальное количество элементов
            throw new Exception("Вы ввели меньше данных, чем нужно. Попробуйте ещё раз.", null);
        }
        if (array.length > count){ // проверяем на максимальное количество элементов
            throw new Exception("Вы ввели больше данных, чем нужно. Попробуйте ещё раз.", null);
        }


        try { // проверяем телефон по типу
            Long.parseLong(array[4]);
        } catch (Exception e) {
            System.out.println("Номер телефона введён неверно. Введённые данные невозможно преобразовать в число.");
        }

        return new Userinfo(array[0], array[1], array[2], array[3], Long.parseLong(array[4]), StringToChar(array[5])); // Создаём юзера
    }

    public static Character StringToChar(String s)   {
        if (s.length() > 1) {
            throw new ArrayIndexOutOfBoundsException ("Пол должен состоять из 1 символа. Попробуйте ещё раз.");
        } else {
            return s.charAt(0);
        }
    }

    // Пользователь вводит строку, она не должна быть пустой.
    public static String askString(Scanner scanner) { 
        boolean state = true;
        String st = "";
        while (state) {
            try {
                System.out.println("Введите через пробел следующие данные: Фамилия Имя Отчество Дата_Рождения(дд.мм.ггг) Телефон(только цифры без пробелов) Пол(м или ж)\n" + 
                "Например:\n" +
                "Muster Mann Manner 01.01.1990 9876543210 m");
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
        return st;
    }
}
    