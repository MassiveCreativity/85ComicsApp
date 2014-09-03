package com.example.comics85app;
// ------------------------------------ DBADapter.java ---------------------------------------------



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter {

	/////////////////////////////////////////////////////////////////////
	//	Constants & Data
	/////////////////////////////////////////////////////////////////////
	// For logging:
	private static final String TAG = "DBAdapter";
	
	// DB Fields
	public static final String KEY_ROWID = "_id";
	public static final int COL_ROWID = 0;
	/*
	 * CHANGE 1:
	 */
	//CAMPOS DE LA BASE DE DATOS
	public static final String KEY_TIL = "Titulo";
	public static final String KEY_DESC = "DESCRIPCION";
	public static final String KEY_COMPRAR = "COMPRAR";
	public static final String KEY_PORTADA = "PORTADA";
	public static final String KEY_INTERIOR1 = "INTERIOR 1";
	public static final String KEY_INTERIOR2 = "INTERIOR 2";

	
	// COLUMNA DE CADA CAMPO
	public static final int COL_TIL = 1;
	public static final int COL_DESC = 1;
	public static final int COL_COMPRAR = 2;
	public static final int COL_PORTADA = 3;
	public static final int COL_INTERIOR1 = 4;
	public static final int COL_INTERIOR2 = 5;

	// NOMBRES DE TODAS LAS KEUS DE LA BASE DE DATOS
	public static final String[] ALL_KEYS = new String[] 
			{KEY_ROWID, KEY_TIL, KEY_DESC,KEY_COMPRAR,KEY_PORTADA,KEY_INTERIOR1,KEY_INTERIOR2};
	
	// DB info: it's name, and the table we are using (just one).
	public static final String DATABASE_NAME = "MyDb";
	public static final String DATABASE_TABLE = "mainTable";
	// Track DB version if a new version of your app changes the format.
	public static final int DATABASE_VERSION = 178;	
	
	
	// CREACION DE LA TABLE EN SQL
	private static final String DATABASE_CREATE_SQL = 
			"create table " + DATABASE_TABLE 
			+ " (" + KEY_ROWID + " integer primary key autoincrement, "
			
			// + KEY_{...} + " {type} not null"
			//	- Key is the column name you created above.
			//	- {type} is one of: text, integer, real, blob
			//		(http://www.sqlite.org/datatype3.html)
			//  - "not null" means it is a required field (must be given a value).
			// NOTE: All must be comma separated (end of line!) Last one must have NO comma!!
			+ KEY_TIL + " text not null, "
			+ KEY_DESC + " text not null, "
			+ KEY_COMPRAR + " text not null, "
			+ KEY_PORTADA + " text not null, "
			+ KEY_INTERIOR1 + " text not null, "
			+ KEY_INTERIOR2 + " text not null "
			
			// Rest  of creation:
			+ ");";
	
	// Context of application who uses us.
	private final Context context;
	
	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;

	/////////////////////////////////////////////////////////////////////
	//	Public methods:
	/////////////////////////////////////////////////////////////////////
	
	public DBAdapter(Context ctx) {
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}
	
	// Open the database connection.
	public DBAdapter openCategorias() {
		db = myDBHelper.getWritableDatabase();
		return this;
	}
	
	// Close the database connection.
	public void close() {
		myDBHelper.close();
	}
	
	// Add a new set of values to the database.
	public long insertRow(String TITULO, String Q1, String Q2, String Q3, String Q4, String Q5) {
		// Create row's data:
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_TIL, TITULO);
		initialValues.put(KEY_DESC, Q1);
		initialValues.put(KEY_COMPRAR, Q2);		
		initialValues.put(KEY_PORTADA, Q3);
		initialValues.put(KEY_INTERIOR1, Q4);
		initialValues.put(KEY_INTERIOR2, Q5);
		// Insert it into the database.
		return db.insert(DATABASE_TABLE, null, initialValues);
	}
	
	// Delete a row from the database, by rowId (primary key)
	public boolean deleteRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		return db.delete(DATABASE_TABLE, where, null) != 0;
	}
	
	public void deleteAll() {
		Cursor c = getAllRows();
		long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
		if (c.moveToFirst()) {
			do {
				deleteRow(c.getLong((int) rowId));				
			} while (c.moveToNext());
		}
		c.close();
	}
	
	// Return all data in the database.
	public Cursor getAllRows() {
		String where = null;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS, 
							where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	// Get a specific row (by rowId)
	public Cursor getRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS, 
						where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	
	// Change an existing row to be equal to new data.
	public boolean updateRow(long rowId, String TITULO, String Q1, String Q2, String Q3, String Q4, String Q5) {
		String where = KEY_ROWID + "=" + rowId;


		// Create row's data:
		ContentValues newValues = new ContentValues();
		newValues.put(KEY_TIL, TITULO);
		newValues.put(KEY_DESC, Q1);
		newValues.put(KEY_COMPRAR, Q2);
		newValues.put(KEY_PORTADA, Q3);
		newValues.put(KEY_INTERIOR1, Q4);
		newValues.put(KEY_INTERIOR2, Q5);
		
		// Insert it into the database.
		return db.update(DATABASE_TABLE, newValues, where, null) != 0;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////
	//	Private Helper Classes:
	/////////////////////////////////////////////////////////////////////
	
	/**
	 * Private class which handles database creation and upgrading.
	 * Used to handle low-level database access.
	 */
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase _db) {
			_db.execSQL(DATABASE_CREATE_SQL);			
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading application's database from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data!");
			
			// Destroy old database:
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			
			// Recreate new database:
			onCreate(_db);
		}
	}
}
