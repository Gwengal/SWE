package Uebungsaufgaben.MVC_Observer.Controller;

import Uebungsaufgaben.MVC_Observer.Model.Temperature;
import Uebungsaufgaben.MVC_Observer.View.ConsoleView;
import Uebungsaufgaben.MVC_Observer.View.GraphicalView;

import java.util.Scanner;

public class TemperatureController {
    private Temperature temperature;
    private Scanner scanner;

    /**
     * Konstruktor
     *
     * @param temperature Instanz der Temperatur
     */
    public TemperatureController(Temperature temperature) {
        this.temperature = temperature;
        this.temperature.addObserver(new ConsoleView());
        this.temperature.addObserver(new GraphicalView());
        this.scanner = new Scanner(System.in);
    }

    /**
     * Temperatur-Eingaben aus der Konsole auslesen
     */
    public void userInp(){
        String inp = "";

        while(true){
            try {
                System.out.print("Geben Sie eine Temperatur ein (oder ein 'exit' zum Beenden): ");
                inp = scanner.nextLine();

                if(inp.equals("exit")){
                    break;
                }

                this.changeTemperature(Double.parseDouble(inp));
                System.out.print("\n\n\n");
            }catch (Exception e){
                System.out.printf("Ihre Eingabe [%s] ist keine gültige Zahl!\n\n\n", inp);
            }
        }
    }

    /**
     * Temperatur ändern
     *
     * @param newTemp Neuer Wert für die Temperatur
     */
    private void changeTemperature(double newTemp) {
        this.temperature.setTemperature(newTemp);
    }
}
