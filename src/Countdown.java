import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    public Countdown() {

    }

    public static void main() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ResultScreen.main();
            }
        };

        Thread newThread = new Thread(() -> {
            timer.schedule(task, 60);
        });

        newThread.start();
    }
}
