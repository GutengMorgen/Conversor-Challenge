package com.project;

import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

class conversor implements ActionListener {
    private static final MyItems MY_ITEMS = new MyItems();
    static int gapX = 25;
    static int posX = 20;

    // for unit converter components
    static int UCposY = 20;
    static int UCheight = 40;

    // for I/O components
    static int IOheight = 60;
    static int IposY = 80;
    static int OposY = IOheight + IposY + gapX + 10;
    JFrame jf;
    JButton currencyBtn, temperatureBtn,
            convertBtn, CleanBtn;
    JTextField inputText, outputText;
    JComboBox<MyItems> inputBox, outputBox;

    conversor() {
        jf = new JFrame();

        // set Unit Converter buttons
        currencyBtn = new JButton("Currency");
        currencyBtn.setBounds(20, UCposY, 100, UCheight);
        currencyBtn.addActionListener(this);

        temperatureBtn = new JButton("Temperature");
        temperatureBtn.setBounds(120 + gapX, UCposY, 120, UCheight);
        temperatureBtn.addActionListener(this);

        // I/O buttons
        inputBox = new JComboBox<>();
        inputBox.setBounds(posX, IposY, 80, IOheight);

        outputBox = new JComboBox<>();
        outputBox.setBounds(posX, OposY, 80, IOheight);

        // I/O textfields
        inputText = new JTextField("1");
        inputText.setBounds(120, IposY, 350, IOheight);

        outputText = new JTextField("result");
        outputText.setEnabled(false);
        outputText.setBounds(120, OposY, 350, IOheight);

        // convert and clean buttons
        convertBtn = new JButton("CONVERT");
        convertBtn.setBounds(posX, 265, 370, IOheight);
        convertBtn.addActionListener(this);

        CleanBtn = new JButton("C");
        CleanBtn.setBounds(415, 265, 50, IOheight);
        CleanBtn.addActionListener(this);

        jf.add(currencyBtn);
        jf.add(temperatureBtn);

        jf.add(outputBox);
        jf.add(inputBox);

        jf.add(inputText);
        jf.add(outputText);

        jf.add(convertBtn);
        jf.add(CleanBtn);

        jf.setSize(500, 380);
        jf.setLayout(null);// using no layout managers
        jf.setVisible(true);// making the frame visible
        jf.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertBtn) {
            String getActive = MY_ITEMS.getActived();
            try {
                double iDouble = Double.parseDouble(inputText.getText());
                // System.out.println(iDouble);
                if (getActive == "Currency") {
                    MY_ITEMS.getCurrencyResult(iDouble, outputText, inputBox, outputBox);
                } else if (getActive == "Temperature") {
                    MY_ITEMS.getTemperatureResult(iDouble, outputText, inputBox, outputBox);
                }
            } catch (Exception ex) {
                outputText.setText(ex.getMessage());
            }
        } else if (e.getSource() == currencyBtn) {
            MY_ITEMS.setActived("Currency");

            Map<String, getData> map = getData.readCurrencyData();
            MY_ITEMS.SetCurrencyBox(map, inputBox, outputBox);
        } else if (e.getSource() == temperatureBtn) {
            MY_ITEMS.setActived("Temperature");

            Map<String, getData> map = getData.readTemperatureData();
            MY_ITEMS.setTemperatureBox(map, inputBox, outputBox);
        } else if (e.getSource() == CleanBtn) {
            inputText.setText("");
            outputText.setText("");
        }
    }

    public static void main(String[] args) {
        new conversor();
    }
}