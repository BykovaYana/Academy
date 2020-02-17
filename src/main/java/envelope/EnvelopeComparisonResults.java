package envelope;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeComparisonResults {
    private Envelope envelope;
    private List<Envelope> listOfLagerElements = new ArrayList<Envelope>();
    private List<Envelope> listOfSmallerElements = new ArrayList<Envelope>();
    private List<Envelope> listOfEqualElements = new ArrayList<Envelope>();

    public Envelope getEnvelope() {
        return envelope;
    }

    public List<Envelope> getListOfLagerElements() {
        return listOfLagerElements;
    }

    public List<Envelope> getListOfSmallerElements() {
        return listOfSmallerElements;
    }

    public List<Envelope> getListOfEqualElements() {
        return listOfEqualElements;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    public void setListOfLagerElements(List<Envelope> listOfLagerElements) {
        this.listOfLagerElements = listOfLagerElements;
    }

    public void setListOfSmallerElements(List<Envelope> listOfSmallerElements) {
        this.listOfSmallerElements = listOfSmallerElements;
    }

    public void setListOfEqualElements(List<Envelope> listOfEqualElements) {
        this.listOfEqualElements = listOfEqualElements;
    }
}