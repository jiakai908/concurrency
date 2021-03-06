package com.icinfo.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2018年11月18
 */
@Slf4j
public class SynchronizedExample2 {
    //修饰一个类 调用对象
    public static void test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i=0; i< 10;i++){
               log.info("test1 {} - {}",j,i);
            }
        }
    }
    //修饰一个静态方法 调用对象
    public static synchronized void test2(int j){
        for (int i=0;i<10;i++){
            log.info("test2 {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->{
//            synchronizedExample1.test1();
//        });
//        executorService.execute(()->{
//            synchronizedExample1.test1();
//        });
//
//        executorService.execute(()->{
//            synchronizedExample1.test2();
//        });
//        executorService.execute(()->{
//            synchronizedExample1.test2();
//        });
        executorService.execute(()->{
            synchronizedExample1.test1(11111);
        });
        executorService.execute(()->{
            synchronizedExample2.test1(22222);
        });

        executorService.shutdown();

    }
}
