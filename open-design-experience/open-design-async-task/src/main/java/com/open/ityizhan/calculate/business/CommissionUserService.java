package com.open.ityizhan.calculate.business;

import java.util.Date;

/**
 * 获取提成相关用户信息
 */
public interface CommissionUserService {
    CommissionUserDTO findUser(String bsCode, Date calMonth, Commission commission);
}
