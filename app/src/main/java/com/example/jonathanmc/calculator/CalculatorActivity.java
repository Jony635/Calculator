package com.example.jonathanmc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView currentnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentnumber = findViewById(R.id.currnumber);
    }

    public void OnDigit(View view)
    {
        Button but = (Button) view;
        String buttonText = but.getText().toString();
        currentnumber.setText(currentnumber.getText() + buttonText);
    }
    public void OnOperator(View view)
    {
        int lastNum = Integer.parseInt(currentnumber.getText().toString());
        Button but = (Button) view;
        String buttonText = but.getText().toString();

        switch(buttonText)
        {
            case "*":
            {
                if(buttonText.isEmpty())
                    break;





                break;
            }
            case ":":
            {
                if(buttonText.isEmpty())
                    break;
                break;
            }
            case "+":
            {
                if(buttonText.isEmpty())
                    break;
                break;
            }
            case "-":
            {
                if(buttonText.isEmpty())
                    break;
                break;
            }
        }

        currentnumber.setText(currentnumber.getText() + buttonText);
    }

    public void OnResult(View view)
    {
        Button but = (Button) view;
        String buttonText = but.getText().toString();
        currentnumber.setText(currentnumber.getText() + buttonText);
    }

    public void OnDot(View view)
    {
        Button but = (Button) view;
        String buttonText = but.getText().toString();
        currentnumber.setText(currentnumber.getText() + buttonText);
    }
}
