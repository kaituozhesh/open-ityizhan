package com.open.ityizhan.rebuild.example01.version2;

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

    public double getCharge() {
        double resutl = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                resutl += 2;
                if (getDaysRented() > 2) {
                    resutl += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                resutl += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                resutl += 1.5;
                if (getDaysRented() > 3) {
                    resutl += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return resutl;
    }

    public int getFrequentRenterPoints() {
        return getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1 ? 2 : 1;
    }
}
