package com.project;

import java.util.Map;

import javax.swing.JComboBox;

public class MyItems {
    private String name, symbol;
    private double value;

    public MyItems() {
    }

    public MyItems(String name, String symbol, double value) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }

    public void SetToComboBox(Map<String, getData> map, JComboBox<MyItems> iBox, JComboBox<MyItems> oBox) {
        for (var i : map.values()) {
            iBox.addItem(new MyItems(i.name, i.symbol, i.value));
            oBox.addItem(new MyItems(i.name, i.symbol, i.value));
        }
    }

    public double IBoxgetSelectedItem(JComboBox<MyItems> iBox) {
        MyItems selecteItem = (MyItems) iBox.getSelectedItem();
        if (selecteItem != null) {
            return selecteItem.getValue();
        } else {
            // TODO: agregar un manejo de errores adecuado
            return 0.0;
        }
    }

    public double OBoxGetSelectedItem(JComboBox<MyItems> oBox) {
        MyItems selecItem = (MyItems) oBox.getSelectedItem();
        if (selecItem != null) {
            return selecItem.getValue();
        } else {
            return 0.0;
        }
    }
}
