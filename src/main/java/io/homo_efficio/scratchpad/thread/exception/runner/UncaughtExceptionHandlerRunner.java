package io.homo_efficio.scratchpad.thread.exception.runner;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-20
 */
public class UncaughtExceptionHandlerRunner {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(
                (thread, throwable) -> System.out.println(
                        String.format(
                                "Default: [%s] 스레드에서 발생한 [%s] 처리",
                                thread.getName(), throwable.getMessage()))
        );
        Thread aThread = new Thread(() -> {
            throw new NullPointerException("널포인터 예외 A");
        });
        aThread.start();
        aThread.join();
        System.out.println("-------------------------");
        Thread bThread = new Thread(() -> {
            throw new NullPointerException("널포인터 예외 B");
        });
        bThread.setUncaughtExceptionHandler(
                (thread, throwable) -> System.out.println(
                        String.format(
                                "Custom: [%s] 스레드에서 발생한 [%s] 처리",
                                thread.getName(), throwable.getMessage()))
        );
        bThread.start();
    }
}
