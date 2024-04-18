import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainScreen extends JFrame implements ActionListener{
    public static JFrame frame = new JFrame();
    public static String title = "Добро пожаловать в математический тренажер";
    public static String subtitle = "Нажмите играть, чтобы приступить к решению задач";
    private final static MainScreen listener = new MainScreen();

    public static void main(String[] args) {
        frame.add(getDisplay());
        frame.setSize(1000, 500);
        frame.setVisible(true);
        Countdown countdown = new Countdown();
    }

    private static JPanel getDisplay() {
        JTextArea text = new JTextArea();
        text.append(title);
        text.append(subtitle);

        JPanel display = new JPanel();
        JPanel buttons = new JPanel();

        JButton start = new JButton("Играть");
        start.addActionListener(listener);
        JButton exit = new JButton("Выйти");
        exit.addActionListener(listener);

        buttons.add(start);
        buttons.add(exit);

        display.add(text);
        display.add(buttons);
        return display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Играть")) {
            frame.dispose();
            Countdown.main();
            ExcercizesScreen.update();
        }
        else {
            frame.dispose();
        }
    }
}
