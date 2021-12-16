package homeworkLesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeekbrainsWindow extends JFrame {
    private int randomNumber;
    private JTextField textField;
    private int check = 0;
    private boolean win = false;
    private int touchs=2;

    public GeekbrainsWindow() {
        this.randomNumber = (int) (Math.random() * 10) + 1; // [1, 10]


        setTitle("Игра: Угадай число");
        setBounds(600, 300, 600, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());
        setResizable(false);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        textField.setText("Программа загадала число от 1 до 10. У вас 3 попытки.");
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);


        Font font = new Font("Arial", Font.PLAIN, 20);
        textField.setFont(font);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 10));
        buttonsPanel.setBackground(Color.BLUE);
        add(buttonsPanel, BorderLayout.CENTER);

        JButton buttonReset = new JButton("Перезапуск");
        add(buttonReset, BorderLayout.SOUTH);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(font);
            buttonsPanel.add(button);
            int buttonIndex = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tryToAnswer(buttonIndex);
                }
            });
        }


        setVisible(true);
    }

    public void restart() {
        randomNumber = (int) (Math.random() * 10) + 1;
        check=0;
        win=false;
        touchs=2;
        textField.setText("Комьютер загадал новое число. У Вас 3 попытки.");

    }

    public void tryToAnswer(int answer) {
        if (check==3){
            textField.setText("Вы проиграли, начните заново!");
            return;
        }
        if (win == true) {
            textField.setText("Хватит жать на кнопки, Вы победили!");
            return;
        }
        if (check == 2 && answer != randomNumber) {
            textField.setText("Вы проиграли.");
            check++;
            return;
        }
        if (answer < randomNumber) {
            textField.setText("Не угадали! Загаданное число больше! Попыток : " + touchs);
            if (check <= 2) {
                check++;
                touchs-=check;
            }
            return;
        }
        if (answer > randomNumber) {
            textField.setText("Не угадали! Загаданное число меньше. Попыток : " + touchs);
            if (check <= 2) {
                check++;
                touchs-=check;
            }
            return;
        }
        if (answer == randomNumber) {
            textField.setText("Вы угадали!!! Ответ: " + randomNumber + "!");
            win = true;
            return;
        }
    }
}
