package io.homo_efficio.scratchpad.thread.exception.runner;

import io.homo_efficio.scratchpad.thread.exception.runnable.ExceptionProducingRunnable;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-17
 */
public class ThreadRunnerWithoutTryCatch {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ExceptionProducingRunnable());
        thread.start();
        thread.join();
        System.out.println(ExecutorServiceUtils.OOO_MAIN_THREAD_정상_종료_OOO);
    }
}
