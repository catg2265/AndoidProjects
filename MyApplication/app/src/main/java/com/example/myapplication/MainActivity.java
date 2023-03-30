package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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
	public void onClick(View view)
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
	private void CounterLayout2()
	{
		TextView textCounter = findViewById(R.id.txtCount);
		String currentText = textCounter.getText().toString();
		Integer current = Integer.parseInt(currentText);
		current++;
		Log.d("current count", current.toString());
		textCounter.setText(current.toString());
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
		switch (item.getItemId())
		{
			case R.id.home:
				setContentView(R.layout.activity_main);
				break;
			case R.id.secondlayout:
				setContentView(R.layout.activity_secondary);
				break;
			case R.id.exit:
				finish();
		}

		return super.onOptionsItemSelected(item);
	}
}