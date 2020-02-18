package happyTickets;

import java.util.ArrayList;
import java.util.List;

public class TicketsSequence {
    private long minNumber;
    private long maxNumber;
    private List<String> ticketsSequence;

    public TicketsSequence() {
        this.ticketsSequence = new ArrayList<String>();
    }

    public long getMinNumber() {
        return minNumber;
    }

    public long getMaxNumber() {
        return maxNumber;
    }

    public List<String> getTicketsSequence() {
        return ticketsSequence;
    }

    public void setMinNumber(long minNumber) {
        this.minNumber = minNumber;
    }

    public void setMaxNumber(long maxNumber) {
        this.maxNumber = maxNumber;
    }
}
