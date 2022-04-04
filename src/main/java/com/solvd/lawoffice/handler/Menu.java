package com.solvd.lawoffice.handler;

import com.solvd.lawoffice.exception.InvalidAreaException;
import com.solvd.lawoffice.exception.InvalidServiceException;
import com.solvd.lawoffice.exception.NoInputException;

import java.util.Scanner;

public abstract class Menu {

    public static void services() {
        System.out.println("Select an option and press Enter: \n");
        System.out.println("1- Counseling\n" +
                "2- Protection\n" +
                "3- Succession\n");
    }

    public static void area() {
        System.out.println("Select area: \n");
        System.out.println("1- Criminal\n" +
                "2- Labor\n" +
                "3- Family\n" +
                "4- Corporate\n" +
                "5- Civil\n" +
                "6- Business\n");
    }

    public static int selectService() throws InvalidServiceException, NoInputException {
        Scanner input = new Scanner(System.in);
        int option;

        option = input.nextInt();

        if (option == 0) {
            throw new NoInputException("No option selected, you must choose an option from the list and pres Enter");
        }
        if (option < 1 || option > 3) {
            throw new InvalidServiceException("Invalid service");
        }
        return option;
    }

    public static int selectArea() throws InvalidAreaException, NoInputException {
        Scanner input = new Scanner(System.in);
        int option;

        option = input.nextInt();

        if (option == 0) {
            throw new NoInputException("No option selected, you must choose an option from the list and pres Enter");
        }
        if (option < 1 || option > 6) {
            throw new InvalidAreaException("Invalid area");
        }
        return option;
    }
}
