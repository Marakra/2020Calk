package com.example.a2020calk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Character action = null;
    Double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void insertCharacterIntoTextView(View view) {
        Button button = (Button)view;

        if (isNumeric(button.getText().toString()) || button.getText().charAt(0) == '.')
        {
            if(!isNumeric(textView.getText().toString())) textView.setText("");

            textView.append(button.getText());
            return;
        }

        switch (button.getText().charAt(0)) {
            case '+':
                if(isNumeric(textView.getText().toString())) {
                    if(action == null) {
                        result = DoubleParseWithTry(textView.getText().toString());

                    } else {
                        PerformAction();
                    }
                }
                textView.append("+");
                action = '+';
                break;
            case '*':
                if(isNumeric(textView.getText().toString())) {
                    if (action == null) {
                        result = DoubleParseWithTry(textView.getText().toString());
                    } else {
                        PerformAction();
                    }
                }
                textView.append("*");
                action = '*';
                break;
            case '-':
                if(isNumeric(textView.getText().toString())) {
                    if(action == null) {
                        result = DoubleParseWithTry(textView.getText().toString());
                    } else {
                        PerformAction();
                    }
                }
                textView.append("-");
                action = '-';
                break;
            case '/':
                if(isNumeric(textView.getText().toString())) {
                    if(action == null) {
                        if(isNumeric(textView.getText().toString()))
                            result = DoubleParseWithTry(textView.getText().toString());
                    } else {
                        PerformAction();
                    }
                }
                textView.append("/");
                action = '/';
                break;
            case '=':
                PerformAction();
                textView.append("=");
                action = null;
                break;
            case 'C':
                if(isNumeric(textView.getText().toString()))
                    textView.setText(textView.getText().subSequence(0, textView.getText().length() -1));
                break;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    Double DoubleParseWithTry(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0.0;
        }
    }

    void PerformAction() {
        switch (action) {
            default:
                return;
            case '+':
                result += DoubleParseWithTry(textView.getText().toString());
                break;
            case '-':
                result -= DoubleParseWithTry(textView.getText().toString());
                break;
            case '*':
                result *= DoubleParseWithTry(textView.getText().toString());
                break;
            case '/':
                result /= DoubleParseWithTry((textView.getText().toString()));
        }
        textView.setText(String.valueOf(result));
    }
}
