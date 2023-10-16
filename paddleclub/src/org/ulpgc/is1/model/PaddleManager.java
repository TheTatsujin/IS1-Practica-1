package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class PaddleManager {
    private List<Customer> customerList;
    private List<Court> courtList;

    public PaddleManager(){
        customerList = new ArrayList<>();
        courtList = new ArrayList<>();
    }

    public void addCustomer(String name, String surname, NIF nif){
        customerList.add(new Customer(name, surname, nif));
    }
    public void addCourt(String name, int price, CourtType type){
        courtList.add(new Court(name, price, type));
    }
    public Customer getCustomer(){

    }
    public Court getCourt(){

    }
    public Reservation reserve(){

    }
}
