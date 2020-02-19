package luckyTickets;

import util.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyTicketsDataProvider {
    private TicketsSequence ticketsSequence;
    private Scanner scanner;
    private Converter converter;

    public LuckyTicketsDataProvider() {
        ticketsSequence = new TicketsSequence();
        scanner = new Scanner(System.in);
        converter = new Converter();
    }

    public void getInputData() {
        boolean isCorrectData = false;
        while (!isCorrectData) {
            System.out.println("Please enter minimal ticket number.");
            long minNumber = converter.tryToLong(scanner.next());
            if (Long.toString(minNumber).length() > 6 || minNumber < 0) {
                System.out.println("Ticket number should be not longer that 6 digit and more than 0.\nPlease try again.");
            } else {
                isCorrectData = true;
                ticketsSequence.setMinNumber(minNumber);
            }
        }
        isCorrectData = false;
        while (!isCorrectData) {
            System.out.println("Please enter minimal ticket number.");
            long maxNumber = converter.tryToLong(scanner.next());
            if (Long.toString(maxNumber).length() > 6 || maxNumber < 0) {
                System.out.println("Ticket number should be not longer that 6 digit and more than 0.\nPlease try again.");
            } else if (maxNumber < ticketsSequence.getMinNumber()) {
                System.out.println("Max number cannot be less than min.");
            } else {
                isCorrectData = true;
                ticketsSequence.setMaxNumber(maxNumber);
            }
        }
    }

    public TicketsSequence createSequence() {
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
