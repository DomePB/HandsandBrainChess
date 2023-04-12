package com.example.handandbrainchess.domain;

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
        Feld[6][0] = new Figuren(Figur.PAWN,"white",true,24);
        Feld[6][1] = new Figuren(Figur.PAWN,"white",true,25);
        Feld[6][2] = new Figuren(Figur.PAWN,"white",true,26);
        Feld[6][3] = new Figuren(Figur.PAWN,"white",true,27);
        Feld[6][4] = new Figuren(Figur.PAWN,"white",true,28);
        Feld[6][5] = new Figuren(Figur.PAWN,"white",true,29);
        Feld[6][6] = new Figuren(Figur.PAWN,"white",true,30);
        Feld[6][7] = new Figuren(Figur.PAWN,"white",true,31);
    }//Maybe in einer Hashmap speichern ? mit positionen oder wie dursuchen
    public void move(int altesfeldReihe, int altesfeldSpalte,int neuesFeldReihe, int neuesFeldSpalte){
        if(neuesFeldReihe<Feld.length && neuesFeldSpalte<Feld[0].length) {
            if(checkLegalmove(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte)){
                Feld[neuesFeldReihe][neuesFeldSpalte] = Feld[altesfeldReihe][altesfeldSpalte];
                Feld[altesfeldReihe][altesfeldSpalte] = null;
            }

        }
    }

    public boolean checkLegalmove(int altesfeldReihe, int altesfeldSpalte,int neuesFeldReihe, int neuesFeldSpalte){
        switch(Feld[altesfeldReihe][altesfeldSpalte].getType()){
            case ROOK : if(collisionCheckROOK(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte)) return true; else break; //altesfeldReihe == neuesFeldReihe  || altesfeldSpalte == neuesFeldSpalte
            case BISHOP: if(collisionCheckBISHOP(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte)) return true; else break;
            case KNIGHT: if(collisionCheckKnight(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte))return true; else break;
            case QUEEN: if(altesfeldReihe == neuesFeldReihe  || altesfeldSpalte == neuesFeldSpalte) {if(collisionCheckROOK(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte)) return true; else break;}
            else if (Math.abs(altesfeldReihe - neuesFeldReihe) == Math.abs(altesfeldSpalte - neuesFeldSpalte)) {if(collisionCheckBISHOP(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte))return true; else break;} else break;
            case KING: if(collisionCheckKing(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte)) return true; else break;
            case PAWN: if(collisionCheckPawn(altesfeldReihe,altesfeldSpalte,neuesFeldReihe,neuesFeldSpalte)){return true;} else break; //Pawn kann noch gerade aus schlagen und nicht zur Seite
            default : return false;

        }
        return false;
    }
    private boolean collisionCheckROOK(int altesfeldReihe, int altesfeldSpalte,int neuesFeldReihe, int neuesFeldSpalte){
        if(altesfeldReihe == neuesFeldReihe){
            if(altesfeldSpalte < neuesFeldSpalte){
                for(int i = altesfeldSpalte+1; i < neuesFeldSpalte; i++){
                    if(Feld[neuesFeldReihe][i] != null){
                        return false;
                    }
                }
            } else if (altesfeldSpalte > neuesFeldSpalte) {
                for(int i = altesfeldSpalte-1; i > neuesFeldSpalte; i--){
                    if(Feld[neuesFeldReihe][i] != null){
                        return false;
                    }
                }
            }
        } else if (altesfeldSpalte == neuesFeldSpalte){
            if (altesfeldReihe < neuesFeldReihe){
                for(int i = altesfeldReihe+1; i < neuesFeldReihe; i++){
                    if(Feld[i][altesfeldSpalte] != null){
                         return false;
                    }
                }
            } else if (altesfeldReihe > neuesFeldReihe) {
                for(int i = altesfeldReihe-1; i > neuesFeldReihe; i--){
                    if(Feld[i][altesfeldSpalte] != null){
                        return false;
                    }
                }
            }
        }
        if(Feld[neuesFeldReihe][neuesFeldSpalte]!= null){
            if(Feld[altesfeldReihe][altesfeldSpalte].EqualTeam(Feld[neuesFeldReihe][neuesFeldSpalte])){
                return false;
            }
        }
        return true;
    }
    private boolean collisionCheckBISHOP(int altesFeldReihe, int altesFeldSpalte, int neuesFeldReihe, int neuesFeldSpalte){
        if(Math.abs(altesFeldReihe - neuesFeldReihe) == Math.abs(altesFeldSpalte - neuesFeldSpalte)){
            if (altesFeldReihe < neuesFeldReihe){
                if (altesFeldSpalte < neuesFeldSpalte){
                    for(int i = 1; altesFeldReihe+i< neuesFeldReihe; i++){
                        if (Feld[altesFeldReihe+i][altesFeldSpalte+i] != null){
                            return false;
                        }
                    }
                }
                else { //altesFeldSpalte > neuesFeldSpalte
                    for(int i = 1; altesFeldReihe+i< neuesFeldReihe; i++){
                        if (Feld[altesFeldReihe+i][altesFeldSpalte-i] != null){
                            return false;
                        }
                    }
                }
            } else { //altesFeldReihe > neuesFeldReihe
                if (altesFeldSpalte < neuesFeldSpalte) {
                    for (int i =  1; altesFeldReihe-i > neuesFeldReihe; i++) {
                        if (Feld[altesFeldReihe - i][altesFeldSpalte + i] != null) {
                            return false;
                        }
                    }
                }else {//altesFeldSpalte > neuesFeldSpalte
                    if (altesFeldSpalte > neuesFeldSpalte) {
                        for (int i = 1; altesFeldReihe-i >= neuesFeldReihe; i++) {
                            if (Feld[altesFeldReihe - i][altesFeldSpalte - i] != null) {
                                return false;
                            }
                        }
                    }
                }
            }
            if(Feld[neuesFeldReihe][neuesFeldSpalte]!= null) {
                if (Feld[altesFeldReihe][altesFeldSpalte].EqualTeam(
                        Feld[neuesFeldReihe][neuesFeldSpalte])) {
                    return false;
                }
            }
            return true;
        }
       return false;
    }
    private boolean collisionCheckPawn(int altesFeldReihe, int altesFeldSpalte, int neuesFeldReihe, int neuesFeldSpalte) {
        if (Math.abs(altesFeldReihe - neuesFeldReihe) == 1) {
          if (Feld[neuesFeldReihe][neuesFeldSpalte] == null) {
              if(Feld[altesFeldReihe][altesFeldSpalte].team == "white" && altesFeldReihe > neuesFeldReihe) {
                  return true;
              } else if (Feld[altesFeldReihe][altesFeldSpalte].team == "black" && altesFeldReihe < neuesFeldReihe) {
                  return true;
              }
              return false;
          }
            if (Feld[altesFeldReihe][altesFeldSpalte].team == "white") {
             if (Feld[neuesFeldReihe][neuesFeldSpalte ].team == "black" && Math.abs(altesFeldSpalte-neuesFeldSpalte)==1) {
                 return true;
               }

            }
          if (Feld[altesFeldReihe][altesFeldSpalte].team == "black") {
             if (Feld[neuesFeldReihe][neuesFeldSpalte].team == "white" && Math.abs(altesFeldSpalte-neuesFeldSpalte)==1){// null check muss noch gemacht werden
                 return true;
              }
         }
        return false;
    }
        else {//2 Moves von Start
            if (Math.abs(altesFeldReihe - neuesFeldReihe) == 2) {
                if(Feld[altesFeldReihe][altesFeldSpalte].getTeam() == "black" && altesFeldReihe ==1){
                    if(Feld[altesFeldReihe+1][altesFeldSpalte] == null){
                        if(Feld[neuesFeldReihe][neuesFeldSpalte]== null){
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                if(Feld[altesFeldReihe][altesFeldSpalte].getTeam() == "white" && altesFeldReihe ==6){
                    if(Feld[altesFeldReihe-1][altesFeldSpalte] == null){
                        if(Feld[neuesFeldReihe][neuesFeldSpalte]== null){
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
            }
            return false;
        }
    }

    private boolean collisionCheckKnight(int altesFeldReihe, int altesFeldSpalte, int neuesFeldReihe, int neuesFeldSpalte){
        if(Math.abs(altesFeldReihe-neuesFeldReihe) ==2 && Math.abs(altesFeldSpalte-neuesFeldSpalte) == 1 || Math.abs(altesFeldReihe -neuesFeldReihe) ==1 && Math.abs(altesFeldSpalte-neuesFeldSpalte)==2){
            if(Feld[neuesFeldReihe][neuesFeldSpalte]==null){
                return true;
            }
            if(Feld[altesFeldReihe][altesFeldSpalte].EqualTeam(Feld[neuesFeldReihe][neuesFeldSpalte])){
                return false;
            }
            return true;
        }
       return false;
    }
    private boolean collisionCheckKing(int altesFeldReihe, int altesFeldSpalte, int neuesFeldReihe, int neuesFeldSpalte){
        if(Math.abs(altesFeldReihe-neuesFeldReihe) <=1 && Math.abs(altesFeldSpalte-neuesFeldSpalte) <=1) {
            if(Feld[neuesFeldReihe][neuesFeldSpalte]==null){
                return true;
            }
            if(Feld[altesFeldReihe][altesFeldSpalte].EqualTeam(Feld[neuesFeldReihe][neuesFeldSpalte])){
                return false;
            }
            return true;
        }
        return false;
    }

    public  Figuren getPosition(int row, int column) {
        return Feld[row][column];
    }
    public Figuren[][] getFeld(){
        return Feld;
    }
}
