package util;

import chessBoard.ChessBoardGame;
import envelope.EnvelopeGame;
import fibonacciSeries.FibonacciSeriesGame;
import fileTask.FileParserGame;
import interfaces.IPlay;
import numericalSequenceGame.NumericalSequenceGame;
import palindrome.PalindromeGame;
import triangle.TriangleGame;

import java.util.Scanner;

public class Menu {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);

    public Menu WelcomeMessage() {
        System.out.println("Hi friend!\nWelcome to 'Elementary task' home work.\n");
        return this;
    }

    public Menu MainMenu() throws Exception {
        System.out.println("List of tasks you can find bellow. \n1. Chess Board.\n2. Envelope Analysis\n3. Triangle Sort\n4. Numerical sequence.\n5.File parser\n6. Fibonacci series\n7. Palindrome");
        short taskNumber = 0;
        System.out.println("Please, select a task number! ");
        boolean isTaskSelected = false;
        while (!isTaskSelected) {
            taskNumber = converter.TryToShort(scanner.next());
            if (taskNumber < 1 || taskNumber > 9) {
                System.out.println("Sorry I have only 9 task please try again.");
            } else {
                isTaskSelected = true;
            }
        }
        TaskCall(taskNumber);
        return this;
    }

    private void TaskCall(short taskNumber) throws Exception {

        IPlay game=null;
        switch (taskNumber) {
            case 1: {
                game = new ChessBoardGame();
                break;
            }
            case 2: {
                 game = new EnvelopeGame();
                break;
            }
            case 3: {
                 game = new TriangleGame();
                break;
            }
            case 4: {
                 game = new NumericalSequenceGame();
                break;
            }
            case 5: {
                game = new FileParserGame();
                break;
            }
            case 6: {
                game = new FibonacciSeriesGame();
                break;
            }
            case 7: {
                game = new PalindromeGame();
                break;
            }
            default: {
                MainMenu();
            }
        }
        game.Play();
        Proceed(game);
    }

    private void Proceed(IPlay game) throws Exception {
        boolean isProceed = false;
        do {
            System.out.println("Do you want play more?");
            String decision = scanner.next();
            if (decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes")) {
                game.Play();
                isProceed = true;
            } else {
                System.out.println("See you!");
                isProceed = false;
                MainMenu();
            }
        } while (isProceed);
    }
}