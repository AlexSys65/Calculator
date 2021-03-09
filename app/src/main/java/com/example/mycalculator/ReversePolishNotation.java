package com.example.mycalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReversePolishNotation {

    public static List<Object> transformationString(List<Object> arithmeticExpression) {
        HashMap<String, Integer> priority;

        if (arithmeticExpression.isEmpty()) {
            return null;
        }
        List<Object> outputStack = new ArrayList<>();
        List<String> actStack = new ArrayList<>();
        final String actions = "%^*/+-()";
        final String briefActions = "%^*/+-";
        int j;
        priority = new HashMap<>();
        priority.put("%",5);
        priority.put("^",4);
        priority.put("*",3);
        priority.put("/",3);
        priority.put("+",2);
        priority.put("-",2);
        priority.put("(",1);
        priority.put(")",1);

        for (Object o : arithmeticExpression) {
            if (briefActions.contains(arithmeticExpression.get(0).toString())) {
                outputStack.add("0");
                continue;
            }
            if (actions.contains(o.toString())) {
                //actionProcessing(o.toString(), actStack, outputStack);
                j = -1;
                if (actStack.isEmpty() | o.toString().equals("(")) {
                    actStack.add(o.toString());
                    continue;
                }
                for (int i = actStack.size() - 1; i >= 0; i--) {
                    if (o.toString().equals(")")) {
                        while (!actStack.get(i).equals("(")) {
                            outputStack.add(actStack.get(i));
                            i--;
                            j++;
                        }
                        actStack.remove(i);
                        break;
                    }
                    if (priority.get(actStack.get(i)) < priority.get(o.toString())) {break;}
                    outputStack.add(actStack.get(i));
                    j++;
                }
                while (j >= 0){
                    actStack.remove(actStack.size() - 1);
                    j--;
                }
                if (!o.toString().equals(")")) {
                    actStack.add(o.toString());
                }
            } else {
                outputStack.add(o);
            }
        }
        if (!actStack.isEmpty()) {
            for (int i = actStack.size() - 1; i >= 0; i--) {
                outputStack.add(actStack.get(i));
            }
        }
        return outputStack;
    }

   /* private static void actionProcessing(String act, List<String> actStack, List<Object> outStack) {

        int j = -1;
        if (actStack.isEmpty() | act.equals("(")) {
            actStack.add(act);
            return;
        }
        for (int i = actStack.size() - 1; i >= 0; i--) {
            if (act.equals(")")) {
                while (!actStack.get(i).equals("(")) {
                    outStack.add(actStack.get(i));
                    i--;
                    j++;
                }
                actStack.remove(i);
                break;
            }
            if (priority.get(actStack.get(i)) < priority.get(act)) {break;}
            outStack.add(actStack.get(i));
            j++;
        }
        while (j >= 0){
            actStack.remove(actStack.size() - 1);
            j--;
        }
        if (!act.equals(")")) {
            actStack.add(act);
        }
    }*/
}
