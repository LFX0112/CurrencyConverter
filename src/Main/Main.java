package Main;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        boolean whileBoolean = true;
        Units units = new Units();
        int option;

        String mainMenu = """
                    Welcome to Alura's currency converter\n
                    **********************************
                    1) Euro to US Dollar
                    2) US Dollar to Euro
                    3) Colombian Peso to US Dollar
                    4) US Dollar to Colombian Peso
                    5) Argentine Peso to US Dollar
                    6) US Dollar to Argentine Peso
                    7) Brazilian Real to US Dollar
                    8) US Dollar to Brazilian Real
                    9) Exit
                    **********************************
                    """;

        while(true) {
            System.out.println(mainMenu);
            System.out.println("Select Option");
            while(!keyboard.hasNextInt()){
                System.out.println(mainMenu);
                keyboard.next();
            }
            option = keyboard.nextInt();
            if (option  >= 9 || option <= 0){
                break;
            }
            System.out.println(units.start(option));
        }
    }
}