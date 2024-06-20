package Uebungsaufgaben.MVC_Observer;

import Uebungsaufgaben.MVC_Observer.Controller.TemperatureController;
import Uebungsaufgaben.MVC_Observer.Model.Temperature;

public class Test {
    public static void main(String[] args) {
        TemperatureController controller = new TemperatureController(new Temperature());
        controller.userInp();
    }
}
