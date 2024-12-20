import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String email = getEmail();
            System.out.println("Ваш адрес электронной почты: " + email);
            System.out.println("------------Задача2-----------");
            Programmer programmer = new Programmer("Иван", "доступен");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите задачу для программиста: ");
            String task = scanner.nextLine();
            try {
                String result = programmer.doWork(task);
                System.out.println("Результат работы программиста: " + result);
            } catch (ProgrammerBusyException k) {
                System.out.println("Программист занят другой задачей.");
            } catch (ProgrammerUnavailableNowException l) {
                System.out.println("Программист не доступен.");
            }
            } catch (NotCorrectEmailFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());

        }
    }
public static String getEmail() throws NotCorrectEmailFormatException { //throws класса если метод не безопасен и может вызвать эксепшны
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите ваш адрес электронной почты: ");
    String email = scanner.nextLine();
    if (email.length() < 5) {
        throw new NotCorrectEmailFormatException("Адрес должен не менее 5 символов.");
    }
    if (!email.contains("@")) {
        throw new NotCorrectEmailFormatException("Адрес должен иметь знак '@'.");
    }
    if (email.startsWith("@") || email.endsWith("@")) { //проверка первый и последний символ это собачка
        throw new NotCorrectEmailFormatException("@ - не должна быть первой или последней.");
    }
    return email; //если все ок то супер
}
}



