import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyThreads implements  Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
