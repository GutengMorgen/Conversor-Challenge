package com.project;

import javax.script.*;

public class MathExpression {
    public static void _main(String[] args) {
        String operation = "(3 * 4) - 2";

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            Object result = engine.eval(operation);

            // int resultInt = (int) result;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error al evaluar la expresión: " + e.getMessage());
        }
    }
}
