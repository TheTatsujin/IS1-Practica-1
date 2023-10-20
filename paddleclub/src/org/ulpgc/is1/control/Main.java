package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.Date;

public class Main {
    public static void init(PaddleManager manager){
        manager.addMember("Juan", "Pérez", "54117087L", 100, "Calle Mayor", 10, 28001, "Madrid");
        manager.addCustomer("Ana", "García", "12SD34TT4");

        manager.addCourt("Court1", 50, CourtType.FastCourt);
        manager.addCourt("Court2", 35, CourtType.SlowCourt);
    }
    public static void main(String[] args) {
        PaddleManager manager = new PaddleManager();
        init(manager);
        for (Customer i: manager.getCustomers()) {
            if (!i.getNif().toString().equals("XXXX")){
                System.out.println(i.getNif());
            }
        }
        System.out.print(manager.getCustomer(1).getName() + " ");
        System.out.print(manager.getCustomer(1).getSurname() + " ");
        System.out.println(manager.getCustomer(1).getNif() + " ");

        System.out.print(manager.getCustomer(2).getName() + " ");
        System.out.print(manager.getCustomer(2).getSurname() + " ");
        System.out.println(manager.getCustomer(2).getNif() + " ");

        System.out.print(manager.getCourt(2).getName() + " ");
        System.out.print(manager.getCourt(2).getPrice() + " ");
        System.out.println(manager.getCourt(2).getType() + " ");

        Date date = new Date();
        manager.reserve(1, 2, date);
        manager.removeCustomer(2);


        System.out.println("Customers: " + manager.getCustomers().size());

        System.out.println("---RESERVATIONS---");
        for (Customer i: manager.getCustomers()){
            System.out.print("Customer: ");
            System.out.print(i.getName() + " ");
            System.out.println(i.getSurname());
            for (Reservation j: i.getReservations()){
                System.out.print("Reservation ID: " + j.getId() + " ");
                System.out.print("Court: " + j.getCourt().getName() + " ");
                System.out.print("Date: " + j.getDate() + " ");
                System.out.print("Price: " + j.price() + " ");
            }
        }
    }
}