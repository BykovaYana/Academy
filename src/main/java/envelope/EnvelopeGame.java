package envelope;

import interfaces.IPlay;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeGame implements IPlay {
    private EnvelopesDataProvider envelopesDataProvider;
    private List<EnvelopeComparisonResults> envelopeComparisonResults;

    public EnvelopeGame() {
        envelopesDataProvider = new EnvelopesDataProvider();
        envelopeComparisonResults = new ArrayList<EnvelopeComparisonResults>();
    }

    public void play() throws Exception {
        List<Envelope> envelopeList = envelopesDataProvider.getEnvelopesSizes();
        checkEnvelopes(envelopeList);
        printGameResults(envelopeList);
    }


    private void checkEnvelopes(List<Envelope> envelopeList) {
        int listSize = envelopeList.size();
        for (int i = 0; i < listSize; i++) {
            EnvelopeComparisonResults comparisonResults = new EnvelopeComparisonResults();
            comparisonResults.setEnvelope(envelopeList.get(i));
            for (int j = i; j < listSize; j++) {
                if (i != j) {
                    if (envelopeList.get(i).compareTo(envelopeList.get(j)) < 0) {
                        comparisonResults.getSmallerEnvelopes().add(envelopeList.get(j));
                    } else if (envelopeList.get(i).compareTo(envelopeList.get(j)) > 0) {
                        comparisonResults.getLagerEnvelopes().add(envelopeList.get(j));
                    } else {
                        comparisonResults.getEqualEnvelopes().add(envelopeList.get(j));
                    }
                }
            }
            envelopeComparisonResults.add(comparisonResults);
        }
    }

    private void printGameResults(List<Envelope> envelopeList) {
        for (EnvelopeComparisonResults result : envelopeComparisonResults) {
            int indexOfEnvelope = envelopeList.indexOf(result.getEnvelope()) + 1;

            System.out.printf("Envelope %d with size %f*%f\n", indexOfEnvelope, result.getEnvelope().getLength(), result.getEnvelope().getWidth());

            if (!result.getLagerEnvelopes().isEmpty()) {
                System.out.print("Lager than envelopes: ");
                for (Envelope env : result.getLagerEnvelopes()) {
                    System.out.print((envelopeList.indexOf(env) +1) + " ");
                }
                System.out.print("\n");
            }

            if(!result.getSmallerEnvelopes().isEmpty()) {
                System.out.print("Smaller than envelopes: ");
                for (Envelope env :  result.getSmallerEnvelopes()) {
                    System.out.print((envelopeList.indexOf(env) +1)+ " ");
                }
                System.out.print("\n");
            }

            if(!result.getEqualEnvelopes().isEmpty()) {
                System.out.print("Equal to envelopes: ");
                for (Envelope env : result.getEqualEnvelopes()) {
                    System.out.print((envelopeList.indexOf(env) +1) + " ");
                }
                System.out.print("\n");
            }
        }
    }
}