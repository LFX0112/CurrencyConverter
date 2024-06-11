package Main;

import Connect.ConnectAPI;
import FileGenerator.CreateFile;
import FileWriter.SaveFile;

import java.text.DecimalFormat;
import java.util.*;

public class Units {
    private String start;
    Scanner keyboard = new Scanner(System.in);
    DecimalFormat formatter = new DecimalFormat("0");
    double converting;
    SaveFile save;
    List<SaveFile> saveFiles = new ArrayList<>();
    Map<String, Double> currencies;
    CreateFile createFile;
    ConnectAPI apiConnect = new ConnectAPI();
    double saveCalc;

    public String start(int option) {
        System.out.print("Type amount to convert: ");
        while(!keyboard.hasNextDouble()){
            System.out.print("Type amount to convert: ");
            keyboard.next();
        }
        converting = keyboard.nextDouble();

        switch (option) {
            case 1:
                currencies = apiConnect.usage("EUR").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("USD")));
                save = new SaveFile("Euro to US Dollar", "USD", "EUR", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in US Dollars is: " + saveCalc + " USD\n";
                break;
            case 2:
                currencies = apiConnect.usage("USD").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("EUR")));
                save = new SaveFile("US Dollar to Euro", "EUR", "USD", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in Euros is: " + saveCalc + " EUR\n";
                break;
            case 3:
                currencies = apiConnect.usage("COP").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("USD")));
                save = new SaveFile("Colombian Peso to US Dollar", "USD", "COP", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in US Dollars is: " + saveCalc + " USD\n";
                break;
            case 4:
                currencies = apiConnect.usage("USD").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("COP")));
                save = new SaveFile("US Dollar to Colombian Peso", "COP", "EUR", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in Pesos is: " + saveCalc + " COP\n";
                break;
            case 5:
                currencies = apiConnect.usage("ARS").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("USD")));
                save = new SaveFile("Argentine Peso to US Dollar", "ARS", "USD", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in Pesos is: " + saveCalc + " ARS\n";
                break;
            case 6:
                currencies = apiConnect.usage("USD").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("ARS")));
                save = new SaveFile("US Dollar to Argentine Peso", "USD", "ARS", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in US Dollars is: " + saveCalc + " USD\n";
                break;
            case 7:
                currencies = apiConnect.usage("BRL").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("USD")));
                save = new SaveFile("Brazilian Real to US Dollar", "BRL", "USD", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in US Dollars is: " + saveCalc + " USD\n";
                break;
            case 8:
                currencies = apiConnect.usage("USD").conversion_rates();
                saveCalc = Double.parseDouble(formatter.format(converting * currencies.get("BRL")));
                save = new SaveFile("Brazilian Real to US Dollar", "USD", "BRL", converting, saveCalc);
                saveFiles.add(save);
                start = "\nThe value in Real is: " + saveCalc + " BRL\n";
                break;
            default:
                start = "App has been stopped!\n";
        }
        createFile = new CreateFile(saveFiles);
        return start;
    }
}