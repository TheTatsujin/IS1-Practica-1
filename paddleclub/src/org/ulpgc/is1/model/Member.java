package org.ulpgc.is1.model;

public class Member extends Customer{
    private int points;
    private Address address;

    public Member(String name, String surname, String nif, int points, String street, int number, int postalCode, String city) {
        super(name, surname, nif);
        this.points = points;
        this.address = new Address(street, number, postalCode, city);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Address getAddress() {
        return new Address(
                this.address.getStreet(),
                this.address.getNumber(),
                this.address.getPostalCode(),
                this.address.getCity()
        );
    }

    public void setAddress(String street, int number, int postalCode, String city) {
        this.address = new Address(street, number, postalCode, city);
    }
}
