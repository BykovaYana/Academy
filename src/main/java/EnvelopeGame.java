import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnvelopeGame implements IPlay {

    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);
    private List<Envelope> envelopeList = new ArrayList<Envelope>();
    private List<EnvelopeComparisonResults> envelopeComparisonResultsList = new ArrayList<EnvelopeComparisonResults>();

    public void Play() throws Exception {
        GetTheEnvelopesSizes();
        CheckEnvelopes();
    }

    private void GetTheEnvelopesSizes() throws Exception {
        boolean isContinue = true;
        while (isContinue) {
            Envelope envelope = new Envelope();
            System.out.println("Please enter size of the envelopes.");
            boolean isCorrectParameters = false;
            System.out.println("Please enter the length:");
            envelope.setLength(converter.TryToFloat(scanner.next()));
            while (!isCorrectParameters) {
                System.out.println("Please enter the width:");
                envelope.setWidth(converter.TryToFloat(scanner.next()));
                if (envelope.getLength() < envelope.getWidth()) {
                    System.out.println("Sorry length should be more than width.\nTry again.");
                } else {
                    isCorrectParameters = true;
                }
            }
            envelopeList.add(envelope);
            if (envelopeList.size() >= 2) {
                System.out.println("Do you want add one more?");
                String decision = scanner.next();
                isContinue = decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes");
            }
        }
    }

    private void CheckEnvelopes() {
        int listSize = envelopeList.size();
        for (int i = 0; i < listSize; i++) {
            for (int j = i; j < listSize; j++) {
                if (i != j) {
                    if ((envelopeList.get(i).getLength() < envelopeList.get(j).getLength()) && (envelopeList.get(i).getWidth() < envelopeList.get(j).getWidth())) {
                      //  if(envelopeComparisonResultsList.stream().filter(o -> o.getEnvelope().equals(envelopeList.get(i))))
                            //list.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();

                       /* System.out.printf("\n%d envelope bigger than %d.", j, i);
                        System.out.printf("\nYou can put the %d into the %d.\n", i, j);
                        System.out.printf("\nSize of envelop %d = > %f*%f.", i, envelopeList.get(i).getLength(), envelopeList.get(i).getWidth());
                        System.out.printf("\nSize of envelop %d = > %f*%f.\n\n", j, envelopeList.get(j).getLength(), envelopeList.get(j).getWidth());*/
                    }
                    else if ((envelopeList.get(i).getLength() > envelopeList.get(j).getLength()) && (envelopeList.get(i).getWidth() > envelopeList.get(j).getWidth())) {
                        System.out.printf("\n%d envelope bigger than %d.", i, j);
                        System.out.printf("\nYou can put the %d into the %d.\n", j , i );
                        System.out.printf("\nSize of envelop %d = > %f*%f.", i, envelopeList.get(i).getLength(), envelopeList.get(i).getWidth());
                        System.out.printf("\nSize of envelop %d = > %f*%f.\n\n", j, envelopeList.get(j).getLength(), envelopeList.get(j).getWidth());
                    } else if ((envelopeList.get(i).getLength() == envelopeList.get(j).getLength()) && (envelopeList.get(i).getWidth() == envelopeList.get(j).getWidth())) {
                        System.out.printf("Envelope %d and %d are the same.\n", i, j);
                    } else {
                        System.out.println("You cannot put one envelope in another.");
                    }
                }
            }
        }
    }
}
