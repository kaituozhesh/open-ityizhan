package com.open.ityizhan.rebuild.example01.version3.price;

import com.open.ityizhan.rebuild.example01.version3.Movie;

/**
 * @Description:
 * @ClassName: Price
 * @Auther: lin
 * @Date: 2024/7/24 16:03
 * @Version: 1.0
 */
public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
