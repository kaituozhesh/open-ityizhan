package com.open.ityizhan.calculate;

import com.open.ityizhan.calculate.business.Commission;
import com.open.ityizhan.calculate.business.CommissionUserDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class CalculateContext implements Serializable {

    public CalculateContext(Commission commission, CommissionUserDTO commissionUserDTO) {
        this.commission = commission;
        this.commissionUserDTO = commissionUserDTO;
        this.calculateData = CalculatePool.getCalculateData(commission, commissionUserDTO);
    }

    private Commission commission;
    private CommissionUserDTO commissionUserDTO;
    private Object calculateData;
}