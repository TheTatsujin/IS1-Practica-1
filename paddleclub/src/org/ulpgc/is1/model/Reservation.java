package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private static int NEXT_ID = 0;
    private Date date;
    private final int id;
    private List<Extra> extras;
    public Reservation(Date date, int id) {
        NEXT_ID++;
        this.date = date;
        this.id = id;
        this.extras = new ArrayList<>();
    }
    public void addExtra(Extra extra){
        this.extras.add(extra);
    }
    public void removeExtra(int indx){
        this.extras.remove(indx);
    }
    public void removeExtra(Extra extra){
        this.extras.remove(extra);
    }
    public int price(){
        int resultado = 0;
        for (Extra i: this.extras) {
            resultado += i.getPrice();
        } return resultado;
    }
}
