package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	Button button1, button2, button3;
	TextView text1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = findViewById(R.id.btn_1);
		button2 = findViewById(R.id.btn_2);
		button3 = findViewById(R.id.btn_3);
		text1 = findViewById(R.id.txt1);
		button3.setOnClickListener(this);
		button2.setOnClickListener(this);
		button1.setOnClickListener(this);
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
		if (view.getId() == R.id.btn_3)
		{
			text1.setText(R.string.but3text);
		}
	}
}