import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

public class MainScreen {

    static JFrame frame;
    static JTextField exercize;
    static Random rand = new Random();
    static ArrayList<String> operations = new ArrayList<>();
    static String title = "";
    static int answer = 0;

    public static void main(String[] args) {
//        Main listen = new Main();
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
                answer = firstNum + secondNum;
            }
            else {
                answer = 1;
            }
        }

        frame = new JFrame("Тренажёр по математике");

        exercize = new JTextField(5);
        exercize.setEditable(false);
        exercize.setText(title);

        ArrayList<JButton> btn = generateButtons();

        JPanel buttons = new JPanel();
        btn.forEach(buttons::add);

        JPanel display = new JPanel();
        GridLayout nums = new GridLayout(1, 4);
        buttons.setLayout(nums);

        display.add(exercize);
        display.add(buttons);

        // Screen
        frame.add(display);
        frame.setSize(1000, 500);
        frame.setVisible(true);


    }

    public static ArrayList<JButton> generateButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        ArrayList<Integer> numbers = generateNum();
        for (int i = 0; i < 4; i++) {
            JButton jTmpButton = new JButton(Integer.toString(numbers.get(i)));
//            jTmpButton.addActionListener(listen);
            buttons.add(jTmpButton);
        }
        return buttons;
    }

    public static int randomNumber() {
        int minValue = 1;
        int maxValue = 10;
        return minValue + (int) (Math.random() * (maxValue - minValue + 1));
    }

    public static @NotNull ArrayList<Integer> generateNum() {
        ArrayList<Integer> num = new ArrayList<Integer>();
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

//    @Override
//    public void actionPerfomed(ActionEvent e) {
//        System.out.println(e.getActionCommand);
//    }
}
