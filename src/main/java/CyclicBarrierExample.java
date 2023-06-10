import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    private static final int THREAD_COUNT = 3; // 线程数量

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有线程已经到达屏障点，开始执行后续操作...");
            }
        }); // 创建一个CyclicBarrier对象，并指定计数器的初始值和屏障行为

        for (int i = 0; i < THREAD_COUNT; i++) { // 启动多个线程
            new Thread(new Task(cyclicBarrier)).start();
        }

        cyclicBarrier.reset(); // 重置CyclicBarrier对象的计数器

        for (int i = 0; i < THREAD_COUNT; i++) { // 再次启动多个线程
            new Thread(new Task(cyclicBarrier)).start();
        }
    }

    private static class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行任务...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "已经到达屏障点，等待其他线程到达...");
                cyclicBarrier.await(); // 调用await()方法，等待其他线程到达屏障点
                System.out.println(Thread.currentThread().getName() + "已经被释放，继续执行任务...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}