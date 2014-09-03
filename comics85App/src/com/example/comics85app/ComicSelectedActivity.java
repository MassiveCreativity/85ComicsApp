package com.example.comics85app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ComicSelectedActivity extends Activity implements OnClickListener{

	Bundle bundle;
	
	String ComicSeleccionado;
	
	TextView tituloComic;
	TextView descripcionComic;
	ImageView imagen1;
	
	ImageView categoriasBoton;
	ImageView AZBoton;
	ImageView OchentayCincoBoton;
	
	int PortadaSeleccionada;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comic_selected);
		
		bundle = getIntent().getExtras();
		ComicSeleccionado= bundle.getString("comicSeleccionado");
		
		tituloComic = (TextView)findViewById(R.id.tituloComicSeleccionado);
		descripcionComic = (TextView)findViewById(R.id.descripcionComicSeleccionadoAqui);
		imagen1 = (ImageView)findViewById(R.id.imageComicSelected1);

		
		categoriasBoton = (ImageView)findViewById(R.id.imagenbotonCategorias);
		AZBoton = (ImageView)findViewById(R.id.imagenbotonAZ);
		OchentayCincoBoton = (ImageView)findViewById(R.id.imagenboton85);
		
		categoriasBoton.setOnClickListener (this);
		AZBoton.setOnClickListener (this);
		OchentayCincoBoton.setOnClickListener (this);
		
		imagen1.setOnClickListener (this);

		
		// **********************************
		// Cargamos los campos de la pantalla
		// **********************************
		
		//1- Titulo del comic seleccionado
		
		tituloComic.setText(ComicSeleccionado);
		
		//2- Cargamos las imagenes
		
		if (ComicSeleccionado.equals("100 Balas")){
			imagen1.setImageResource(R.drawable.pf100balas);
			PortadaSeleccionada = 0;
		} // Fin IF 100 Balas
		if (ComicSeleccionado.equals("Akira")){
			imagen1.setImageResource(R.drawable.pfakira);
			PortadaSeleccionada = 1;
		} // Fin IF 100 Balas
		

	} // Fin onCreate


	@Override
	public void onClick(View v) {
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.portadas);
		Intent i;
		
		switch (v.getId()) {
		case R.id.imagenboton85:
			i = new Intent(this, Los85Activity.class);
			startActivity(i);
		break;
		case R.id.imagenbotonCategorias:
			i = new Intent(this, CategoriasActivity.class);
			startActivity(i);
		break;
		case R.id.imagenbotonAZ:
			i = new Intent(this, AtozActivity.class);
			startActivity(i);
		break;
		case R.id.imagenCarritoCompra:
			//i = new Intent(this, ComicSelectedActivity.class);
			//startActivity(i);
		break;	
		case R.id.imageComicSelected1:
			i = new Intent(this, DetallePortadaActivity.class);
			i.putExtra("Portada",PortadaSeleccionada);
			startActivity(i);
		break;
		
		
		} // Fin SWITCH
		
	} // Fin onClick



} // Fin de la clase
