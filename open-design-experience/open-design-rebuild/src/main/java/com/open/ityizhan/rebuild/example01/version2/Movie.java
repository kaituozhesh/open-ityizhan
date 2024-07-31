package com.open.ityizhan.rebuild.example01.version2;

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
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
