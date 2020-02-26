package triangle;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;
import util.ConsoleIo;
import util.Converter;

public class Validator {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private Converter converter;
    private ConsoleIo io;

    public Validator() {
        io = new ConsoleIo();
        converter = new Converter();
    }

    public String validateName(String name) {
        logger.debug("Validate triangle name.");
        boolean isNameEntered = false;
        String newName = "";
        if (name != null && !name.isEmpty()) {
            return name;
        } else {
            while (!isNameEntered) {
                io.printLine("Triangle name is empty!\nPlease enter new name:");
                newName = io.readString();
                if (newName != null && !newName.isEmpty()) {
                    isNameEntered = true;
                }
            }
        }
        return newName;
    }

    public float validateSide(String side) throws Exception {
        logger.debug("Validate triangle side.");

        boolean isSideEntered = false;
        float sideSize = converter.tryToFloat(side);
        float newSize = 0;
        if (sideSize > 0) {
            return sideSize;
        }
        while (!isSideEntered) {
            io.printLine("Incorrect side size! Side should be more than 0!\nPlease enter new value:");
            newSize = converter.tryToFloat(io.readString());
            if (newSize > 0) {
                isSideEntered = true;
            }
        }
        return newSize;
    }

    public boolean validateTriangle(float firstSide, float secondSide, float thirdSide) {
        logger.debug("Validate triangle.");

        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        if (firstSide < triangle.calculatePerimeter() &&
                secondSide < triangle.calculatePerimeter() &&
                thirdSide < triangle.calculatePerimeter()) {
            return true;
        }
        return false;
    }
}