package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Extra{
    private int price;
    private List<Reservation> reservations;
    abstract public String getName();

    public Extra(int price) {
        this.price = price;
        this.reservations = new ArrayList<>();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Reservation getReservation(int index){
        return this.reservations.get(index);
    }

    public int reservationCount(){
        return this.reservations.size();
    }

    public void addReservation(Reservation newReservation){
        this.reservations.add(newReservation);
    }

}
