package com.project;

import java.io.BufferedReader;
import java.io.FileReader;

public class getData {
    static String line = "";
    static String splitBy = ";";

    public static void readCurrencyData() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("com\\project\\Data\\currency.csv"))) {
            while ((line = buffer.readLine()) != null) {
                String[] currency = line.split(splitBy);

                System.out.println(currency[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
