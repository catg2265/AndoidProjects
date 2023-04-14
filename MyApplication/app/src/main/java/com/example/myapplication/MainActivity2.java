package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity
{

	AutoCompleteTextView autoText;

	ArrayList<String> list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		autoText = (AutoCompleteTextView) findViewById(R.id.autoComplete);

		list = new ArrayList<String>();

		list.add("Hello");
		list.add("World");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, list);
		autoText.setThreshold(1);
		autoText.setAdapter(adapter);

		

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
			case R.id.MainActivity2:
				intent = new Intent(this, MainActivity2.class);
				startActivity(intent);
				break;
			case R.id.exit:
				finish();
		}

		return super.onOptionsItemSelected(item);
	}
}