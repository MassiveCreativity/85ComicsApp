package com.example.comics85app;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity implements OnClickListener{

	ImageView Categorias;
	ImageView Contacto;
	ImageView Los85;
	ImageView AtoZ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Declaracion de variables
		
		//Inicializacion de variables
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		Categorias = (ImageView) findViewById (R.id.botonCategorias);
		Contacto  = (ImageView) findViewById (R.id.botonContacto);
		Los85  = (ImageView) findViewById (R.id.botonLos85);
		AtoZ  = (ImageView) findViewById (R.id.botonAtoZ);
		
		Categorias.setOnClickListener (this);
		Contacto.setOnClickListener (this);
		Los85.setOnClickListener (this);
		AtoZ.setOnClickListener (this);
		
	} // Fin onCreate


	@Override
	public void onClick(View v) {
		// Blink del boton pulsado.
		Animation animacion = AnimationUtils.loadAnimation(this,R.anim.fade);
		v.startAnimation(animacion);
		
		//Lanzamiento de actividades
		Intent i;
		
		switch (v.getId()) {
			case R.id.botonCategorias:
				i = new Intent(this, CategoriasActivity.class);
				startActivity(i);
			break;
			
			case R.id.botonLos85:
				i = new Intent(this, Los85Activity.class);
				startActivity(i);
			break;
		} // Fin del SWITCH


	} // Fin onClick

} // Fin de la clase ManuActivity
