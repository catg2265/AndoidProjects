package com.example.sqliteprepoptest;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


public class DBHelper extends SQLiteOpenHelper
{

	Context mcontext;
	String dbName;
	String dbPath;
	private static final String TAG = "DatabaseHelper";

	public DBHelper(Context context, String name, int version)
	{
		super(context, name, null, version);
		this.dbName = name;
		this.mcontext = context;
		this.dbPath = "/data/data/" + "com.example.sqliteprepoptest" + "/databases/";
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase)
	{

	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
	{

	}


// Might only be needed to stop it from copying if it already exists
	/*public void CheckDB()
	{
		SQLiteDatabase checkdb = null;
		String filepath = dbPath + dbName;
		try
		{
			checkdb = SQLiteDatabase.openDatabase(filepath, null, 0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (checkdb != null)
		{
			Toast.makeText(mcontext, "Database already exists", Toast.LENGTH_SHORT).show();
		}else
		{
			CopyDatase();
		}
		CopyDatase();
	}*/

	public void CopyDatase()
	{
		this.getReadableDatabase();
		try
		{
			InputStream ios = mcontext.getAssets().open(dbName);
			OutputStream os = new FileOutputStream(dbPath+dbName);

			byte[] buffer = new byte[1024];

			int len;

			while ((len = ios.read(buffer)) > 0)
			{
				os.write(buffer, 0, len);
			}
			os.flush();
			ios.close();
			os.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Log.d("CopyDB", "Database Copied");
	}
	public void OpenDatabase()
	{
		String filePath = dbPath + dbName;
		SQLiteDatabase.openDatabase(filePath, null, 0);
	}
	public void fetchAllData()
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor     cursor = db.rawQuery("select * from food", null, null);
		while (cursor.moveToNext())
		{
			Log.e(TAG, "fetchAllData: title is : "+cursor.getString(0));
		}
		cursor.close();
	}
	public void PopulateList(ArrayList<FoodTypes> list)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor     cursor = db.rawQuery("select * from food", null, null);
		if (cursor.moveToFirst())
			do
			{
				FoodTypes ft = new FoodTypes(cursor.getString(0),cursor.getDouble(1),cursor.getDouble(2),cursor.getDouble(3),cursor.getDouble(4),Boolean.parseBoolean(cursor.getString(5)),
						Boolean.parseBoolean(cursor.getString(6)),Boolean.parseBoolean(cursor.getString(7)),Boolean.parseBoolean(cursor.getString(8)),Boolean.parseBoolean(cursor.getString(9)),
						Boolean.parseBoolean(cursor.getString(10)));
				list.add(ft);
			}while (cursor.moveToNext());
		cursor.close();
	}
}
