package numericalSequenceGame;

import interfaces.IPlay;

public class NumericalSequenceGame implements IPlay {
    private GetDataForNumericalSequence data = new GetDataForNumericalSequence();
    private CalculateSequence calculateSequence = new CalculateSequence();

    public void Play() throws Exception {
        NumericalSequence numericalSequence = data.GetTheData();
        String result = calculateSequence.CalculateTheResult(numericalSequence);
        PrintResult(result);
    }

    private void PrintResult(String results) {
        System.out.println(results);
    }
}
