package com.open.ityizhan.rebuild.example01.version1;

import java.io.Serializable;

/**
 * @Description:
 * @ClassName: Rental
 * @Auther: lin
 * @Date: 2024/7/24 13:49
 * @Version: 1.0
 */
public class Rental implements Serializable {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
