package com.open.ityizhan.rebuild.example01.version3.price;

import com.open.ityizhan.rebuild.example01.version3.Movie;

/**
 * @Description:
 * @ClassName: RegularPrice
 * @Auther: lin
 * @Date: 2024/7/24 16:04
 * @Version: 1.0
 */
public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double resutl = 2;
        if (daysRented > 2) {
            resutl += (daysRented - 2) * 1.5;
        }
        return resutl;
    }


}
