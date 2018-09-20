package com.example.jonathanmc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView currentnumber;
    private float lastNum = 0f;

    private enum operations
    {
        NO_OP,
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    operations actual_operation = operations.NO_OP;

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
        lastNum = Float.parseFloat(currentnumber.getText().toString());
        Button but = (Button) view;
        String buttonText = but.getText().toString();

        if(buttonText.isEmpty() || actual_operation != operations.NO_OP)
            return;
        
        switch(buttonText)
        {
            case "*":
            {
                actual_operation = operations.MULTIPLY;
                break;
            }
            case ":":
            {
                actual_operation = operations.DIVIDE;
                break;
            }
            case "+":
            {
                actual_operation = operations.ADD;
                break;
            }
            case "-": {
                actual_operation = operations.SUBTRACT;
                break;
            }
        }

        currentnumber.setText("");
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
