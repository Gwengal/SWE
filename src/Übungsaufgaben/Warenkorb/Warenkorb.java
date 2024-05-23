package Übungsaufgaben.Warenkorb;

public class Warenkorb<T extends Comparable<T>> {
    private Node _oHead;

    class Node {
        private Node _oNext;
        private T _oElement;

        public Node(T element, Node node) {
            this._oElement = element;
            this._oNext = node;
        }
    }

    public void add(T element) {
        Node oNode = this._oHead;

        if (oNode == null || oNode._oElement.compareTo(element) > 0) {
            this._oHead = new Node(element, oNode);
        } else {
            while (oNode._oNext != null) {
                if (oNode._oNext._oElement.compareTo(element) > 0) {
                    break;
                }
                oNode = oNode._oNext;
            }

            oNode._oNext = new Node(element, oNode._oNext);
        }
    }

    public void delete(long id) {
        Node oNode = this._oHead;

        if (oNode != null) {
            if (oNode._oElement.equals(id)) {
                this._oHead = oNode._oNext;
            } else {
                while (oNode._oNext != null) {
                    if (oNode._oNext._oElement.equals(id)) {
                        oNode._oNext = oNode._oNext._oNext;
                    }

                    oNode = oNode._oNext;
                }
            }
        }
    }
}
