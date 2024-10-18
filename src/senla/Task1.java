package senla;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Task1 {

    // слова для игры
    private static final List<String> word_lst = Arrays.asList("hangman", "study", "java", "cat", "list", "array",
            "scanner", "random");

    // метод для получения рандомного слова
    private static String getRandWord(List<String> wordlst){
        Random rand = new Random();
        int randIndex = rand.nextInt(wordlst.size());
        return wordlst.get(randIndex);
    }

    // метод для отображения состояния угадывания слова
    private static String displayWord(String word, List<Character> guessedLetters) {
        StringBuilder displayedWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);

            // если угадана буква, добавляю в строку
            if (guessedLetters.contains(currLetter)) {
                displayedWord.append(currLetter);
            } else {
                // если не угадана, добавляю _
                displayedWord.append("_");
            }

            // добавляю пробел для разделения букв
            displayedWord.append(" ");
        }

        return displayedWord.toString();
    }


    private static void displayHumanCondition(int incorrectGuesses){
        switch (incorrectGuesses){
            case 0:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=====");
                break;
            case 1:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=====");
                break;
            case 2:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=====");
                break;
            case 3:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=====");
                break;
            case 4:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=====");
                break;
            case 5:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/    |");
                System.out.println("     |");
                System.out.println("=====");
                break;
            case 6:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/ \\  |");
                System.out.println("     |");
                System.out.println("=====");
                break;
            default:
                System.out.println("error");
                break;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = getRandWord(word_lst);

        List<Character> guessedLetters = new ArrayList<>();

        int incorrectGuesses = 0;
        final int maxIncorrectGuesses = 6;

        System.out.println("Игра Виселица начинается");

        while (incorrectGuesses < maxIncorrectGuesses){
            displayHumanCondition(incorrectGuesses);

            System.out.println(displayWord(word, guessedLetters));

            System.out.println("Угадайте букву: ");

            char guess = scan.next().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)){
                System.out.println("Буква уже была угадана");
            }

            guessedLetters.add(guess);

            if(word.indexOf(guess) >= 0){
                System.out.println("Верно, буква " + guess + "есть в слове");
            }else {
                incorrectGuesses++;
                System.out.println("Неверно, осталось попыток :" + (maxIncorrectGuesses - incorrectGuesses));
            }

            if (word.chars().allMatch(c -> guessedLetters.contains((char) c))){
                System.out.println("Вы угадали слово! " + word);
                break;
            }
        }
        if (incorrectGuesses == maxIncorrectGuesses){
            System.out.println("Вы проиграли! Слово было " + word);
            displayHumanCondition(incorrectGuesses);
        }

        scan.close();
    }

}
