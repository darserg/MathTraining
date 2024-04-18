import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainScreen extends  JFrame implements ActionListener {

    public static JFrame frame;
    public static Random rand = new Random();
    private static final ArrayList<String> operations = new ArrayList<>();
    public static String title = "";
    private static int answer = 0;
    public static MainScreen listener = new MainScreen();

    public static void main(String[] args) {
        update();
    }

    public static @NotNull ArrayList<JButton> generateButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        ArrayList<Integer> numbers = generateNum();
        for (int i = 0; i < 4; i++) {
            JButton jTmpButton = new JButton(Integer.toString(numbers.get(i)));
            jTmpButton.addActionListener(listener);
            buttons.add(jTmpButton);
        }
        return buttons;
    }

    private static int randomNumber() {
        int minValue = 1;
        int maxValue = 10;
        return minValue + (int) (Math.random() * (maxValue - minValue + 1));
    }

    private static @NotNull ArrayList<Integer> generateNum() {
        ArrayList<Integer> num = new ArrayList<>();
        int countAns = 0;
        for (int i = 0; i < 4; i++) {
            int temp = randomNumber();
            if (temp == answer) {
                countAns += 1;
                if (countAns > 1) {
                    i -= 1;
                } else {
                    num.add(temp);
                }
            } else {
                if ((i == 3) && (countAns == 0)) {
                    num.add(answer);
                }
                else {
                    num.add(temp);
                }
            }
        }
        return num;
    }

    // Обработка события
    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if (answer == Integer.parseInt(e.getActionCommand())) {
            System.out.println("You got a correct answer");
            windowPreparation(frame);
        }
        else {
            System.out.println("You got incorrect answer, try again");
            System.out.println(e.getActionCommand());
        }
    }


    // Отрисовка пользовательского интерфейса
    public static void update() {
        operations.add("+");
        operations.add("-");

        int firstNum = randomNumber();
        int secondNum = randomNumber();
        String operation = operations.get(rand.nextInt(operations.size()));


        // Task to complete
        if (firstNum > secondNum) {
            title  = String.format("%d %s %d", firstNum, operation, secondNum);
            if (Objects.equals(operation, "+")) {
                answer = firstNum + secondNum;
            }
            else {
                answer = firstNum - secondNum;
            }
        }
        else if (firstNum < secondNum) {
            title = String.format("%d %s %d", secondNum, operation, firstNum);
            if (Objects.equals(operation, "+")) {
                answer = firstNum + secondNum;
            }
            else {
                answer = secondNum - firstNum;
            }
        }
        else {
            title = String.format("%d %s %d", firstNum, operation, secondNum - 1);
            if (Objects.equals(operation, "+")) {
                answer = firstNum + (secondNum-1);
            }
            else {
                answer = 1;
            }
        }

        frame = new JFrame("Тренажёр по математике");

        JTextField exercise = new JTextField(5);
        exercise.setEditable(false);
        exercise.setText(title);

        ArrayList<JButton> btn = generateButtons();

        JPanel buttons = new JPanel();
        btn.forEach(buttons::add);

        JPanel display = new JPanel();
        GridLayout num = new GridLayout(1, 4);
        buttons.setLayout(num);

        display.add(exercise);
        display.add(buttons);

        // Screen
        frame.add(display);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }


    // Очистка экрана при правильном ответе
    private static void windowPreparation(@NotNull JFrame window) {
        window.dispose();
        update();
    }
}
