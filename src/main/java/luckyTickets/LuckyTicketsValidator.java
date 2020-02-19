package luckyTickets;

import java.util.ArrayList;
import java.util.List;

public class LuckyTicketsValidator {

    public List<String> countBySimpleMethod(TicketsSequence happyTickets) {
        List<String> luckyTicketsSequence = new ArrayList<>();
        for (String ticket : happyTickets.getTicketsSequence()) {
            String firstPart = ticket.substring(0, 3);
            String secondPart = ticket.substring(3, 6);
            int firstSum = 0;
            int secondSum = 0;
            for (int i = 0; i < 3; i++) {
                firstSum += Integer.parseInt(firstPart.substring(i, i + 1));
                secondSum += Integer.parseInt(secondPart.substring(i, i + 1));
            }
            if (firstSum == secondSum) {
                luckyTicketsSequence.add(ticket);
            }
        }
        return luckyTicketsSequence;
    }

    public List<String> countByDifficultMethod(TicketsSequence happyTickets) {
        List<String> luckyTicketsSequence = new ArrayList<>();
        for (String ticket : happyTickets.getTicketsSequence()) {
            int sumOfEven = 0;
            int sumOfOdd = 0;
            for (int i = 0; i < 6; i++) {
                int nextDigit = Integer.parseInt(ticket.substring(i, i + 1));
                if ((i + 1) % 2 == 0) {
                    sumOfEven += nextDigit;
                } else {
                    sumOfOdd += nextDigit;
                }
            }
            if (sumOfEven==sumOfOdd)
            {
                luckyTicketsSequence.add(ticket);
            }
        }
        return luckyTicketsSequence;
    }
}
