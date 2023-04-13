package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	TextView text1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text1 = findViewById(R.id.txt1);
	}
	@Override
	public void onClick(@NonNull View view)
	{
		if(view.getId() == R.id.btn_1)
		{
			text1.setText(R.string.but1text);
		}
		if (view.getId() == R.id.btn_2)
		{
			text1.setText(R.string.but2text);
		}
		if (view.getId() == R.id.btn_2_2)
		{
			CounterLayout2();
		}
	}
	@SuppressLint("SetTextI18n")
	private void CounterLayout2()
	{
		TextView textCounter = findViewById(R.id.txtCount);
		String currentText = textCounter.getText().toString();
		int    current     = Integer.parseInt(currentText);
		current++;
		Log.d("current count", Integer.toString(current));
		
		textCounter.setText(Integer.toString(current));
	}
	public void GoToSecondaryLayout(View view)
	{
		Log.d("SecondLayoutMethod", "GoToSecondaryLayout: ");
		setContentView(R.layout.activity_secondary);
	}
	public void GoToMainLayout(View view)
	{
		Log.d("MainLayoutMethod", "GoToMainLayout: ");
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater menuInflater = getMenuInflater();

		menuInflater.inflate(R.menu.mymenu, menu);

		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item)
	{
		Intent intent;
		switch (item.getItemId())
		{
			case R.id.home:
				intent = new Intent(this, MainActivity.class);
				startActivity(intent);
				break;
			case R.id.secondlayout:
				setContentView(R.layout.activity_secondary);
				break;
			case R.id.inputlayout:
				intent = new Intent(this, CalculatorActivity.class);
				startActivity(intent);
				break;
			case R.id.sensorlayout:
				intent = new Intent(this, SensorTest.class);
				startActivity(intent);
				break;
			case R.id.exit:
				finish();
		}

		return super.onOptionsItemSelected(item);
	}


}