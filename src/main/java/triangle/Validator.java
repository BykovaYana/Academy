package triangle;

import util.Converter;

import java.util.Scanner;

public class Validator {
    private Scanner scanner;
    private Converter converter;

    public Validator() {
        scanner = new Scanner(System.in);
        converter = new Converter();
    }

    public String validateName(String name) {
        boolean isNameEntered = false;
        String newName = "";
        if (name != null && !name.isEmpty()) {
            return name;
        } else {
            while (!isNameEntered) {
                System.out.println("triangle.Triangle name is empty!\nPlease enter new name:");
                newName = scanner.next();
                if (newName != null && !newName.isEmpty()) {
                    isNameEntered = true;
                }
            }
        }
        return newName;
    }

    public float validateSide(String side) throws Exception {
        boolean isSideEntered = false;
        float sideSize = converter.tryToFloat(side);
        float newSize = 0;
        if (sideSize > 0) {
            return sideSize;
        }
        while (!isSideEntered) {
            System.out.println("Incorrect side size! Side should be more than 0!\nPlease enter new value:");
            newSize = converter.tryToFloat(scanner.next());
            if (newSize > 0) {
                isSideEntered = true;
            }
        }
        return newSize;
    }

    public boolean validateTriangle(float firstSide, float secondSide, float thirdSide) {
        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        if (firstSide < triangle.calculatePerimeter() &&
                secondSide < triangle.calculatePerimeter() &&
                thirdSide < triangle.calculatePerimeter()) {
            return true;
        }
        return false;
    }
}
