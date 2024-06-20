package Uebungsaufgaben.MVC_Observer.View;

import Uebungsaufgaben.MVC_Observer.Interfaces.Observer;

public class GraphicalView implements Observer {
    @Override
    public void update(double temperature) {
        System.out.printf("%s: Aktualisierung der grafischen Anzeige mit der Temperatur %.1f Grad.\n", this.getClass().getSimpleName(), temperature);
    }
}
