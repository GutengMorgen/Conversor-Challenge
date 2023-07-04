package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class getData {
    static String line = "";
    static String splitBy = ";";

    public String name, symbol, formula1, formula2;
    public double value;

    public getData() {
    }

    public getData(String name, String symbol, String value) {
        this.name = name;
        this.symbol = symbol;
        this.value = Double.parseDouble(value);
    }

    public getData(String name, String symbol, String formula1, String formula2) {
        this.name = name;
        this.symbol = symbol;
        this.formula1 = formula1;
        this.formula2 = formula2;
    }

    public static Map<String, getData> readCurrencyData() {
        Map<String, getData> setCurrencies = new HashMap<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader("com\\project\\Data\\currency.csv"))) {
            while ((line = buffer.readLine()) != null) {
                String[] getText = line.split(splitBy);
                setCurrencies.put(getText[0], new getData(getText[0], getText[1], getText[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return setCurrencies;
    }

    public static Map<String, getData> readTemperatureData() {
        Map<String, getData> setTemperatures = new HashMap<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader("com\\project\\Data\\temperature.csv"))) {
            while ((line = buffer.readLine()) != null) {
                String[] getText = line.split(splitBy);
                setTemperatures.put(getText[0], new getData(getText[0], getText[1], getText[2], getText[3]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO: poner un manejo de errores si Map esta vacio
        return setTemperatures;
    }
}
