package com.example.comics85app;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Los85Activity extends Activity implements OnClickListener{

	ImageView cienbalas;
	ImageView akira;
	ImageView animalman;
	ImageView arkham;
	ImageView authority;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.los85);
		
		cienbalas = (ImageView)findViewById(R.id.comic100balas);
		akira = (ImageView)findViewById(R.id.comicakira);
		animalman = (ImageView)findViewById(R.id.comicanimalman);
		arkham = (ImageView)findViewById(R.id.comicarkham);
		authority = (ImageView)findViewById(R.id.comicauthority);
		
		
		
		cienbalas.setOnClickListener (this);
		akira.setOnClickListener (this);
		animalman.setOnClickListener (this);
		arkham.setOnClickListener (this);
		authority.setOnClickListener (this);


		
		
	} // Fin onCreater


	@Override
	public void onClick(View v) {
		
		Intent i;
		
		switch (v.getId()) {
		case R.id.comic100balas:
			i = new Intent(this, ComicSelectedActivity.class);
			i.putExtra("comicSeleccionado", "100 Balas");
			startActivity(i);
		break;
		case R.id.comicakira:
			i = new Intent(this, ComicSelectedActivity.class);
			i.putExtra("comicSeleccionado", "Akira");
			startActivity(i);
		break;
		
		
	} // Fin SWITCH

	} // Fin onClick 
}
