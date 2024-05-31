package com.open.ityizhan.example2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @ClassName: CompletableFutureExample
 * @Author: lin
 * @Date: 2023/6/18 15:24
 * @Version: 1.0
 */
public class CompletableFutureExample {


    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 使用runAsync或supplyAsync发起异步调用
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "result1", executor);
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> System.out.println("result1"), executor);


        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> 100).thenApply(num -> "¥:" + num);
        CompletableFuture<Void> cf4 = CompletableFuture.supplyAsync(() -> 100).thenAccept(num -> System.out.println("¥:" + num));
        CompletableFuture<String> cf5 = CompletableFuture.supplyAsync(() -> 100).thenCompose((num) -> CompletableFuture.supplyAsync(() -> "¥:" + num));


        CompletableFuture<Integer> cf6 = CompletableFuture.supplyAsync(() -> 100);
        CompletableFuture<Integer> cf7 = CompletableFuture.supplyAsync(() -> 20);
        cf6.thenCombine(cf7, (result1, result2) -> "¥:" + (result1 + result2));


        CompletableFuture<Void> cf8 = CompletableFuture.allOf(cf3, cf4, cf5);
        CompletableFuture<String> result = cf8.thenApply(v -> {
            cf3.join();
            cf4.join();
            cf5.join();
            return "result";
        });
    }
}
