package com.example.handandbrainchess.Service;

import com.example.handandbrainchess.domain.Feld;
import com.example.handandbrainchess.domain.Figuren;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    private Feld SpielFeld = new Feld();

    public void init(){
        SpielFeld.init();
    }
    public Figuren getPosition(int row, int column){
        return SpielFeld.getPosition(row,column);
    }
    public Figuren[][] getFeld(){
        return SpielFeld.getFeld();
    }

}
