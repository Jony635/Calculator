package com.example.jonathanmc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    ///TODO: WE HAVE TO IMPLEMENT THE VIEW ON SCREEN AND THE REAL NUMBER SEPARATELY.
    private TextView textView;
    private int numView = 0;

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

         textView = findViewById(R.id.currnumber);
    }

    public void OnDigit(View view)
    {
        Button but = (Button) view;
        String buttonText = but.getText().toString();

        numView = Integer.parseInt(Integer.toString(numView) + buttonText);
        numView *= negative ? -1 : 1;
        textView.setText(Integer.toString((numView)));
    }
    public void OnOperator(View view)
    {
        Button but = (Button) view;
        String buttonText = but.getText().toString();

        if(buttonText.isEmpty())
            return;

        if(actual_operation != operations.NO_OP )
        {
            OnResult(view);
        }

        String lastNumberString = textView.getText().toString();
        boolean alreadyNumbered = !lastNumberString.isEmpty();
        if(alreadyNumbered)
        {
            lastNum = Float.parseFloat(textView.getText().toString());
            textView.setText("");
            numView = 0;
            negative = false;
        }

        switch(buttonText)
        {
            ///TODO: CONCATENATE OPERATIONS WITHOUT HITTING 'EQUAL' EACH TIME.
            case "*":
            {
               if(!alreadyNumbered)
                    return;



                actual_operation = operations.MULTIPLY;
                break;
            }
            case ":":
            {
                if(!alreadyNumbered)
                    return;



                actual_operation = operations.DIVIDE;
                break;
            }
            case "+":
            {
                if(!alreadyNumbered)
                    return;

                actual_operation = operations.ADD;
                break;
            }
            case "-":
            {
                if(!alreadyNumbered && !negative)
                {
                    negative = true;
                    return;
                }

                if(!alreadyNumbered)
                    return;


                actual_operation = operations.SUBTRACT;


                break;
            }
        }
    }

    public void OnResult(View view)
    {
        float result = 0f;
        float secondNum = numView;
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
            case NO_OP:
            {
                result = numView;
                break;
            }
        }
        numView = (int)result;
        textView.setText(Float.toString(result));
        lastNum = 0f;
        actual_operation = operations.NO_OP;
        negative = false;
    }

    public void OnC(View view)
    {
       lastNum = 0f;
       numView = 0;
       textView.setText("");
       actual_operation = operations.NO_OP;
       negative = false;
    }
}
