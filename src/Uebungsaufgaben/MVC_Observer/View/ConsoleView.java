package Uebungsaufgaben.MVC_Observer.View;

import Uebungsaufgaben.MVC_Observer.Interfaces.Observer;

public class ConsoleView implements Observer {
    @Override
    public void update(double temperature) {
        System.out.printf("%s: Die aktuelle Temperatur ist %.1f Grad.\n", this.getClass().getSimpleName(), temperature);
    }
}
