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

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        // add footer lines
        result += "Amount owned is " + this.getTotalCharge() + "\n";
        result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
                result += rental.getCharge();
        }
        return result;
    }

    private double getTotalFrequentRenterPoints() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
