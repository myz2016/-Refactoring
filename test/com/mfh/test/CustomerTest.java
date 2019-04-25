package com.mfh.test;

import com.mfh.ch1.Customer;
import com.mfh.ch1.Movie;
import com.mfh.ch1.Rental;
import org.junit.Test;

/**
 * @Author mfh
 * @Date 2019/4/25 21:24
 */
public class CustomerTest {
    @Test
    public void foo() {
        Movie childMovie = new Movie("熊出没之变形记", 2);
        Movie regularMovie = new Movie("吸血鬼日记", 0);
        Movie newReleaseMovie = new Movie("飞驰人生", 1);

        Rental childMovieRental = new Rental(childMovie, 4);
        Rental regularMovieRental = new Rental(regularMovie, 2);
        Rental newReleaseMovieRental = new Rental(newReleaseMovie, 3);

        Customer customer = new Customer("光头强");
        customer.addRental(childMovieRental);
        customer.addRental(regularMovieRental);
        customer.addRental(newReleaseMovieRental);

        String statement = customer.statement();

        System.out.println(statement);
        /**
         * Rental Record for 光头强
         * 	熊出没之变形记	3.0
         * 	吸血鬼日记	2.0
         * 	飞驰人生	3.5
         * Amount owned is 8.5
         * You earned 4 frequent renter points
         */
    }
}