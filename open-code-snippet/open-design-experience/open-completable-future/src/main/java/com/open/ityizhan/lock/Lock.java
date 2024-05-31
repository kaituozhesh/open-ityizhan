package com.open.ityizhan.lock;

import java.util.concurrent.*;

/**
 * @Description:
 * @ClassName: Lock
 * @Auther: lin
 * @Date: 2023/6/12 20:47
 * @Version: 1.0
 */
public class Lock {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    doGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.countDown();
    }

    static ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));

    public static Object doGet() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            // 子任务
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("child");
                return "child";
            }, threadPool).join();
        }, threadPool);
        return cf1.join();
    }
}
