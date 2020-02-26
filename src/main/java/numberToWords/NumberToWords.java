package numberToWords;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;

public class NumberToWords {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private static final String[] units = {
            "ноль",
            "один",
            "два",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять",
            "десять",
            "одиннадцать",
            "двенадцать",
            "тринадцать",
            "четырнадцать",
            "пятнадцать",
            "шестнадцать",
            "семнадцать",
            "вомьнадцать",
            "девятнадцать"
    };

    private static final String[] dozens = {
            "",
            "",
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"
    };

    private static final String[] hundreds = {
            "",
            "сто",
            "двести",
            "триста",
            "четыреста",
            "пятьсот",
            "шестьсот",
            "семьсот",
            "восемь",
            "девятьсот"
    };

    private static final String[] bigMultiples = {
            "миллион",
            "миллиард",
            "трилион",
            "квадрилион",
            "секстилион",
            "септильон",
            "октальон",
            "нональон",
            "декальон",
            "эндекальон",
            "додекальон"
    };

    public String convert(Long number) {
        logger.debug("Convert number to words.");
        String numberInWords = "";
        if (number < 20) {
            return convertUnits(Math.toIntExact(number));
        }
        if (number < 100) {
           return convertDozens(Math.toIntExact(number));
        }
        if (number < 1000) {
            return convertHundreds(Math.toIntExact(number));
        }
        if (number < 20000) {
            return convertUnitsOfThousand(Math.toIntExact(number));
        }
        if (number < 100000) {
            return convertDozensOfThousand (Math.toIntExact(number));
        }
        if (number < 1000000)
        {
            return  convertHundredsOfThousand(Math.toIntExact(number));
        }
        return "";
    }

    private String convertUnits(int number) {
        return units[number];
    }

    private String convertDozens(int number) {
        if(number / 10 == 0)
        {
            return " " + units[number % 10];
        }
        return dozens[number / 10] + ((number % 10 != 0) ? (" " + units[number % 10]) : "");
    }

    private String convertHundreds(int number) {
        long dozens = (Math.toIntExact(number) % 100);
        if(number / 100 == 0)
        {
            return " " + convert(dozens);
        }
        return hundreds[number / 100] + ((number % 100 != 0) ? (" " + convert(dozens)) : "");
    }

    private String convertUnitsOfThousand(int number) {
        long hundreds = (Math.toIntExact(number) % 1000);
        String thousand;
        if(number / 1000 == 0)
        {
            return " " + convert(hundreds);
        }
        if (Math.toIntExact(number) / 1000 >= 3 && Math.toIntExact(number) / 1000 <= 4) {
            thousand = " тысячи";
        } else {
            thousand = " тысяч";
        }
        if (number / 1000 == 1) {
            return "одна тысяча" + ((number % 1000 != 0) ? (" " + convert(hundreds)) : "");
        }
        if (number / 1000 == 2) {
            return "две тысячи" + ((number % 1000 != 0) ? (" " + convert(hundreds)) : "");
        }

        return units[number / 1000] + thousand + ((number % 1000 != 0) ? (" " + convert(hundreds)) : "");
    }

    private String convertDozensOfThousand(int number)
    {
        if(number / 10000 == 0)
        {
            return " " + convertUnitsOfThousand(number%10000);
        }
        return dozens[number / 10000] + " " + convertUnitsOfThousand(number%10000);
    }

    private String convertHundredsOfThousand(int number)
    {
        return hundreds[number / 100000]+ " " + convertDozensOfThousand(number%100000);
    }

}
