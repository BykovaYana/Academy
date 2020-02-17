package numericalSequenceGame;

import java.util.ArrayList;
import java.util.List;

public class CalculateSequence {
    private short startedNumber;

    public String CalculateTheResult(NumericalSequence numericalSequence) {
        startedNumber = (short)Math.sqrt(numericalSequence.getMinimumSquare());
        List<String> resultsList = new ArrayList<String>();

        for (int i = 0; i < numericalSequence.getSequenceLength(); i++) {
            startedNumber++;
            resultsList.add(String.valueOf(startedNumber));
        }
        return String.join(",", resultsList);
    }
}
