package happyTickets;

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
        List<String> luckyTicketsByFirst = ticketsValidator.countBySimpleMethod(ticketsSequence);
    }
}
