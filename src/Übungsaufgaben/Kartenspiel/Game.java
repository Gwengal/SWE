package Übungsaufgaben.Kartenspiel;

import java.util.Scanner;

public class Game {
    private Player _oPlayer1, _oPlayer2;

    public static void main(String[] args) {
        Game oGame = new Game();
        oGame.play();
    }

    /**
     * Konstruktor
     */
    public Game() {
        Scanner oScan = new Scanner(System.in);

        System.out.print("Spieler 1 - Namen erfassen: ");
        this._oPlayer1 = new Player(oScan.nextLine());
        System.out.print("Spieler 2 - Namen erfassen: ");
        this._oPlayer2 = new Player(oScan.nextLine());

        oScan.close();
    }

    public void play() {
        // Spiel vorbereiten (Karten austeilen...)
        this.prepare();

        // Zufallszahl - Entweder 1 oder 2
        int iStart = (int) (Math.random() * 2) + 1;

        while (true) {
            this.playRound(iStart++);
        }

    }

    private int playRound(int iStart) {
        int iIndex = iStart;
        Card oPlayed = null;
        Color firstColor = null;
        Player oPlayer = null;
        Stack<Card> oStack = new Stack<Card>(Card.MAXCARDS);

        while (true) {
            try {
                // Spieler bestimmen, welcher gerade am Zug ist
                oPlayer = (iIndex++ % 2 == 0 ? this._oPlayer2 : this._oPlayer1);
                // Oberste Karte aus dem Stapel ziehen
                oPlayed = oPlayer.getStack().pop();
                // Gespielte 
                oStack.push(oPlayed);


                // Bei der aller ersten Karte der Runde, die Farbe merken
                if (iIndex == iStart) {
                    firstColor = oPlayed.getColor();                  
                // Farbe der gespielten Karte stimmt mit der Farbe der ersten Karte überein
                // --> Runde gewonnen      
                } else if(firstColor == oPlayed.getColor()){

                }

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    /**
     * Spiel vorbereiten
     * - Kartenstapel mit allen Karten erzeugen
     * - Kartenstapel mischen
     * - Karten austeilen
     */
    private void prepare() {
        // Kartenstapel erzeugen
        Stack<Card> oStack = new Stack<Card>(Card.MAXCARDS, Card.allCards());

        // Kartenstapel mischen
        oStack.mix();

        int iIndex = 0;
        Player oPlayer = null;
        while (true) {
            try {
                // Spieler (je Schleifendurchlauf) bestimmen, welcher die nächste
                // Karte bekommt
                oPlayer = (iIndex++ % 2 == 0 ? this._oPlayer2 : this._oPlayer1);
                // Oberste Karte aus dem Stapel dem aktuellen Spieler zuordnen
                oPlayer.getStack().push(oStack.pop());
            } catch (Exception e) {
                // Schleife verlassen, da keine Karten mehr im Stapel vorhanden sind
                break;
            }
        }
    }

    public void startGame() {
        // String sInput;
        // Player oPlayer1, oPlayer2;
        // Random oRandom = new Random();
        // Scanner oScanner = new Scanner(System.in);

        // while (true) {
        // // Spielernamen erfassen und die dazugehörigen Objekte initiieren
        // oPlayer1 = this.recordPlayer(1, oScanner);
        // oPlayer2 = this.recordPlayer(2, oScanner);

        // System.out.println("Spiel beginnt. Viel Spaß!\n\n\n");

        // // Spiel ausführen
        // this.execute(oPlayer1, oPlayer2, oRandom);

        // System.out.print("Noch eine Runde [y/Y]?");
        // sInput = oScanner.nextLine();

        // // Noch eine Runde ausführen
        // if (sInput.contains("y") || sInput.contains("Y")) {
        // System.out.println("\n\n\n\n");
        // continue;
        // }

        // // Schleife verlassen
        // break;
        // }
    }
}
