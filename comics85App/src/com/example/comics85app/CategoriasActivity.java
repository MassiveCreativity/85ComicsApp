 package com.example.comics85app;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoriasActivity extends Activity implements OnClickListener {
	


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//Declaracion de variables
		final Intent i;
		ImageView cienciaficcion;
		ImageView erotico;
		ImageView generonegro;
		ImageView humor;
		ImageView superheroes;
		ImageView western;
		
		ImageView aventuras;
		ImageView cotidiano;
		ImageView fantasia;
		ImageView historia;
		ImageView infantil;
		ImageView terror;
		
		
		Button AtoZButton;
		
		Animation animacionDerecha;
		Animation animacionIzquierda;
		Animation animacionAbajo;
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.categorias);
		
		//Setup de variables
		i = new Intent(this, CategoriasActivity.class);
		cienciaficcion = (ImageView)findViewById(R.id.imageCF);
		erotico = (ImageView)findViewById(R.id.imageErotico);
		generonegro = (ImageView)findViewById(R.id.imageGeneroNegro);
		humor = (ImageView)findViewById(R.id.imageHumor);
		superheroes = (ImageView)findViewById(R.id.imageSuperheroes);
		western = (ImageView)findViewById(R.id.imageWestern);

		aventuras = (ImageView)findViewById(R.id.imageAven);
		cotidiano = (ImageView)findViewById(R.id.imageCotidiano);
		fantasia = (ImageView)findViewById(R.id.imageFantasia);
		historia = (ImageView)findViewById(R.id.imageHistoria);
		infantil = (ImageView)findViewById(R.id.imageInfantil);
		terror = (ImageView)findViewById(R.id.imageTerror);
		
		AtoZButton = (Button)findViewById(R.id.categoriasComicsAtoZButton);

		
		animacionDerecha = AnimationUtils.loadAnimation(this, R.anim.animacioncategoriasderecha);
		animacionIzquierda = AnimationUtils.loadAnimation(this, R.anim.animacionizquierda);
		animacionAbajo = AnimationUtils.loadAnimation(this, R.anim.animaciondebajo);
		
		AtoZButton.setOnClickListener(this);
		cienciaficcion.setOnClickListener(this);
		erotico.setOnClickListener(this);
		 generonegro.setOnClickListener(this);
		 humor.setOnClickListener(this);
		 superheroes.setOnClickListener(this);
		 western.setOnClickListener(this);
		
		 aventuras.setOnClickListener(this);
		 cotidiano.setOnClickListener(this);
		 fantasia.setOnClickListener(this);
		 historia.setOnClickListener(this);
		 infantil.setOnClickListener(this);
		 terror.setOnClickListener(this);
		
		// Animaciones
		
		cienciaficcion.startAnimation(animacionDerecha);
		erotico.startAnimation(animacionDerecha);
		generonegro.startAnimation(animacionDerecha);
		humor.startAnimation(animacionDerecha);
		superheroes.startAnimation(animacionDerecha);
		western.startAnimation(animacionDerecha);
		
		aventuras.startAnimation(animacionIzquierda);
		cotidiano.startAnimation(animacionIzquierda);
		fantasia.startAnimation(animacionIzquierda);
		historia.startAnimation(animacionIzquierda);
		infantil.startAnimation(animacionIzquierda);
		terror.startAnimation(animacionIzquierda);
		
		AtoZButton.startAnimation(animacionAbajo);
		
		//Typeface typeFace=Typeface.createFromAsset(getAssets(),"Fonts/markerfeltnormal.ttf");
		//texto.setTypeface(typeFace);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.categorias, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		Intent i;
		
		switch (v.getId()) {
		
			case R.id.categoriasComicsAtoZButton :
				i = new Intent(this, AtozActivity.class);
				startActivity(i);
				break;
			case R.id.imageAven :
				break;
			case R.id.imageCF :
				i = new Intent(this,CategoriaSeleccionadaActivity.class);
				i.putExtra("Categoria", "Ciencia Ficci—n");
				startActivity(i);
				break;
			case R.id.imageCotidiano :
				break;
			case R.id.imageErotico:
				break;
			case R.id.imageFantasia :
				break;
			case R.id.imageGeneroNegro :
				break;
			case R.id.imageHistoria :
				break;
			case R.id.imageHumor :
				break;
			case R.id.imageInfantil :
				break;
			case R.id.imageSuperheroes :
				break;
			case R.id.imageTerror :
				break;
			case R.id.imageWestern :
				break;
			} // End SWITCH
		
		
	}

}
