package domain;

public class Feld {

    Figuren[][] Feld = new Figuren[8][8];

    public void init(){
        Feld[0][0] = new Figuren(Figur.ROOK,"black",true,0);
        Feld[0][1] = new Figuren(Figur.KNIGHT,"black",true,1);
        Feld[0][2] = new Figuren(Figur.BISHOP,"black",true,2);
        Feld[0][3] = new Figuren(Figur.QUEEN,"black",true,3);
        Feld[0][4] = new Figuren(Figur.KING,"black",true,4);
        Feld[0][5] = new Figuren(Figur.BISHOP,"black",true,5);
        Feld[0][6] = new Figuren(Figur.KNIGHT,"black",true,6);
        Feld[0][7] = new Figuren(Figur.ROOK,"black",true,7);
        Feld[7][0] = new Figuren(Figur.ROOK,"white",true,8);
        Feld[7][1] = new Figuren(Figur.KNIGHT,"white",true,9);
        Feld[7][2] = new Figuren(Figur.BISHOP,"white",true,10);
        Feld[7][3] = new Figuren(Figur.QUEEN,"white",true,11);
        Feld[7][4] = new Figuren(Figur.KING,"white",true,12);
        Feld[7][5] = new Figuren(Figur.BISHOP,"white",true,13);
        Feld[7][6] = new Figuren(Figur.KNIGHT,"white",true,14);
        Feld[7][7] = new Figuren(Figur.ROOK,"white",true,15);
    }//Maybe in einer Hashmap speichern ? mit positionen oder wie dursuchen
    public void move(int altesfeldhorinzontal, int altesfeldvertikal,int feldhorizontal, int feldvertikal){
        if(feldhorizontal<Feld.length && feldvertikal<Feld[0].length) {
           Feld[feldhorizontal][feldvertikal] = Feld[altesfeldhorinzontal][altesfeldvertikal];
           Feld[altesfeldhorinzontal][altesfeldvertikal] = null;
        }
    }
}
