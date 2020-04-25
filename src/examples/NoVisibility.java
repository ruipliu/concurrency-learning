package examples;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 *
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {
    private static volatile boolean ready;
    private static volatile int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            if (number != 42) {
                System.out.println(number);
            }
//            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new ReaderThread().start();
            number = 42;
            ready = true;
        }

    }
}
