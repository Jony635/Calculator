package com.example.jonathanmc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    ///TODO: WE HAVE TO IMPLEMENT THE VIEW ON SCREEN AND THE REAL NUMBER SEPARATELY.
    private TextView currentnumber;
    private float lastNum = 0f;
    private boolean negative = false;

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
        ///TODO: ADD THE NUMBERS TO THE REAL NUMBER WHICH MUST BE IMPLEMENTED.
    }
    public void OnOperator(View view)
    {
        Button but = (Button) view;
        String buttonText = but.getText().toString();

        if(buttonText.isEmpty())
            return;

        String lastNumberString = currentnumber.getText().toString();
        boolean alreadyNumbered = !lastNumberString.isEmpty();
        if(alreadyNumbered)
        {
            lastNum = Float.parseFloat(currentnumber.getText().toString());
            currentnumber.setText("");
        }

        switch(buttonText)
        {

            ///TODO: CONCATENATE OPERATIONS WITHOUT HITTING 'EQUAL' EACH TIME.
            case "*":
            {
                if(actual_operation != operations.NO_OP || !alreadyNumbered)
                    return;
                actual_operation = operations.MULTIPLY;
                break;
            }
            case ":":
            {
                if(actual_operation != operations.NO_OP || !alreadyNumbered)
                    return;
                actual_operation = operations.DIVIDE;
                break;
            }
            case "+":
            {
                if(actual_operation != operations.NO_OP || !alreadyNumbered)
                    return;
                actual_operation = operations.ADD;
                break;
            }
            case "-":
            {
                if(actual_operation == operations.NO_OP && alreadyNumbered)
                    actual_operation = operations.SUBTRACT;
                else if(!negative)
                {
                    negative = true;

                    ///TODO: IT SHOWS A 0, BUT REMEMBERS THE NEGATIVE SIGN. MUST BE CORRECTED.
                    currentnumber.setText(Integer.toString(-0));
                }

                break;
            }
        }
    }

    public void OnResult(View view)
    {
        float result = 0f;
        float secondNum = currentnumber.getText().toString().isEmpty() ? 0 : Float.parseFloat(currentnumber.getText().toString());
        switch(actual_operation)
        {
            case ADD:
            {
                result = lastNum + secondNum;
                break;
            }
            case SUBTRACT:
            {
                result = lastNum - secondNum;
                break;
            }
            case MULTIPLY:
            {
                result = lastNum * secondNum;
                break;
            }
            case DIVIDE: {
                result = lastNum / secondNum;
                break;
            }
        }
        currentnumber.setText(Float.toString( negative ? -1 * result : result));
        lastNum = 0f;
        actual_operation = operations.NO_OP;
        negative = false;
        secondNum = 0f;
    }

    public void OnDot(View view)
    {
       // Button but = (Button) view;
        //String buttonText = but.getText().toString();
        //currentnumber.setText(currentnumber.getText() + buttonText);
    }
}
