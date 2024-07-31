package com.open.ityizhan.rebuild.example01.version3.price;

import com.open.ityizhan.rebuild.example01.version3.Movie;

/**
 * @Description:
 * @ClassName: NewReleasePrice
 * @Auther: lin
 * @Date: 2024/7/24 16:04
 * @Version: 1.0
 */
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }

}
