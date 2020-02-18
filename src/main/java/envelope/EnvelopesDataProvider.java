package envelope;

import util.Converter;
import util.Menu;

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

    public List<Envelope> getEnvelopesSizes() throws Exception {
        List<Envelope> envelopeList = new ArrayList<Envelope>();
        boolean isContinue = true;
        Envelope envelope= null;
        while (isContinue) {
            System.out.println("Please enter size of the envelopes.");
            boolean isCorrectParameters = false;
            System.out.println("Please enter the length:");
            float length = converter.tryToFloat(scanner.next());
            float width;
            while (!isCorrectParameters) {
                System.out.println("Please enter the width:");
                width= converter.tryToFloat(scanner.next());
                if (length < width) {
                    System.out.println("Sorry length should be more than width.\nTry again.");
                } else {
                    isCorrectParameters = true;
                    envelope = new Envelope(length, width);
                }
            }
            envelopeList.add(envelope);
            if (envelopeList.size() >= 2) {
                isContinue = Menu.isContinue();
            }
        }
        return envelopeList;
    }
}
