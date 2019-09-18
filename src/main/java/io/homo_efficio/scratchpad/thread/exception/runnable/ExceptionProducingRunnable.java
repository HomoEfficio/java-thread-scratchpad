package io.homo_efficio.scratchpad.thread.exception.runnable;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-17
 */
public class ExceptionProducingRunnable implements Runnable {
    @Override
    public void run() {
        String simpleName = this.getClass().getSimpleName();
        System.out.println("OOO " + simpleName + " 실행 OOO");
        if (true) throw new RuntimeException("XXXXX " + simpleName + " 예외 발생 XXXXX");
    }
}
