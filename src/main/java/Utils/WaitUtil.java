package Utils;

public class WaitUtil {

    public static void waitFor(int waitFor){
        try {
            Thread.sleep(waitFor);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
