package com.mfh.ch1;

/**
 * @Author mfh
 * @Date 2019/4/24 21:02
 */
public class Movie {
    public final static int CHILDREN = 2;
    public final static int REGULAR = 0;
    public final static int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }
}
