package domain;

import com.example.handandbrainchess.domain.Feld;
import com.example.handandbrainchess.domain.Figur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class FeldTest {


    @Test
    @DisplayName("Move Queen to 3,3 then to 4,2")
    void moveQueen_1(){
        Feld f = new Feld();
        f.init();
        f.move(0,3,3,3);
        f.move(3,3,4,2);


        assertThat(f.getFeld()[4][2].getType()).isEqualTo(Figur.QUEEN);
        assertThat(f.getFeld()[0][3]).isNull();

    }

    /*
     PAWNS Tests
     */
    @Test
    @DisplayName("Move Pawn 2 to 3,1 then to 4,1")
    void movePawn_1(){
        Feld f = new Feld();
        f.init();
        f.move(1,1,3,1);
        f.move(3,1,4,1);


        assertThat(f.getFeld()[4][1].getType()).isEqualTo(Figur.PAWN);
        assertThat(f.getFeld()[1][1]).isNull();

    }

    @Test
    @DisplayName("White Pawn forward 1")
    void moveWPawn_2(){
        Feld f = new Feld();
        f.init();
        f.move(6,0,5,0);

        assertThat(f.getFeld()[5][0].getType()).isEqualTo(Figur.PAWN);
        assertThat(f.getFeld()[6][0]).isNull();
    }
    @Test
    @DisplayName("White Pawn forward 2 from start")
    void moveWPawn_3(){
        Feld f = new Feld();
        f.init();
        f.move(6,0,4,0);

        assertThat(f.getFeld()[4][0].getType()).isEqualTo(Figur.PAWN);
        assertThat(f.getFeld()[6][0]).isNull();
    }
    @Test
    @DisplayName("White Pawn 1 forward but something is in the way")
    void moveWPawn_4(){
        Feld f = new Feld();
        f.init();
        f.move(1,0,2,0);
        f.move(2,0,3,0);
        f.move(3,0,4,0);
        f.move(4,0,5,0);
        //act
        f.move(6,0,5,0);

        assertThat(f.getFeld()[5][0].getTeam()).isEqualTo("black");
        assertThat(f.getFeld()[6][0].getType()).isEqualTo(Figur.PAWN);
    }
    @Test
    @DisplayName("White Pawn 2 forward something in the way")
    void moveWPawn_5(){
        Feld f = new Feld();
        f.init();
        f.move(1,0,2,0);
        f.move(2,0,3,0);
        f.move(3,0,4,0);
        f.move(4,0,5,0);
        //act
        f.move(6,0,4,0);

        assertThat(f.getFeld()[5][0].getTeam()).isEqualTo("black");
        assertThat(f.getFeld()[6][0].getType()).isEqualTo(Figur.PAWN);
    }
    @Test
    @DisplayName("White Pawn 2 forward from not the start")
    void moveWPawn_6(){
        Feld f = new Feld();
        f.init();
        f.move(6,0,5,0);
        //act
        f.move(5,0,3,0);

        assertThat(f.getFeld()[5][0].getType()).isEqualTo(Figur.PAWN);
        assertThat(f.getFeld()[3][0]).isNull();
    }
    @Test
    @DisplayName("White Pawn take")
    void moveWPawn_7(){
        Feld f = new Feld();
        f.init();
        f.move(6,0,4,0);
        f.move(1,1,3,1);
        //act
        f.move(4,0,3,1);

        assertThat(f.getFeld()[3][1].getTeam()).isEqualTo("white");
        assertThat(f.getFeld()[4][0]).isNull();
    }
    /*
    ROOK TESTS
     */
    @Test
    @DisplayName("Move Rook to 4,0")
    void moverook_1(){
        Feld f = new Feld();
        f.init();
        f.move(1,0,3,0);
        f.move(3,0,4,0);
        f.move(4,0,5,0);

        f.move(0,0,4,0);

        assertThat(f.getFeld()[4][0].getType()).isEqualTo(Figur.ROOK);
        assertThat(f.getFeld()[0][0]).isNull();
    }
    @Test
    @DisplayName("Move Rook to 4,0 then 4,4")
    void moverook_2(){
        Feld f = new Feld();
        f.init();
        f.move(1,0,3,0);
        f.move(3,0,4,0);
        f.move(4,0,5,0);

        f.move(0,0,4,0);
        f.move(4,0,4,4);

        assertThat(f.getFeld()[4][4].getType()).isEqualTo(Figur.ROOK);
        assertThat(f.getFeld()[0][0]).isNull();
    }
    @Test
    @DisplayName("Move Rook to 6,0 TAKE")
    void moverook_3(){
        Feld f = new Feld();
        f.init();
        f.move(1,0,3,0);
        f.move(3,0,4,0);
        f.move(4,0,5,0);
        f.move(5,0,6,1);

        f.move(0,0,6,0);

        assertThat(f.getFeld()[6][0].getType()).isEqualTo(Figur.ROOK);
        assertThat(f.getFeld()[0][0]).isNull();
    }
    @Test
    @DisplayName("Move Rook to 6,0 TAKE Backwards stuff at 2,0")
    void moverook_4(){
        Feld f = new Feld();
        f.init();
        f.move(1,0,3,0);
        f.move(3,0,4,0);
        f.move(4,0,5,0);
        f.move(5,0,6,1);
        f.move(6,4,4,4);


        f.move(0,0,6,0);
        f.move(7,5,2,0);
        f.move(6,0,2,0);

        assertThat(f.getFeld()[2][0].getType()).isEqualTo(Figur.ROOK);
        assertThat(f.getFeld()[0][0]).isNull();
        assertThat(f.getFeld()[7][5]).isNull();
    }

    /*
    BISHOP TESTS
     */
    @Test
    @DisplayName("Move Bishop to 2,0")
    void movebishop_1(){
        Feld f = new Feld();
        f.init();
        f.move(1,1,2,1);
        //act
        f.move(0,2,2,0);

        assertThat(f.getFeld()[2][0].getType()).isEqualTo(Figur.BISHOP);
        assertThat(f.getFeld()[0][2]).isNull();
    }
    @Test
    @DisplayName("Move white Bishop to 5,7")
    void movebishop_2(){
        Feld f = new Feld();
        f.init();
        f.move(6,6,5,6);
        //
        f.move(7,5,5,7);

        assertThat(f.getFeld()[5][7].getType()).isEqualTo(Figur.BISHOP);
        assertThat(f.getFeld()[7][5]).isNull();
    }
    @Test
    @DisplayName("Move white Bishop 7,5 to 2,0")
    void movebishop_3(){
        Feld f = new Feld();
        f.init();
        f.move(6,4,4,4);
        //
        f.move(7,5,2,0);

        assertThat(f.getFeld()[2][0].getType()).isEqualTo(Figur.BISHOP);
        assertThat(f.getFeld()[7][5]).isNull();
    }
    @Test
    @DisplayName("Move Black Bishop 0,2 to 5,7")
    void movebishop_4(){
        Feld f = new Feld();
        f.init();
        f.move(1,3,2,3);
        //
        f.move(0,2,5,7);

        assertThat(f.getFeld()[5][7].getType()).isEqualTo(Figur.BISHOP);
        assertThat(f.getFeld()[0][2]).isNull();
    }
    /*
     Knight
     */
    @Test
    @DisplayName("Move Knight to 2,0 then to 3,2")
    void moveKnight_1(){
        Feld f = new Feld();
        f.init();
        f.move(0,1,2,0);
        f.move(2,0,3,2);

        assertThat(f.getFeld()[3][2].getType()).isEqualTo(Figur.KNIGHT);
        assertThat(f.getFeld()[0][1]).isNull();

    }
    @Test
    @DisplayName("Move Knight onto own piece")
    void moveKnight_2(){
        Feld f = new Feld();
        f.init();
        f.move(6,5,6,4);
        //
        f.move(7,6,6,4);

        assertThat(f.getFeld()[6][4].getType()).isEqualTo(Figur.PAWN);
        assertThat(f.getFeld()[0][2]).isNotNull();
    }

    /*
     KING
     */
    @Test
    @DisplayName("Move King to 1,3 then to 2,2")
    void moveKing_1(){
        Feld f = new Feld();
        f.init();

        f.move(1,3,2,3);
        f.move(0,4,1,3);

        f.move(1,3,2,2);

        assertThat(f.getFeld()[2][2].getType()).isEqualTo(Figur.KING);
        assertThat(f.getFeld()[0][4]).isNull();

    }
}