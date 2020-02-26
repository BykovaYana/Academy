package numericalSequenceGame;

import interfaces.IPlay;

public class NumericalSequenceGame implements IPlay {
    private NumericalSequenceProvider dataProvider;
    private CalculateSequence calculateSequence;

    public NumericalSequenceGame() {
        dataProvider = new NumericalSequenceProvider();
        calculateSequence = new CalculateSequence();
    }

    public void play() {
        NumericalSequence numericalSequence = dataProvider.getTheData();
        String result = calculateSequence.calculateTheResult(numericalSequence);
        printResult(result);
    }

    private void printResult(String results) {
        System.out.println(results);
    }
}