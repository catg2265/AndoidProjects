package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener
{
	EditText num1text;
	EditText num2text;
	TextView resultText;
	Intent main = new Intent(this, MainActivity.class);
	Intent calc = new Intent(this, CalculatorActivity.class);
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		num1text   = findViewById(R.id.number1);
		num2text   = findViewById(R.id.number2);
		resultText = findViewById(R.id.result);
	}
	@Override
	public void onClick(View view)
	{
		int num1 = Integer.parseInt(num1text.getText().toString());
		int num2 = Integer.parseInt(num2text.getText().toString());
		int result;

		if (view.getId() == R.id.button)
		{
			// Addition
			result = num1 + num2;
			Log.d("plus", "onClick: plus");
			resultText.setText(String.valueOf(result));
		}
		if (view.getId() == R.id.button2)
		{
			// Subtraction
			result = num1-num2;
			Log.d("minus", "onClick: minus");
			resultText.setText(String.valueOf(result));
		}
		if (view.getId() == R.id.button3)
		{
			// Multiplication
			result = num1*num2;
			Log.d("multiply", "onClick: multiply");
			resultText.setText(String.valueOf(result));
		}
		if (view.getId() == R.id.button4)
		{
			// Division
			result = num1/num2;
			Log.d("divide", "onClick: divide");
			resultText.setText(String.valueOf(result));
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater menuInflater = getMenuInflater();

		menuInflater.inflate(R.menu.mymenu, menu);

		return super.onCreateOptionsMenu(menu);
	}
	@SuppressLint("NonConstantResourceId")
	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.home:
				startActivity(main);
				break;
			case R.id.secondlayout:
				setContentView(R.layout.activity_secondary);
				break;
			case R.id.inputlayout:
				startActivity(calc);
				break;
			case R.id.exit:
				finish();
		}
		return super.onOptionsItemSelected(item);
	}
}

