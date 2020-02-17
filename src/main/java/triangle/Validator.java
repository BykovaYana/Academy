package triangle;

import util.Converter;

import java.util.Scanner;

public class Validator {
    private Scanner scanner = new Scanner(System.in);
    private Converter converter = new Converter();

    public String ValidateName(String name) {
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

    public float ValidateSide(String side) throws Exception {
        boolean isSideEntered = false;
        float sideSize = converter.TryToFloat(side);
        float newSize = 0;
        if (sideSize > 0) {
            return sideSize;
        }
        while (!isSideEntered) {
            System.out.println("Incorrect side size! Side should be more than 0!\nPlease enter new value:");
            newSize = converter.TryToFloat(scanner.next());
            if (newSize > 0) {
                isSideEntered = true;
            }
        }
        return newSize;
    }

    public boolean ValidateTriangle(Triangle triangle) {
        if (triangle.getFirstSide() < triangle.CalculatePerimeter() &&
                triangle.getSecondSide() < triangle.CalculatePerimeter() &&
                triangle.getThirdSide() < triangle.CalculatePerimeter()) {
            return true;
        }
        return false;
    }
}
