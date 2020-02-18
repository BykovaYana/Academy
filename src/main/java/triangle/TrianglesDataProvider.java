package triangle;

import util.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrianglesDataProvider {
    private Scanner scanner;
    private Validator validator;

    public TrianglesDataProvider() {
        scanner = new Scanner(System.in);
        validator = new Validator();
    }

    public List<Triangle> getData() throws Exception {
        boolean isContinue = true;
        boolean isCorrect = false;
        Triangle triangle = null;
        List<Triangle> triangleList = new ArrayList<>();
        while (isContinue) {
            while (!isCorrect) {
                System.out.println("Please enter triangle data in format <triangle.Triangle Name; First side; Second side; Third side>");
                String trianglesData = scanner.nextLine();
                String clearString = trianglesData.replaceAll("\\s+", "");
                String[] data = clearString.split(";");
                if (data.length >= 4) {
                    float firstSide;
                    float secondSide;
                    float thirdSide;
                    firstSide = validator.validateSide(data[1]);
                    secondSide= validator.validateSide(data[2]);
                    thirdSide = validator.validateSide(data[3]);
                    if (validator.validateTriangle(firstSide, secondSide,thirdSide)) {
                        triangle = new Triangle(firstSide, secondSide,thirdSide);
                        triangle.setTriangleName(validator.validateName(data[0]));
                        isCorrect = true;
                    }else {
                        System.out.println("triangle.Triangle like this does not exist.");
                    }
                } else {
                    System.out.println("Incorrect format of entered data.");
                }
            }
            triangleList.add(triangle);
            isContinue = Menu.isContinue();
        }
        return triangleList;
    }
}
