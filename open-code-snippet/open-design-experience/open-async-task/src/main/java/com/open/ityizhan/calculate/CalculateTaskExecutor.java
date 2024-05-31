package com.open.ityizhan.calculate;

import cn.hutool.extra.spring.SpringUtil;
import com.open.ityizhan.calculate.business.Commission;
import com.open.ityizhan.calculate.business.CommissionUserDTO;
import com.open.ityizhan.calculate.business.CommissionUserService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description: 异步任务执行器
 * @ClassName: CalculateTaskExecutor
 * @Auther: lin
 * @Date: 2023/5/31 20:50
 * @Version: 1.0
 */
public class CalculateTaskExecutor {

    static ExecutorService scheduledThreadPool = Executors.newFixedThreadPool(10);
    static ExecutorService scheduledExecutorService = Executors.newFixedThreadPool(2);
    private static final CommissionUserService commissionUserService = SpringUtil.getBean(CommissionUserService.class);


    /**
     * 计算任务
     */
    static class CalculateTask implements Callable<Map<String, BigDecimal>> {

        private final CommissionUserDTO commissionUserDTO;
        private final Commission commission;

        public CalculateTask(CommissionUserDTO commissionUserDTO, Commission commission) {
            this.commissionUserDTO = commissionUserDTO;
            this.commission = commission;
        }

        @Override
        public Map<String, BigDecimal> call() throws Exception {
            return CalculatePool.calculate(commissionUserDTO, commission);
        }
    }

    static class Task implements Callable<CommissionUserDTO> {
        String bsCode;
        Date calMonth;
        Commission commission;

        public Task(String bsCode, Date calMonth, Commission commission) {
            this.bsCode = bsCode;
            this.calMonth = calMonth;
            this.commission = commission;
        }

        @Override
        public CommissionUserDTO call() throws Exception {
            return commissionUserService.findUser(bsCode, calMonth, commission);
        }
    }

    private static CommissionUserDTO syncFindUser(String bsCode, Date calMonth, Commission commission)
            throws ExecutionException, InterruptedException {
        Task task = new Task(bsCode, calMonth, commission);
        Future<CommissionUserDTO> submit = scheduledThreadPool.submit(task);
        return submit.get();
    }


    /**
     * 任务异步执行
     */
    public static void asyncTask(String bsCode, Date calMonth, Commission commission) {
        try {
            CommissionUserDTO commissionUserDTO = syncFindUser(bsCode, calMonth, commission);
            scheduledExecutorService.submit(new CalculateTask(commissionUserDTO, commission));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("计算任务提交失败");
        }
    }

    /**
     * 任务同步执行
     */
    public static Map<String, BigDecimal> syncTask(String bsCode, Date calMonth, Commission commission) {
        try {
            CommissionUserDTO commissionUserDTO = syncFindUser(bsCode, calMonth, commission);
            Future<Map<String, BigDecimal>> submit = scheduledExecutorService.submit(new CalculateTask(commissionUserDTO, commission));
            return submit.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("任务计算出错");
        }
    }

}
