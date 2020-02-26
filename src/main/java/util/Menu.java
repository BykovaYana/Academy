package util;

import chessBoard.ChessBoardGame;
import envelope.EnvelopeGame;
import fibonacciSeries.FibonacciSeriesGame;
import fileTask.FileParserGame;
import interfaces.IPlay;
import luckyTickets.LuckyTicketsGame;
import numberToWords.ConvertNumberToWordsGame;
import numericalSequenceGame.NumericalSequenceGame;
import org.apache.log4j.Logger;
import palindrome.PalindromeGame;
import triangle.TriangleGame;

public class Menu {
    final static Logger logger = Logger.getLogger(ChessBoardGame.class);

    private Converter converter;
    private ConsoleIo io;

    public Menu() {
        converter = new Converter();
        io = new ConsoleIo();
    }

    public Menu welcomeMessage() {
        io.printLine("Hi friend!\nWelcome to 'Elementary task' home work.\n");
        return this;
    }

    public Menu mainMenu() throws Exception {
        logger.debug("Main menu opened.");
        boolean isContinue = true;
        String menuOption = "1. Chess Board.\n2. Envelope Analysis\n3. Triangle Sort\n" +
                "4. Numerical sequence.\n5.File parser\n6. Fibonacci series\n7. Palindrome\n8. HappyTickets\n9.Convert number to words\n10. Exit";
        while (isContinue) {
            io.printLine("List of tasks you can find bellow.");
            io.printLine(menuOption);
            short taskNumber = 0;
            io.printLine("Please, select a task number!");
            do {
                taskNumber = converter.tryToShort(io.readString());
            } while (!isCorrectTaskSelected(menuOption, taskNumber));
            isContinue = taskCall(taskNumber);
        }
        return this;
    }

    public static boolean isContinue() {
        logger.debug("Ask for continued.");
        ConsoleIo io = new ConsoleIo();
        io.printLine("Do you want add one more?");
        String decision = io.readString();
        return decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes");
    }

    public static boolean isCorrectTaskSelected(String menuOptions, short taskNumber) {
        ConsoleIo io = new ConsoleIo();
        String[] tempArray = menuOptions.split("\n");
        int countOfOptions = tempArray.length;
        if (taskNumber < 1 || taskNumber > countOfOptions) {
            io.printFormat("Sorry you have only %d option try again.\n", countOfOptions, null);
            return false;
        } else {
            return true;
        }
    }

    private boolean taskCall(short taskNumber) throws Exception {
        IPlay game = null;
        switch (taskNumber) {
            case 1: {
                logger.debug("Chess board game selected.");
                game = new ChessBoardGame();
                break;
            }
            case 2: {
                logger.debug("Envelop game selected.");
                game = new EnvelopeGame();
                break;
            }
            case 3: {
                logger.debug("Triangle game selected.");
                game = new TriangleGame();
                break;
            }
            case 4: {
                logger.debug("Numerical sequence game selected.");
                game = new NumericalSequenceGame();
                break;
            }
            case 5: {
                logger.debug("File parser game selected.");
                game = new FileParserGame();
                break;
            }
            case 6: {
                logger.debug("Fibonacci series game selected.");
                game = new FibonacciSeriesGame();
                break;
            }
            case 7: {
                logger.debug("Palindrome game selected.");
                game = new PalindromeGame();
                break;
            }
            case 8: {
                logger.debug("Lucky tickets game selected.");
                game = new LuckyTicketsGame();
                break;
            }
            case 9: {
                logger.debug("Convert number to words game selected.");
                game = new ConvertNumberToWordsGame();
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
        logger.debug("Ask for continued.");
        boolean isProceed;
        do {
            io.printLine("Do you want play more?");
            String decision = io.readString();
            if (decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes")) {
                game.play();
                isProceed = true;
            } else {
                io.printLine("See you!");
                isProceed = false;
            }
        } while (isProceed);
        return isProceed;
    }
}