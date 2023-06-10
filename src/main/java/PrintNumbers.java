public class PrintNumbers {
    private static final int MAX_NUMBER = 20;
    private static final int THREAD_COUNT = 3;
    private static int currentNumber = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new PrintTask(i)).start();
        }
    }

    static class PrintTask implements Runnable {
        private final int taskId;

        public PrintTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (currentNumber > MAX_NUMBER) {
                        break;
                    }
                    if (currentNumber % THREAD_COUNT == taskId) {
                        System.out.println("Thread-" + taskId + ": " + currentNumber++);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}