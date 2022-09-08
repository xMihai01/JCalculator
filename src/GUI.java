import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame frame;
    JTextField textField;
    JTextField operatorField, errorField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton addition, substraction, multiply, division;
    JButton decimalButton, equalsButton, deleteButton, clearButton, negativeButton;
    JPanel panel;


    double num1 = 0, num2 = 0, result = 0;
    char operator;

    GUI() {

        frame = new JFrame("JCalculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setEditable(false);

        operatorField = new JTextField();
        operatorField.setBounds(0, 25, 50, 50);
        operatorField.setEditable(false);

        errorField = new JTextField();
        errorField.setBounds(00, 500, 420, 50);
        errorField.setEditable(false);
        errorField.setText("JCalculator has started!");

        addition = new JButton("+");
        substraction = new JButton("-");
        multiply = new JButton("*");
        division = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("Del");
        clearButton = new JButton("Clr");
        negativeButton = new JButton("(-)");

        functions[0] = addition;
        functions[1] = substraction;
        functions[2] = multiply;
        functions[3] = division;
        functions[4] = decimalButton;
        functions[5] = equalsButton;
        functions[6] = deleteButton;
        functions[7] = clearButton;
        functions[8] = negativeButton;

        for (int i = 0; i<9; i++) {
            functions[i].addActionListener(this);
            functions[i].setFocusable(false);
        }

        for (int i = 0; i<10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
        }

        negativeButton.setBounds(50,430,100,50);
        deleteButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10, 10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addition);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(substraction);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiply);
        panel.add(decimalButton);
        panel.add(numbers[0]);
        panel.add(equalsButton);
        panel.add(division);

        frame.add(panel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(operatorField);
        frame.add(errorField);
        frame.add(textField);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            for (int i = 0; i < 10; i++) {

                if (e.getSource() == numbers[i]) {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                    errorField.setText("");
                }

            }
            if (e.getSource() == decimalButton) {
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource() == addition) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
                operatorField.setText("+");
            }
            if (e.getSource() == substraction) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
                operatorField.setText("-");
            }
            if (e.getSource() == multiply) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
                operatorField.setText("*");
            }
            if (e.getSource() == substraction) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
                operatorField.setText("/");
            }
            if (e.getSource() == equalsButton) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                operatorField.setText("");
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == clearButton) {
                textField.setText("");
            }
            if (e.getSource() == deleteButton) {
                String str = textField.getText();
                textField.setText("");
                for (int i = 0; i < str.length() - 1; i++) {
                    textField.setText(textField.getText() + str.charAt(i));
                }
            }
            if (e.getSource() == negativeButton) {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
        } catch(NumberFormatException exception) {
            errorField.setText("Error: No number selected");
        }
    }
}
