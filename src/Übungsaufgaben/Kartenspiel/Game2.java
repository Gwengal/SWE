package Übungsaufgaben.Kartenspiel;

public class Game2 extends Game {

    public static void main(String[] args) {
        Game2 oGame = new Game2();
        oGame.play();
    }

    @Override
    protected int playRound(int iIndex) throws Exception {
        Card oFCard = null, oSCard = null;
        Player oPlayer = null;
        Stack<Card> oStack = new Stack<Card>(Card.MAXCARDS);

        while (true) {
            // Spieler bestimmen, welcher gerade am Zug ist
            oPlayer = (iIndex % 2 == 0 ? this._oPlayer2 : this._oPlayer1);

            // Erster Spieler ist am Zug
            // -> Nächster Schleifen
            if (oFCard == null) {
                oFCard = oPlayer.draw();
                oStack.push(oFCard);
            } else {
                // Zweiter Spieler ist dran
                oSCard = oPlayer.draw();
                oStack.push(oSCard);

                // Unentschieden
                // -> Noch eine Runde spielen
                if (oFCard.compare(oSCard) == 0) {
                    oFCard = null;
                    oSCard = null;
                }
                // Spieler der die zweite Kafte gelegt hat, hat die Runde gewonnen
                else if (oFCard.compare(oSCard) < 0) {
                    oStack.mix();
                    oPlayer.getStack().insert(oStack);
                    System.out.printf("%s hat die Runde gewonnen.\n", oPlayer);
                    break;
                }
                // Spieler der die erste Karte gelegt hat, hat die Runde gewonnen
                else if (oFCard.compare(oSCard) > 0) {
                    oStack.mix();
                    oPlayer = (oPlayer.equals(this._oPlayer1) ? this._oPlayer2 : this._oPlayer1);
                    oPlayer.getStack().insert(oStack);
                    System.out.printf("%s hat die Runde gewonnen.\n", oPlayer);
                    break;
                }

            }

            // 1 Sekunde warten (Sekunden in Millisekunden umrechnen)
            Thread.sleep(1 * 1000);
            iIndex++;
        }

        return iIndex;
    }

}