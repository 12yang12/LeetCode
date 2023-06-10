/**
 * 多线程依次打印数字
 */
public class PrintNumber {
    // 打印的数字个数
    private static final int N = 20;
    // 最开始打印的数字
    private static volatile int current = 2;
    // 线程个数
    static int threadCount = 3;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 1; i <= threadCount; i++) {
            new Thread(new Task(i)).start();
        }
    }


    static class Task implements Runnable {
        private final int threadId;

        public Task(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (current <= N) {
                synchronized (lock) {
                    if (current % threadCount == (threadId - 1)) {
                        System.out.printf(Thread.currentThread().getName() + "打印数字：%d%n", current);
                        current++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
