package test;

import java.io.IOException;

public class ThreadPrint implements Runnable {

    private static final Object LOCK = new Object();
    // 线程数
    private static final int THREAD_NUM = 3;
    // 输出的最大数字
    private static final int MAX_NUM = 100;
    // 当前数字
    private static int currentNo = 0;
    // 线程编号
    private int threadNo;
    // 线程总数
    private int threadCnt;

    public ThreadPrint(int threadNo, int threadCnt) {
        this.threadCnt = threadCnt;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (LOCK) {
                    // 判断是否当前线程编号
                    while (currentNo % threadCnt != threadNo) {
                        if (currentNo >= MAX_NUM) {
                            break;
                        }
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (currentNo >= MAX_NUM) {
                        break;
                    }
                    System.out.println("#thread-" + (threadNo + 1) + " " + (currentNo + 1));
                    currentNo++;
                    LOCK.notifyAll();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new ThreadPrint(i, THREAD_NUM)).start();
        }
    }

}
