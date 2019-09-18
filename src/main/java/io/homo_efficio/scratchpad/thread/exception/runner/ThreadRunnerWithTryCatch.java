package io.homo_efficio.scratchpad.thread.exception.runner;

import io.homo_efficio.scratchpad.thread.exception.runnable.ExceptionProducingRunnable;

import static io.homo_efficio.scratchpad.thread.exception.runner.ExecutorServiceUtils.CCC_THREAD_내에서_발생한_예외_CATCH_CCC;
import static io.homo_efficio.scratchpad.thread.exception.runner.ExecutorServiceUtils.OOO_MAIN_THREAD_정상_종료_OOO;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-17
 */
public class ThreadRunnerWithTryCatch {

    public static void main(String[] args) throws InterruptedException {
        try {
            Thread thread = new Thread(new ExceptionProducingRunnable());
            thread.start();
            thread.join();
            System.out.println(OOO_MAIN_THREAD_정상_종료_OOO);
        } catch (Exception e) {
            System.out.println(CCC_THREAD_내에서_발생한_예외_CATCH_CCC);
            throw e;
        }
    }
}
