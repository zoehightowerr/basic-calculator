import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calcFrame extends JFrame implements ActionListener{

    static JButton zero;
    static JButton one;
    static JButton two;
    static JButton three;
    static JButton four;
    static JButton five;
    static JButton six;
    static JButton seven;
    static JButton eight;
    static JButton nine;
    static JButton add;
    static JButton subtract;
    static JButton divide;
    static JButton multiple;
    static JButton percent;
    static JButton clear;
    static JButton point;
    static JButton equal;
    static JButton negative;

    static JTextField textField;
    
    private double num1, num2, result;
    private char operator;

    calcFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(250,425);
        this.setResizable(false);


        JPanel panel= new JPanel(); 
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,2,2));

        zero= new JButton("0");
        zero.setPreferredSize(new Dimension(100,60));
        one = new JButton("1");
        one.setPreferredSize(new Dimension(50,60));
        two= new JButton("2");
        two.setPreferredSize(new Dimension(50,60));
        three= new JButton("3");
        three.setPreferredSize(new Dimension(50,60));
        four= new JButton("4");
        four.setPreferredSize(new Dimension(50,60));
        five= new JButton("5");
        five.setPreferredSize(new Dimension(50,60));
        six= new JButton("6");
        six.setPreferredSize(new Dimension(50,60));
        seven= new JButton("7");
        seven.setPreferredSize(new Dimension(50,60));
        eight= new JButton("8");
        eight.setPreferredSize(new Dimension(50,60));
        nine= new JButton("9");
        nine.setPreferredSize(new Dimension(50,60));
        add= new JButton("+");
        add.setPreferredSize(new Dimension(50,60));
        subtract= new JButton("-");
        subtract.setPreferredSize(new Dimension(50,60));
        divide= new JButton("÷");
        divide.setPreferredSize(new Dimension(50,60));
        multiple= new JButton("x");
        multiple.setPreferredSize(new Dimension(50,60));
        clear= new JButton("C");
        clear.setPreferredSize(new Dimension(50,60));
        negative= new JButton("+/-");
        negative.setPreferredSize(new Dimension(50,60));
        percent= new JButton("%");
        percent.setPreferredSize(new Dimension(50,60));
        point= new JButton(".");
        point.setPreferredSize(new Dimension(50,60));
        equal= new JButton("=");
        equal.setPreferredSize(new Dimension(50,60));
        
        panel.add(clear);
        panel.add(negative);
        panel.add(percent);
        panel.add(divide);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(multiple);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(subtract);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(add);
        panel.add(zero);
        panel.add(point);
        panel.add(equal);

        JPanel panel2= new JPanel();

    
        textField= new JTextField();
        textField.setPreferredSize(new Dimension(250, 80));
        textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textField.setBackground(new Color(0xFFE1F5FE));
        textField.setEditable(false);

        panel2.add(textField);

        panel2.setBounds(0, 0, 250, 80);
        panel.setBounds(0, 80, 250, 325);
        this.add(panel2);
        this.add(panel);

        this.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : new JButton[]{zero, one, two, three, four, five, six, seven, eight, nine}) {
            if (e.getSource() == button) {
                textField.setText(textField.getText() + button.getText());
                return;
            }
        }
        if (e.getSource() == point) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }
        if (e.getSource() == clear) {
            textField.setText("");
        }
        if (e.getSource() == negative) {
            if (textField.getText().length() > 0) {
                double value = Double.parseDouble(textField.getText());
                value = value * -1;
                textField.setText(String.valueOf(value));
            }
        }
        if (e.getSource() == add || e.getSource() == subtract || e.getSource() == divide || e.getSource() == multiple) {
            num1 = Double.parseDouble(textField.getText());
            operator = ((JButton)e.getSource()).getText().charAt(0);
            textField.setText("");
        }
        if (e.getSource() == equal) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        }
    }
