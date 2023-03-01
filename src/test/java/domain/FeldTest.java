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

}