import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ResultScreen extends JFrame implements ActionListener {
    public static JFrame frame = new JFrame();
    public static String title = String.format("Игра окочнена, вы набрали %d правильных ответов из %d.", 9, 10);
    private final static ResultScreen listener = new ResultScreen();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Начать заново")) {
            frame.dispose();
            ExcercizesScreen.update();
        }
        else {
            frame.dispose();
        }
    }

    public static void main() {
        frame.add(getDisplay());
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    private static JPanel getDisplay() {
        JTextArea text = new JTextArea();
        text.append(title);

        JPanel display = new JPanel();
        JPanel buttons = new JPanel();

        JButton newGame = new JButton("Начать заново");
        newGame.addActionListener(listener);
        JButton exit = new JButton("Выйти");
        exit.addActionListener(listener);

        buttons.add(newGame);
        buttons.add(exit);

        display.add(text);
        display.add(buttons);

        return display;
    }
}
