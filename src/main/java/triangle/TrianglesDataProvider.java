package triangle;

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

    public List<Triangle> GetData() throws Exception {
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
                triangle = new Triangle();
                if (data.length >= 4) {
                    triangle.setTriangleName(validator.ValidateName(data[0]));
                    triangle.setFirstSide(validator.ValidateSide(data[1]));
                    triangle.setSecondSide(validator.ValidateSide(data[2]));
                    triangle.setThirdSide(validator.ValidateSide(data[3]));
                    if (validator.ValidateTriangle(triangle)) {
                        isCorrect = true;
                    }else {
                        System.out.println("triangle.Triangle like this does not exist.");
                    }
                } else {
                    System.out.println("Incorrect format of entered data.");
                }
            }
            triangleList.add(triangle);
            System.out.println("Do you want add one more?");
            String decision = scanner.nextLine();
            isContinue = decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes");
        }

        return triangleList;
    }
}
