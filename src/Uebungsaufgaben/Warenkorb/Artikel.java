package Uebungsaufgaben.Warenkorb;

// import java.util.Date;

// enum Unit {
//     mm, cm, dm, m
// }

public class Artikel implements Comparable<Artikel> {
    private long _lId;
    private String _sName;
    private double _dPreis;
    private boolean _isAvailable;
    // private Date _oMhd;
    // private double _dLength;
    // private double _dWidth;
    // private double _dHeight;
    // private Unit _eUom;

    public Artikel(String name, double preis, boolean avail) {
        // this._lId = Artikel.getNewId();
        this._sName = name;
        this._dPreis = preis;
        this._isAvailable = avail;
    }

    // private static long getNewId() {
    // return 0;
    // }

    @Override
    public String toString() {
        return String.format("Name: %s\tPreis: %.2f - Verfügbar[%s]", this.getName(), this.getPreis(),
                this._isAvailable);
    }

    public long getId() {
        return this._lId;
    }

    public String getName() {
        return this._sName;
    }

    public double getPreis() {
        return this._dPreis;
    }

    public boolean isAvailable() {
        return this._isAvailable;
    }

    @Override
    public int compareTo(Artikel o) {
        return (int) (this.getPreis() - o.getPreis());
    }
}
