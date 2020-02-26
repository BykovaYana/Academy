package luckyTickets;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;
import util.ConsoleIo;
import util.Converter;

import java.util.ArrayList;
import java.util.List;

public class LuckyTicketsDataProvider {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private TicketsSequence ticketsSequence;
    private Converter converter;
    private ConsoleIo io;

    public LuckyTicketsDataProvider() {
        ticketsSequence = new TicketsSequence();
        converter = new Converter();
        io = new ConsoleIo();
    }

    public void getInputData() {
        logger.debug("Get tickets data.");

        boolean isCorrectData = false;
        while (!isCorrectData) {
            io.printLine("Please enter minimal ticket number.");
            long minNumber = converter.tryToLong(io.readString());
            if (Long.toString(minNumber).length() > 6 || minNumber < 0) {
                io.printLine("Ticket number should be not longer that 6 digit and more than 0.\nPlease try again.");
            } else {
                isCorrectData = true;
                ticketsSequence.setMinNumber(minNumber);
            }
        }
        isCorrectData = false;
        while (!isCorrectData) {
            io.printLine("Please enter minimal ticket number.");
            long maxNumber = converter.tryToLong(io.readString());
            if (Long.toString(maxNumber).length() > 6 || maxNumber < 0) {
                io.printLine("Ticket number should be not longer that 6 digit and more than 0.\nPlease try again.");
            } else if (maxNumber < ticketsSequence.getMinNumber()) {
                io.printLine("Max number cannot be less than min.");
            } else {
                isCorrectData = true;
                ticketsSequence.setMaxNumber(maxNumber);
            }
        }
    }

    public TicketsSequence createSequence() {
        logger.debug("Create sequence.");

        List<Long> numbers = new ArrayList<>();
        numbers.add(ticketsSequence.getMinNumber());
        int size = numbers.size();
        while (numbers.get(size - 1) <= ticketsSequence.getMaxNumber()) {
            long lastElement = numbers.get(size - 1);
            numbers.add(lastElement + 1);
            size = numbers.size();
        }
        for (Long number : numbers) {
            ticketsSequence.getTicketsSequence().add(String.format("%06d", number));
        }
        return ticketsSequence;
    }
}