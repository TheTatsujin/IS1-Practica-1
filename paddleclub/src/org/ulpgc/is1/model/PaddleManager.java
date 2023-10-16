package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
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
    public Customer getCustomer(int indx){
         return this.customerList.get(indx);
    }
    public Court getCourt(int indx){
        return this.courtList.get(indx);
    }
    public Customer getCustomer(String customerName){
        for (Customer i: customerList){
             if ((i.getName() + " " + i.getSurname()).equals(customerName)){
                 return i;
             }
         }
        return null;
    }
    public Court getCourt(String name){
        for (Court i: courtList){
            if (i.getName().equals(name)){
                return i;
            }
        }return null;
    }
    public Reservation reserve(String customerName, String courtName, Date date){
        Customer client = this.getCustomer(customerName);
        Court court = this.getCourt(courtName);
        return new Reservation(client, court, date);
    }

    public Reservation reserve(int customerIndex, int courtIndex, Date date){
        Customer client = this.getCustomer(customerIndex);
        Court court = this.getCourt(courtIndex);
        return new Reservation(client, court, date);
    }

}
