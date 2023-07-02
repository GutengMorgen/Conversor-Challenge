package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class getData {
    static String line = "";
    static String splitBy = ";";

    public String name;
    public String symbol;
    public double value;
    public String lname;

    public static void main(String[] args) {
        readCurrencyData();
    }

    public getData() {
    }

    public getData(String name, String symbol, String value, String lname) {
        this.name = name;
        this.symbol = symbol;
        this.value = Double.parseDouble(value);
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

    public static Map<String, getData> readCurrencyData() {
        Map<String, getData> getCurrency = new HashMap<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader("com\\project\\Data\\currency.csv"))) {
            while ((line = buffer.readLine()) != null) {
                String[] getText = line.split(splitBy);

                // System.out.println(getText[0]);
                getCurrency.put(getText[0], new getData(getText[0], getText[1], getText[2], getText[3]));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return getCurrency;
        /*
         * String actualKey = "PEN";
         * if (getCurrency.containsKey(actualKey)) {
         * getData data = getCurrency.get(actualKey);
         * // return data;
         * System.out.println(data.name + " " + data.symbol + " " + data.value + " " +
         * data.lname);
         * } else {
         * System.out.println("no disponible");
         * // return new getData();
         * }
         */
    }

    public static void readTemperatureData() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("com\\project\\Data\\temperature.csv"))) {
            while ((line = buffer.readLine()) != null) {
                String[] currency = line.split(splitBy);

                System.out.println(currency[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readOthersData() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("com\\project\\Data\\others.csv"))) {
            while ((line = buffer.readLine()) != null) {
                String[] currency = line.split(splitBy);

                System.out.println(currency[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
