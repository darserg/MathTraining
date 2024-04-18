import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    public Countdown() {

    }

    public static int countCorrectAns = 0;
    public static int countAns = 0;

    public static void endOfWorking() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ExcercizesScreen.closeWindow();
                ResultScreen.drawFrame(countCorrectAns, countAns);
            }
        };

        Thread newThread = new Thread(() -> {
            timer.schedule(task, 60000);
        });

        newThread.start();
    }
}
