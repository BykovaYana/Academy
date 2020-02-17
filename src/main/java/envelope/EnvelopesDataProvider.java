package envelope;

import util.Converter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnvelopesDataProvider {
    private Converter converter;
    private Scanner scanner;

    public EnvelopesDataProvider() {
        converter = new Converter();
        scanner = new Scanner(System.in);
    }

    public List<Envelope> GetEnvelopesSizes() throws Exception {
        List<Envelope> envelopeList = new ArrayList<Envelope>();
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
        return envelopeList;
    }
}
