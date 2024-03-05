package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class Ahorcado implements IAhorcado {
    public static final List<String> WORDS_LIST = List.of("BUENAS", "BABEL", "PATIO", "ESCUELA", "CLASSIC", "ARCOS", "RIESGO", "SALIDA", "SPACES", "AMERICAN");
    public int MAX_ATTEMPTS = 8;
    @Override
    public void menu(){
        while(true){
            System.out.println("1) Empezar a jugar");
            System.out.println("2) Salir");
            int input = selectOptionMenu();

            if (input != 1){
                break;
            }
            game();
        }
        System.out.println("Fin del Juego");
    }

    public int selectOptionMenu(){
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        input.nextLine();
        return option;
    }

    public char selectLetter() {
        Scanner input = new Scanner(System.in);
        String letter = input.nextLine().toUpperCase();
        return letter.charAt(0);
    }
    public void game(){
        Random randomizer = new Random();
        String randomWord = WORDS_LIST.get(randomizer.nextInt(WORDS_LIST.size()));
        char[] wordState = new char[randomWord.length()];
        Arrays.fill(wordState,'_');
        int currentAttempts = 0;

        while (currentAttempts < MAX_ATTEMPTS){

            System.out.println("Palabra actual: " + String.valueOf(wordState));
            System.out.println("Intentos restantes: " + currentAttempts);
            char letter = selectLetter();

            if (randomWord.indexOf(letter) != -1){
                for (int i = 0; i< randomWord.length(); i++){
                    if (randomWord.charAt(i) == letter){
                        wordState[i] = letter;
                    }
                }
            }else{
                currentAttempts++;
            }

            if(Arrays.equals(wordState, randomWord.toCharArray())){
                System.out.println("Felicidades! Has adivinado la palabra: " + randomWord);
                break;
            }
        }
        if (currentAttempts == MAX_ATTEMPTS){
            System.out.println("Lo siento, has perdido... La palabra era: " + randomWord);
        }

    }
}
