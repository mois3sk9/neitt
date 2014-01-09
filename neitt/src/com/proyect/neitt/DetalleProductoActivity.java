package com.proyect.neitt;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class DetalleProductoActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_detalle_productos);
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0342ab")));
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.actionbar, menu);
		return true;
	}

}
