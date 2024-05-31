package com.open.ityizhan.calculate.business;


/**
 * 提成类型
 */
public enum Commission {
    DIRECT_CUSTOMER("直客销售提成", "directCustomer"),
    NOT_DIRECT_CUSTOMER("直客销售提成_无", "notDirectCustomer"),
    ;

    Commission(String desc, String code) {
        this.desc = desc;
        this.code = code;

    }

    final String desc;
    final String code;

}
