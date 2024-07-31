package com.open.ityizhan.rebuild.example01.version1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
        // 消费
        double totalAmount = 0;
        // 积分
        int frequentRenterPoints = 0;
        StringBuilder res = new StringBuilder(getName() + "租凭记录：\n");

        for (Rental rental : rentals) {
            double thisAmount = 0;
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2) {
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            res.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount);
            totalAmount += thisAmount;
        }
        res.append("总消费：").append(totalAmount).append("\n");
        res.append("总积分：").append(frequentRenterPoints);

        return res.toString();
    }
}
