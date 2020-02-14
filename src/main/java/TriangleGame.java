import java.util.*;

public class TriangleGame implements IPlay {
    private Scanner scanner = new Scanner(System.in);
    private Converter converter = new Converter();
    private List<Triangle> triangleList = new ArrayList<>();

    public void Play() throws Exception {
        GetTrianglesData();
        CalculateAreas();
        PrintResult();
    }

    private void GetTrianglesData() throws Exception {
        boolean isContinue = true;
        boolean isCorrect = false;
        Triangle triangle = null;
        while (isContinue) {
            while (!isCorrect) {
                System.out.println("Please enter triangle data in format <Triangle Name; First side; Second side; Third side>");
                String trianglesData = scanner.nextLine();
                String clearString = trianglesData.replaceAll("\\s+", "");
                String[] data = clearString.split(";");
                triangle = new Triangle();
                if (data.length >= 4) {
                    triangle.setTriangleName(ValidateName(data[0]));
                    triangle.setFirstSide(ValidateSide(data[1]));
                    triangle.setSecondSide(ValidateSide(data[2]));
                    triangle.setThirdSide(ValidateSide(data[3]));
                    if (ValidateTriangle(triangle)) {
                        break;
                    }else {
                        System.out.println("Triangle like this does not exist.");
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
    }

    private void PrintResult() {
        System.out.println("============= Triangles list: ===============");
        Collections.sort(triangleList, new Triangle());
        for (int i = 0; i < triangleList.size(); i++) {
            System.out.printf("[%s]: %f cm\n", triangleList.get(i).getTriangleName(), triangleList.get(i).getArea());
        }
    }

    private void CalculateAreas() {
        for (int i = 0; i < triangleList.size(); i++) {
            triangleList.get(i).setArea(triangleList.get(i).CalculateArea());
        }
    }

    private String ValidateName(String name) {
        boolean isNameEntered = false;
        String newName = "";
        if (name != null && !name.isEmpty()) {
            return name;
        } else {
            while (!isNameEntered) {
                System.out.println("Triangle name is empty!\nPlease enter new name:");
                newName = scanner.next();
                if (newName != null && !newName.isEmpty()) {
                    isNameEntered = true;
                }
            }
        }
        return newName;
    }

    private float ValidateSide(String side) throws Exception {
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

    private boolean ValidateTriangle(Triangle triangle) {
        if (triangle.getFirstSide() < triangle.CalculatePerimeter() &&
                triangle.getSecondSide() < triangle.CalculatePerimeter() &&
                triangle.getThirdSide() < triangle.CalculatePerimeter()) {
            return true;
        }
        return false;
    }
}
