package util;

import chessBoard.ChessBoardGame;
import envelope.EnvelopeGame;
import fibonacciSeries.FibonacciSeriesGame;
import fileTask.FileParserGame;
import happyTickets.LuckyTicketsGame;
import interfaces.IPlay;
import numericalSequenceGame.NumericalSequenceGame;
import palindrome.PalindromeGame;
import triangle.TriangleGame;

import java.util.Scanner;

public class Menu {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);

    public Menu welcomeMessage() {
        System.out.println("Hi friend!\nWelcome to 'Elementary task' home work.\n");
        return this;
    }

    public Menu mainMenu() throws Exception {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("List of tasks you can find bellow. \n1. Chess Board.\n2. Envelope Analysis\n3. Triangle Sort\n" +
                    "4. Numerical sequence.\n5.File parser\n6. Fibonacci series\n7. Palindrome\n8. HappyTickets\n10. Exit");
            short taskNumber = 0;
            System.out.println("Please, select a task number! ");

            taskNumber = converter.tryToShort(scanner.next());
            if (taskNumber < 1 || taskNumber > 9) {
                System.out.println("Sorry I have only 9 task please try again.");
            } else {
                isContinue = taskCall(taskNumber);
            }
        }
        return this;
    }

    public static boolean isContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want add one more?");
        String decision = scanner.nextLine();
        scanner.close();
        return decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes");
    }

    private boolean taskCall(short taskNumber) throws Exception {
        IPlay game = null;
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
            case 8: {
                game = new LuckyTicketsGame();
                break;
            }
            case 10: {
                return false;
            }
            default: {
                mainMenu();
            }
        }
        game.play();
        isProceed(game);

        return true;
    }

    private boolean isProceed(IPlay game) throws Exception {
        boolean isProceed;
        do {
            System.out.println("Do you want play more?");
            String decision = scanner.next();
            if (decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes")) {
                game.play();
                isProceed = true;
            } else {
                System.out.println("See you!");
                isProceed = false;
            }
        } while (isProceed);

        return isProceed;
    }
}