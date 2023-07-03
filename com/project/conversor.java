package com.project;

import javax.swing.*;
import java.awt.event.*;
// import java.util.ArrayList;
// import java.util.List;
// import com.project.getData;
import java.util.Map;

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
            CleanBtn;
    JComboBox<MyItems> inputBox, outputBox;
    // String[] languages = { "C", "C++", "C#", "Java", "PHP" };

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
        inputBox = new JComboBox<>();
        inputBox.setBounds(posX, IposY, 80, IOheight);

        outputBox = new JComboBox<>();
        outputBox.setBounds(posX, OposY, 80, IOheight);

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

    public String getResult(String itext, double ibtn, double obtn) {
        if (ibtn == obtn) {
            return itext;
        } else {
            // TODO: agregar manejo de excepciones
            double input = Double.parseDouble(itext);
            double result = (obtn / ibtn) * input;
            return Double.toString(result);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == convertBtn) {

            String itext = inputText.getText();
            double iboxdouble = new MyItems().IBoxgetSelectedItem(inputBox);
            double oboxdouble = new MyItems().OBoxGetSelectedItem(outputBox);
            // System.out.println(iboxdouble + "\n" + oboxdouble);
            String result = getResult(itext, iboxdouble, oboxdouble);
            outputText.setText(result);

        } else if (e.getSource() == CleanBtn) {

            inputText.setText("");
            outputText.setText("");

        } else if (e.getSource() == currencyBtn) {

            Map<String, getData> map = getData.readCurrencyData();
            new MyItems().SetToComboBox(map, inputBox, outputBox);

        } else if (e.getSource() == temperatureBtn) {

            Map<String, getData> map = getData.readTemperatureData();
            new MyItems().SetToComboBox(map, inputBox, outputBox);

        } else if (e.getSource() == measureBtn) {

            // Map<String, getData> map = getData.readOthersData();
            // new MyItems().SetToComboBox(map, inputBox, outputBox);
        }
    }

    public static void main(String[] args) {
        // new conversor();
        String operation = "(K * 4) - 5";
        String result = operation.replace("K", "3");
        System.out.println(result);
    }
}