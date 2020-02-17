package envelope;

import interfaces.IPlay;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeGame implements IPlay {
    private GetTheEnvelopesData getTheEnvelopesData = new GetTheEnvelopesData();
    private List<EnvelopeComparisonResults> envelopeComparisonResultsList = new ArrayList<EnvelopeComparisonResults>();

    public void Play() throws Exception {
        List<Envelope> envelopeList = getTheEnvelopesData.GetTheEnvelopesSizes();
        CheckEnvelopes(envelopeList);
        PrintResults(envelopeList);
    }


    private void CheckEnvelopes(List<Envelope> envelopeList) {
        int listSize = envelopeList.size();
        for (int i = 0; i < listSize; i++) {
            EnvelopeComparisonResults comparisonResults = new EnvelopeComparisonResults();
            comparisonResults.setEnvelope(envelopeList.get(i));
            for (int j = i; j < listSize; j++) {
                if (i != j) {
                    if (envelopeList.get(i).compareTo(envelopeList.get(j)) < 0) {
                        comparisonResults.getListOfSmallerElements().add(envelopeList.get(j));
                    } else if (envelopeList.get(i).compareTo(envelopeList.get(j)) > 0) {
                        comparisonResults.getListOfLagerElements().add(envelopeList.get(j));
                    } else {
                        comparisonResults.getListOfEqualElements().add(envelopeList.get(j));
                    }
                }
            }
            envelopeComparisonResultsList.add(comparisonResults);
        }
    }

    private void PrintResults(List<Envelope> envelopeList) {
        for (EnvelopeComparisonResults element : envelopeComparisonResultsList) {
            int indexOfEnvelope = envelopeList.indexOf(element.getEnvelope()) + 1;
            List<Envelope> listOfLager = element.getListOfLagerElements();
            List<Envelope> listOfSmaller = element.getListOfSmallerElements();
            List<Envelope> listOfEqual = element.getListOfEqualElements();
            System.out.printf("Envelope %d with size %f*%f\n", indexOfEnvelope, element.getEnvelope().getLength(), element.getEnvelope().getWidth());
            if (!listOfLager.isEmpty()) {
                System.out.print("Lager than envelopes: ");
                for (Envelope env : listOfLager) {
                    System.out.print((envelopeList.indexOf(env) +1) + " ");
                }
                System.out.print("\n");
            }
            if(!listOfSmaller.isEmpty()) {
                System.out.print("Smaller than envelopes: ");
                for (Envelope env : listOfSmaller) {
                    System.out.print((envelopeList.indexOf(env) +1)+ " ");
                }
                System.out.print("\n");
            }
            if(!listOfEqual.isEmpty()) {
                System.out.print("Equal to envelopes: ");
                for (Envelope env : listOfEqual) {
                    System.out.print((envelopeList.indexOf(env) +1) + " ");
                }
                System.out.print("\n");
            }
        }
    }
}