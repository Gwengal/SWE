package Uebungsaufgaben.Kartenspiel;

import java.util.Scanner;

public class Game {
    protected Player _oPlayer1, _oPlayer2;

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

    /**
     * ToDo
     */
    public void play() {
        // Spiel vorbereiten (Karten austeilen...)
        this.prepare();

        // Zufallszahl - Entweder 1 oder 2
        int iStart = (int) (Math.random() * 2) + 1;

        while (true) {
            try {
                System.out.println();
                iStart = this.playRound(iStart % 2);
                this._oPlayer1.amountCards();
                this._oPlayer2.amountCards();

                // 3 Sekunden warten (Sekunden in Millisekunden umrechnen)
                Thread.sleep(3 * 1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // Aktueller Spieler hat keine Karten mehr
                // --> Anderer Spieler hat das Spiel somit gewonnen
                try {
                    LostException eLe = (LostException) e;
                    System.out.printf("%s hat gewonnen!\n",
                            eLe.getPlayer().equals(this._oPlayer1) ? this._oPlayer2 : this._oPlayer1);
                } catch (ClassCastException eCast) {
                }
                break;
            }
        }
    }

    /**
     * 1. Merken der Farbe von der ersten Karte
     * 2. Wird solange gespielt bis:
     * - einer keine Karten mehr hat
     * - einer eine Karte mit der gleichen Farbe legt
     * --> Spieler bekommt alle Karte, die gespielt wurden
     * 
     * @param iStart
     * @return
     * @throws Exception
     */
    protected int playRound(int iIndex) throws Exception {
        Card oPlayed = null;
        Color firstColor = null;
        Player oPlayer = null;
        Stack<Card> oStack = new Stack<Card>(Card.MAXCARDS);

        while (true) {
            // Spieler bestimmen, welcher gerade am Zug ist
            oPlayer = (iIndex % 2 == 0 ? this._oPlayer2 : this._oPlayer1);
            // Oberste Karte aus dem Stapel ziehen
            oPlayed = oPlayer.draw();
            // Gespielte Karte auf den Stapel legen
            oStack.push(oPlayed);

            // Bei der aller ersten Karte der Runde, die Farbe merken
            if (firstColor == null) {
                firstColor = oPlayed.getColor();
                // Farbe der gespielten Karte stimmt mit der Farbe der ersten Karte überein
                // -> Runde gewonnen
                // -> Karten, die sich im Stapel "oStack" befinden, werden dem aktuellen Spieler
                // zugeordnet
            } else if (firstColor == oPlayed.getColor()) {
                System.out.printf("%s hat die Runde gewonnen.\n", oPlayer);
                oStack.mix();
                oPlayer.getStack().insert(oStack);
                break;
            }

            // 1 Sekunde warten (Sekunden in Millisekunden umrechnen)
            Thread.sleep(1 * 1000);
            iIndex++;
        }

        return iIndex;
    }

    /**
     * Spiel vorbereiten
     * - Kartenstapel mit allen Karten erzeugen
     * - Kartenstapel mischen
     * - Karten austeilen
     */
    protected void prepare() {
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
}