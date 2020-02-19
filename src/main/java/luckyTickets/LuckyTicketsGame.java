package luckyTickets;

import interfaces.IPlay;

import java.util.List;

public class LuckyTicketsGame implements IPlay {
    private LuckyTicketsDataProvider dataProvider;
    private TicketsSequence ticketsSequence;
    private LuckyTicketsValidator ticketsValidator;


    public LuckyTicketsGame() {
        dataProvider = new LuckyTicketsDataProvider();
        ticketsSequence = new TicketsSequence();
        ticketsValidator = new LuckyTicketsValidator();
    }

    public void play() {
        dataProvider.getInputData();
        ticketsSequence = dataProvider.createSequence();
        ticketsValidator.countBySimpleMethod(ticketsSequence);
        List<String> luckyTicketsByFirstMethod = ticketsValidator.countBySimpleMethod(ticketsSequence);
        List<String> luckyTicketsBySecondMethod = ticketsValidator.countByDifficultMethod(ticketsSequence);
        printGameResult(luckyTicketsByFirstMethod,luckyTicketsBySecondMethod);
    }

    private int calculateGameResult(List<String> luckyTicketsByFirstMethod, List<String> luckyTicketsBySecondMethod){
        return luckyTicketsByFirstMethod.size() - luckyTicketsBySecondMethod.size();
    }

    private void printGameResult(List<String> luckyTicketsByFirstMethod, List<String> luckyTicketsBySecondMethod)
    {
        int result = calculateGameResult(luckyTicketsByFirstMethod, luckyTicketsBySecondMethod);
        if (result>0)
        {
            System.out.println("First method found more lucky tickets than second.");
        }
        else if (result<0)
        {
            System.out.println("Second method found more lucky tickets than first.");
        }else {
            System.out.println("Methods found the same number of tickets.");
        }
        System.out.printf("Result first method %d. Result second method  %d.\n", luckyTicketsByFirstMethod.size(), luckyTicketsBySecondMethod.size());
    }
}
