package com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses;

import com.shpp.p2p.cs.iburlaka.assignment14.MyArrayList;

public class Calculator {
    public static double calculate(MyArrayList<String> formulaList) {
        try {
            while (formulaList.size() != 1) {
                power(formulaList);
                multiplyAndDivide(formulaList);
                // System.out.println("mult" + formulaList);
                plusAndMinus(formulaList);
                // System.out.println("plus" + formulaList);
            }
            Double.parseDouble(formulaList.getElement(0));
        } catch (NumberFormatException n) {
            System.out.println("Something went wrong!\n" +
                    "Maybe you forgot input values for variables or inputted incorrect data " + n.getMessage());
            System.exit(1);
        }
        return Double.parseDouble(formulaList.getElement(0));
    }

    /**
     * In the method plus or minus operations are done
     * one by one
     *
     * @param formulaList - - parsed formula as list
     */
    private static void plusAndMinus(MyArrayList<String> formulaList) {
        for (int i = 0; i < formulaList.size(); i++) {
            if (formulaList.getElement(i).equals("+") && (i != 0)) {
                double firstValue = Double.parseDouble(formulaList.getElement(i - 1));
                double secondValue = Double.parseDouble(formulaList.getElement(i + 1));
                double plus = firstValue + secondValue;
                formulaUpdate(i, plus, formulaList);
                i = 0;
                if (formulaList.size() == 1) {
                    break;
                }
            } else if ((formulaList.getElement(i).equals("-")) && (i != 0)) {
                double firstValue = Double.parseDouble(formulaList.getElement(i - 1));
                double secondValue = Double.parseDouble(formulaList.getElement(i + 1));
                double minus = firstValue - secondValue;
                formulaUpdate(i, minus, formulaList);
                i = 0;
                if (formulaList.size() == 1) {
                    break;
                }
            }
        }
    }

    /**
     * In the method plus or minus operations are done
     * one by one
     * Also divided on zero is checked
     *
     * @param formulaList - parsed formula as list
     */
    private static void multiplyAndDivide(MyArrayList<String> formulaList) {
        for (int i = 0; i < formulaList.size(); i++) {
            if ((formulaList.getElement(i).equals("*")) && (i != 0)) {
                double firstValue = Double.parseDouble(formulaList.getElement(i - 1));
                double secondValue = Double.parseDouble(formulaList.getElement(i + 1));
                double multiply = firstValue * secondValue;
                formulaUpdate(i, multiply, formulaList);
                i = 0;
                if (formulaList.size() == 1) {
                    break;
                }
            } else if ((formulaList.getElement(i).equals("/")) && (i != 0)) {
                double firstValue = Double.parseDouble(formulaList.getElement(i - 1));
                double secondValue = Double.parseDouble(formulaList.getElement(i + 1));
                if (secondValue == 0) {
                    System.out.println("Divided on zero!");
                    System.exit(1);
                } else {
                    double divided = firstValue / secondValue;
                    formulaUpdate(i, divided, formulaList);
                    i = 0;
                    if (formulaList.size() == 1) {
                        break;
                    }
                }
            }
        }
    }

    private static void formulaUpdate(int index, double sign, MyArrayList<String> formulaList) {
        formulaList.setElement(index - 1, Double.toString(sign));
        formulaList.removeElement(index + 1);
        formulaList.removeElement(index);
    }

    /**
     * In the method power operation is done
     * Also taking a negative number to a fractional power is checked
     *
     * @param formulaList - parsed formula as list
     */
    private static void power(MyArrayList<String> formulaList) {
        for (int i = formulaList.size() - 1; i >= 0; i--) {
            if ((formulaList.getElement(i).equals("^"))) {
                double firstValue = Double.parseDouble(formulaList.getElement(i - 1));
                double secondValue = Double.parseDouble(formulaList.getElement(i + 1));
                if ((firstValue < 0) && ((secondValue % 1) != 0)) {
                    System.out.println("Invalid input - cannot take a negative number to a fractional power!");
                    System.exit(1);
                } else {
                    double power = Math.pow(firstValue, secondValue);
                    formulaUpdate(i, power, formulaList);
                }
                if (formulaList.size() == 1) {
                    break;
                }
            }
        }
    }
}
