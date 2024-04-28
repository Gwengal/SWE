package Übungsaufgaben.Kartenspiel;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void startGame(){
        String sInput;
        Player oPlayer1, oPlayer2;
        Random oRandom = new Random();
        Scanner oScanner = new Scanner(System.in);
        
        while (true) {
            // Spielernamen erfassen und die dazugehörigen Objekte initiieren
            oPlayer1 = this.recordPlayer(1, oScanner);
            oPlayer2 = this.recordPlayer(2, oScanner);

            System.out.println("Spiel beginnt. Viel Spaß!\n\n\n");    
            
            // Spiel ausführen
            this.execute(oPlayer1, oPlayer2, oRandom);
            
            System.out.print("Noch eine Runde [y/Y]?");
            sInput = oScanner.nextLine(); 
            
            // Noch eine Runde ausführen
            if (sInput.contains("y") || sInput.contains("Y")) {
                System.out.println("\n\n\n\n");
                continue;                
            }

            // Schleife verlassen
            break;
        }
    }

    /**
     * Spielernamen erfassen
     * 
     * @param iIndex
     * @param oScan
     * @return
     */
    private Player recordPlayer(int iIndex, Scanner oScan){
        System.out.printf("%d. Spieler - Namen erfassen: ");
        String sInput = oScan.nextLine();
        System.out.println();

        return new Player(sInput, new Stack<Card>(Card.MAXCARDS));
    }

    private void execute(Player oPlayer1, Player oPlayer2, Random oRandom){
        
    }
}
