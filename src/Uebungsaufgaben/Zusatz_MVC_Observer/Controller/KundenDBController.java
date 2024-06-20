package Uebungsaufgaben.Zusatz_MVC_Observer.Controller;

import Uebungsaufgaben.Zusatz_MVC_Observer.Model.KundeDB;

import java.util.Scanner;

public class KundenDBController {
    private KundeDB kundeDB;
    private Scanner scanner;

    public KundenDBController(KundeDB kundeDB) {
        this.kundeDB = kundeDB;
        // ToDo Observer hinzufügen
        this.scanner = new Scanner(System.in);
    }

    public void userInp(){
        while(true){
            try {


            }catch (Exception e) {

            }
        }
    }
}
