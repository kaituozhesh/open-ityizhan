package com.open.ityizhan.rebuild.example01.version3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: Customer
 * @Auther: lin
 * @Date: 2024/7/24 13:50
 * @Version: 1.0
 */
public class Customer implements Serializable {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        StringBuilder res = new StringBuilder(getName() + "租凭记录：\n");

        for (Rental rental : rentals) {
            res.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge());
        }
        res.append("总消费：").append(getTotalCharge()).append("\n");
        res.append("总积分：").append(getTotalFrequentRenterPoints());

        return res.toString();
    }

    private double getTotalCharge() {
        double res = 0;
        for (Rental rental : rentals) {
            res += rental.getCharge();
        }
        return res;
    }

    private int getTotalFrequentRenterPoints() {
        int res = 0;
        for (Rental rental : rentals) {
            res += rental.getFrequentRenterPoints();
        }
        return res;
    }


}
