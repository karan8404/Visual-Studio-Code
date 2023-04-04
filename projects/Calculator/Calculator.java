package Calculator;

//implementing a simple calculator.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;// Frame of buttons
    JTextField textField;// Number field.
    JButton[] numButtons = new JButton[10];
    JButton[] funButtons = new JButton[8];// function buttons
    JButton add, subtract, multiply, divide, delete, decimal, equals, clear;
    JPanel panel;
    Font myFont = new Font("Javanese text", Font.BOLD, 20);

    double operand1 = 0, operand2 = 0;
    double result = 0;
    char operator;

    // Non parameterized constructor.
    public Calculator() {
        // all frame operations
        frame = new JFrame("Calculator By Karan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(53, 53, 53));

        // textfield operations
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // all function button operations
        funButtons[0] = add = new JButton("+");
        funButtons[1] = subtract = new JButton("-");
        funButtons[2] = multiply = new JButton("*");
        funButtons[3] = divide = new JButton("/");
        funButtons[4] = equals = new JButton("=");
        funButtons[5] = decimal = new JButton(".");
        funButtons[6] = clear = new JButton("clr");
        funButtons[7] = delete = new JButton("del");
        for (int i = 0; i < 8; i++) {
            funButtons[i].addActionListener(this);
            funButtons[i].setFont(myFont);
            funButtons[i].setFocusable(false);
        }
        delete.setBounds(50, 430, 145, 50);
        clear.setBounds(205, 430, 145, 50);

        // all number button operations
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(i + "");
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        // all panel operations
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(null);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(add);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subtract);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(multiply);
        panel.add(decimal);
        panel.add(numButtons[0]);
        panel.add(equals);
        panel.add(divide);

        // finalizing frame operations
        frame.add(textField);
        frame.add(delete);
        frame.add(clear);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == decimal) {
            textField.setText(textField.getText() + ".");
        }

        else if (e.getSource() == add) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        else if (e.getSource() == subtract) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        else if (e.getSource() == multiply) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        else if (e.getSource() == divide) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        else if(e.getSource()==clear){
            textField.setText("");
        }

        else if(e.getSource()==delete){
            textField.setText(textField.getText().substring(0,textField.getText().length()-1)); 
        }

        else if (e.getSource() == equals) {
            operand2 = Double.parseDouble(textField.getText());
            result = math.operate(operand1, operand2, operator);
            textField.setText(result+"");
            operand1=result;
        }
    }
}