package com.open.ityizhan.rebuild.example01.version3.price;

import com.open.ityizhan.rebuild.example01.version3.Movie;

/**
 * @Description:
 * @ClassName: ChildrenPrice
 * @Auther: lin
 * @Date: 2024/7/24 16:03
 * @Version: 1.0
 */
public class ChildrenPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        double resutl = 1.5;
        if (daysRented > 3) {
            resutl += (daysRented - 3) * 1.5;
        }
        return resutl;
    }
}
