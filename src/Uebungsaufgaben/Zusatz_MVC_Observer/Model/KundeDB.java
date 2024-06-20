package Uebungsaufgaben.Zusatz_MVC_Observer.Model;

import Uebungsaufgaben.Zusatz_MVC_Observer.Interfaces.Observer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KundeDB {
    private ArrayList<String> kunden = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addKunde(String kunde) {
        kunden.add(kunde);
        this.notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.kunden);
        }
    }
}
