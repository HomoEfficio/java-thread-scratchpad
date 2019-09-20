package io.homo_efficio.scratchpad.thread.exception.runner;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-19
 */
public class TryCatchMainThread {

    public static void main(String[] args) {
        try {
            String simpleName = TryCatchMainThread.class.getSimpleName();
            System.out.println("OOO " + simpleName + " 실행 OOO");
            if (true) throw new NullPointerException("XXXXX " + simpleName + " 예외 발생 XXXXX");
        } catch (Exception e) {
            throw new RuntimeException("NPE를 RuntimeException으로 감싸서 던지기", e);
        }
    }
}
