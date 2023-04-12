package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.hardware.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorTest extends AppCompatActivity implements SensorEventListener
{
	Intent sensorActivity = new Intent( this, SensorTest.class);
	Intent main           = new Intent(this, MainActivity.class);
	Intent calc = new Intent(this, CalculatorActivity.class);

	private SensorManager sensorManager;
	private Sensor lightSensor;

	TextView sensorText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_test);

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		sensorText = findViewById(R.id.sensorOutput);
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent)
	{
		float lux = sensorEvent.values[0];
		String output = String.valueOf(lux);
		sensorText.setText(output);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i)
	{

	}

	@Override
	protected void onResume()
	{
		super.onResume();
		sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		sensorManager.unregisterListener(this);
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
			case R.id.sensorlayout:
				startActivity(sensorActivity);
				break;
			case R.id.exit:
				finish();
		}
		return super.onOptionsItemSelected(item);
	}
}