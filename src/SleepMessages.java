/**
 * @author liuruiping
 * @version 1.0
 * @date 3/9/2020 6:47 PM
 */
public class SleepMessages {
    public static void main(String args[]) throws InterruptedException {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String s : importantInfo) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(s);
        }
    }
}
