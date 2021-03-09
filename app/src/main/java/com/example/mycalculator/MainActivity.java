package com.example.mycalculator;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private TextView textView, preResultTextView;
    private List<Object> calculateList = new ArrayList<>();
    private String partNumber = "";
    private final String actions = "%+-*/^";



    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String auxString;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonPoint = findViewById(R.id.button_point);

        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonMultiplication = findViewById(R.id.button_multiply);
        Button buttonDIV = findViewById(R.id.button_split);

        Button buttonResult = findViewById(R.id.button_result);

        Button buttonPercent = findViewById(R.id.button_percent);
        Button buttonGP = findViewById(R.id.button_generate_password);

        Button buttonMemoryClear = findViewById(R.id.button_memory_clear);
        Button buttonMemoryPlus = findViewById(R.id.button_memory_plus);
        Button buttonMemoryRead = findViewById(R.id.button_memory_read);
        Button buttonMemoryMinus = findViewById(R.id.button_memory_minus);

        Button buttonSQRT = findViewById(R.id.button_sqrt);
        Button buttonSquare = findViewById(R.id.button_square);

        Button buttonCancel = findViewById(R.id.button_cancel);
        Button buttonBackSpace = findViewById(R.id.button_back);

        textView = findViewById(R.id.textView);
        preResultTextView = findViewById(R.id.textView2);
        textView.setText("");
        preResultTextView.setText("");

        button0.setOnClickListener(v -> {
            if (textView.getText().toString().length() == 1 & textView.getText().toString().equals("0")) {
                        return;
                    }
                    textView.setText(textView.getText().toString() + "0");
                    partNumber = partNumber + "0";
            if (calculateList.size() >= 2) {
                        preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button1.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "1");
            partNumber = partNumber + "1";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button2.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "2");
            partNumber = partNumber + "2";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button3.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "3");
            partNumber = partNumber + "3";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button4.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "4");
            partNumber = partNumber + "4";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button5.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "5");
            partNumber = partNumber + "5";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button6.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "6");
            partNumber = partNumber + "6";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button7.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "7");
            partNumber = partNumber + "7";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button8.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "8");
            partNumber = partNumber + "8";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        button9.setOnClickListener(v -> {
            textView.setText(textView.getText().toString() + "9");
            partNumber = partNumber + "9";
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }
        });
        buttonPoint.setOnClickListener(v -> {
            if (textView.getText().toString().contains(".")) {
                return;
            }
            textView.setText(textView.getText().toString() + ".");
            partNumber = partNumber + ".";
        });
        buttonPlus.setOnClickListener(v -> {
            if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                return;
            }

            preResultTextView.setText(resultMethod(true, partNumber));
            textView.setText(textView.getText().toString() + "+");
            calculateList.add("+");

        });
        buttonMinus.setOnClickListener(v -> {
            if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                return;
            }
            textView.setText(textView.getText().toString() + "-");
            preResultTextView.setText(resultMethod(true, partNumber));
            calculateList.add("-");
        });
        buttonMultiplication.setOnClickListener(v -> {
            if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                return;
            }
            textView.setText(textView.getText().toString() + "*");
            preResultTextView.setText(resultMethod(true, partNumber));
            calculateList.add("*");
        });
        buttonDIV.setOnClickListener(v -> {
            if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                return;
            }
            textView.setText(textView.getText().toString() + "/");
            preResultTextView.setText(resultMethod(true, partNumber));
            calculateList.add("/");
        });
        buttonCancel.setOnClickListener(v -> {
            textView.setText("");
            preResultTextView.setText("");
            calculateList.clear();
            index = 0;
            partNumber = "";
        });
        buttonBackSpace.setOnClickListener(v -> {
            String auxString = textView.getText().toString().substring(textView.getText().toString().length() - 1);
            if (!actions.contains(auxString)) {
                partNumber = partNumber.substring(0,partNumber.length() - 1);
            } else {
                calculateList.remove(calculateList.size() - 1);
            }
            textView.setText(textView.getText().toString().substring(0,textView.getText().toString().length() - 1));
            if (calculateList.size() >= 2) {
                preResultTextView.setText(resultMethod(false, partNumber));
            }

        });
        buttonResult.setOnClickListener(v -> {
            calculateList.clear();
            try {
                calculateList.add(Double.parseDouble(preResultTextView.getText().toString()));
            } catch (NumberFormatException e) {
                Log.e("PARSE ", "onCreate: ", e );
            }
            textView.setText(preResultTextView.getText());
            partNumber = preResultTextView.getText().toString();
            preResultTextView.setText("");
            index = 0;
        });
        buttonPercent.setOnClickListener(v -> {
            if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                return;
            }
            textView.setText(textView.getText().toString() + "%");
            preResultTextView.setText(resultMethod(true, partNumber));
            calculateList.add("%");
        });

    }

    private String resultMethod(boolean flag, String partB) {

        if (calculateList.size() < 1 & flag) {
            calculateList.add(Double.parseDouble(partB));
            partNumber = "";
            return partB;
        }
        if (actions.contains(calculateList.get(calculateList.size() - 1).toString())) {
            calculateList.add(Double.parseDouble(partB));
        } else {
            calculateList.set(calculateList.size() - 1, Double.parseDouble(partB));
        }
        if (flag) {
            partNumber = "";
        }
        return CalculationRPN.calc(ReversePolishNotation.transformationString(calculateList));
    }

    private boolean checkSymbol(String charAction) {
        String m = "%+-*/^";
        return m.contains(charAction);
    }

}