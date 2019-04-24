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

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = 0d;
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDayRented() > 2) {
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDayRented() > 3) {
                        thisAmount += (each.getDayRented() - 3) * 1.5;
                    }
                case Movie.NEW_RELEASE:
                    thisAmount += 2;
                    if(each.getDayRented() > 2) {
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    }
                    break;
            }
            // add frequent renter points
            frequentRenterPoints++;
            // add bound for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owned is" + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
