package com.project;

import java.util.Map;

import javax.swing.JComboBox;

public class MyItems {
    private String name, symbol, lname;
    private double value;

    public MyItems() {
    }

    public MyItems(String name, String symbol, double value, String lname) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
        this.lname = lname;
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

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return name;
    }

    public void SetToComboBox(Map<String, getData> map, JComboBox<MyItems> iBox, JComboBox<MyItems> oBox) {
        for (var i : map.values()) {
            iBox.addItem(new MyItems(i.name, i.symbol, i.value, i.lname));
            oBox.addItem(new MyItems(i.name, i.symbol, i.value, i.lname));
        }
    }

    public double IBoxgetSelectedItem(JComboBox<MyItems> iBox) {
        MyItems selecteItem = (MyItems) iBox.getSelectedItem();
        if (selecteItem != null) {
            return selecteItem.getValue();
        } else {
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
