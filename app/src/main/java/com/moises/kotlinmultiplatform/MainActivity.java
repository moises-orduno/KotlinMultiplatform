package com.moises.kotlinmultiplatform;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moises.common.Calculator;

public class MainActivity
        extends AppCompatActivity
{

    private EditText mNumberOneView;
    private EditText mNumberTwoView;
    private TextView mResultView;
    private Calculator mCalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mNumberOneView = findViewById(R.id.numberOneView);
        mNumberTwoView = findViewById(R.id.numberTwoView);
        mResultView = findViewById(R.id.resultView);
        mCalculator = new Calculator();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String numberOne = mNumberOneView.getText().toString();
                String numberTwo = mNumberTwoView.getText().toString();

                boolean validation = true;

                if(TextUtils.isEmpty(numberOne) || !TextUtils.isDigitsOnly(numberOne))
                {
                    validation = false;
                }
                if(TextUtils.isEmpty(numberTwo) || !TextUtils.isDigitsOnly(numberTwo))
                {
                    validation = false;
                }
                if(!validation)
                {
                    Toast.makeText(MainActivity.this,"Validation Error",Toast.LENGTH_LONG).show();
                    return;
                }

                mResultView.setText(String.valueOf(mCalculator.addToNumbers(Double.parseDouble(numberOne),
                        Double.parseDouble(numberTwo))));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
