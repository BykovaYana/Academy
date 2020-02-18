package happyTickets;

import java.util.ArrayList;
import java.util.List;

public class LuckyTicketsValidator {

    public List<String> CountBySimpleMethod(TicketsSequence happyTickets) {
        List<String> luckyTicketsSequence = new ArrayList<>();
        for (String ticket : happyTickets.getTicketsSequence()) {
            String firstPart = ticket.substring(0, 2);
            String secondPart = ticket.substring(3, 5);
            int firstSum = 0;
            int secondSum = 0;
            for (int i = 0; i < 3; i++) {
                firstSum = firstSum + (int) firstPart.charAt(i);
                secondSum = secondSum + (int) secondPart.charAt(i);
            }
            if (firstSum == secondSum) {
                luckyTicketsSequence.add(ticket);
            }
        }
        return luckyTicketsSequence;
    }
}
