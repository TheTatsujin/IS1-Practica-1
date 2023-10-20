package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private static int NEXT_ID = 0;
    private Date date;
    private final int id;
    private Court court;
    private Customer customer;
    private List<Extra> extras;
    public Reservation(Customer customer, Court court, Date date) {
        this.customer = customer;
        this.court = court;


        this.date = date;
        this.id = ++NEXT_ID;
        this.extras = new ArrayList<>();
    }
    public void addExtra(Extra extra){
        if (!this.extras.contains(extra)){
            this.extras.add(extra);
        }
    }

    public void removeExtra(int index){
        this.extras.remove(index);
    }
    public void removeExtra(Extra extra){
        this.extras.remove(extra);
    }

    public Extra getExtra(int index){
        return extras.get(index);
    }

    public List<Extra> getExtras(){
        return new ArrayList<>(this.extras);
    }


    public int price(){
        int resultado = 0;
        for (Extra i: this.extras) {
            resultado += i.getPrice();
        } return resultado;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Court getCourt() {
        return court;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
}
