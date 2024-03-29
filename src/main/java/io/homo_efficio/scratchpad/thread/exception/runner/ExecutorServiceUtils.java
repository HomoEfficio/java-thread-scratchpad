package io.homo_efficio.scratchpad.thread.exception.runner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-18
 */
public class ExecutorServiceUtils {
    public static final String OOO_MAIN_THREAD_정상_종료_OOO = "OOO MAIN THREAD 정상 종료 OOO";
    public static final String CCC_THREAD_내에서_발생한_예외_CATCH_CCC = "CCC Thread 내에서 발생한 예외 catch CCC";

    public static void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
