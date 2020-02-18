package util;

public class Converter {
    public short tryToShort(String string) {
        short value = 0;
        boolean isCorrectValue = false;
        while (!isCorrectValue) {
            try {
                value = Short.parseShort(string);
                isCorrectValue = true;
            } catch (Exception ex) {
                System.out.println("Are you sure that it is a number?\nPlease try again!");
            }
        }
        return value;
    }

    public long tryToLong(String string) {
        long value = 0L;
        boolean isCorrectValue = false;
        while (!isCorrectValue) {
            try {
                value = Long.parseLong(string);
                isCorrectValue = true;
            } catch (Exception ex) {
                System.out.println("Are you sure that it is a number?\nPlease try again!");
            }
        }
        return value;
    }

    public float tryToFloat(String string) throws Exception {
        float value;
        StringBuilder tempString = new StringBuilder(string);
        try {
            value = Float.parseFloat(string);
        } catch (NumberFormatException ex) {
            if (tempString.indexOf(",") == 0) {
                tempString = tempString.deleteCharAt(0);
            }
            if (tempString.charAt(tempString.length() - 1) == ',') {
                tempString = tempString.deleteCharAt(tempString.length() - 1);
            }
            long numberOfComa = tempString.chars().filter(q -> q == ',').count();
            if (numberOfComa > 1) {
                throw new Exception("Incorrect format of entered data.");
            } else {
                String newString = tempString.toString();
                value = Float.parseFloat(newString.replace(',', '.'));
            }
        }
        return value;
    }
}