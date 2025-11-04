import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{


    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];

    JButton[] functionButtons = new JButton[16];


    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;


    JButton cosButton, sinButton, tanButton, logButton, piButton, sqrtButton, powButton;

    JPanel panel;
    Font myFont = new Font("Ink Free",Font.BOLD,20);
    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){

        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 550);
        frame.setLayout(null);

        // txtfield ry8miseis
        textfield = new JTextField();
        textfield.setBounds(20, 20, 395, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        // arxikopoihsh
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        cosButton = new JButton("cos");
        sinButton = new JButton("sin");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        piButton = new JButton("π");
        sqrtButton = new JButton("sqrt");
        powButton = new JButton("^");

        //16 functionButtons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = cosButton;
        functionButtons[10] = sinButton;
        functionButtons[11] = tanButton;
        functionButtons[12] = logButton;
        functionButtons[13] = piButton;
        functionButtons[14] = sqrtButton;
        functionButtons[15] = powButton;


        //loop functionButtons
        Color purpleColor = new Color(128, 0, 128); // deep purple
        for(int i =0;i<16;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(purpleColor);
            functionButtons[i].setForeground(Color.WHITE);
        }

        // loop numberButtons
        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }


        panel = new JPanel();
        panel.setBounds(20, 80, 395, 400);
        panel.setLayout(new GridLayout(5,5,10,10));
        panel.setBackground(Color.LIGHT_GRAY);


        //sin, cos, tan, log, π
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(piButton);

        // sqrt, ^, Del, Clr, /
        panel.add(sqrtButton);
        panel.add(powButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(divButton);

        // 7, 8, 9, *
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(negButton);
        //  4, 5, 6, -
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(addButton);
        //  1, 2, 3, ., =
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(decButton);
        panel.add(equButton);


        frame.add(panel);
        frame.add(textfield);
        // delButton, clrButton, negButton, cosButton efygan apo do
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }



        if(e.getSource() == piButton) {
            textfield.setText(String.valueOf(Math.PI));
        }

        // organosh cos sin tan log sqrt
        if(e.getSource() == cosButton || e.getSource() == sinButton || e.getSource() == tanButton || e.getSource() == logButton || e.getSource() == sqrtButton) {
            try {
                double num = Double.parseDouble(textfield.getText());
                double result = 0;
                String command = e.getActionCommand();

                if (command.equals("cos")) {
                    result = Math.cos(Math.toRadians(num));
                } else if (command.equals("sin")) {
                    result = Math.sin(Math.toRadians(num));
                } else if (command.equals("tan")) {
                    result = Math.tan(Math.toRadians(num));
                } else if (command.equals("log")) {
                    if (num > 0) {
                        result = Math.log10(num); // log10
                    } else {
                        textfield.setText("Error (Log Domain)");
                        return;
                    }
                } else if (command.equals("sqrt")) {
                    if (num >= 0) {
                        result = Math.sqrt(num);
                    } else {
                        textfield.setText("Error negative root");
                        return;
                    }
                }
                textfield.setText(String.valueOf(result));
            } catch (NumberFormatException ex){
                textfield.setText("Error");
            }
        }

        // binary operators
        if(e.getSource()==decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='*';
            textfield.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='/';
            textfield.setText("");
        }
         // dynamh
        if(e.getSource()==powButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '^';
            textfield.setText("");
        }

        // =
        if(e.getSource()==equButton) {
            try {
                num2=Double.parseDouble(textfield.getText());
                switch(operator) {
                    case'+':
                        result=num1+num2;
                        break;
                    case'-':
                        result=num1-num2;
                        break;
                    case'*':
                        result=num1*num2;
                        break;
                    case'/':
                        if (num2 == 0) {
                            textfield.setText("Error (divided by 0");
                            return;
                        }
                        result=num1/num2;
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        break;
                }
                textfield.setText(String.valueOf(result));
                num1=result;
            } catch (NumberFormatException ex) {
                textfield.setText("Error");
            } catch (ArithmeticException ex) {
                textfield.setText("Error");
            }
        }

        // clear del neg
        if(e.getSource()==clrButton) {
            textfield.setText("");
            num1 = 0;
            num2 = 0;
            operator = ' ';
        }
        if(e.getSource()==delButton) {
            String string = textfield.getText();
            if (string.length() > 0) {
                textfield.setText(string.substring(0, string.length() - 1));
            }
        }
        if(e.getSource()==negButton) {
            try {
                double temp = Double.parseDouble(textfield.getText());
                temp*=-1;
                textfield.setText(String.valueOf(temp));
            } catch (NumberFormatException ex) {

            }
        }
    }
}