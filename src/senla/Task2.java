package senla;

import java.util.Scanner;

public class Task2 {

    private static final double rub_to_usd = 97.95;
    private static final double rub_to_eur = 107.54;
    private static final double rub_to_aed = 26.45;
    private static final double rub_to_cny = 13.55;
    private static final double rub_to_byn = 29.43;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите сумму для конвертации в рублях");
        double rubAmount = scan.nextDouble();

        System.out.println("Введите валюту для конвертации");
        System.out.println("1. USD (Доллары)");
        System.out.println("2. EUR (Евро)");
        System.out.println("3. AED (Дирхамы ОАЭ)");
        System.out.println("4. CNY (Юани)");
        System.out.println("5. BYN (Белорусский рубль)");

        int currChoice = scan.nextInt();

        double convertedAmount = 0;

        switch (currChoice){
            case 1:
                convertedAmount = rubAmount / rub_to_usd ;
                System.out.println(rubAmount + " RUB = " + convertedAmount + " USD");
                break;
            case 2:
                convertedAmount = rubAmount / rub_to_eur;
                System.out.println(rubAmount + " RUB = " + convertedAmount + " EUR");
                break;
            case 3:
                convertedAmount = rubAmount / rub_to_aed;
                System.out.println(rubAmount + " RUB = " + convertedAmount + " AED");
                break;
            case 4:
                convertedAmount = rubAmount / rub_to_cny;
                System.out.println(rubAmount + " RUB = " + convertedAmount + " CNY");
                break;
            case 5:
                convertedAmount = rubAmount / rub_to_byn;
                System.out.println(rubAmount + " RUB = " + convertedAmount + " BYN");
                break;
            default:
                System.out.println("Неверный выбор валюты");


        }

        scan.close();
    }
}
