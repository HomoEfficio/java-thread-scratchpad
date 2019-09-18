package io.homo_efficio.scratchpad.thread.exception.runner;

import io.homo_efficio.scratchpad.thread.exception.runnable.ExceptionProducingRunnable;

import java.util.Objects;
import java.util.concurrent.*;

import static io.homo_efficio.scratchpad.thread.exception.runner.ExecutorServiceUtils.*;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-17
 */
public class ExecutorSubmitAndGetWithTryCatch {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();
            Future<?> future = executorService.submit(new ExceptionProducingRunnable());
            Object result = future.get();
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
