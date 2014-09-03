package com.example.comics85app;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class InicioActivity extends Activity implements OnClickListener{

	

	DBAdapter myDbComics;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		final Intent i;
		
		final Handler handler = new Handler();
		//i = new Intent(this, CategoriasActivity.class);
		i = new Intent(this,MenuActivity.class);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);
		
		ImageView imagen = (ImageView)findViewById(R.id.imageCF);
		TextView texto = (TextView)findViewById(R.id.textTitulo);
		ImageView carruse = (ImageView)findViewById(R.id.imageCarrusel);
		
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"Fonts/markerfeltnormal.ttf");
		texto.setTypeface(typeFace);
		
		Animation animacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
		Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.animaciontexto);
		Animation animacion3 =AnimationUtils.loadAnimation(this, R.anim.animacionizquierda);
		
		imagen.startAnimation(animacion);
		texto.startAnimation(animacion2);
		carruse.startAnimation(animacion3);
		
		
		handler.postDelayed(new Runnable(){
			@Override
			public void run(){
				startActivity(i);
			}
		},2000);
		
		imagen.setOnClickListener (this);
		
		// Cargamos las bases de datos
		
		openDBs(); // Cuando creamos la actividad, abriremos todas las bases de datos
		cargarDBs(); // Cargamos las bases de datos a pelo
		
	} // Fin onCreate

	
	@Override
	public void onClick(View arg0) {
		Intent i;
		i = new Intent(this, CategoriasActivity.class);
		startActivity(i);
	} // Fin onCLICK


	
	// ----------------------------
	// Manejo de las bases de datos
	// ----------------------------
	
	private void displayText (String message) {
		
		//TextView textView = (TextView) findViewById (R.id.textDisplay); 
		//textView.setText(message);
		
	} // END displayText
	
	
	private void displayRecordSet(Cursor cursor) {

		String message = "";
		
		if (cursor.moveToFirst()) {
			do {
			// Process the data
			int id = cursor.getInt(DBAdapter.COL_ROWID);
			String cat = cursor.getString(DBAdapter.COL_TIL);
			message += "id = " + id + ", categoria = " + cat + "\n"; 
		   } while (cursor.moveToNext()) ;
		}
		cursor.close();
		displayText(message);
	}
	
	private void cargarDBs () {
		
		// Carga de comics. Formato:
		// Titulo, Descripcion, Donde se comprara, Nombre fichero portada, Nombre fichero interior 1, Nombre fichero interior 1.

		long newId;
		Cursor cursor;
		newId = myDbComics.insertRow("100 Balas", "descripcion de 100 balas","Amazon","portada100balas","interior1100balas","interior2100balas");
		cursor = myDbComics.getRow(newId);
		displayRecordSet(cursor);

		

} // Fin de cargarDBs
	
	
	// Apertura de todas las bases de datos
	private void openDBs() {
		// Categorias

		myDbComics = new DBAdapter(this);
		myDbComics.openCategorias();


		}
	
	// Destruccion de todas las bases de datos
	protected void onDestroy() {
		super.onDestroy();
		closeDBs();
		
	}

	// Cerramos las bases de datos
	private void closeDBs() {
		// Categorias
		myDbComics.close();
	}
	

	// FIN MANEJO BASE DE DATOS
	
	
} // Fin de la clase
