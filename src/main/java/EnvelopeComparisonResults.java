import java.util.ArrayList;
import java.util.List;

public class EnvelopeComparisonResults {
    private Envelope envelope;
    private EnvelopeStatus status;
    private List<Envelope> resultList = new ArrayList<Envelope>();

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    public void setStatus(EnvelopeStatus status) {
        this.status = status;
    }

    public void setResultList(List<Envelope> resultList) {
        this.resultList = resultList;
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public EnvelopeStatus getStatus() {
        return status;
    }

    public List<Envelope> getResultList() {
        return resultList;
    }
}
