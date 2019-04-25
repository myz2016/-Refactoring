package com.mfh.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mfh
 * @Date 2019/4/24 21:11
 */
public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }
        // add footer lines
        result += "Amount owned is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}
