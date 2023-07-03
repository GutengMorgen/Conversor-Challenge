package com.project;

import javax.swing.*;

public class testing {
    public static void main(String[] args) {
        Item opcion1 = new Item("option 1", 10);
        Item opcion2 = new Item("option 2", 20);
        Item opcion3 = new Item("option 3", 30);

        JComboBox<Item> comboBox = new JComboBox<>();
        comboBox.addItem(opcion1);
        comboBox.addItem(opcion2);
        comboBox.addItem(opcion3);
        // comboBox.setSelectedItem(opcion2);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(comboBox);
        frame.setVisible(true);

        Item selectedItem = (Item) comboBox.getSelectedItem();
        if (selectedItem != null) {
            int valorEntero = selectedItem.getValue();
            System.out.println("Valor entero seleccionado: " + valorEntero);
        }
    }
}

class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}