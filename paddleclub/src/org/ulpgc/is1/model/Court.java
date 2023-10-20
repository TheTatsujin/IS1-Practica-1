package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Court {
    private String name;
    private int price;
    private CourtType type;

    private final List<Reservation> reservations;

    public Court(String name, int price, CourtType type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.reservations = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CourtType getType() {
        return type;
    }

    public void setType(CourtType type) {
        this.type = type;
    }

    public Reservation getReservation(int index){
        return this.reservations.get(index);
    }

    public int reservationCount(){
        return this.reservations.size();
    }

    public void addReservation(Reservation newReservation){
        if (!this.reservations.contains(newReservation)){
            this.reservations.add(newReservation);
        }
    }


}
