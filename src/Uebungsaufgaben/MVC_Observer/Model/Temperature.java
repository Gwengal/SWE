package Uebungsaufgaben.MVC_Observer.Model;

import Uebungsaufgaben.MVC_Observer.Interfaces.Observer;

import java.util.ArrayList;

public class Temperature {
    private double temperature;
    private ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Setter für Temperatur
     *
     * @param temperature Zu setzende Temperatur
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        this.notifyObservers();
    }

    /**
     * Observer hinzufügen
     *
     * @param observer Instanz des Observers
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Observer entfernen
     *
     * @param observer Instanz des Observers
     */
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    /**
     * Alle Observer benachrichtigen
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.temperature);
        }
    }
}
