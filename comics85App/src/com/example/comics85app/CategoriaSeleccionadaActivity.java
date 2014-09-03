package com.example.comics85app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class CategoriaSeleccionadaActivity extends Activity {

	
	TextView categoriaTitulo;
	Bundle bundle;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//Declarcion de variables
		
		String categoria;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categoria_seleccionada);
		
		// Inicializacion de variables
		
		categoriaTitulo = (TextView)findViewById(R.id.textCategoriaSeleccionada);
		bundle = getIntent().getExtras();
        categoria= bundle.getString("Categoria");
        categoriaTitulo.setText(categoria);
		
	} //Fin onCreate


} // Fin clase CategoriaSeleccionadaActivity
