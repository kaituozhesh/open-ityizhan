package com.open.ityizhan.calculate;

import cn.hutool.extra.spring.SpringUtil;

import com.open.ityizhan.calculate.business.Commission;
import com.open.ityizhan.calculate.business.CommissionUserDTO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description: 计算池（提供提成算力）
 * @author : 林俊豪
 * @ClassName: ApplicationContextUtil
 * @Date: 2023-04-26
 * @Version: 1.0.0
 */
@Slf4j
public class CalculatePool implements AutoCloseable {

    private CalculatePool(Commission commission, CommissionUserDTO commissionUserDTO) {
        CalculateContext calculateContext = new CalculateContext(commission, commissionUserDTO);

        procedure.set(new HashMap<>());
        CONTEXT.set(calculateContext);
    }

    /**
     * 计算途中的结果池
     */
    private static final ThreadLocal<Map<String, BigDecimal>> procedure = ThreadLocal.withInitial(HashMap::new);

    private static final ThreadLocal<CalculateContext> CONTEXT = new ThreadLocal<>();



    /**
     * @return 获取当前池中的结果
     */
    public static Map<String, BigDecimal> getCurrentPoolResult() {
        return procedure.get();
    }

    public static void setCalculateResult(String ruleName, BigDecimal data) {
        Map<String, BigDecimal> currentPoolResult = getCurrentPoolResult();
        currentPoolResult.put(ruleName, data);
        procedure.set(currentPoolResult);
    }


    /**
     * @param commission        提成方案
     * @param commissionUserDTO 参与计算的用户
     * @return 获取参与计算的数据
     */
    public static Object getCalculateData(Commission commission, CommissionUserDTO commissionUserDTO) {
        return null;
    }

    public static Object getCalculateData() {
        return CONTEXT.get().getCalculateData();
    }

    public static CommissionUserDTO getCommissionUser() {
        return CONTEXT.get().getCommissionUserDTO();
    }


    /**
     * @param commissionUserDTO 参与计算的用户信息
     * @param commission        使用的提成计算规则
     * @return 提成计算结果
     */
    public static Map<String, BigDecimal> calculate(CommissionUserDTO commissionUserDTO, Commission commission) {
       return null;
    }


    /**
     * 资源卸载
     */
    @Override
    public void close() throws Exception {
        procedure.remove();
        CONTEXT.remove();
    }
}
