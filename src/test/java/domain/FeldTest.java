package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class FeldTest {

    @Test
    @DisplayName("Move Rook to 0,5")
    void moverook_1(){
        Feld f = new Feld();
        f.init();
        f.move(0,0,0,5);

        assertThat(f.Feld[0][5].type).isEqualTo(Figur.ROOK);
        assertThat(f.Feld[0][0]).isNull();
    }
    @Test
    @DisplayName("Move Bishop to 2,0")
    void movebishop_1(){
        Feld f = new Feld();
        f.init();
        f.move(0,2,5,7);

        assertThat(f.Feld[5][7].type).isEqualTo(Figur.BISHOP);
        assertThat(f.Feld[0][2]).isNull();
    }
    @Test
    @DisplayName("Move Knight to 2,0 then to 3,2")
    void moveKnight_1(){
        Feld f = new Feld();
        f.init();
        f.move(0,1,2,0);
        f.move(2,0,3,2);

        assertThat(f.Feld[3][2].type).isEqualTo(Figur.KNIGHT);
        assertThat(f.Feld[0][1]).isNull();

    }
    @Test
    @DisplayName("Move Queen to 3,3 then to 4,2")
    void moveQueen_1(){
        Feld f = new Feld();
        f.init();
        f.move(0,3,3,3);
        f.move(3,3,4,2);


        assertThat(f.Feld[4][2].type).isEqualTo(Figur.QUEEN);
        assertThat(f.Feld[0][3]).isNull();

    }
}