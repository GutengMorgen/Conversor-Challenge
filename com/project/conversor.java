package com.project;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
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
        currencyBtn.addActionListener(this);

        currencyBtn.setBorder(new LineBorder(new Color(0, 128, 0), 2));
        currencyBtn.setForeground(new Color(0, 64, 128));
        currencyBtn.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        currencyBtn.setFocusPainted(false);
        currencyBtn.setBackground(SystemColor.inactiveCaptionBorder);
        currencyBtn.setBounds(10, 12, 220, 40);

        temperatureBtn = new JButton("Temperature");
        temperatureBtn.addActionListener(this);

        temperatureBtn.setFocusPainted(false);
        temperatureBtn.setForeground(new Color(0, 70, 0));
        temperatureBtn.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        temperatureBtn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        temperatureBtn.setBorder(new LineBorder(new Color(0, 128, 0), 2));
        temperatureBtn.setBackground(SystemColor.inactiveCaptionBorder);
        temperatureBtn.setBounds(254, 12, 220, 40);

        // I/O comboBox
        inputBox = new JComboBox<>();
        inputBox.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        inputBox.setEditable(true);
        inputBox.setBorder(null);
        inputBox.setBackground(new Color(250, 250, 250));
        inputBox.setBounds(10, 108, 130, 40);

        outputBox = new JComboBox<>();
        // outputBox.setBounds(posX, OposY, 80, IOheight);
        outputBox.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        outputBox.setBorder(null);
        outputBox.setEditable(true);
        outputBox.setBackground(new Color(250, 250, 250));
        outputBox.setBounds(10, 197, 130, 40);

        // I/O textfields
        inputText = new JTextField();
        inputText.setHorizontalAlignment(SwingConstants.CENTER);
        inputText.setForeground(Color.BLACK);
        inputText.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        inputText.setDisabledTextColor(Color.BLACK);
        inputText.setColumns(10);
        inputText.setBorder(new CompoundBorder(new LineBorder(new Color(240, 240, 240), 1, true),
                new LineBorder(new Color(240, 240, 240), 0, true)));
        inputText.setBackground(new Color(250, 250, 250));
        inputText.setBounds(174, 108, 300, 40);

        outputText = new JTextField("result");
        outputText.setBorder(new CompoundBorder(new LineBorder(new Color(240, 240, 240), 1, true),
                new LineBorder(new Color(240, 240, 240), 0, true)));
        outputText.setDisabledTextColor(new Color(0, 0, 0));
        outputText.setEnabled(false);
        outputText.setHorizontalAlignment(SwingConstants.CENTER);
        outputText.setForeground(new Color(0, 0, 0));
        outputText.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        outputText.setColumns(10);
        outputText.setBackground(new Color(250, 250, 250));
        outputText.setBounds(174, 197, 300, 40);

        // convert and clean buttons
        convertBtn = new JButton("CONVERT");
        convertBtn.addActionListener(this);

        convertBtn.setFocusPainted(false);
        convertBtn.setBorder(new LineBorder(Color.BLACK, 2));
        convertBtn.setForeground(new Color(0, 64, 128));
        convertBtn.setFont(new Font("Franklin Gothic Book", Font.BOLD, 35));
        convertBtn.setBackground(SystemColor.inactiveCaptionBorder);
        convertBtn.setBounds(10, 295, 350, 65);

        CleanBtn = new JButton("C");
        CleanBtn.addActionListener(this);

        CleanBtn.setFocusPainted(false);
        CleanBtn.setBorder(new LineBorder(new Color(128, 0, 0), 2));
        CleanBtn.setForeground(new Color(128, 0, 0));
        CleanBtn.setFont(new Font("Franklin Gothic Book", Font.BOLD, 35));
        CleanBtn.setBackground(SystemColor.inactiveCaptionBorder);
        CleanBtn.setBounds(399, 295, 75, 65);

        jf.add(currencyBtn);
        jf.add(temperatureBtn);

        jf.add(outputBox);
        jf.add(inputBox);

        jf.add(inputText);
        jf.add(outputText);

        jf.add(convertBtn);
        jf.add(CleanBtn);

        jf.setBounds(120, 120, 500, 410);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setTitle("Conversor");
        jf.setAlwaysOnTop(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setIconImage(new ImageIcon("com\\project\\figure.png").getImage());
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