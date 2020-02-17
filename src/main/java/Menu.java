import java.util.Scanner;

public class Menu {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);

    public Menu WelcomeMessage() {
        System.out.println("Hi friend!\nWelcome to 'Elementary task' home work.\n");
        return this;
    }

    public Menu MainMenu() throws Exception {
        System.out.println("List of tasks you can find bellow. \n1. ChessBoard.\n2. Envelope Analysis\n3. Triangle Sort\n4. Numerical sequence.\n5.File parser\n6. Fibonacci series");
        short taskNumber = 0;
        System.out.println("Please, select a task number! ");
        boolean isTaskSelected = false;
        while (!isTaskSelected) {
            taskNumber = converter.TryToShot(scanner.nextLine());
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
        switch (taskNumber) {
            case 1: {
                ChessBoard chessBoard = new ChessBoard();
                chessBoard.Play();
                Proceed(chessBoard);
                break;
            }
            case 2: {
                EnvelopeGame envelopeGame = new EnvelopeGame();
                envelopeGame.Play();
                Proceed(envelopeGame);
                break;
            }
            case 3: {
                TriangleGame triangleGame = new TriangleGame();
                triangleGame.Play();
                Proceed(triangleGame);
                break;
            }
            case 4: {
                NumericalSequenceGame numericalSequenceGame = new NumericalSequenceGame();
                numericalSequenceGame.Play();
                Proceed(numericalSequenceGame);
                break;
            }
            case 5: {
                FileParserMenu fileParser = new FileParserMenu();
                fileParser.Play();
                Proceed(fileParser);
                break;
            }
            case 6: {
                FibonacciSeriesMenu fibonacciSeries = new FibonacciSeriesMenu();
                fibonacciSeries.Play();
                Proceed(fibonacciSeries);
            }
            default: {
                MainMenu();
            }
        }
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