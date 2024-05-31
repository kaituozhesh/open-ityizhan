package com.open.ityizhan.example1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * @Description:
 * @ClassName: CompletableFutureExample
 * @Author: lin
 * @Date: 2023/6/12 20:11
 * @Version: 1.0
 */
public class CompletableFutureExample {

    public static void main(String[] args) {
        ExecutorService executor = newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        }, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 2");
            return "step2 result";
        }, executor);
        cf1.thenCombine(cf2, (result1, result2) -> {
            System.out.println(result1 + " , " + result2);
            System.out.println("执行step 3");
            return "step3 result";
        }).thenAccept(System.out::println);
    }
}
