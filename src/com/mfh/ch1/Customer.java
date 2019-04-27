package com.mfh.ch1;

import com.sun.org.apache.regexp.internal.RE;

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

    public String htmlStatement() {
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() + ": " + rental.getCharge() + "<BR>\n";
        }
        // add footer lines
        result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";
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
