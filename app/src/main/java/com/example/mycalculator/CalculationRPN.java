package com.example.mycalculator;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class CalculationRPN {
    public static  String calc(List expRPN) {
        String actions = "%^*/+-";
        String resultString = "";
        List linkedListRPN = new LinkedList();
        int i = 0;
        final byte outputSize = 13;

        linkedListRPN.addAll(expRPN);

        try {
            while (linkedListRPN.size() > 1) {
                if (actions.contains(linkedListRPN.get(i).toString())) {
                    switch (linkedListRPN.get(i).toString()) {
                        case ("%") :{
                            linkedListRPN.set(i - 2, (Double) linkedListRPN.get(i-2) / 100 * (Double) linkedListRPN.get(i - 1));
                            break;
                        }
                        case ("^") :{
                            linkedListRPN.set(i - 2, Math.pow((Double) linkedListRPN.get(i-2), (Double) linkedListRPN.get(i - 1)));
                            break;
                        }
                        case ("*") :{
                            linkedListRPN.set(i - 2, (Double) linkedListRPN.get(i-2) * (Double) linkedListRPN.get(i - 1));
                            break;
                        }
                        case ("/") :{
                            if ((Double) linkedListRPN.get(i - 1) == 0) {
                                return "Деление на 0";
                            }
                            linkedListRPN.set(i - 2, (Double) linkedListRPN.get(i-2) / (Double) linkedListRPN.get(i - 1));
                            break;
                        }
                        case ("+") :{
                            linkedListRPN.set(i - 2, (Double) linkedListRPN.get(i-2) + (Double) linkedListRPN.get(i - 1));
                            break;
                        }
                        case ("-") :{
                            linkedListRPN.set(i - 2, (Double) linkedListRPN.get(i-2) - (Double) linkedListRPN.get(i - 1));
                            break;
                        }
                    }
                    linkedListRPN.remove(i);
                    linkedListRPN.remove(i - 1);
                    i = i - 2;
                }
                i++;
            }
        } catch (Exception e) {
            Log.e("TAGNum", "calc: ", e);
        }

        resultString = linkedListRPN.toString().substring(1,linkedListRPN.toString().indexOf("]"));
        if ((Double) linkedListRPN.get(0)%1 == 0) {
            resultString = resultString.substring(0, resultString.indexOf("."));
        }
        /*if (resultString.length() > outputSize) {

        }*/

        return resultString;
    }
}
