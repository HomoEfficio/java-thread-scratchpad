package io.homo_efficio.scratchpad.thread.exception.runner;

import io.homo_efficio.scratchpad.thread.exception.runnable.ExceptionProducingRunnable;

import java.util.concurrent.CompletableFuture;

import static io.homo_efficio.scratchpad.thread.exception.runner.ExecutorServiceUtils.CCC_THREAD_내에서_발생한_예외_CATCH_CCC;
import static io.homo_efficio.scratchpad.thread.exception.runner.ExecutorServiceUtils.OOO_MAIN_THREAD_정상_종료_OOO;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-17
 */
public class CompletableFutureRunAsync {

    public static void main(String[] args) {
        CompletableFuture.runAsync(new ExceptionProducingRunnable())
                .exceptionally(t -> {
                    System.err.println("예외 처리 in thread " + Thread.currentThread().getName());
                    System.out.println(CCC_THREAD_내에서_발생한_예외_CATCH_CCC);
                    t.printStackTrace();
                    throw new RuntimeException("exceptionally에서 throw", t);
                });
        System.out.println(OOO_MAIN_THREAD_정상_종료_OOO);
    }
}
