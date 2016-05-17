package com.example.kashish.calculatorapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends Activity {
    private String numbers = new String("");
    private String display = new String("");
    private LinkedList<String> operation = new LinkedList<String>();
    private Float result = (Float) null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    public void onClickClear(View v) {
        this.numbers = new String("");
        this.operation = new LinkedList<String>();
        this.result = (Float) null;
        this.display = new String("");
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickZero(View v) {
        this.numbers += "0";
        this.display += "0";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickOne(View v) {
        this.numbers += "1";
        this.display += "1";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickTwo(View v) {
        this.display += "2";
        this.numbers += "2";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickThree(View v) {
        this.numbers += "3";
        this.display += "3";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickFour(View v) {
        this.numbers += "4";
        this.display += "4";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickFive(View v) {
        this.numbers += "5";
        this.display += "5";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickSix(View v) {
        this.numbers += "6";
        this.display += "6";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickSeven(View v) {
        this.numbers += "7";
        this.display += "7";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickEight(View v) {
        this.numbers += "8";
        this.display += "8";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickNine(View v) {
        this.numbers += "9";
        this.display += "9";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickPlus(View v) {
        this.operation.add("+");
        this.numbers += " ";
        this.display += "+";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickMinus(View v) {
        this.operation.add("-");
        this.numbers += " ";
        this.display += "-";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickMultiply(View v) {
        this.operation.add("*");
        this.numbers += " ";
        this.display += "×";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickDivision(View v) {
        this.operation.add("/");
        this.numbers += " ";
        this.display += "÷";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickEqual(View v) {

        if (this.numbers.isEmpty()) {
            Toast toast = Toast.makeText(getApplicationContext(), "No numbers",
                    Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Log.d("sad", this.numbers.split(" ").toString());
        LinkedList<String> operators = new LinkedList<String>();
        LinkedList<Float> numbers = new LinkedList<Float>();
        LinkedList<Float> numbers2 = new LinkedList<Float>();
        if (this.numbers.split(" ").length == 1) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No operations", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        for (String num : this.numbers.split(" ")) {
            Log.d("sad", num);
            numbers.add(Float.parseFloat(num));
        }

        for (int i = 0; i < this.operation.size(); i++) {
            if (this.operation.get(i).equals("*")
                    || this.operation.get(i).equals("/")) {
                if (this.result == null) {
                    result = numbers.get(i);
                }
                if (this.operation.get(i).equals("*")) {
                    result *= numbers.get(i + 1);
                } else {
                    result /= numbers.get(i + 1);
                }
            } else {
                if (this.result != null) {
                    numbers2.add(result);
                    result = (Float) null;
                    if (i == (this.operation.size() - 1))
                        numbers2.add(numbers.get(i + 1));
                } else
                    numbers2.add(numbers.get(i));
                operators.add(this.operation.get(i));
            }
        }
        numbers2.add(result);
        Log.d("asd", operators.toString());
        Log.d("asd", numbers2.toString());

        if (operators.isEmpty()) {
            TextView text = (TextView) findViewById(R.id.display);
            text.setText(this.result.toString());
            this.numbers = this.result.toString();
            this.display = this.result.toString();
            this.operation = new LinkedList<String>();
            return;
        } else {
            this.result = (Float) null;
            for (int i = 0; i < operators.size(); i++) {
                if (this.result == null) {
                    this.result = numbers2.get(i);
                }
                if (operators.get(i).equals("+")) {
                    result += numbers2.get(i + 1);
                } else {
                    result -= numbers2.get(i + 1);
                }
            }
        }
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.result.toString());

        this.numbers = this.result.toString();
        this.display = this.result.toString();
        this.operation = new LinkedList<String>();

    }

    public void onClickPoint(View v) {
        this.numbers += ".";
        this.display += ".";
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(this.display);
    }

    public void onClickDelete(View v) {
        if (!this.display.equals("")) {
            if (this.display.endsWith("+") || this.display.endsWith("-")
                    || this.display.endsWith("×") || this.display.endsWith("÷")) {
                this.operation.removeLast();
            }
            this.display = this.display.substring(0, this.display.length() - 1);
            this.numbers = this.numbers.substring(0, this.numbers.length() - 1);
            TextView text = (TextView) findViewById(R.id.display);
            text.setText(this.display);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Invalid input", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

