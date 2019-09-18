package io.homo_efficio.scratchpad.thread.exception.runner;

import io.homo_efficio.scratchpad.thread.exception.runnable.ExceptionProducingRunnable;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static io.homo_efficio.scratchpad.thread.exception.runner.ExecutorServiceUtils.*;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-17
 */
public class ExecutorSubmitWithTryCatch {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();
            Future<?> future = executorService.submit(new ExceptionProducingRunnable());
//            Object result = future.get();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println(OOO_MAIN_THREAD_정상_종료_OOO);
        } catch (Exception e) {
            System.out.println(CCC_THREAD_내에서_발생한_예외_CATCH_CCC);
            throw e;
        } finally {
            if (Objects.nonNull(executorService))
                shutdownAndAwaitTermination(executorService);
        }
    }
}
