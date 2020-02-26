package envelope;

import chessBoard.ChessBoardLengthProvider;
import interfaces.IPlay;
import org.apache.log4j.Logger;
import util.ConsoleIo;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeGame implements IPlay {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private EnvelopesDataProvider envelopesDataProvider;
    private List<EnvelopeComparisonResults> envelopeComparisonResults;
    private ConsoleIo io;

    public EnvelopeGame() {
        envelopesDataProvider = new EnvelopesDataProvider();
        envelopeComparisonResults = new ArrayList<EnvelopeComparisonResults>();
        io = new ConsoleIo();
    }

    public void play() throws Exception {
        List<Envelope> envelopeList = envelopesDataProvider.getEnvelopesSizes();
        checkEnvelopes(envelopeList);
        printGameResults(envelopeList);
    }


    private void checkEnvelopes(List<Envelope> envelopeList) {
        logger.debug("Check envelopes.");
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
        logger.debug("Print game result.");
        for (EnvelopeComparisonResults result : envelopeComparisonResults) {
            int indexOfEnvelope = envelopeList.indexOf(result.getEnvelope()) + 1;
            io.printFormat("Envelope %d with size %f*%f\n", indexOfEnvelope, result.getEnvelope().getLength(), result.getEnvelope().getWidth());
            if (!result.getLagerEnvelopes().isEmpty()) {
                io.printLine("Lager than envelopes: ");
                for (Envelope env : result.getLagerEnvelopes()) {
                    io.print((envelopeList.indexOf(env) + 1) + " ");
                }
                io.printLine("\n");
            }

            if (!result.getSmallerEnvelopes().isEmpty()) {
                io.print("Smaller than envelopes: ");
                for (Envelope env : result.getSmallerEnvelopes()) {
                    io.print((envelopeList.indexOf(env) + 1) + " ");
                }
                io.printLine("\n");
            }

            if (!result.getEqualEnvelopes().isEmpty()) {
                io.print("Equal to envelopes: ");
                for (Envelope env : result.getEqualEnvelopes()) {
                    io.print((envelopeList.indexOf(env) + 1) + " ");
                }
                io.print("\n");
            }
        }
    }
}