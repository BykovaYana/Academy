package util;

import com.sun.istack.internal.Nullable;

import java.util.Scanner;

public class ConsoleIo <T>{
    private static Scanner scanner;

    public ConsoleIo() {
        scanner = new Scanner(System.in);
    }

    public String readString()
    {
        return scanner.next();
    }

    public int printLine(String string)
    {
        System.out.println(string);
        return 1;
    }

    public int print(String string)
    {
        System.out.print(string);
        return 1;
    }

    public int printFormat(String string, T firstVariable, @Nullable T secondVariable)
    {
        try{
            System.out.printf(string, firstVariable, secondVariable);
            return 1;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    public Long readLong()
    {
        return scanner.nextLong();
    }
}
