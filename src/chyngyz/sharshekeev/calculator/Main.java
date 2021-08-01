package chyngyz.sharshekeev.calculator;

import java.util.Scanner;

public class Main {
    private static boolean its_an_arabic_numbers = true;

    private static String[] pars(String input) {
        String[] parsed_input = input.split(" ");
        if (parsed_input.length != 3) {
            Scanner input_a_value_again = new Scanner(System.in);
            System.out.println("Invalid input");
            input = input_a_value_again.nextLine();
            return pars(input);
        } else {
            return parsed_input;
        }
    }


    public static void main(String[] args) {

        Scanner input_a_value = new Scanner(System.in);
        System.out.print("Enter the operation: ");
        String input = input_a_value.nextLine();
        while (!input.isEmpty()) {
            String[] parsed_input = Main.pars(input);
            String operation = parsed_input[1];
            Calculable values;
            int value1 = 0;
            int value2 = 0;

            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);
            } catch (NumberFormatException e) {
                its_an_arabic_numbers = false;
                System.out.println("Error");
            }

            if (its_an_arabic_numbers) {
                values = new Arab(value1, value2);
            } else {
                values = new Roman(parsed_input[0], parsed_input[2]);
            }

            if (operation.equals("+")) {
                values.addition();
            } else if (operation.equals("-")) {
                values.subtraction();
            } else if (operation.equals("*")) {
                values.multiple();
            } else if (operation.equals("/")) {
                values.division();
            }

            if (its_an_arabic_numbers) {
                System.out.println("Result: " + values.getResult());
            } else {
                System.out.println("Result: " + values.getStringResult());
            }

            System.out.print("Enter next operation: ");
            input = input_a_value.nextLine();
        }
        System.out.println("Out of service");
    }
}
