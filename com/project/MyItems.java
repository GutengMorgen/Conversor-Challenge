package com.project;

import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MyItems {
    private String actived;
    public String name, symbol, formula1, formula2;
    private double value;
    private static String CELSIUS = "Celsius", KELVIN = "Kelvin", FAHRENHEIT = "Fahrenheit";

    public MyItems() {
    }

    public MyItems(String name, String symbol, String formula1, String formula2) {
        this.name = name;
        this.symbol = symbol;
        this.formula1 = formula1;
        this.formula2 = formula2;
    }

    public MyItems(String name, String symbol, double value) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getActived() {
        return actived;
    }

    public void setActived(String actived) {
        this.actived = actived;
    }

    @Override
    public String toString() {
        return name;
    }

    public void SetCurrencyBox(Map<String, getData> map, JComboBox<MyItems> iBox, JComboBox<MyItems> oBox) {
        iBox.removeAllItems();
        oBox.removeAllItems();
        for (var i : map.values()) {
            iBox.addItem(new MyItems(i.name, i.symbol, i.value));
            oBox.addItem(new MyItems(i.name, i.symbol, i.value));
        }
    }

    public void setTemperatureBox(Map<String, getData> map, JComboBox<MyItems> iBox, JComboBox<MyItems> oBox) {
        iBox.removeAllItems();
        oBox.removeAllItems();
        for (var i : map.values()) {
            iBox.addItem(new MyItems(i.name, i.symbol, i.formula1, i.formula2));
            oBox.addItem(new MyItems(i.name, i.symbol, i.formula1, i.formula2));
        }
    }

    public void getTemperatureResult(double inputDouble, JTextField otext, JComboBox<MyItems> iBox,
            JComboBox<MyItems> oBox) {
        String iString = iBox.getSelectedItem().toString();
        String oString = oBox.getSelectedItem().toString();
        double result;

        if (iString.equals(oString)) {
            otext.setText(Double.toString(inputDouble));
            return;
        } else if (iString.equals(CELSIUS)) { // input :: Celsius
            if (oString.equals(FAHRENHEIT)) {
                result = (1.80 * inputDouble + 32);
                otext.setText(Double.toString(result));
            } else if (oString.equals(KELVIN)) {
                result = (inputDouble + 273.15);
                otext.setText(Double.toString(result));
            }
        } else if (iString.equals(FAHRENHEIT)) { // input :: fahrenheit
            if (oString.equals(CELSIUS)) {
                result = (inputDouble - 32) / 1.8;
                otext.setText(Double.toString(result));
            } else if (oString.equals(KELVIN)) {
                result = (inputDouble + 459.67) * 5 / 9;
                otext.setText(Double.toString(result));
            }
        } else if (iString.equals(KELVIN)) { // input :: Kelvin
            if (oString.equals(CELSIUS)) {
                result = (inputDouble - 273.15);
                otext.setText(Double.toString(result));
            } else if (oString.equals(FAHRENHEIT)) {
                result = (1.8 * (inputDouble - 273.15) + 32);
                otext.setText(Double.toString(result));
            }
        }
    }

    public void getCurrencyResult(double inputDouble, JTextField otext, JComboBox<MyItems> iBox,
            JComboBox<MyItems> oBox) {
        MyItems itemIBox = (MyItems) iBox.getSelectedItem();
        MyItems itemOBox = (MyItems) oBox.getSelectedItem();

        if (itemIBox.equals(itemOBox)) {
            otext.setText(Double.toString(inputDouble));
            return;
        } else {
            double result = (itemOBox.getValue() / itemIBox.getValue()) * inputDouble;
            otext.setText(Double.toString(result));
        }
    }
}
