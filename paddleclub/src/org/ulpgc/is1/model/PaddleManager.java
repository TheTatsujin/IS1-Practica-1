package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaddleManager {
    private final List<Customer> customerList;
    private final List<Court> courtList;

    public PaddleManager(){
        customerList = new ArrayList<>();
        courtList = new ArrayList<>();
    }

    public void addCustomer(String name, String surname, String nif){
        if (this.getCustomer(name+" "+surname) == null){
            customerList.add(new Customer(name, surname, nif));
        }
    }
    public void addMember(String name, String surname, String nif, int points, String street, int number, int postalCode, String city) {
        if (this.getCustomer(name + " " + surname) == null) {
            customerList.add(new Member(name, surname, nif, points, street, number, postalCode, city));

        }
    }
    public void addCourt(String name, int price, CourtType type){
        if (this.getCourt(name) == null) {
            courtList.add(new Court(name, price, type));
        }
    }
    public Customer getCustomer(int index){
         return this.customerList.get(index - 1);
    }
    public Court getCourt(int index){
        return this.courtList.get(index - 1);
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
    public void reserve(String customerName, String courtName, Date date){
        Customer client = this.getCustomer(customerName);
        Court court = this.getCourt(courtName);
        Reservation r = new Reservation(client, court, date);
        court.addReservation(r);
        client.addReservation(r);
    }

    public void reserve(int customerIndex, int courtIndex, Date date){
        Customer client = this.getCustomer(customerIndex);
        Court court = this.getCourt(courtIndex);
        Reservation r = new Reservation(client, court, date);
        court.addReservation(r);
        client.addReservation(r);
    }

    public List<Customer> getCustomers(){
        return new ArrayList<>(this.customerList);
    }

    public List<Court> getCourts(){
        return new ArrayList<>(this.courtList);
    }

    public void removeCustomer(int index){
        this.customerList.remove(index - 1);
    }

    public void removeCourt(int index){
        this.courtList.remove(index - 1);
    }
}
