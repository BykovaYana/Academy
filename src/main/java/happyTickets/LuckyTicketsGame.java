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

    public void Play() {
        dataProvider.GetInputData();
        ticketsSequence = dataProvider.CreateSequence();
        ticketsValidator.CountBySimpleMethod(ticketsSequence);
        List<String> luckyTicketsByFirst = ticketsValidator.CountBySimpleMethod(ticketsSequence);
    }
}
