package senla;

import java.security.SecureRandom;

public class Task3 {

    // наборы символов
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_+=";


    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SPECIAL;


    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        // генерация случайного пароля
        String password = generatePassword();
        System.out.println("Сгенерированный пароль: " + password);
    }

    // метод генерации пароля длиной 8-12 символов
    public static String generatePassword() {
        int passwordLength = 8 + random.nextInt(5); // случайная длина от 8 до 12
        StringBuilder password = new StringBuilder(passwordLength);

        // гарантируем хотя бы одну букву, цифру и спецсимвол
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        // заполняем оставшиеся символы случайным образом
        for (int i = 4; i < passwordLength; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        // перемешиваем символы для случайности
        return shuffleString(password.toString());
    }

    // метод для перемешивания строки
    private static String shuffleString(String input) {
        char[] array = input.toCharArray();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return new String(array);
    }
}
