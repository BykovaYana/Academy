package envelope;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeComparisonResults {
    private Envelope envelope;
    private List<Envelope> lagerEnvelopes;
    private List<Envelope> smallerEnvelopes;
    private List<Envelope> equalEnvelopes;

    public EnvelopeComparisonResults() {
        lagerEnvelopes = new ArrayList<Envelope>();
        smallerEnvelopes = new ArrayList<Envelope>();
        equalEnvelopes = new ArrayList<Envelope>();
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public List<Envelope> getLagerEnvelopes() {
        return lagerEnvelopes;
    }

    public List<Envelope> getSmallerEnvelopes() {
        return smallerEnvelopes;
    }

    public List<Envelope> getEqualEnvelopes() {
        return equalEnvelopes;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }
}