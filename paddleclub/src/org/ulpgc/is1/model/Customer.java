package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private NIF nif;
    private List<Reservation> reservations;

    public Customer(String name, String surname, String nif) {
        this.name = name;
        this.surname = surname;
        this.nif = new NIF(nif);
        this.reservations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public NIF getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif.setNumber(nif);
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
