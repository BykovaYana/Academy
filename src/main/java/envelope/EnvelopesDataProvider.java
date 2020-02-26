package envelope;

import chessBoard.ChessBoardGame;
import org.apache.log4j.Logger;
import util.ConsoleIo;
import util.Converter;
import util.Menu;

import java.util.ArrayList;
import java.util.List;

public class EnvelopesDataProvider {
    final static Logger logger = Logger.getLogger(ChessBoardGame.class);

    private Converter converter;
    private ConsoleIo io;

    public EnvelopesDataProvider() {
        io = new ConsoleIo();
        converter = new Converter();
    }

    public List<Envelope> getEnvelopesSizes() throws Exception {
        logger.debug("Get envelopes sizes.");
        List<Envelope> envelopeList = new ArrayList<Envelope>();
        boolean isContinue = true;
        Envelope envelope = null;
        while (isContinue) {
            io.printLine("Please enter size of the envelopes.");
            boolean isCorrectParameters = false;
            io.printLine("Please enter the length:");
            float length = converter.tryToFloat(io.readString());
            float width;
            while (!isCorrectParameters) {
                io.printLine("Please enter the width:");
                width = converter.tryToFloat(io.readString());
                if (length < width) {
                    io.printLine("Sorry length should be more than width.\nTry again.");
                    logger.error("Incorrect width entered.");
                } else {
                    isCorrectParameters = true;
                    logger.debug("Envelope sizes received." + length + "*" + width);
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
