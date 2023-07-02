package com.project;

import javax.swing.*;
import java.awt.event.*;
// import com.project.getData;

class conversor implements ActionListener {

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
    JTextField inputText, outputText;
    JButton currencyBtn, temperatureBtn,
            measureBtn, convertBtn,
            CleanBtn, inputBtn,
            outputBtn;

    conversor() {
        jf = new JFrame();

        // set Unit Converter buttons
        currencyBtn = new JButton("Currency");
        currencyBtn.setBounds(20, UCposY, 100, UCheight);
        currencyBtn.addActionListener(this);

        temperatureBtn = new JButton("Temperature");
        temperatureBtn.setBounds(120 + gapX, UCposY, 120, UCheight);
        temperatureBtn.addActionListener(this);

        measureBtn = new JButton("Measure");
        measureBtn.setBounds(265 + gapX, UCposY, 100, UCheight);
        measureBtn.addActionListener(this);

        // I/O buttons
        inputBtn = new JButton("USD");
        inputBtn.setBounds(posX, IposY, 80, IOheight);

        outputBtn = new JButton("EUR");
        outputBtn.setBounds(posX, OposY, 80, IOheight);

        // I/O textfields
        inputText = new JTextField("insert valor");
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
        jf.add(measureBtn);

        jf.add(inputBtn);
        jf.add(outputBtn);

        jf.add(inputText);
        jf.add(outputText);

        jf.add(convertBtn);
        jf.add(CleanBtn);

        jf.setSize(500, 380);
        jf.setLayout(null);// using no layout managers
        jf.setVisible(true);// making the frame visible
        jf.setResizable(false);
    }

    public String testing(String itext, String ibtn, String obtn) {
        if (ibtn == obtn) {
            return itext;
        } else {
            return itext + ibtn + obtn;
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == convertBtn) {
            String itext = inputText.getText();
            String ibtn = inputBtn.getText();
            String obtn = outputBtn.getText();

            outputText.setText(testing(itext, ibtn, obtn));
        } else if (e.getSource() == CleanBtn) {
            inputText.setText("");
            outputText.setText("");
        } else if (e.getSource() == currencyBtn) {
            getData.readCurrencyData();
        } else if (e.getSource() == temperatureBtn) {
            getData.readTemperatureData();
        } else if (e.getSource() == measureBtn) {
            getData.readOthersData();
        }
    }

    public static void main(String[] args) {
        new conversor();
    }
}