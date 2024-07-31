package com.open.ityizhan.rebuild.example01.version3;

import com.open.ityizhan.rebuild.example01.version3.price.ChildrenPrice;
import com.open.ityizhan.rebuild.example01.version3.price.NewReleasePrice;
import com.open.ityizhan.rebuild.example01.version3.price.Price;
import com.open.ityizhan.rebuild.example01.version3.price.RegularPrice;

import java.io.Serializable;

/**
 * @Description:
 * @ClassName: Movie
 * @Auther: lin
 * @Date: 2024/7/24 13:48
 * @Version: 1.0
 */
public class Movie implements Serializable {

    // 普通
    public static final int REGULAR = 0;
    // 新片
    public static final int NEW_RELEASE = 1;
    // 儿童
    public static final int CHILDREN = 2;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case Movie.CHILDREN:
                price = new ChildrenPrice();
                break;
        }
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return getPriceCode() == Movie.NEW_RELEASE && daysRented > 1 ? 2 : 1;
    }
}
