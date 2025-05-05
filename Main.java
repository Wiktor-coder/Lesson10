import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (sc) {
            System.out.println("Введите минимальную длинну пароля: ");
            int minLength = sc.nextInt();

            System.out.println("Введите максимальное допустимое количество повторяющихся символов подряд: ");
            int maxRepeats = sc.nextInt();
            sc.nextLine();

            PasswordChecker checker = new PasswordChecker();
            checker.setMinLength(minLength);
            checker.setMaxRepeats(maxRepeats);

            while (true) {
                System.out.println("Введите пароль или end: ");
                String password = sc.nextLine();

                if (password.equals("end")) break;
                boolean isValid = checker.verify(password);
                System.out.println(isValid ? "Подходит" : "Не подходит");
            }
            System.out.println("Программа завершена");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в настройках: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }

    }
}
