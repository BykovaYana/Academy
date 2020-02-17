package numericalSequenceGame;

import interfaces.IPlay;

public class NumericalSequenceGame implements IPlay {
    private NumericalSequenceProvider dataProvider;
    private CalculateSequence calculateSequence;

    public NumericalSequenceGame() {
        dataProvider = new NumericalSequenceProvider();
        calculateSequence = new CalculateSequence();
    }

    public void Play() {
        NumericalSequence numericalSequence = dataProvider.GetTheData();
        String result = calculateSequence.CalculateTheResult(numericalSequence);
        PrintResult(result);
    }

    private void PrintResult(String results) {
        System.out.println(results);
    }
}
