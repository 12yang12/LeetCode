package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PrintNumber {
    private static final int N = 10; // 打印的数字个数
    private static volatile int current = 1; // 当前打印数字

    // 使用CountDownLatch和Semaphore控制线程的顺序
    private static final CountDownLatch latch = new CountDownLatch(2);
    private static final Semaphore sema1 = new Semaphore(1); // 控制线程1和线程2的顺序
    private static final Semaphore sema2 = new Semaphore(0); // 控制线程2和线程3的顺序

    public static void main(String[] args) {
        // 创建三个线程
        Thread t1 = new Thread(() -> {
            try {
                sema1.acquire(); // 先获取sema1的信号量，保证线程1先启动
                while (current <= N) {
                    System.out.printf("线程1打印数字：%d%n", current);
                    current++;
                    sema2.release(); // 唤醒线程2，让它执行
                    sema1.acquire(); // 等待线程2唤醒它
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // 唤醒main线程
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                sema2.acquire(); // 先等待线程1的信号量
                while (current <= N) {
                    System.out.printf("线程2打印数字：%d%n", current);
                    current++;
                    sema1.release(); // 唤醒线程1，让它执行
                    if (current % 3 == 1) {
                        sema2.acquire(); // 如果该轮线程2已经打印了1个数字，则等待线程3唤醒它
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // 唤醒main线程
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                sema2.acquire(); // 先等待线程2的信号量
                while (current <= N) {
                    System.out.printf("线程3打印数字：%d%n", current);
                    current++;
                    sema1.release(); // 唤醒线程1，让它执行
                    if (current % 3 != 1) {
                        sema2.acquire(); // 如果该轮线程3已经打印了2个数字，则等待线程2唤醒它
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // 唤醒main线程
            }
        });

        // 启动线程
        t1.start();
        t2.start();
        t3.start();

        try {
            latch.await(); // 等待三个线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
