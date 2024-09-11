package com.open.ityizhan.rebuild.example02;

/**
 * @Description: 去除临时变量
 * @ClassName: Demo01
 * @Auther: lin
 * @Date: 2024/8/5 10:48
 * @Version: 1.0
 */
public class Demo01 {

    private int quantity, price;

    class version01 {
        double getPrice() {
            int basePrice = quantity * price;
            double discountFactor;
            if (basePrice > 1000) {
                discountFactor = 0.95;
            } else {
                discountFactor = 0.98;
            }
            return basePrice * discountFactor;
        }
    }

    class version02 {

        double getPrice() {
            return basePrice() * discountFactor();
        }

        private int basePrice() {
            return quantity * price;
        }

        private double discountFactor() {
            return basePrice() > 1000 ? 0.95 : 0.98;
        }
    }

}
