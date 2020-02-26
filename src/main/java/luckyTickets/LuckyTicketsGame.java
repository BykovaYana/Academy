package luckyTickets;

import chessBoard.ChessBoardLengthProvider;
import interfaces.IPlay;
import org.apache.log4j.Logger;
import util.ConsoleIo;

import java.util.List;

public class LuckyTicketsGame implements IPlay {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private LuckyTicketsDataProvider dataProvider;
    private TicketsSequence ticketsSequence;
    private LuckyTicketsValidator ticketsValidator;
    private ConsoleIo io;

    public LuckyTicketsGame() {
        dataProvider = new LuckyTicketsDataProvider();
        ticketsSequence = new TicketsSequence();
        ticketsValidator = new LuckyTicketsValidator();
        io= new ConsoleIo();
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
        logger.debug("Calculate game result.");
        return luckyTicketsByFirstMethod.size() - luckyTicketsBySecondMethod.size();
    }

    private void printGameResult(List<String> luckyTicketsByFirstMethod, List<String> luckyTicketsBySecondMethod)
    {
        logger.debug("Print game result.");
        int result = calculateGameResult(luckyTicketsByFirstMethod, luckyTicketsBySecondMethod);
        if (result>0)
        {
            io.printLine("First method found more lucky tickets than second.");
        }
        else if (result<0)
        {
            io.printLine("Second method found more lucky tickets than first.");
        }else {
            io.printLine("Methods found the same number of tickets.");
        }
        System.out.printf("Result first method %d. Result second method  %d.\n", luckyTicketsByFirstMethod.size(), luckyTicketsBySecondMethod.size());
    }
}
