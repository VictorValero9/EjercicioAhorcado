package es.neesis.annotations.services;

public interface IAhorcado {
     void menu();
     int selectOptionMenu();
     void game();
     void displayGameState(char[] wordState, int currentAttempts);
     char selectLetter();
}
