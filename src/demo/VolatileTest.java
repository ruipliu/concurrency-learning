package demo;


/**
 * @author liuruiping
 * @version 1.0
 * @date 4/8/2020 9:22 PM
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static void increase() {
        race++;
        //  0x0000000002f75818: mov     rsi,76badbcc0h    ;   {oop(a 'java/lang/Class' = 'demo/VolatileTest')}
        //  0x0000000002f75822: mov     edi,dword ptr [rsi+68h]  ;*getstatic race
        //                                                ; - demo.VolatileTest::increase@0 (line 12)
        //
        //  0x0000000002f75825: inc     edi
        //  0x0000000002f75827: mov     dword ptr [rsi+68h],edi
    }
    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
