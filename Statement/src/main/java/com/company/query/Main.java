package com.company.query;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.util.Scanner;


public class Main {
    static Scanner scanner;

    public static void main(String[] args) {
        System.out.println(Ansi.colorize("Welcome to JDBC Statement program!", Attribute.GREEN_TEXT()));
        scanner = new Scanner(System.in);
        int userChose = -1;
        int wrongChoseLimit = 0;
        do {
            userChose = getUserChose();
            switch (userChose) {
                case 0:
                    break;
                case 1: {
                    wrongChoseLimit = 0;
                    Task01.run();
                    break;
                }
                case 2: {
                    wrongChoseLimit = 0;
                    Task02.run();
                    break;
                }
                case 3: {
                    wrongChoseLimit = 0;
                    Task03.run();
                    break;
                }
                case 4: {
                    wrongChoseLimit = 0;
                    Task04.run();
                    break;
                }
                case 5: {
                    wrongChoseLimit = 0;
                    Task05.run();
                    break;
                }
                case 6: {
                    wrongChoseLimit = 0;
                    Task06.run();
                    break;
                }
                case 7: {
                    wrongChoseLimit = 0;
                    Task07.run();
                    break;
                }
                case 8: {
                    wrongChoseLimit = 0;
                    Task08.run();
                    break;
                }
                case 9: {
                    wrongChoseLimit = 0;
                    Task09.run();
                    break;
                }
                default: {
                    if (wrongChoseLimit++ < 2) {
                        int attemptCount = 3 - (wrongChoseLimit);
                        System.out.println(Ansi.colorize("Wrong chose, select again! there is ", Attribute.RED_TEXT()) + attemptCount + Ansi.colorize(" attempt left", Attribute.RED_TEXT()));
                    } else {
                        userChose = 0;
                        System.out.println(Ansi.colorize("You have made 3 mistakes, the program is shutting down", Attribute.RED_TEXT()));
                    }
                }
            }

        } while (userChose != 0);
        System.out.println(Ansi.colorize("Have Nice Day!!!!", Attribute.GREEN_TEXT()));
    }

    private static int getUserChose() {
        System.out.println(Ansi.colorize("Choose operation:", Attribute.YELLOW_TEXT()));
        System.out.print("\t");
        System.out.println(" 1. Select all authors ordered by first and last name");
        System.out.print("\t");
        System.out.println(" 2. Add new publisher");
        System.out.print("\t");
        System.out.println(" 3. Rename publisher");
        System.out.print("\t");
        System.out.println(" 4. Show ordered Tiles by chosen publisher");
        System.out.print("\t");
        System.out.println(" 5. Add new author");
        System.out.print("\t");
        System.out.println(" 6. Rename author by id");
        System.out.print("\t");
        System.out.println(" 7. Add new publisher");
        System.out.print("\t");
        System.out.println(" 8. Add new Title");
        System.out.print("\t");
        System.out.println(" 9. Add new authorISBN");
        System.out.print("\t");
        System.out.println(" 0. Exit");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }
}
