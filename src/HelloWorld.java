/**
 * @author liuruiping
 * @version 1.0
 * @date 3/9/2020 6:44 PM
 */
public class HelloWorld implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String[] args) {
        (new Thread(new HelloWorld())).start();
    }
}
