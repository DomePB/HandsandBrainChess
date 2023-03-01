package domain;

public class Feld {

    Figuren[][] Feld = new Figuren[8][8];

    public void init(){
        //Black
        Feld[0][0] = new Figuren(Figur.ROOK,"black",true,0);
        Feld[0][1] = new Figuren(Figur.KNIGHT,"black",true,1);
        Feld[0][2] = new Figuren(Figur.BISHOP,"black",true,2);
        Feld[0][3] = new Figuren(Figur.QUEEN,"black",true,3);
        Feld[0][4] = new Figuren(Figur.KING,"black",true,4);
        Feld[0][5] = new Figuren(Figur.BISHOP,"black",true,5);
        Feld[0][6] = new Figuren(Figur.KNIGHT,"black",true,6);
        Feld[0][7] = new Figuren(Figur.ROOK,"black",true,7);
        //Pawns
        Feld[1][0] = new Figuren(Figur.PAWN,"black",true,8);
        Feld[1][1] = new Figuren(Figur.PAWN,"black",true,9);
        Feld[1][2] = new Figuren(Figur.PAWN,"black",true,10);
        Feld[1][3] = new Figuren(Figur.PAWN,"black",true,11);
        Feld[1][4] = new Figuren(Figur.PAWN,"black",true,12);
        Feld[1][5] = new Figuren(Figur.PAWN,"black",true,13);
        Feld[1][6] = new Figuren(Figur.PAWN,"black",true,14);
        Feld[1][7] = new Figuren(Figur.PAWN,"black",true,15);
        //White
        Feld[7][0] = new Figuren(Figur.ROOK,"white",true,16);
        Feld[7][1] = new Figuren(Figur.KNIGHT,"white",true,17);
        Feld[7][2] = new Figuren(Figur.BISHOP,"white",true,18);
        Feld[7][3] = new Figuren(Figur.QUEEN,"white",true,19);
        Feld[7][4] = new Figuren(Figur.KING,"white",true,20);
        Feld[7][5] = new Figuren(Figur.BISHOP,"white",true,21);
        Feld[7][6] = new Figuren(Figur.KNIGHT,"white",true,22);
        Feld[7][7] = new Figuren(Figur.ROOK,"white",true,23);
        //Pawns
        Feld[6][0] = new Figuren(Figur.PAWN,"black",true,24);
        Feld[6][1] = new Figuren(Figur.PAWN,"black",true,25);
        Feld[6][2] = new Figuren(Figur.PAWN,"black",true,26);
        Feld[6][3] = new Figuren(Figur.PAWN,"black",true,27);
        Feld[6][4] = new Figuren(Figur.PAWN,"black",true,28);
        Feld[6][5] = new Figuren(Figur.PAWN,"black",true,29);
        Feld[6][6] = new Figuren(Figur.PAWN,"black",true,30);
        Feld[6][7] = new Figuren(Figur.PAWN,"black",true,31);
    }//Maybe in einer Hashmap speichern ? mit positionen oder wie dursuchen
    public void move(int altesfeldhorinzontal, int altesfeldvertikal,int feldhorizontal, int feldvertikal){
        if(feldhorizontal<Feld.length && feldvertikal<Feld[0].length) {
            if(checkLegalmove(altesfeldhorinzontal,altesfeldvertikal,feldhorizontal,feldvertikal)){
                Feld[feldhorizontal][feldvertikal] = Feld[altesfeldhorinzontal][altesfeldvertikal];
                Feld[altesfeldhorinzontal][altesfeldvertikal] = null;
            }

        }
    }

    public boolean checkLegalmove(int altesfeldhorinzontal, int altesfeldvertikal,int feldhorizontal, int feldvertikal){
        switch(Feld[altesfeldhorinzontal][altesfeldvertikal].type){
            case ROOK : if(altesfeldhorinzontal == feldhorizontal  || altesfeldvertikal == feldvertikal) return true;
            case BISHOP: if(Math.abs(altesfeldhorinzontal - feldhorizontal) == Math.abs(altesfeldvertikal - feldvertikal)) return true;
            case KNIGHT: if(Math.abs(altesfeldhorinzontal-feldhorizontal) ==2 && Math.abs(altesfeldvertikal-feldvertikal) == 1 || Math.abs(altesfeldhorinzontal -feldhorizontal) ==1 && Math.abs(altesfeldvertikal-feldvertikal)==2)return true;
            case QUEEN: if(altesfeldhorinzontal == feldhorizontal  || altesfeldvertikal == feldvertikal) return true; else if (Math.abs(altesfeldhorinzontal - feldhorizontal) == Math.abs(altesfeldvertikal - feldvertikal)) return true;
            case KING: if(Math.abs(altesfeldhorinzontal-feldhorizontal) <=1 && Math.abs(altesfeldvertikal-feldvertikal) <=1 ) return true;
            case PAWN: if(altesfeldhorinzontal == 1 && Feld[altesfeldhorinzontal][altesfeldvertikal].team == "black"){
                if(Math.abs(altesfeldhorinzontal-feldhorizontal)<=2)return true;} else if ((Math.abs(altesfeldhorinzontal-feldhorizontal)==1)) {return true;} //Pawn kann noch gerade aus schlagen und nicht zur Seite
            default : return false;
        }
    }
}