package domain;

public class Feld {

    Figuren[][] Feld = new Figuren[8][8];

    public void init(){
        Feld[0][0] = new Figuren(Figur.ROOK,"black",true);
        Feld[0][1] = new Figuren(Figur.KNIGHT,"black",true);
        Feld[0][2] = new Figuren(Figur.BISHOP,"black",true);
        Feld[0][3] = new Figuren(Figur.QUEEN,"black",true);
        Feld[0][4] = new Figuren(Figur.KING,"black",true);
        Feld[0][5] = new Figuren(Figur.BISHOP,"black",true);
        Feld[0][6] = new Figuren(Figur.KNIGHT,"black",true);
        Feld[0][7] = new Figuren(Figur.ROOK,"black",true);
        Feld[7][0] = new Figuren(Figur.ROOK,"white",true);
        Feld[7][1] = new Figuren(Figur.KNIGHT,"white",true);
        Feld[7][2] = new Figuren(Figur.BISHOP,"white",true);
        Feld[7][3] = new Figuren(Figur.QUEEN,"white",true);
        Feld[7][4] = new Figuren(Figur.KING,"white",true);
        Feld[7][5] = new Figuren(Figur.BISHOP,"white",true);
        Feld[7][6] = new Figuren(Figur.KNIGHT,"white",true);
        Feld[7][7] = new Figuren(Figur.ROOK,"white",true);
    }
}
