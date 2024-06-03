package com.open.ityizhan.calculate.business;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 提成用户信息
 */
@Data
public class CommissionUserDTO implements Serializable {

    private String bsCode;

    private String orgId;

    private Date startDate;

    private Date endDate;

    private Date belongMonth;
    private String month;
    /**
     * 对应计算月用户币别
     */
    private String currency;

    private String company;
    /**
     * 通讯费用
     */
    private BigDecimal communicationFee;
    /**
     * 月扣除数
     */
    private BigDecimal deductMonth;

    private String saleType;

    private String saleLevel;
}
