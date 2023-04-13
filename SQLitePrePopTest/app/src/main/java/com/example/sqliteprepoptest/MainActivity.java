package com.example.sqliteprepoptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
	DBHelper databaseHelper;
	Button   fetchData;
	ArrayList<FoodTypes> listOfFood = new ArrayList<FoodTypes>();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fetchData = findViewById(R.id.fetch_data_button);

		databaseHelper = new DBHelper(this, "foods.db", 1);
		try
		{
			databaseHelper.CopyDatase();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			databaseHelper.OpenDatabase();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			databaseHelper.fetchAllData();
		}
		catch (Exception e)
		{
			Log.e("main", "data did not fetch");
			e.printStackTrace();
		}
		try
		{
			databaseHelper.PopulateList(listOfFood);
			for (FoodTypes element:listOfFood)
			{
				Log.d("type", element.getType());
				Log.d("x", String.valueOf(element.getX()));
				Log.d("y", String.valueOf(element.getY()));
				Log.d("g", String.valueOf(element.getG()));
				Log.d("h", String.valueOf(element.getH()));
				Log.d("kg", String.valueOf(element.isKg()));
				Log.d("gm", String.valueOf(element.isGm()));
				Log.d("L", String.valueOf(element.isL()));
				Log.d("dL", String.valueOf(element.isdL()));
				Log.d("mL", String.valueOf(element.ismL()));
				Log.d("pcs", String.valueOf(element.isPcs()));

			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		fetchData.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				databaseHelper.fetchAllData();
			}
		});
	}

}